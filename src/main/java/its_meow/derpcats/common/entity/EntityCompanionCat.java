package its_meow.derpcats.common.entity;

import javax.annotation.Nullable;

import its_meow.derpcats.common.item.ItemCatnip;
import its_meow.derpcats.init.ModItems;
import its_meow.derpcats.init.ModLootTables;
import its_meow.derpcats.init.ModSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityCompanionCat extends EntityTameable {
    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager
            .<Float>createKey(EntityCompanionCat.class, DataSerializers.FLOAT);

    public EntityCompanionCat(World worldIn) {
        super(worldIn);
        this.setSize(1.2F, 1.8F);
        this.setTamed(false);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.aiSit = new EntityAISit(this);
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityCompanionCat.AIAvoidEntity(this, EntityLlama.class, 24.0F, 1.5D, 1.5D));
        this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(6, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(7, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1D);

        if(this.isTamed()) {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(27.0D);
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
        }

        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.5D);
    }

    /**
     * Sets the active target the Task system uses for tracking
     */
    @Override
    public void setAttackTarget(@Nullable EntityLivingBase entitylivingbaseIn) {
        super.setAttackTarget(entitylivingbaseIn);

        if(entitylivingbaseIn == null) {
            this.setAngry(false);
        } else if(!this.isTamed()) {
            this.setAngry(true);
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setBoolean("Angry", this.isAngry());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setAngry(compound.getBoolean("Angry"));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if(this.isAngry()) {
            this.playSound(SoundEvents.ENTITY_CAT_HISS, 1, 1);
        }
        return null;// this.isAngry() ? SoundEvents.ENTITY_CAT_HISS : null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) {
        this.playSound(ModSoundEvents.grumphit, 1, 1);
        return null;// SoundRegistry.grumphit;
    }

    @Override
    protected SoundEvent getDeathSound() {
        this.playSound(ModSoundEvents.grumpdeath, 1, 1);
        return null;// SoundRegistry.grumpdeath;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    @Override
    protected float getSoundVolume() {
        return 1.5F;
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.FARTLOOT;
    }

    /**
     * Called frequently so the entity can update its state every tick as required.
     * For example, zombies and skeletons use this to react to sunlight and start to
     * burn.
     */
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if(!this.world.isRemote && this.getAttackTarget() == null && this.isAngry()) {
            this.setAngry(false);
        }
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if(this.isEntityInvulnerable(source)) {
            return false;
        } else {
            Entity entity = source.getTrueSource();

            if(entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
                amount = (amount + 1.0F) / 2.0F;
            }

            return super.attackEntityFrom(source, amount);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this),
                ((int) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));

        if(flag) {
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    @Override
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);

        if(tamed) {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(27.0D);
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
        }

        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.5D);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if(this.isTamed()) {
            if(!itemstack.isEmpty()) {
                if(itemstack.getItem() instanceof Item) {
                    Item item = itemstack.getItem();
                    if(this.getHealth() < 27.0F) {
                        if(item.getClass() == ItemCatnip.class) {
                            if(!player.capabilities.isCreativeMode) {
                                itemstack.shrink(1);
                            }

                            this.heal(9F);
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                    }
                }
            }

            if(this.isOwner(player) && !this.world.isRemote && itemstack.getItem() != ModItems.catnip) {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.navigator.clearPath();
                this.setAttackTarget((EntityLivingBase) null);
            }

        } else if(itemstack.getItem() == ModItems.catnip && !this.isAngry()) {
            if(!player.capabilities.isCreativeMode) {
                itemstack.shrink(1);
            }

            if(!this.world.isRemote) {
                if(this.rand.nextInt(3) == 0) {
                    this.setTamed(true);
                    this.navigator.clearPath();
                    this.setAttackTarget((EntityLivingBase) null);
                    this.setHealth(27.0F);
                    this.setOwnerId(player.getUniqueID());
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte) 7);
                } else {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte) 6);
                }
            }

            return true;
        }

        return super.processInteract(player, hand);
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    @Override
    public int getMaxSpawnedInChunk() {
        return 8;
    }

    /**
     * Determines whether this wolf is angry or not.
     */
    public boolean isAngry() {
        return (this.dataManager.get(TAMED).byteValue() & 2) != 0;
    }

    /**
     * Sets whether this wolf is angry or not.
     */
    public void setAngry(boolean angry) {
        byte b0 = this.dataManager.get(TAMED).byteValue();

        if(angry) {
            this.dataManager.set(TAMED, Byte.valueOf((byte) (b0 | 2)));
        } else {
            this.dataManager.set(TAMED, Byte.valueOf((byte) (b0 & -3)));
        }
    }

    @Override
    public EntityCompanionCat createChild(EntityAgeable ageable) {
        return null;
    }

    @Override
    public boolean shouldAttackEntity(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_) {
        if(!(p_142018_1_ instanceof EntityCreeper) && !(p_142018_1_ instanceof EntityGhast)) {
            if(p_142018_1_ instanceof EntityCompanionCat) {
                EntityCompanionCat entitycompanioncat = (EntityCompanionCat) p_142018_1_;

                if(entitycompanioncat.isTamed() && entitycompanioncat.getOwner() == p_142018_2_) {
                    return false;
                }
            }

            return p_142018_1_ instanceof EntityPlayer && p_142018_2_ instanceof EntityPlayer
                    && !((EntityPlayer) p_142018_2_).canAttackPlayer((EntityPlayer) p_142018_1_) ? false
                            : !(p_142018_1_ instanceof AbstractHorse) || !((AbstractHorse) p_142018_1_).isTame();
        } else {
            return false;
        }
    }

    @Override
    public boolean canBeLeashedTo(EntityPlayer player) {
        return !this.isAngry() && super.canBeLeashedTo(player);
    }

    class AIAvoidEntity<T extends Entity> extends EntityAIAvoidEntity<T> {
        private final EntityCompanionCat cat;

        public AIAvoidEntity(EntityCompanionCat catIn, Class<T> p_i47251_3_, float p_i47251_4_, double p_i47251_5_,
                double p_i47251_7_) {
            super(catIn, p_i47251_3_, p_i47251_4_, p_i47251_5_, p_i47251_7_);
            this.cat = catIn;
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        @Override
        public boolean shouldExecute() {
            return super.shouldExecute() && this.closestLivingEntity instanceof EntityLlama
                    ? !this.cat.isTamed() && this.avoidLlama((EntityLlama) this.closestLivingEntity)
                    : false;
        }

        private boolean avoidLlama(EntityLlama p_190854_1_) {
            return p_190854_1_.getStrength() >= EntityCompanionCat.this.rand.nextInt(5);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        @Override
        public void startExecuting() {
            EntityCompanionCat.this.setAttackTarget((EntityLivingBase) null);
            super.startExecuting();
        }

        /**
         * Updates the task
         */
        @Override
        public void updateTask() {
            EntityCompanionCat.this.setAttackTarget((EntityLivingBase) null);
            super.updateTask();
        }
    }
}
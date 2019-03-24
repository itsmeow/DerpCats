package its_meow.derpcats.common.entity;

import java.util.Random;

import javax.annotation.Nullable;

import its_meow.derpcats.init.ModLootTables;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.Village;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityCatLady extends EntityAnimal {

    private int randomTickDivider;
    Village villageObj;

    private boolean isLookingForHome;
    private boolean rareDone = false;

    public EntityCatLady(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 1.95F);
        ((PathNavigateGround) this.getNavigator()).setBreakDoors(true);
        this.setCanPickUpLoot(true);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAvoidEntity<EntityZombie>(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(1, new EntityAIAvoidEntity<EntityEvoker>(this, EntityEvoker.class, 12.0F, 0.8D, 0.8D));
        this.tasks.addTask(1, new EntityAIAvoidEntity<EntityVindicator>(this, EntityVindicator.class, 8.0F, 0.8D, 0.8D));
        this.tasks.addTask(1, new EntityAIAvoidEntity<EntityVex>(this, EntityVex.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(9, new EntityAIWanderAvoidWater(this, 0.6D));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
    }

    @Override
    protected void updateAITasks() {
        if(--this.randomTickDivider <= 0) {
            BlockPos blockpos = new BlockPos(this);
            this.world.getVillageCollection().addToVillagerPositionList(blockpos);
            this.randomTickDivider = 70 + this.rand.nextInt(50);
            this.villageObj = this.world.getVillageCollection().getNearestVillage(blockpos, 32);
            if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT && this.world.isRemote) {
                this.spawnParticles(EnumParticleTypes.VILLAGER_HAPPY);
            }
            if(!this.world.isRemote) {
                int ch = new Random().nextInt(4);
                if(ch == 1) {

                    Random rand = new Random();
                    int c = rand.nextInt(10);
                    c++; // hehe
                    int rareCat = rand.nextInt(50);
                    if(rareCat == 32 && !this.rareDone) {
                        EntityGiantCat giantcat = new EntityGiantCat(this.world);
                        this.nameLoc(giantcat);
                        this.rareDone = true;
                    }

                    switch(c) {
                    case 1:
                        EntityFartCat fartcat = new EntityFartCat(this.world);
                        this.nameLoc(fartcat);
                        break;
                    case 2:
                        EntityCompanionCat companioncat = new EntityCompanionCat(this.world);
                        this.nameLoc(companioncat);
                        break;
                    case 3:
                        EntityGrumpyCat grumpycat = new EntityGrumpyCat(this.world);
                        this.nameLoc(grumpycat);
                        break;
                    case 4:
                        EntityHotDogCat hotdogcat = new EntityHotDogCat(this.world);
                        this.nameLoc(hotdogcat);
                        break;
                    case 5:
                        EntityRobotCat robotcat = new EntityRobotCat(this.world);
                        this.nameLoc(robotcat);
                        break;
                    case 6:
                        EntitySpaceCat spacecat = new EntitySpaceCat(this.world);
                        this.nameLoc(spacecat);
                        break;
                    case 7:
                        EntitySpiderCat spidercat = new EntitySpiderCat(this.world);
                        this.nameLoc(spidercat);
                        break;
                    case 8:
                        EntityChefCat chefcat = new EntityChefCat(this.world);
                        this.nameLoc(chefcat);
                        break;
                    case 9:
                        EntityGiraffeCat giraffecat = new EntityGiraffeCat(this.world);
                        this.nameLoc(giraffecat);
                        break;
                    case 10:
                        EntityCrazyCat crazycat = new EntityCrazyCat(this.world);
                        this.nameLoc(crazycat);
                        break;
                    }
                }
            }
            if(this.villageObj == null) {
                this.detachHome();
            } else {
                BlockPos blockpos1 = this.villageObj.getCenter();
                this.setHomePosAndDistance(blockpos1, this.villageObj.getVillageRadius());

                if(this.isLookingForHome) {
                    this.isLookingForHome = false;
                    this.villageObj.setDefaultPlayerReputation(5);
                }
            }
        }

        super.updateAITasks();
    }

    public void nameLoc(EntityLiving cat) {
        cat.setLocationAndAngles(this.posX + this.rand.nextInt(6), this.posY, this.posZ + this.rand.nextInt(6),
                this.rotationYaw, this.rotationPitch);
        if(this.hasCustomName()) {
            cat.setCustomNameTag(this.getCustomNameTag());
            cat.setAlwaysRenderNameTag(this.getAlwaysRenderNameTag());
        }
        if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY, this.posZ, 0, 0, 0);
        }
        this.world.spawnEntity(cat);
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    @Override
    protected boolean canDespawn() {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_VILLAGER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) {
        return SoundEvents.ENTITY_VILLAGER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_VILLAGER_DEATH;
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.LADYLOOT;
    }

    @Override
    public void onEntityUpdate() {
        if(!this.isEntityAlive()) {
            this.onDeath();
        }
        super.onEntityUpdate();
    }

    public void onDeath() {
        if(!this.world.isRemote) {
            EntityExplodingCat explodingcat = new EntityExplodingCat(this.world);
            this.nameLoc(explodingcat);
        }
    }

    public World getWorld() {
        return this.world;
    }

    public BlockPos getPos() {
        return new BlockPos(this);
    }

    @Override
    public float getEyeHeight() {
        return 1.62F;
    }

    @SideOnly(Side.CLIENT)
    private void spawnParticles(EnumParticleTypes particleType) {
        for(int i = 0; i < 5; ++i) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.world.spawnParticle(particleType, this.posX + this.rand.nextFloat() * this.width * 2.0F - this.width,
                    this.posY + 1.0D + this.rand.nextFloat() * this.height,
                    this.posZ + this.rand.nextFloat() * this.width * 2.0F - this.width, d0, d1, d2, new int[0]);
        }
    }

    public void setLookingForHome() {
        this.isLookingForHome = true;
    }

    @Override
    public boolean canBeLeashedTo(EntityPlayer player) {
        return false;
    }

    /**
     * Called when a lightning bolt hits the entity.
     */
    @Override
    public void onStruckByLightning(EntityLightningBolt lightningBolt) {
        if(!this.world.isRemote && !this.isDead) {
            EntityExplodingCat entityexplodingcat = new EntityExplodingCat(this.world);
            entityexplodingcat.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw,
                    this.rotationPitch);

            if(this.hasCustomName()) {
                entityexplodingcat.setCustomNameTag(this.getCustomNameTag());
                entityexplodingcat.setAlwaysRenderNameTag(this.getAlwaysRenderNameTag());
            }

            this.world.spawnEntity(entityexplodingcat);
            this.setDead();
        }
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }

}

package its_meow.derpcats.common.entity;

import its_meow.derpcats.init.ModSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntitySpiderCat extends EntityCat {

    private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte>createKey(EntitySpiderCat.class,
            DataSerializers.BYTE);

    public EntitySpiderCat(World worldIn) {
        super(worldIn);
        this.setSize(catWidth + 0.3F, catHeight);
    }

    /**
     * Returns new PathNavigateGround instance
     */
    @Override
    protected PathNavigate createNavigator(World worldIn) {
        return new PathNavigateClimber(this, worldIn);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(CLIMBING, Byte.valueOf((byte) 0));
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        super.onUpdate();

        if(!this.world.isRemote) {
            this.setBesideClimbableBlock(this.collidedHorizontally);
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(27.0F);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3F);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) {
        return ModSoundEvents.grumphit;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SPIDER_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
    }

    /**
     * returns true if this entity is by a ladder, false otherwise
     */
    @Override
    public boolean isOnLadder() {
        return this.isBesideClimbableBlock();
    }

    /**
     * Sets the Entity inside a web block.
     */
    @Override
    public void setInWeb() {

    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ARTHROPOD;
    }

    @Override
    public boolean isPotionApplicable(PotionEffect potioneffectIn) {
        return potioneffectIn.getPotion() == MobEffects.POISON ? false : super.isPotionApplicable(potioneffectIn);
    }

    /**
     * Returns true if the WatchableObject (Byte) is 0x01 otherwise returns false.
     * The WatchableObject is updated using setBesideClimableBlock.
     */
    public boolean isBesideClimbableBlock() {
        return (this.dataManager.get(CLIMBING).byteValue() & 1) != 0;
    }

    /**
     * Updates the WatchableObject (Byte) created in entityInit(), setting it to
     * 0x01 if par1 is true or 0x00 if it is false.
     */
    public void setBesideClimbableBlock(boolean climbing) {
        byte b0 = this.dataManager.get(CLIMBING).byteValue();

        if(climbing) {
            b0 = (byte) (b0 | 1);
        } else {
            b0 = (byte) (b0 & -2);
        }

        this.dataManager.set(CLIMBING, Byte.valueOf(b0));
    }

}

package its_meow.derpcats.common.entity;

import javax.annotation.Nullable;

import its_meow.derpcats.init.ModItems;
import its_meow.derpcats.init.ModLootTables;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityCat extends EntityAnimal {

    public static final float catWidth = 1.2F;
    public static final float catHeight = 1.8F;

    public EntityCat(World worldIn) {
        super(worldIn);
        this.setSize(catWidth, catHeight);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.23F));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, net.minecraft.entity.player.EntityPlayer.class, 10F));
        this.tasks.addTask(7, new EntityAITempt(this, 0.6D, ModItems.catnip, true));

    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(27.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1D);
    }

    @Override
    protected boolean canDespawn() {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.FARTLOOT;
    }

    @Override
    public float getEyeHeight() {
        return 2F;
    }

    @Override
    public void onStruckByLightning(EntityLightningBolt lightningBolt) {

    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }

}

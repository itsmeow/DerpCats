package its_meow.derpcats.common.entity;

import javax.annotation.Nullable;

import its_meow.derpcats.init.ModLootTables;
import its_meow.derpcats.init.ModSoundEvents;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityMeanCat extends EntityMob {

    public EntityMeanCat(World worldIn) {
        super(worldIn);
        this.setSize(1.2F, 1.8F);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIWanderAvoidWater(this, 0.23F));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, net.minecraft.entity.player.EntityPlayer.class, 10F));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 0.3D, false));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(27.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSoundEvents.growl;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) {
        return ModSoundEvents.grumphit;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSoundEvents.grumpdeath;
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.FARTLOOT;
    }

}

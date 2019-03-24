package its_meow.derpcats.common.entity;

import javax.annotation.Nullable;

import its_meow.derpcats.init.ModLootTables;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityHotDogCat extends EntityCat {

    public EntityHotDogCat(World worldIn) {
        super(worldIn);
        this.setSize(catWidth, catHeight);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIWanderAvoidWater(this, 0.23F));

    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    protected SoundEvent getHurtSound() {
        return SoundEvents.BLOCK_CLOTH_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.HOTDOGLOOT;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }

}

package its_meow.derpcats.common.entity;

import java.util.Random;

import its_meow.derpcats.init.ModItems;
import its_meow.derpcats.init.ModSoundEvents;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityCrazyCat extends EntityCat {

    public int headRoll = 0;
    public int legRoll = 0;
    private boolean mode = true;

    public EntityCrazyCat(World worldIn) {
        super(worldIn);
        this.setSize(catWidth, catHeight);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIWanderAvoidWater(this, 5F, 100));
        this.tasks.addTask(3, new EntityAITempt(this, 0.6D, ModItems.catnip, true));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(27.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(5D);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(this.headRoll + 1 <= 360) {
            this.headRoll++;
        } else {
            this.headRoll = 0;
        }
        if(this.legRoll + 1 <= 90 && this.mode) {
            this.legRoll++;
        } else if(this.legRoll - 1 >= 0 && !this.mode) {
            this.legRoll--;
        } else {
            this.mode = !this.mode;
        }
        Random rand = new Random();
        int chance = rand.nextInt(3000);
        if(chance == 300) {
            this.spawnExplosionParticle();
            this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1, 1);
            this.addVelocity(rand.nextInt(5), rand.nextInt(5), rand.nextInt(5));
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSoundEvents.grumphitlong;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) {
        return ModSoundEvents.grumphit;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSoundEvents.grumpdeath;
    }

}

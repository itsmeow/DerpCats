package its_meow.derpcats.common.entity;

import java.util.Random;

import its_meow.derpcats.init.ModSoundEvents;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityHopCat extends EntityCat {

    public EntityHopCat(World worldIn) {
        super(worldIn);

    }

    @Override
    protected void initEntityAI() {
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(27.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(100.0D);
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
        return ModSoundEvents.grumpdeath;
    }

    private int randomTickDivider;

    @Override
    protected void updateAITasks() {
        if(--this.randomTickDivider <= 0) {
            this.randomTickDivider = 70 + this.rand.nextInt(50);
            if(!this.world.isRemote) {
                Random rand = new Random();
                int ch = rand.nextInt(2);
                if(ch == 1) {

                    this.addVelocity(0, rand.nextFloat() + 0.1 + rand.nextFloat() - 0.1, 0);

                }
            }
        }

        super.updateAITasks();
    }

}

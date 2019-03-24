package its_meow.derpcats.common.entity;

import javax.annotation.Nullable;

import its_meow.derpcats.init.ModLootTables;
import its_meow.derpcats.init.ModSoundEvents;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityExplodingCat extends EntityCat {

    public EntityExplodingCat(World worldIn) {
        super(worldIn);
        this.setSize(catWidth, catHeight);
    }

    @Override
    public void playLivingSound() {
        this.playSound(SoundEvents.ENTITY_CAT_AMBIENT, 0.5F, 1.0F);
    }

    @Override
    public void onDeath(DamageSource cause) {
        if(!world.isRemote) {
            this.explode();
        }
        super.onDeath(cause);
    }

    public void explode() {
        this.world.createExplosion(this, this.posX, this.posY, this.posZ, 1F, true);
        this.setDead();
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        this.world.profiler.startSection("mobBaseTick");
        if(this.isEntityAlive() && this.rand.nextInt(10000) < this.livingSoundTime++) {
            // this.applyEntityAI();
            this.playLivingSound();
        }
        if(this.getHealth() < 25 && !this.world.isRemote) {
            if(this.isEntityAlive()) {
                this.explode();
            }
        }

        this.world.profiler.endSection();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) {
        this.playSound(ModSoundEvents.grumphit, 1, 1);
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        this.playSound(ModSoundEvents.grumpdeath, 1, 1);
        return null;
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.FARTLOOT;
    }

}

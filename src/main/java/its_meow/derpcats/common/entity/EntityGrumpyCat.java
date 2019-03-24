package its_meow.derpcats.common.entity;

import its_meow.derpcats.init.ModSoundEvents;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityGrumpyCat extends EntityCat {

    public EntityGrumpyCat(World worldIn) {
        super(worldIn);
        this.setSize(catWidth, catHeight);
    }

    @Override
    public void playLivingSound() {
        this.playSound(ModSoundEvents.grump, 1.5F, 1.0F);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        this.world.spawnParticle(EnumParticleTypes.VILLAGER_ANGRY, this.posX, this.posY + 1, this.posZ, 0.0D, 0.0D,
                0.0D);
        return ModSoundEvents.grump;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) {
        this.world.spawnParticle(EnumParticleTypes.VILLAGER_ANGRY, this.posX, this.posY + 1, this.posZ, 0.0D, 0.0D,
                0.0D);
        this.world.spawnParticle(EnumParticleTypes.VILLAGER_ANGRY, this.posX, this.posY + 1, this.posZ, 0.0D, 0.0D,
                0.0D);
        this.world.spawnParticle(EnumParticleTypes.VILLAGER_ANGRY, this.posX, this.posY + 1, this.posZ, 0.0D, 0.0D,
                0.0D);
        return ModSoundEvents.grumphit;
    }

    @Override
    public void onDeath(DamageSource cause) {
        if(!this.world.isRemote) {
            if(world.getGameRules().getBoolean("mobGriefing")) {
                this.world.createExplosion(this, this.posX, this.posY, this.posZ, 3F, true);
            }
            EntityLightningBolt entitylightning = new EntityLightningBolt(this.world, this.posX, this.posY, this.posZ,
                    false);
            this.world.spawnEntity(entitylightning);
        }
        super.onDeath(cause);
    }

    @Override
    protected SoundEvent getDeathSound() {
        this.world.spawnParticle(EnumParticleTypes.VILLAGER_ANGRY, this.posX, this.posY + 1, this.posZ, 0.0D, 0.0D,
                0.0D);
        this.world.spawnParticle(EnumParticleTypes.VILLAGER_ANGRY, this.posX + 0.1, this.posY + 1, this.posZ, 0.0D,
                0.0D, 0.0D);
        this.world.spawnParticle(EnumParticleTypes.VILLAGER_ANGRY, this.posX - 0.1, this.posY + 1, this.posZ, 0.0D,
                0.0D, 0.0D);
        this.world.spawnParticle(EnumParticleTypes.VILLAGER_ANGRY, this.posX, this.posY + 1, this.posZ + 0.1, 0.0D,
                0.0D, 0.0D);
        this.world.spawnParticle(EnumParticleTypes.VILLAGER_ANGRY, this.posX, this.posY + 1, this.posZ - 0.1, 0.0D,
                0.0D, 0.0D);
        return ModSoundEvents.grumpdeath;
    }

}

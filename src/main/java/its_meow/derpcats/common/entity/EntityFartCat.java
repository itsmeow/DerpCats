package its_meow.derpcats.common.entity;

import its_meow.derpcats.init.ModSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityFartCat extends EntityCat {

    public EntityFartCat(World worldIn) {
        super(worldIn);
        this.setSize(catWidth, catHeight);
    }

    public void sRP() {
        if(this.isSprinting() && !this.isInWater()) {
            this.cRP();
        }
    }

    public void cRP() {

        this.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY,
                this.posX + (this.rand.nextFloat() - 0.5D) * this.width, this.getEntityBoundingBox().minY + 0.1D,
                this.posZ + (this.rand.nextFloat() - 0.5D) * this.width, -this.motionX * 4.0D, 1.5D,
                -this.motionZ * 4.0D);

    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        this.world.profiler.startSection("mobBaseTick");
        this.sRP();
        if(this.isEntityAlive() && this.rand.nextInt(2000) < this.livingSoundTime++) {
            this.playLivingSound();
        }

        if(!this.isEntityAlive()) {
        }

        this.world.profiler.endSection();

    }

    @Override
    public void playLivingSound() {
        this.playSound(ModSoundEvents.fart, 1.0F, 1.0F);
        int i = MathHelper.floor(this.posX - 1);
        int j = MathHelper.floor(this.posY + 1);
        int k = MathHelper.floor(this.posZ - 1);
        BlockPos blockpos = new BlockPos(i, j, k);
        IBlockState iblockstate = this.world.getBlockState(blockpos);
        this.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY,
                this.posX + (this.rand.nextFloat() - 0.5D) * this.width, this.getEntityBoundingBox().minY + 0.1D,
                this.posZ + (this.rand.nextFloat() - 0.5D) * this.width, -this.motionX * 4.0D, 1.5D,
                -this.motionZ * 4.0D, new int[] { Block.getStateId(iblockstate) });
        this.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY,
                this.posX + (this.rand.nextFloat() - 0.5D) * this.width, this.getEntityBoundingBox().minY + 0.1D,
                this.posZ + (this.rand.nextFloat() - 0.5D) * this.width, -this.motionX * 4.0D, 1.5D,
                -this.motionZ * 4.0D, new int[] { Block.getStateId(iblockstate) });
        this.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY,
                this.posX + (this.rand.nextFloat() - 0.5D) * this.width, this.getEntityBoundingBox().minY + 0.1D,
                this.posZ + (this.rand.nextFloat() - 0.5D) * this.width, -this.motionX * 4.0D, 1.5D,
                -this.motionZ * 4.0D, new int[] { Block.getStateId(iblockstate) });

    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) {
        return ModSoundEvents.hit;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSoundEvents.death;
    }

}

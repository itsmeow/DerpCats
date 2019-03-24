package its_meow.derpcats.common.entity;

import javax.annotation.Nullable;

import its_meow.derpcats.common.particle.ParticleBasic;
import its_meow.derpcats.init.ModItems;
import its_meow.derpcats.init.ModLootTables;
import its_meow.derpcats.init.ModSoundEvents;
import its_meow.derpcats.init.ModTextures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityRobotCat extends EntityCat {

    public short[] writing = { 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1 };
    private int sortIndex = 0;

    public EntityRobotCat(World worldIn) {
        super(worldIn);
        this.setSize(catWidth, catHeight);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIWanderAvoidWater(this, 0.23F));
        this.tasks.addTask(3, new EntityAITempt(this, 0.6D, ModItems.catrobotcircuit, true));
    }

    @Override
    public void playLivingSound() {
        if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT && this.world.isRemote) {
            this.doParticleThing1();
        }
    }

    @SideOnly(Side.CLIENT)
    private void doParticleThing1() {
        Particle particlebinary1 = new ParticleBasic(this.world, this.posX, this.posY + 2.5,
                this.posZ + this.rand.nextInt(1), 0.0F, 0.0F, 0.0F, ModTextures.binary1, 4F);
        Particle particlebinary0 = new ParticleBasic(this.world, this.posX, this.posY + 2.5, this.posZ, 0.0F, 0.0F,
                0.0F, ModTextures.binary0, 4F);
        if(this.sortIndex == 16) {
            this.sortIndex = 0;
        }
        int print = this.writing[this.sortIndex];
        this.sortIndex++;

        if(print == 1) {
            Minecraft.getMinecraft().effectRenderer.addEffect(particlebinary1);
        }
        if(print == 0) {
            Minecraft.getMinecraft().effectRenderer.addEffect(particlebinary0);
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) // sets hurt sound (the sound played when damaged or hit)
    {
        this.playSound(ModSoundEvents.alert, 1.0F, 1.0F);
        if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT && this.world.isRemote) {
            this.doParticleThing2();
        }
        return null;
    }

    @SideOnly(Side.CLIENT)
    private void doParticleThing2() {
        Particle particlealert = new ParticleBasic(this.world, this.posX, this.posY + 2.5, this.posZ, 0.0F, 0.0F, 0.0F,
                ModTextures.alert, 2.3F);
        Minecraft.getMinecraft().effectRenderer.addEffect(particlealert);
    }

    @Override
    protected SoundEvent getDeathSound() // sets death sound (the sound played when entity dies)
    {
        this.playSound(ModSoundEvents.shutdown, 1.0F, 1.0F);
        return null;
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.ROBOTLOOT;
    }

}

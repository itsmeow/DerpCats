package its_meow.derpcats.common.entity;

import java.util.Random;

import its_meow.derpcats.init.ModItems;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityChefCat extends EntityCat {

    public EntityChefCat(World worldIn) {
        super(worldIn);
        this.setSize(catWidth, catHeight);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIWanderAvoidWater(this, 0.23F));
        this.tasks.addTask(3, new EntityAITempt(this, 0.6D, ModItems.catnip, true));
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        Random rand = new Random();
        if(rand.nextInt(5000) == 40) {
            EntityItem item = new EntityItem(this.world, this.posX, this.posY, this.posZ,
                    new ItemStack(Items.COOKED_BEEF, 1));
            this.world.spawnEntity(item);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) {
        return SoundEvents.BLOCK_FIRE_EXTINGUISH;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_LAVA_EXTINGUISH;
    }

}

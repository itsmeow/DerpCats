package its_meow.derpcats.common.entity;

import javax.annotation.Nullable;

import its_meow.derpcats.init.ModLootTables;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntitySpaceCat extends EntityCat {

    public EntitySpaceCat(World worldIn) {
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(27.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(100.0D);
    }

    @Override
    public void onDeath(DamageSource cause) {
        if(!this.world.isRemote) {
            this.world.createExplosion(this, this.posX, this.posY, this.posZ, 3F, true);
        }
        super.onDeath(cause);
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.FARTLOOT;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }

}

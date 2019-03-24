package its_meow.derpcats.common.entity;

import javax.annotation.Nullable;

import its_meow.derpcats.init.ModLootTables;
import its_meow.derpcats.init.ModSoundEvents;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityGiantCat extends EntityCat {

    public EntityGiantCat(World worldIn) {
        super(worldIn);
        this.setSize(4F/* width */, 9.4F/* height */);
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource d) {
        this.playSound(ModSoundEvents.grumphit, 2.0F, 0.5F);
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        this.playSound(ModSoundEvents.grumpdeath, 2.0F, 0.5F);
        return null;
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.GIANTLOOT;
    }

}

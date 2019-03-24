package its_meow.derpcats.common.dimension;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class CatTeleporter extends Teleporter {
    private BlockPos destPos;

    public CatTeleporter(WorldServer worldIn, BlockPos destinationPos) {
        super(worldIn);
        this.destPos = destinationPos;
    }

    @Override
    public void placeInPortal(Entity entityIn, float rotationYaw) {
        if(this.destPos == null) {
            System.out.println(this.world.getWorldType().getName());
            BlockPos spawn = this.world.getSpawnPoint();
            spawn = this.world.getTopSolidOrLiquidBlock(spawn);
            entityIn.setLocationAndAngles(spawn.getX(), spawn.getY(), spawn.getZ(), rotationYaw,
                    entityIn.rotationPitch);
        } else {
            entityIn.setLocationAndAngles(this.destPos.getX(), this.destPos.getY(), this.destPos.getZ(), rotationYaw,
                    entityIn.rotationPitch);
        }
    }

    public double getPointSign(double doubleIn) {
        if(doubleIn >= 0) {
            return 0.5D;
        } else if(doubleIn < 0) {
            return -0.5D;
        } else {
            return 0D;
        }
    }

    @Override
    public boolean placeInExistingPortal(Entity entityIn, float p_180620_2_) {
        return false;
    }

}
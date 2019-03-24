package its_meow.derpcats.common.dimension;

import java.util.Random;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class CatTeleporter extends Teleporter {
    private final WorldServer worldServerInstance;
    private final Random random;
    private final Long2ObjectMap<Teleporter.PortalPosition> destinationCoordinateCache = new Long2ObjectOpenHashMap(
            4096);
    private BlockPos destPos;

    public CatTeleporter(WorldServer worldIn, BlockPos destinationPos) {
        super(worldIn);
        this.worldServerInstance = worldIn;
        this.random = new Random(worldIn.getSeed());
        this.destPos = destinationPos;
    }

    @Override
    public void placeInPortal(Entity entityIn, float rotationYaw) {
        if(this.destPos == null) {
            System.out.println(this.worldServerInstance.getWorldType().getName());
            BlockPos spawn = this.worldServerInstance.getSpawnPoint();
            spawn = this.worldServerInstance.getTopSolidOrLiquidBlock(spawn);
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

    private boolean isPositionClear(BlockPos pos) {
        return !this.worldServerInstance.isAirBlock(pos) || !this.worldServerInstance.isAirBlock(pos.up());
    }

}
package its_meow.derpcats.common.dimension;

import its_meow.derpcats.init.ModDimensions;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderCatLand extends WorldProvider {

    @Override
    public DimensionType getDimensionType() {
        return ModDimensions.catland;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new CatChunkGeneratorReloaded(this.world, this.world.getSeed(), true);
    }

    @Override
    public boolean canRespawnHere() {
        return true;
    }

    @Override
    public boolean hasSkyLight() {
        return true;
    }

    @Override
    public boolean canSnowAt(BlockPos pos, boolean checkLight) {
        return false;
    }

    @Override
    public boolean canDoRainSnowIce(Chunk chunk) {
        return false;
    }

    @Override
    public BiomeProvider getBiomeProvider() {
        return super.getBiomeProvider();
    }

}

package its_meow.derpcats.common.dimension;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import its_meow.derpcats.init.ModBiomes;
import its_meow.derpcats.init.ModBlocks;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.gen.structure.StructureOceanMonument;

public class CatChunkGeneratorReloaded implements IChunkGenerator {
    protected static final IBlockState STONE = Blocks.STONE.getDefaultState();
    private final Random rand;
    private NoiseGeneratorOctaves minLimitPerlinNoise;
    private NoiseGeneratorOctaves maxLimitPerlinNoise;
    private NoiseGeneratorOctaves mainPerlinNoise;
    private NoiseGeneratorPerlin surfaceNoise;
    public NoiseGeneratorOctaves scaleNoise;
    public NoiseGeneratorOctaves depthNoise;
    public NoiseGeneratorOctaves forestNoise;
    private final World world;
    private final boolean mapFeaturesEnabled;
    private final WorldType terrainType;
    private final double[] heightMap;
    private final float[] biomeWeights;
    private IBlockState oceanBlock = Blocks.WATER.getDefaultState();
    private double[] depthBuffer = new double[256];
    private MapGenBase caveGenerator = new MapGenCaves();
    private MapGenStronghold strongholdGenerator = new MapGenStronghold();
    private MapGenVillage villageGenerator = new MapGenVillage();
    private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
    private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
    private MapGenBase ravineGenerator = new MapGenRavine();
    private StructureOceanMonument oceanMonumentGenerator = new StructureOceanMonument();
    private Biome[] biomesForGeneration = { ModBiomes.biomecat };
    double[] mainNoiseRegion;
    double[] minLimitRegion;
    double[] maxLimitRegion;
    double[] depthRegion;

    public CatChunkGeneratorReloaded(World worldIn, long seed, boolean mapFeaturesEnabledIn) {
        {
            this.caveGenerator = net.minecraftforge.event.terraingen.TerrainGen.getModdedMapGen(this.caveGenerator,
                    net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.CAVE);

            this.strongholdGenerator = (MapGenStronghold) net.minecraftforge.event.terraingen.TerrainGen
                    .getModdedMapGen(this.strongholdGenerator,
                            net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.STRONGHOLD);

            this.villageGenerator = (MapGenVillage) net.minecraftforge.event.terraingen.TerrainGen.getModdedMapGen(
                    this.villageGenerator, net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.VILLAGE);

            this.mineshaftGenerator = (MapGenMineshaft) net.minecraftforge.event.terraingen.TerrainGen.getModdedMapGen(
                    this.mineshaftGenerator, net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.MINESHAFT);

            this.scatteredFeatureGenerator = (MapGenScatteredFeature) net.minecraftforge.event.terraingen.TerrainGen
                    .getModdedMapGen(this.scatteredFeatureGenerator,
                            net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.SCATTERED_FEATURE);

            this.ravineGenerator = net.minecraftforge.event.terraingen.TerrainGen.getModdedMapGen(this.ravineGenerator,
                    net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.RAVINE);
            this.oceanMonumentGenerator = (StructureOceanMonument) net.minecraftforge.event.terraingen.TerrainGen
                    .getModdedMapGen(this.oceanMonumentGenerator,
                            net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.OCEAN_MONUMENT);

        }
        this.world = worldIn;
        this.mapFeaturesEnabled = mapFeaturesEnabledIn;
        this.terrainType = worldIn.getWorldInfo().getTerrainType();
        this.rand = new Random(seed);
        this.minLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.maxLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.mainPerlinNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.surfaceNoise = new NoiseGeneratorPerlin(this.rand, 4);
        this.scaleNoise = new NoiseGeneratorOctaves(this.rand, 10);
        this.depthNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.forestNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.heightMap = new double[825];
        this.biomeWeights = new float[25];

        for(int i = -2; i <= 2; ++i) {
            for(int j = -2; j <= 2; ++j) {
                float f = 10.0F / MathHelper.sqrt(i * i + j * j + 0.2F);
                this.biomeWeights[i + 2 + (j + 2) * 5] = f;
            }
        }
        this.oceanBlock = Blocks.WATER.getDefaultState();
        worldIn.setSeaLevel(63);

        net.minecraftforge.event.terraingen.InitNoiseGensEvent.ContextOverworld ctx = new net.minecraftforge.event.terraingen.InitNoiseGensEvent.ContextOverworld(
                this.minLimitPerlinNoise, this.maxLimitPerlinNoise, this.mainPerlinNoise, this.surfaceNoise,
                this.scaleNoise, this.depthNoise, this.forestNoise);
        ctx = net.minecraftforge.event.terraingen.TerrainGen.getModdedNoiseGenerators(worldIn, this.rand, ctx);
        this.minLimitPerlinNoise = ctx.getLPerlin1();
        this.maxLimitPerlinNoise = ctx.getLPerlin2();
        this.mainPerlinNoise = ctx.getPerlin();
        this.surfaceNoise = ctx.getHeight();
        this.scaleNoise = ctx.getScale();
        this.depthNoise = ctx.getDepth();
        this.forestNoise = ctx.getForest();
    }

    public void setBlocksInChunk(int chunkX, int chunkZ, ChunkPrimer primer) {
        this.generateHeightmap(chunkX * 4, 0, chunkZ * 4);
        for(int x4 = 0; x4 < 4; ++x4) {
            int l = x4 * 5;
            int i1 = (x4 + 1) * 5;

            for(int z4 = 0; z4 < 4; ++z4) {
                int k1 = (l + z4) * 33;
                int l1 = (l + z4 + 1) * 33;
                int i2 = (i1 + z4) * 33;
                int j2 = (i1 + z4 + 1) * 33;

                for(int height32 = 0; height32 < 32; ++height32) {
                    double d0 = 0.125D;
                    double d1 = this.heightMap[k1 + height32];
                    double d2 = this.heightMap[l1 + height32];
                    double d3 = this.heightMap[i2 + height32];
                    double d4 = this.heightMap[j2 + height32];
                    double d5 = (this.heightMap[k1 + height32 + 1] - d1) * d0;
                    double d6 = (this.heightMap[l1 + height32 + 1] - d2) * d0;
                    double d7 = (this.heightMap[i2 + height32 + 1] - d3) * d0;
                    double d8 = (this.heightMap[j2 + height32 + 1] - d4) * d0;

                    for(int h = 0; h < 8; ++h) {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;
                        int height = (height32 * 8) + h;

                        for(int x = 0; x < 4; ++x) {
                            double d14 = 0.25D;
                            double d16 = (d11 - d10) * d14;
                            double d15 = d10 - d16;

                            for(int z = 0; z < 4; ++z) {
                                if(height < 2) {
                                    primer.setBlockState(x4 * 4 + x, height32 * 8 + h, z4 * 4 + z,
                                            Blocks.BEDROCK.getDefaultState());
                                } else if((d15 += d16) > 0.0D) {
                                    primer.setBlockState(x4 * 4 + x, height32 * 8 + h + 1, z4 * 4 + z,
                                            ModBlocks.catdirtblock.getDefaultState());
                                    primer.setBlockState(x4 * 4 + x, height32 * 8 + h, z4 * 4 + z,
                                            ModBlocks.catnipblock.getDefaultState());
                                }
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    public void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn) {
        if(!net.minecraftforge.event.ForgeEventFactory.onReplaceBiomeBlocks(this, x, z, primer, this.world)) {
            return;
        }
        this.depthBuffer = this.surfaceNoise.getRegion(this.depthBuffer, x * 16, z * 16, 16, 16, 0.0625D, 0.0625D,
                1.0D);

        for(int i = 0; i < 16; ++i) {
            for(int j = 0; j < 16; ++j) {
                Biome biome = ModBiomes.biomecat;
                biome.genTerrainBlocks(this.world, this.rand, primer, x * 16 + i, z * 16 + j,
                        this.depthBuffer[j + i * 16]);
                // biome.decorate(world, rand, new BlockPos(x * 16 + i, this.depthBuffer[j + i *
                // 16], z * 16 + j));
            }
        }
    }

    /**
     * Generates the chunk at the specified position, from scratch
     */
    @Override
    public Chunk generateChunk(int x, int z) {
        this.rand.setSeed(x * 341873128712L + z * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.setBlocksInChunk(x, z, chunkprimer);

        this.replaceBiomeBlocks(x, z, chunkprimer, this.biomesForGeneration);

        this.caveGenerator.generate(this.world, x, z, chunkprimer);

        this.ravineGenerator.generate(this.world, x, z, chunkprimer);

        this.mineshaftGenerator.generate(this.world, x, z, chunkprimer);

        this.oceanMonumentGenerator.generate(this.world, x, z, chunkprimer);

        Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
        byte[] abyte = chunk.getBiomeArray();

        for(int i = 0; i < abyte.length; ++i) {
            abyte[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[0]);
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    private void generateHeightmap(int chunkX4, int chunkY4, int chunkZ4) {
        this.depthRegion = this.depthNoise.generateNoiseOctaves(this.depthRegion, chunkX4, chunkZ4, 5, 5, 200.0D,
                200.0D, 0.5D);
        this.mainNoiseRegion = this.mainPerlinNoise.generateNoiseOctaves(this.mainNoiseRegion, chunkX4, chunkY4,
                chunkZ4, 5, 33, 5, 8.55515D, 4.277575D, 8.55515D);
        this.minLimitRegion = this.minLimitPerlinNoise.generateNoiseOctaves(this.minLimitRegion, chunkX4, chunkY4,
                chunkZ4, 5, 33, 5, 684.412D, 684.412D, 684.412D);
        this.maxLimitRegion = this.maxLimitPerlinNoise.generateNoiseOctaves(this.maxLimitRegion, chunkX4, chunkY4,
                chunkZ4, 5, 33, 5, 684.412D, 684.412D, 684.412D);
        int i = 0;
        int j = 0;

        for(int k = 0; k < 5; ++k) {
            for(int l = 0; l < 5; ++l) {
                float f2 = 0.0F;
                float f3 = 0.0F;
                float f4 = 0.0F;
                Biome biome = ModBiomes.biomecat;

                for(int j1 = -2; j1 <= 2; ++j1) {
                    for(int k1 = -2; k1 <= 2; ++k1) {
                        Biome biome1 = ModBiomes.biomecat;
                        float f5 = biome1.getBaseHeight();
                        float f6 = biome1.getHeightVariation();

                        if(this.terrainType == WorldType.AMPLIFIED && f5 > 0.0F) {
                            f5 = 1.0F + f5 * 2.0F;
                            f6 = 1.0F + f6 * 4.0F;
                        }

                        float f7 = this.biomeWeights[j1 + 2 + (k1 + 2) * 5] / (f5 + 2.0F);

                        if(biome1.getBaseHeight() > biome.getBaseHeight()) {
                            f7 /= 2.0F;
                        }

                        f2 += f6 * f7;
                        f3 += f5 * f7;
                        f4 += f7;
                    }
                }

                f2 = f2 / f4;
                f3 = f3 / f4;
                f2 = f2 * 0.9F + 0.1F;
                f3 = (f3 * 4.0F - 1.0F) / 8.0F;
                double d7 = this.depthRegion[j] / 8000.0D;

                if(d7 < 0.0D) {
                    d7 = -d7 * 0.3D;
                }

                d7 = d7 * 3.0D - 2.0D;

                if(d7 < 0.0D) {
                    d7 = d7 / 2.0D;

                    if(d7 < -1.0D) {
                        d7 = -1.0D;
                    }

                    d7 = d7 / 1.4D;
                    d7 = d7 / 2.0D;
                } else {
                    if(d7 > 1.0D) {
                        d7 = 1.0D;
                    }

                    d7 = d7 / 8.0D;
                }

                ++j;
                double d8 = f3;
                double d9 = f2;
                d8 = d8 + d7 * 0.2D;
                d8 = d8 * 8.5D / 8.0D;
                double d0 = 8.5D + d8 * 4.0D;

                for(int l1 = 0; l1 < 33; ++l1) {
                    double d1 = (l1 - d0) * 12.0D * 128.0D / 256.0D / d9;

                    if(d1 < 0.0D) {
                        d1 *= 4.0D;
                    }

                    double d2 = this.minLimitRegion[l] / 512.0D;
                    double d3 = this.maxLimitRegion[l] / 512.0D;
                    double d4 = (this.mainNoiseRegion[i] / 10.0D + 1.0D) / 2.0D;
                    double d5 = MathHelper.clampedLerp(d2, d3, d4) - d1;

                    if(l1 > 29) {
                        double d6 = (l1 - 29) / 3.0F;
                        d5 = d5 * (1.0D - d6) + -10.0D * d6;
                    }

                    this.heightMap[i] = d5;
                    ++i;
                }
            }
        }
    }

    /**
     * Generate initial structures in this chunk, e.g. mineshafts, temples, lakes,
     * and dungeons
     */
    @Override
    public void populate(int x, int z) {
        BlockFalling.fallInstantly = true;
        int i = x * 16;
        int j = z * 16;
        BlockPos blockpos = new BlockPos(i, 0, j);
        Biome biome = this.world.getBiome(blockpos.add(16, 0, 16));
        this.rand.setSeed(this.world.getSeed());
        long k = this.rand.nextLong() / 2L * 2L + 1L;
        long l = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(x * k + z * l ^ this.world.getSeed());
        boolean flag = false;
        ChunkPos chunkpos = new ChunkPos(x, z);

        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, this, this.world, this.rand, x, z, flag);

        this.mineshaftGenerator.generateStructure(this.world, this.rand, chunkpos);

        this.oceanMonumentGenerator.generateStructure(this.world, this.rand, chunkpos);

        if(biome != Biomes.DESERT && biome != Biomes.DESERT_HILLS && true && !flag && this.rand.nextInt(8) == 0) {
            if(net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, x, z, flag,
                    net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE)) {
                int i1 = this.rand.nextInt(16) + 8;
                int j1 = this.rand.nextInt(256);
                int k1 = this.rand.nextInt(16) + 8;
                (new WorldGenLakes(Blocks.WATER)).generate(this.world, this.rand, blockpos.add(i1, j1, k1));
            }
        }

        if(net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, x, z, flag,
                net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.DUNGEON)) {
            for(int j2 = 0; j2 < 5; ++j2) {
                int i3 = this.rand.nextInt(16) + 8;
                int l3 = this.rand.nextInt(256);
                int l1 = this.rand.nextInt(16) + 8;
                (new WorldGenDungeons()).generate(this.world, this.rand, blockpos.add(i3, l3, l1));
            }
        }

        biome.decorate(this.world, this.rand, new BlockPos(i, 0, j));
        if(net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, x, z, flag,
                net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ANIMALS)) {
            WorldEntitySpawner.performWorldGenSpawning(this.world, biome, i + 8, j + 8, 16, 16, this.rand);
        }
        blockpos = blockpos.add(8, 0, 8);

        if(net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, x, z, flag,
                net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE)) {
            for(int k2 = 0; k2 < 16; ++k2) {
                for(int j3 = 0; j3 < 16; ++j3) {
                    BlockPos blockpos1 = this.world.getPrecipitationHeight(blockpos.add(k2, 0, j3));
                    BlockPos blockpos2 = blockpos1.down();

                    if(this.world.canBlockFreezeWater(blockpos2)) {
                        this.world.setBlockState(blockpos2, Blocks.ICE.getDefaultState(), 2);
                    }

                    if(this.world.canSnowAt(blockpos1, true)) {
                        this.world.setBlockState(blockpos1, Blocks.SNOW_LAYER.getDefaultState(), 2);
                    }
                }
            }
        } // Forge: End ICE

        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(false, this, this.world, this.rand, x, z, flag);

        BlockFalling.fallInstantly = false;
    }

    /**
     * Called to generate additional structures after initial worldgen, used by
     * ocean monuments
     */
    @Override
    public boolean generateStructures(Chunk chunkIn, int x, int z) {
        boolean flag = false;

        if(chunkIn.getInhabitedTime() < 3600L) {
            flag |= this.oceanMonumentGenerator.generateStructure(this.world, this.rand, new ChunkPos(x, z));
        }

        return flag;
    }

    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        Biome biome = this.world.getBiome(pos);

        return biome.getSpawnableList(creatureType);
    }

    @Override
    public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
        if(!this.mapFeaturesEnabled) {
            return false;
        } else if("Monument".equals(structureName) && this.oceanMonumentGenerator != null) {
            return this.oceanMonumentGenerator.isInsideStructure(pos);
        } else if("Mineshaft".equals(structureName) && this.mineshaftGenerator != null) {
            return this.mineshaftGenerator.isInsideStructure(pos);
        } else {
            return "Temple".equals(structureName) && this.scatteredFeatureGenerator != null
                    ? this.scatteredFeatureGenerator.isInsideStructure(pos)
                    : false;
        }
    }

    @Override
    @Nullable
    public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position,
            boolean findUnexplored) {
        if(!this.mapFeaturesEnabled) {
            return null;
        } else if("Monument".equals(structureName) && this.oceanMonumentGenerator != null) {
            return this.oceanMonumentGenerator.getNearestStructurePos(worldIn, position, findUnexplored);
        } else if("Mineshaft".equals(structureName) && this.mineshaftGenerator != null) {
            return this.mineshaftGenerator.getNearestStructurePos(worldIn, position, findUnexplored);
        } else {
            return "Temple".equals(structureName) && this.scatteredFeatureGenerator != null
                    ? this.scatteredFeatureGenerator.getNearestStructurePos(worldIn, position, findUnexplored)
                    : null;
        }
    }

    /**
     * Recreates data about structures intersecting given chunk (used for example by
     * getPossibleCreatures), without placing any blocks. When called for the first
     * time before any chunk is generated - also initializes the internal state
     * needed by getPossibleCreatures.
     */
    @Override
    public void recreateStructures(Chunk chunkIn, int x, int z) {

        this.mineshaftGenerator.generate(this.world, x, z, (ChunkPrimer) null);

        this.oceanMonumentGenerator.generate(this.world, x, z, (ChunkPrimer) null);

    }
}
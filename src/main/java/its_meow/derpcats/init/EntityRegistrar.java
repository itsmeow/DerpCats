package its_meow.derpcats.init;

import java.util.ArrayList;

import its_meow.derpcats.DerpCatsMod;
import its_meow.derpcats.Ref;
import its_meow.derpcats.common.entity.EntityCatLady;
import its_meow.derpcats.common.entity.EntityChefCat;
import its_meow.derpcats.common.entity.EntityCompanionCat;
import its_meow.derpcats.common.entity.EntityCrazyCat;
import its_meow.derpcats.common.entity.EntityExplodingCat;
import its_meow.derpcats.common.entity.EntityFartCat;
import its_meow.derpcats.common.entity.EntityGiantCat;
import its_meow.derpcats.common.entity.EntityGiraffeCat;
import its_meow.derpcats.common.entity.EntityGrumpyCat;
import its_meow.derpcats.common.entity.EntityHopCat;
import its_meow.derpcats.common.entity.EntityHotDogCat;
import its_meow.derpcats.common.entity.EntityMeanCat;
import its_meow.derpcats.common.entity.EntityRobotCat;
import its_meow.derpcats.common.entity.EntitySpaceCat;
import its_meow.derpcats.common.entity.EntitySpiderCat;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityRegistrar {
    private static int modEntities;
    
    public static ArrayList<ResourceLocation> entities = new ArrayList<ResourceLocation>();

    public static void init() {
        regCre(EntityFartCat.class, "fartcat", 0xFF052E, 0x14FFFC, 25, 1, 3, Biomes.PLAINS, Biomes.FOREST,
                Biomes.FOREST_HILLS, Biomes.SAVANNA, Biomes.MUTATED_FOREST, Biomes.MUTATED_SAVANNA, Biomes.DEFAULT,
                ModBiomes.biomecat);
        regCre(EntityExplodingCat.class, "explodingcat", 0x0B9509, 0x000000, 15, 1, 1, Biomes.PLAINS, Biomes.FOREST,
                Biomes.FOREST_HILLS, Biomes.SAVANNA, Biomes.MUTATED_FOREST, Biomes.MUTATED_SAVANNA, Biomes.DEFAULT,
                ModBiomes.biomecat);
        regCre(EntityGrumpyCat.class, "grumpycat", 0xFFFFFF, 0xA86100, 18, 1, 3, Biomes.PLAINS, Biomes.FOREST,
                Biomes.FOREST_HILLS, Biomes.SAVANNA, Biomes.MUTATED_FOREST, Biomes.MUTATED_SAVANNA, Biomes.DEFAULT,
                ModBiomes.biomecat);
        regCre(EntityCompanionCat.class, "companioncat", 0xFF8F95, 0xF467B2, 14, 1, 1, Biomes.PLAINS, Biomes.FOREST,
                Biomes.FOREST_HILLS, Biomes.SAVANNA, Biomes.MUTATED_FOREST, Biomes.MUTATED_SAVANNA, Biomes.DEFAULT,
                ModBiomes.biomecat);
        regMob(EntityMeanCat.class, "meancat", 0xFF1F28, 0xFFC71F, 10, 1, 3, Biomes.FOREST, Biomes.BIRCH_FOREST,
                Biomes.BIRCH_FOREST_HILLS, Biomes.FOREST_HILLS, Biomes.ROOFED_FOREST, ModBiomes.biomecat);
        regCre(EntityRobotCat.class, "robotcat", 0x000000, 0x828282, 18, 1, 3, Biomes.EXTREME_HILLS,
                Biomes.EXTREME_HILLS_EDGE, Biomes.EXTREME_HILLS_WITH_TREES, Biomes.DESERT_HILLS,
                Biomes.COLD_TAIGA_HILLS, Biomes.FOREST_HILLS, Biomes.JUNGLE_HILLS, Biomes.ICE_MOUNTAINS,
                Biomes.REDWOOD_TAIGA_HILLS, Biomes.TAIGA_HILLS, Biomes.SAVANNA_PLATEAU, Biomes.MUTATED_EXTREME_HILLS,
                Biomes.MUTATED_EXTREME_HILLS_WITH_TREES, ModBiomes.biomecat);
        regCre(EntitySpaceCat.class, "spacecat", 0x000000, 0xFFFFFF, 20, 1, 3, Biomes.EXTREME_HILLS,
                Biomes.EXTREME_HILLS_EDGE, Biomes.EXTREME_HILLS_WITH_TREES, Biomes.DESERT_HILLS,
                Biomes.COLD_TAIGA_HILLS, Biomes.FOREST_HILLS, Biomes.JUNGLE_HILLS, Biomes.ICE_MOUNTAINS,
                Biomes.REDWOOD_TAIGA_HILLS, Biomes.TAIGA_HILLS, Biomes.SAVANNA_PLATEAU, Biomes.MUTATED_EXTREME_HILLS,
                Biomes.MUTATED_EXTREME_HILLS_WITH_TREES, ModBiomes.biomecat);
        register(EntityGiantCat.class, "giantcat", 0xF3E5D8, 0x80FF8D);
        regCre(EntitySpiderCat.class, "spidercat", 0x828282, 0xFF1F28, 12, 1, 2, Biomes.FOREST, Biomes.FOREST_HILLS,
                Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, ModBiomes.biomecat);
        regCre(EntityHotDogCat.class, "hotdogcat", 0xE59100, 0x7F0000, 10, 1, 3, Biomes.DESERT, Biomes.DESERT_HILLS,
                Biomes.MESA, Biomes.MESA_ROCK, Biomes.MUTATED_DESERT, Biomes.MUTATED_MESA, Biomes.MUTATED_MESA_ROCK,
                ModBiomes.biomecat);
        regCre(EntityCatLady.class, "catlady", 0x6b6364, 0xa0a0a0, 8, 1, 1, Biomes.SAVANNA, Biomes.PLAINS,
                Biomes.DEFAULT, Biomes.JUNGLE_EDGE, Biomes.MUSHROOM_ISLAND, Biomes.MUSHROOM_ISLAND_SHORE,
                Biomes.MUTATED_SAVANNA, ModBiomes.biomecat);
        regCre(EntityHopCat.class, "hopcat", 0xffffff, 0x000000, 18, 5, 10, Biomes.BEACH, Biomes.COLD_BEACH,
                Biomes.COLD_TAIGA, Biomes.COLD_TAIGA_HILLS, Biomes.TAIGA, Biomes.TAIGA_HILLS, Biomes.PLAINS,
                Biomes.ICE_PLAINS, Biomes.MUTATED_PLAINS, Biomes.MUTATED_ICE_FLATS, Biomes.MUTATED_TAIGA,
                Biomes.MUTATED_TAIGA_COLD, ModBiomes.biomecat);
        regCre(EntityChefCat.class, "chefcat", 0xf78002, 0xff0000, 14, 1, 1, Biomes.PLAINS, Biomes.FOREST,
                Biomes.FOREST_HILLS, Biomes.SAVANNA, Biomes.MUTATED_SAVANNA, Biomes.MUTATED_FOREST, Biomes.DEFAULT,
                ModBiomes.biomecat);
        regCre(EntityGiraffeCat.class, "giraffecat", 0xffdd87, 0x5b4e2c, 20, 2, 4, Biomes.SAVANNA,
                Biomes.SAVANNA_PLATEAU, Biomes.MUTATED_SAVANNA, Biomes.MUTATED_SAVANNA_ROCK, ModBiomes.biomecat);
        regCre(EntityCrazyCat.class, "crazycat", 0x7300ad, 0xffaac4, 11, 1, 4, Biomes.PLAINS, Biomes.SWAMPLAND,
                Biomes.MUTATED_SWAMPLAND, Biomes.MUSHROOM_ISLAND, Biomes.MUSHROOM_ISLAND_SHORE, Biomes.COLD_BEACH,
                Biomes.COLD_TAIGA, Biomes.COLD_TAIGA_HILLS, Biomes.FROZEN_OCEAN, Biomes.FROZEN_RIVER,
                Biomes.ICE_MOUNTAINS, Biomes.ICE_PLAINS, Biomes.MUTATED_ICE_FLATS, Biomes.MUTATED_TAIGA_COLD,
                Biomes.DEFAULT, ModBiomes.biomecat);
    }

    // #################################################################################

    public static void regCre(Class EntityClass, String entityNameIn, int solidColorIn, int spotColorIn, int prob,
            int min, int max, Biome... biomes) {
        register(EntityClass, entityNameIn, solidColorIn, spotColorIn);
        registerCreatureSpawn(EntityClass, prob, min, max, biomes);
    }

    public static void regMob(Class EntityClass, String entityNameIn, int solidColorIn, int spotColorIn, int prob,
            int min, int max, Biome... biomes) {
        register(EntityClass, entityNameIn, solidColorIn, spotColorIn);
        registerMobSpawn(EntityClass, prob, min, max, biomes);
    }

    public static void register(Class EntityClass, String entityNameIn, int solidColorIn, int spotColorIn) {
        ResourceLocation rl = new ResourceLocation(Ref.MOD_ID + ":" + entityNameIn + "loc");
        EntityRegistry.registerModEntity(rl, EntityClass,
                entityNameIn, ++modEntities, DerpCatsMod.mod, 64, 1, true, solidColorIn, spotColorIn);
        entities.add(rl);
    }

    public static void registerCreatureSpawn(Class EntityClass, int prob, int min, int max, Biome... biomes) {
        EntityRegistry.addSpawn(EntityClass, prob, min, max, EnumCreatureType.CREATURE, biomes);
    }

    public static void registerMobSpawn(Class EntityClass, int prob, int min, int max, Biome... biomes) {
        EntityRegistry.addSpawn(EntityClass, prob, min, max, EnumCreatureType.MONSTER, biomes);
    }

    // ####################################################################################

}

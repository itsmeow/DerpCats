package its_meow.derpcats.common.biome;

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
import its_meow.derpcats.common.entity.EntityRobotCat;
import its_meow.derpcats.common.entity.EntitySpaceCat;
import its_meow.derpcats.common.entity.EntitySpiderCat;
import its_meow.derpcats.init.ModBlocks;
import net.minecraft.world.biome.Biome;

public class BiomeCat extends Biome {

    public BiomeCat() {
        super(new Biome.BiomeProperties("BiomeCat"));
        this.topBlock = ModBlocks.catdirtblock.getDefaultState();
        this.fillerBlock = ModBlocks.catnipblock.getDefaultState();
        this.decorator.treesPerChunk = 5;
        this.decorator.grassPerChunk = 1;
        this.decorator.flowersPerChunk = 1;
        this.decorator.gravelPatchesPerChunk = 0;
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityFartCat.class, 100, 1, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGrumpyCat.class, 100, 1, 3));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityExplodingCat.class, 100, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCompanionCat.class, 100, 1, 2));
        // this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityMeanCat.class, 1,
        // 1, 1));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySpaceCat.class, 100, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityRobotCat.class, 100, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySpiderCat.class, 100, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGiantCat.class, 95, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityHopCat.class, 100, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCatLady.class, 30, 0, 1));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChefCat.class, 100, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGiraffeCat.class, 100, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCrazyCat.class, 100, 1, 2));
    }

}

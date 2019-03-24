package its_meow.derpcats.init;

import static its_meow.derpcats.init.ModBiomes.biomecat;
import static its_meow.derpcats.init.ModBlocks.catdirtblock;
import static its_meow.derpcats.init.ModBlocks.catnipblock;
import static its_meow.derpcats.init.ModItems.cathotdog;
import static its_meow.derpcats.init.ModItems.cathotdogm;
import static its_meow.derpcats.init.ModItems.catmeatcooked;
import static its_meow.derpcats.init.ModItems.catmeatraw;
import static its_meow.derpcats.init.ModItems.catnip;
import static its_meow.derpcats.init.ModItems.catrobotcircuit;
import static its_meow.derpcats.init.ModItems.catteleporter;

import com.google.common.base.Preconditions;

import its_meow.derpcats.Ref;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID)
public class DerpCatsRegistrar {

    @SubscribeEvent
    public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
        final IForgeRegistry<Biome> registry = event.getRegistry();
        registry.register(biomecat);
        BiomeDictionary.addTypes(biomecat, Type.FOREST);
        BiomeManager.addBiome(BiomeType.WARM, new BiomeManager.BiomeEntry(biomecat, 1));
        biomecat.createBiomeDecorator();
        biomecat.decorator.treesPerChunk = 1;
    }

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        final IForgeRegistry<Block> registry = event.getRegistry();
        registry.registerAll(catnipblock, catdirtblock);
    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        // ItemBlocks

        final ItemBlock[] itemblocks = { new ItemBlock(catnipblock), new ItemBlock(catdirtblock) };

        final IForgeRegistry<Item> registry = event.getRegistry();

        for(final ItemBlock item : itemblocks) {
            final Block block = item.getBlock();
            final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(),
                    "Block %s has null registry name", block);
            registry.register(item.setRegistryName(registryName));
        }

        // Items
        registry.registerAll(catnip, catrobotcircuit, cathotdog, cathotdogm, catmeatraw, catmeatcooked, catteleporter);
    }

}

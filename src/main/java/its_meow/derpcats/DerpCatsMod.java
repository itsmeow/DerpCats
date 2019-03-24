package its_meow.derpcats;

import java.io.File;

import org.apache.logging.log4j.Logger;

import its_meow.derpcats.config.DerpCatsConfig;
import its_meow.derpcats.init.EntityRegistrar;
import its_meow.derpcats.init.ModDimensions;
import its_meow.derpcats.init.ModItems;
import its_meow.derpcats.init.ModSoundEvents;
import its_meow.derpcats.proxy.ISidedProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Ref.MOD_ID, name = Ref.NAME, version = Ref.VERSION, acceptedMinecraftVersions = Ref.acceptedMCV, updateJSON = Ref.updateJSON)
public class DerpCatsMod {

    @Instance(Ref.MOD_ID)
    public static DerpCatsMod mod;

    @SidedProxy(clientSide = Ref.CLIENT_PROXY_C, serverSide = Ref.SERVER_PROXY_C)
    public static ISidedProxy proxy;

    public static Logger logger;

    public static CreativeTabs tab_derpcats = new CreativeTabs("DerpCats") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.catnip);
        }

        @Override
        public void displayAllRelevantItems(NonNullList<ItemStack> toDisplay) {
            super.displayAllRelevantItems(toDisplay);
            for(ResourceLocation rl : EntityRegistrar.entities) {
                ItemStack stack = new ItemStack(Items.SPAWN_EGG);
                ItemMonsterPlacer.applyEntityIdToItemStack(stack, rl);
                toDisplay.add(stack);
            }
        }

    };

    public static Configuration config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "derpcats.cfg"));
        DerpCatsConfig.readConfig();
        EntityRegistrar.init();
        ModDimensions.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
        GameRegistry.addSmelting(new ItemStack(ModItems.catmeatraw), new ItemStack(ModItems.catmeatcooked), 0.0F);
        OreDictionary.registerOre("circuitBasic", ModItems.catrobotcircuit);
        ModSoundEvents.registerSounds();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
        if(config.hasChanged()) {
            config.save();
        }
    }

}

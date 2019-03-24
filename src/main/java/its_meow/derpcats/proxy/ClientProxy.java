package its_meow.derpcats.proxy;

import static its_meow.derpcats.init.ModBlocks.catdirtblock;
import static its_meow.derpcats.init.ModBlocks.catnipblock;
import static its_meow.derpcats.init.ModItems.cathotdog;
import static its_meow.derpcats.init.ModItems.cathotdogm;
import static its_meow.derpcats.init.ModItems.catmeatcooked;
import static its_meow.derpcats.init.ModItems.catmeatraw;
import static its_meow.derpcats.init.ModItems.catnip;
import static its_meow.derpcats.init.ModItems.catrobotcircuit;
import static its_meow.derpcats.init.ModItems.catteleporter;

import its_meow.derpcats.Ref;
import its_meow.derpcats.client.renderer.entity.RenderCatLady;
import its_meow.derpcats.client.renderer.entity.RenderChefCat;
import its_meow.derpcats.client.renderer.entity.RenderCompanionCat;
import its_meow.derpcats.client.renderer.entity.RenderCrazyCat;
import its_meow.derpcats.client.renderer.entity.RenderExplodingCat;
import its_meow.derpcats.client.renderer.entity.RenderFartCat;
import its_meow.derpcats.client.renderer.entity.RenderGiantCat;
import its_meow.derpcats.client.renderer.entity.RenderGiraffeCat;
import its_meow.derpcats.client.renderer.entity.RenderGrumpyCat;
import its_meow.derpcats.client.renderer.entity.RenderHopCat;
import its_meow.derpcats.client.renderer.entity.RenderHotDogCat;
import its_meow.derpcats.client.renderer.entity.RenderMeanCat;
import its_meow.derpcats.client.renderer.entity.RenderRobotCat;
import its_meow.derpcats.client.renderer.entity.RenderSpaceCat;
import its_meow.derpcats.client.renderer.entity.RenderSpiderCat;
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
import its_meow.derpcats.init.ModTextures;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID, value = Side.CLIENT)
public class ClientProxy implements ISidedProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        RenderingRegistry.registerEntityRenderingHandler(EntityFartCat.class, RenderFartCat::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityExplodingCat.class, RenderExplodingCat::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityGrumpyCat.class, RenderGrumpyCat::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityCompanionCat.class, RenderCompanionCat::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMeanCat.class, RenderMeanCat::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityRobotCat.class, RenderRobotCat::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySpaceCat.class, RenderSpaceCat::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityGiantCat.class, RenderGiantCat::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySpiderCat.class, RenderSpiderCat::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityHotDogCat.class, RenderHotDogCat::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityCatLady.class, RenderCatLady::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityHopCat.class, RenderHopCat::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityChefCat.class, RenderChefCat::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityGiraffeCat.class, RenderGiraffeCat::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityCrazyCat.class, RenderCrazyCat::new);
    }

    @Override
    public void init(FMLInitializationEvent e) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }

    @SubscribeEvent
    public static void textureStitchEventPre(TextureStitchEvent.Pre event) {
        event.getMap().registerSprite(ModTextures.binary1);
        event.getMap().registerSprite(ModTextures.binary0);
        event.getMap().registerSprite(ModTextures.alert);
    }

    @SubscribeEvent
    public static void registerModels(final ModelRegistryEvent event) {
        // Blocks
        initModel(catnipblock, 0);
        initModel(catdirtblock, 0);

        // Items
        initModel(catnip, 0);
        initModel(catrobotcircuit, 0);
        initModel(cathotdog, 0);
        initModel(cathotdogm, 0);
        initModel(catmeatraw, 0);
        initModel(catmeatcooked, 0);
        initModel(catteleporter, 0);
    }

    public static void initModel(Block block, int meta) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    public static void initModel(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta,
                new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}

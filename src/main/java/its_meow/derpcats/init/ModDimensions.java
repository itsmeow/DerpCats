package its_meow.derpcats.init;

import its_meow.derpcats.Ref;
import its_meow.derpcats.common.dimension.WorldProviderCatLand;
import its_meow.derpcats.config.DerpCatsConfig;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {

    public static DimensionType catland;

    public static void init() {
        registerDimensionTypes();
        registerDimensions();
    }

    private static void registerDimensionTypes() {
        catland = DimensionType.register(Ref.MOD_ID, "_catland", DerpCatsConfig.dimId, WorldProviderCatLand.class,
                false);
    }

    private static void registerDimensions() {
        DimensionManager.registerDimension(DerpCatsConfig.dimId, catland);
    }

}
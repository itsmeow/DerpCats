package its_meow.derpcats.init;

import its_meow.derpcats.DerpCatsMod;
import its_meow.derpcats.common.item.ItemCatMeatCooked;
import its_meow.derpcats.common.item.ItemCatMeatRaw;
import its_meow.derpcats.common.item.ItemCatTeleporter;
import its_meow.derpcats.common.item.ItemCatnip;
import its_meow.derpcats.common.item.ItemHotDog;
import its_meow.derpcats.common.item.ItemHotDogMustard;
import net.minecraft.item.Item;

public class ModItems {

    public static final ItemCatnip catnip = new ItemCatnip();
    public static final ItemCatMeatRaw catmeatraw = new ItemCatMeatRaw(4, true);
    public static final ItemCatMeatCooked catmeatcooked = new ItemCatMeatCooked(8, true);
    public static final Item catrobotcircuit = new Item().setRegistryName("catrobotcircuit")
            .setUnlocalizedName("catrobotcircuit").setCreativeTab(DerpCatsMod.tab_derpcats);
    public static final ItemHotDog cathotdog = new ItemHotDog(6, true);
    public static final ItemHotDogMustard cathotdogm = new ItemHotDogMustard(8, true);
    public static final ItemCatTeleporter catteleporter = new ItemCatTeleporter();

}

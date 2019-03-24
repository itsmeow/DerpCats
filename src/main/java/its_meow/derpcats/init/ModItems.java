package its_meow.derpcats.init;

import its_meow.derpcats.DerpCatsMod;
import its_meow.derpcats.common.item.ItemCatTeleporter;
import its_meow.derpcats.common.item.ItemCatnip;
import its_meow.derpcats.common.item.ItemDCFood;
import net.minecraft.item.Item;

public class ModItems {

    public static final ItemCatnip catnip = new ItemCatnip();
    public static final ItemDCFood catmeatraw = new ItemDCFood("catmeatraw", 4, true);
    public static final ItemDCFood catmeatcooked = new ItemDCFood("catmeatcooked", 8, true);
    public static final Item catrobotcircuit = new Item().setRegistryName("catrobotcircuit").setTranslationKey("catrobotcircuit").setCreativeTab(DerpCatsMod.tab_derpcats);
    public static final ItemDCFood cathotdog = new ItemDCFood("cathotdog", 6, true);
    public static final ItemDCFood cathotdogm = new ItemDCFood("cathotdogm", 8, true);
    public static final ItemCatTeleporter catteleporter = new ItemCatTeleporter();

}
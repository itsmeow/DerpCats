package its_meow.derpcats.common.item;

import its_meow.derpcats.DerpCatsMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCatnip extends Item {

    public ItemCatnip() {
        this.setRegistryName("catnip");
        this.setCreativeTab(DerpCatsMod.tab_derpcats);
        this.setTranslationKey("catnip");
    }

    public static boolean isCatnip() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0,
                new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }

}

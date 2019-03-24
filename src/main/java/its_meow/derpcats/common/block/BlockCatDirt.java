package its_meow.derpcats.common.block;

import its_meow.derpcats.DerpCatsMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCatDirt extends Block {

    public BlockCatDirt() {
        super(Material.GROUND);
        this.setRegistryName("catdirtblock");
        this.setCreativeTab(DerpCatsMod.tab_derpcats);
        this.setTranslationKey("catdirtblock");
        this.setHardness(0.3F);
        this.setSoundType(SoundType.GROUND);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0,
                new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }
}

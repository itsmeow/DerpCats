package its_meow.derpcats.common.item;

import its_meow.derpcats.DerpCatsMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCatMeatCooked extends ItemFood {

    /** Number of ticks to run while 'EnumAction'ing until result. */
    public final int itemUseDuration;
    /** The amount this food item heals the player. */
    private final int healAmount;
    /** Whether wolves like this food (true for raw and cooked porkchop). */
    private final boolean isWolfsFavoriteMeat;
    /**
     * If this field is true, the food can be consumed even if the player don't need
     * to eat.
     */
    private boolean alwaysEdible;

    public ItemCatMeatCooked(int amount, boolean isWolfFood) {
        super(amount, isWolfFood);
        this.setCreativeTab(DerpCatsMod.tab_derpcats);
        this.setRegistryName("catmeatcooked");
        this.setUnlocalizedName("catmeatcooked");
        this.itemUseDuration = 32;
        this.healAmount = 3;
        this.isWolfsFavoriteMeat = false;
        this.alwaysEdible = false;
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is
     * being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.EAT;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0,
                new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }

}

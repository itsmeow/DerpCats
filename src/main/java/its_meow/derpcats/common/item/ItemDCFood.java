package its_meow.derpcats.common.item;

import its_meow.derpcats.DerpCatsMod;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemDCFood extends ItemFood {

    public ItemDCFood(String name, int amount, boolean isWolfFood) {
        super(amount, isWolfFood);
        this.setCreativeTab(DerpCatsMod.tab_derpcats);
        this.setRegistryName(name);
        this.setTranslationKey(name);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.EAT;
    }

}

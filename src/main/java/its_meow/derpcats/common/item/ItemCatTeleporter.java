package its_meow.derpcats.common.item;

import its_meow.derpcats.DerpCatsMod;
import its_meow.derpcats.common.dimension.CatTeleporter;
import its_meow.derpcats.config.DerpCatsConfig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCatTeleporter extends Item {

    private static BlockPos dim0Pos;
    private static BlockPos catlandPos;

    public ItemCatTeleporter() {
        this.setRegistryName("catteleporter");
        this.setCreativeTab(DerpCatsMod.tab_derpcats);
        this.setTranslationKey("catteleporter");
        this.setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if(!worldIn.isRemote) {
            if(playerIn instanceof EntityPlayerMP) {
                EntityPlayerMP playerMP = (EntityPlayerMP) playerIn;
                if(playerIn.getRidingEntity() == null | false && playerIn.isBeingRidden() == false
                        && playerIn instanceof EntityPlayer && playerMP.dimension != DerpCatsConfig.dimId
                        && playerMP.dimension == 0) {
                    dim0Pos = playerIn.getPosition();
                    playerMP.server.getPlayerList().transferPlayerToDimension(playerMP, DerpCatsConfig.dimId,
                            new CatTeleporter(playerIn.getServer().getWorld(DerpCatsConfig.dimId), catlandPos));
                } else if(playerIn.getRidingEntity() == null | false && playerIn.isBeingRidden() == false
                        && playerIn instanceof EntityPlayer && playerMP.dimension != 0
                        && playerMP.dimension == DerpCatsConfig.dimId) {
                    catlandPos = playerIn.getPosition();
                    playerMP.server.getPlayerList().transferPlayerToDimension(playerMP, 0,
                            new CatTeleporter(playerIn.getServer().getWorld(0), dim0Pos));
                }
            }
        }
        return ActionResult.newResult(EnumActionResult.PASS, itemstack);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0,
                new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }

}

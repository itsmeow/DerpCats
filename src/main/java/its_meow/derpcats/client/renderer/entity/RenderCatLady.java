package its_meow.derpcats.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.derpcats.common.entity.EntityCatLady;
import its_meow.derpcats.init.ModTextures;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCatLady extends RenderLiving<EntityCatLady> {

    public RenderCatLady(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelVillager(1), 1F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityCatLady entity) {
        return ModTextures.catlady;
    }

}

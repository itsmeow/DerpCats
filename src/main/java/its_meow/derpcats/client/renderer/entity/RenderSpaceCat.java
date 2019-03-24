package its_meow.derpcats.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.derpcats.client.model.ModelBasicCat;
import its_meow.derpcats.common.entity.EntitySpaceCat;
import its_meow.derpcats.init.ModTextures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSpaceCat extends RenderLiving<EntitySpaceCat> {

    public RenderSpaceCat(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBasicCat(), 1F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntitySpaceCat entity) {
        return ModTextures.spacecat;
    }

}

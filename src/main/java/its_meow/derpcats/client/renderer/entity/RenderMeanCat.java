package its_meow.derpcats.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.derpcats.client.model.ModelBasicCat;
import its_meow.derpcats.common.entity.EntityMeanCat;
import its_meow.derpcats.init.ModTextures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMeanCat extends RenderLiving<EntityMeanCat> {

    public RenderMeanCat(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBasicCat(), 1F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityMeanCat entity) {
        return ModTextures.meancat;
    }
}

package its_meow.derpcats.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.derpcats.client.model.ModelSpiderCat;
import its_meow.derpcats.common.entity.EntitySpiderCat;
import its_meow.derpcats.init.ModTextures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSpiderCat extends RenderLiving<EntitySpiderCat> {

    public RenderSpiderCat(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelSpiderCat(), 1F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntitySpiderCat entity) { // sets the entity texture.
        return ModTextures.spidercat; // returns the Resource Location, as defined in the TextureRegistry class
                                      // "fartcatloc".
    }

}

package its_meow.derpcats.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.derpcats.client.model.ModelChefCat;
import its_meow.derpcats.common.entity.EntityChefCat;
import its_meow.derpcats.init.ModTextures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderChefCat extends RenderLiving<EntityChefCat> {

    public RenderChefCat(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelChefCat(), 1F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityChefCat entity) {
        return ModTextures.chefcat;
    }

}

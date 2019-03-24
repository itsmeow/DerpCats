package its_meow.derpcats.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.derpcats.client.model.ModelGiraffeCat;
import its_meow.derpcats.common.entity.EntityGiraffeCat;
import its_meow.derpcats.init.ModTextures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGiraffeCat extends RenderLiving<EntityGiraffeCat> {

    public RenderGiraffeCat(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelGiraffeCat(), 1F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityGiraffeCat entity) {
        return ModTextures.giraffecat;
    }

}

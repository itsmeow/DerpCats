package its_meow.derpcats.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.derpcats.client.model.ModelCrazyCat;
import its_meow.derpcats.common.entity.EntityCrazyCat;
import its_meow.derpcats.init.ModTextures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCrazyCat extends RenderLiving<EntityCrazyCat> {

    public RenderCrazyCat(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCrazyCat(), 1F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityCrazyCat entity) {
        return ModTextures.crazycat;
    }

}

package its_meow.derpcats.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.derpcats.client.model.ModelBasicCat;
import its_meow.derpcats.common.entity.EntityHotDogCat;
import its_meow.derpcats.init.ModTextures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderHotDogCat extends RenderLiving<EntityHotDogCat> {

    public RenderHotDogCat(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelBasicCat(), 1F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityHotDogCat entity) {
        return ModTextures.hotdogcat;
    }

}

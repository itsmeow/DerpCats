package its_meow.derpcats.client.renderer.entity;

import javax.annotation.Nonnull;

import its_meow.derpcats.client.model.ModelNoNoseAntenna;
import its_meow.derpcats.common.entity.EntityRobotCat;
import its_meow.derpcats.init.ModTextures;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderRobotCat extends RenderLiving<EntityRobotCat> {

    public RenderRobotCat(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelNoNoseAntenna(), 1F);
    }

    @Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull EntityRobotCat entity) {
        return ModTextures.robotcat;
    }

}

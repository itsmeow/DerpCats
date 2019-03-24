package its_meow.derpcats.client.model;

import its_meow.derpcats.common.entity.EntityCompanionCat;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * ModelFartCat - by its_meow Created using Tabula 7.0.0
 */
public class ModelBasicCat extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer FrontLeftLeg;
    public ModelRenderer BackLeftLeg;
    public ModelRenderer FrontRightLeg;
    public ModelRenderer BackRightLeg;
    public ModelRenderer Neck;
    public ModelRenderer Tail1;
    public ModelRenderer Head;
    public ModelRenderer Ear1;
    public ModelRenderer Ear2;
    public ModelRenderer Nose;
    public ModelRenderer Tail2;

    public ModelBasicCat() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.BackLeftLeg = new ModelRenderer(this, 11, 61);
        this.BackLeftLeg.setRotationPoint(10.0F, 14.0F, 26.0F);
        this.BackLeftLeg.addBox(0.0F, 0.0F, 0.0F, 2, 16, 2, 0.0F);
        this.Neck = new ModelRenderer(this, 3, 87);
        this.Neck.setRotationPoint(1.0F, 0.0F, -3.0F);
        this.Neck.addBox(0.0F, 0.0F, 0.0F, 10, 12, 3, 0.0F);
        this.Ear2 = new ModelRenderer(this, 85, 0);
        this.Ear2.setRotationPoint(8.0F, -2.0F, 4.0F);
        this.Ear2.addBox(0.0F, 0.0F, 0.0F, 3, 2, 4, 0.0F);
        this.Nose = new ModelRenderer(this, 101, 8);
        this.Nose.setRotationPoint(2.0F, 4.0F, -3.0F);
        this.Nose.addBox(0.0F, 0.0F, 0.0F, 8, 4, 3, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(-6.0F, -6.0F, -14.0F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 12, 14, 28, 0.0F);
        this.Ear1 = new ModelRenderer(this, 85, 0);
        this.Ear1.setRotationPoint(1.0F, -2.0F, 4.0F);
        this.Ear1.addBox(0.0F, 0.0F, 0.0F, 3, 2, 4, 0.0F);
        this.FrontLeftLeg = new ModelRenderer(this, 11, 61);
        this.FrontLeftLeg.setRotationPoint(10.0F, 14.0F, 0.0F);
        this.FrontLeftLeg.addBox(0.0F, 0.0F, 0.0F, 2, 16, 2, 0.0F);
        this.BackRightLeg = new ModelRenderer(this, 11, 61);
        this.BackRightLeg.setRotationPoint(0.0F, 14.0F, 26.0F);
        this.BackRightLeg.addBox(0.0F, 0.0F, 0.0F, 2, 16, 2, 0.0F);
        this.Head = new ModelRenderer(this, 37, 62);
        this.Head.setRotationPoint(-1.0F, -1.0F, -9.0F);
        this.Head.addBox(0.0F, 0.0F, 0.0F, 12, 8, 9, 0.0F);
        this.FrontRightLeg = new ModelRenderer(this, 11, 61);
        this.FrontRightLeg.setRotationPoint(0.0F, 14.0F, 0.0F);
        this.FrontRightLeg.addBox(0.0F, 0.0F, 0.0F, 2, 16, 2, 0.0F);
        this.Tail1 = new ModelRenderer(this, 98, 53);
        this.Tail1.setRotationPoint(6.0F, 2.0F, 29.0F);
        this.Tail1.addBox(0.0F, 0.0F, -2.0F, 1, 1, 11, 0.0F);
        this.setRotateAngle(this.Tail1, -0.6691592352146261F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 98, 77);
        this.Tail2.setRotationPoint(0.0F, 0.3F, 8.0F);
        this.Tail2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 11, 0.0F);
        this.setRotateAngle(this.Tail2, 0.6691592352146261F, 0.0F, 0.0F);
        this.Body.addChild(this.BackLeftLeg);
        this.Body.addChild(this.Neck);
        this.Head.addChild(this.Ear2);
        this.Head.addChild(this.Nose);
        this.Head.addChild(this.Ear1);
        this.Body.addChild(this.FrontLeftLeg);
        this.Body.addChild(this.BackRightLeg);
        this.Neck.addChild(this.Head);
        this.Body.addChild(this.FrontRightLeg);
        this.Body.addChild(this.Tail1);
        this.Tail1.addChild(this.Tail2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.FrontLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.FrontRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
        this.BackRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.BackLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount,
            float partialTickTime) {
        super.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);

        if(entitylivingbaseIn instanceof EntityCompanionCat) {
            EntityCompanionCat entity = (EntityCompanionCat) entitylivingbaseIn;
            if(entity.isSitting()) {
                this.Body.rotateAngleX = (float) Math.toRadians(30);
                this.Head.rotateAngleX = (float) Math.toRadians(-30);
                this.Tail1.rotateAngleX = (float) Math.toRadians(30);

                this.FrontLeftLeg.rotateAngleX += (float) Math.toRadians(-30);
                this.FrontRightLeg.rotateAngleX += (float) Math.toRadians(-30);
                this.BackLeftLeg.rotateAngleX += (float) Math.toRadians(30);
                this.BackRightLeg.rotateAngleX += (float) Math.toRadians(30);
            } else {
                this.Body.rotateAngleX = 0;
                this.Head.rotateAngleX = 0;
                this.Tail1.rotateAngleX = 0;
            }
        }
    }

}

package its_meow.derpcats.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelSpiderCat extends ModelBase {
    // fields
    ModelRenderer FrontLeftLeg;
    ModelRenderer FrontRightLeg;
    ModelRenderer BackLeftLeg;
    ModelRenderer BackRightLeg;
    ModelRenderer Body;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer Nose;
    ModelRenderer Ear1;
    ModelRenderer Ear2;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer FrontRightLeg2;
    ModelRenderer BackRightLeg2;
    ModelRenderer BackLeftLeg2;
    ModelRenderer FrontLeftLeg2;

    public ModelSpiderCat() {
        this.textureWidth = 128;
        this.textureHeight = 128;

        this.FrontLeftLeg = new ModelRenderer(this, 11, 61);
        this.FrontLeftLeg.addBox(0F, 0F, 0F, 2, 16, 2);
        this.FrontLeftLeg.setRotationPoint(4F, 8F, -14F);
        this.FrontLeftLeg.setTextureSize(128, 128);
        this.FrontLeftLeg.mirror = true;
        setRotation(this.FrontLeftLeg, -0.3665191F, 0F, -0.9948377F);
        this.FrontRightLeg = new ModelRenderer(this, 11, 61);
        this.FrontRightLeg.addBox(0F, 0F, 0F, 2, 16, 2);
        this.FrontRightLeg.setRotationPoint(-6F, 6F, -14F);
        this.FrontRightLeg.setTextureSize(128, 128);
        this.FrontRightLeg.mirror = true;
        setRotation(this.FrontRightLeg, -0.3665191F, 0F, 0.9948377F);
        this.BackLeftLeg = new ModelRenderer(this, 11, 61);
        this.BackLeftLeg.addBox(0F, 0F, 0F, 2, 16, 2);
        this.BackLeftLeg.setRotationPoint(4F, 8F, 12F);
        this.BackLeftLeg.setTextureSize(128, 128);
        this.BackLeftLeg.mirror = true;
        setRotation(this.BackLeftLeg, 0.3665191F, 0F, -0.9948377F);
        this.BackRightLeg = new ModelRenderer(this, 11, 61);
        this.BackRightLeg.addBox(0F, 0F, 0F, 2, 16, 2);
        this.BackRightLeg.setRotationPoint(-6F, 6F, 12F);
        this.BackRightLeg.setTextureSize(128, 128);
        this.BackRightLeg.mirror = true;
        setRotation(this.BackRightLeg, 0.3665191F, 0F, 0.9948377F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.addBox(0F, 0F, 0F, 12, 14, 28);
        this.Body.setRotationPoint(-6F, -6F, -14F);
        this.Body.setTextureSize(128, 128);
        this.Body.mirror = true;
        setRotation(this.Body, 0F, 0F, 0F);
        this.Neck = new ModelRenderer(this, 3, 87);
        this.Neck.addBox(0F, 0F, 0F, 10, 12, 3);
        this.Neck.setRotationPoint(-5F, -5F, -17F);
        this.Neck.setTextureSize(128, 128);
        this.Neck.mirror = true;
        setRotation(this.Neck, 0F, 0F, 0F);
        this.Head = new ModelRenderer(this, 37, 62);
        this.Head.addBox(0F, 0F, 0F, 12, 8, 9);
        this.Head.setRotationPoint(-6F, -6F, -25F);
        this.Head.setTextureSize(128, 128);
        this.Head.mirror = true;
        setRotation(this.Head, 0F, 0F, 0F);
        this.Nose = new ModelRenderer(this, 101, 8);
        this.Nose.addBox(0F, 0F, 0F, 8, 4, 3);
        this.Nose.setRotationPoint(-4F, -2F, -28F);
        this.Nose.setTextureSize(128, 128);
        this.Nose.mirror = true;
        setRotation(this.Nose, 0F, 0F, 0F);
        this.Ear1 = new ModelRenderer(this, 85, 0);
        this.Ear1.addBox(0F, 0F, 0F, 3, 2, 4);
        this.Ear1.setRotationPoint(-5F, -8F, -21F);
        this.Ear1.setTextureSize(128, 128);
        this.Ear1.mirror = true;
        setRotation(this.Ear1, 0F, 0F, 0F);
        this.Ear2 = new ModelRenderer(this, 85, 0);
        this.Ear2.addBox(0F, 0F, 0F, 3, 2, 4);
        this.Ear2.setRotationPoint(2F, -8F, -21F);
        this.Ear2.setTextureSize(128, 128);
        this.Ear2.mirror = true;
        setRotation(this.Ear2, 0F, 0F, 0F);
        this.Tail1 = new ModelRenderer(this, 98, 53);
        this.Tail1.addBox(0F, 0F, -2F, 1, 1, 11);
        this.Tail1.setRotationPoint(0F, -4F, 15F);
        this.Tail1.setTextureSize(128, 128);
        this.Tail1.mirror = true;
        setRotation(this.Tail1, -0.669215F, 0F, 0F);
        this.Tail2 = new ModelRenderer(this, 98, 77);
        this.Tail2.addBox(0F, 0F, 0F, 1, 1, 11);
        this.Tail2.setRotationPoint(0F, 1F, 21F);
        this.Tail2.setTextureSize(128, 128);
        this.Tail2.mirror = true;
        setRotation(this.Tail2, 0F, 0F, 0F);
        this.FrontRightLeg2 = new ModelRenderer(this, 11, 61);
        this.FrontRightLeg2.addBox(0F, 0F, 0F, 2, 16, 2);
        this.FrontRightLeg2.setRotationPoint(-6F, 6F, -4F);
        this.FrontRightLeg2.setTextureSize(128, 128);
        this.FrontRightLeg2.mirror = true;
        setRotation(this.FrontRightLeg2, -0.3665191F, 0F, 0.9948377F);
        this.BackRightLeg2 = new ModelRenderer(this, 11, 61);
        this.BackRightLeg2.addBox(0F, 0F, 0F, 2, 16, 2);
        this.BackRightLeg2.setRotationPoint(-6F, 6F, 2F);
        this.BackRightLeg2.setTextureSize(128, 128);
        this.BackRightLeg2.mirror = true;
        setRotation(this.BackRightLeg2, 0.3665191F, 0F, 0.9948377F);
        this.BackLeftLeg2 = new ModelRenderer(this, 11, 61);
        this.BackLeftLeg2.addBox(0F, 0F, 0F, 2, 16, 2);
        this.BackLeftLeg2.setRotationPoint(4F, 8F, 2F);
        this.BackLeftLeg2.setTextureSize(128, 128);
        this.BackLeftLeg2.mirror = true;
        setRotation(this.BackLeftLeg2, 0.3665191F, 0F, -0.9948377F);
        this.FrontLeftLeg2 = new ModelRenderer(this, 11, 61);
        this.FrontLeftLeg2.addBox(0F, 0F, 0F, 2, 16, 2);
        this.FrontLeftLeg2.setRotationPoint(4F, 8F, -4F);
        this.FrontLeftLeg2.setTextureSize(128, 128);
        this.FrontLeftLeg2.mirror = true;
        setRotation(this.FrontLeftLeg2, -0.3665191F, 0F, -0.9948377F);
    }

    @Override
    public void render(Entity entityIn, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entityIn, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entityIn);
        this.FrontLeftLeg.render(f5);
        this.FrontRightLeg.render(f5);
        this.BackLeftLeg.render(f5);
        this.BackRightLeg.render(f5);
        this.Body.render(f5);
        this.Neck.render(f5);
        this.Head.render(f5);
        this.Nose.render(f5);
        this.Ear1.render(f5);
        this.Ear2.render(f5);
        this.Tail1.render(f5);
        this.Tail2.render(f5);
        this.FrontRightLeg2.render(f5);
        this.BackRightLeg2.render(f5);
        this.BackLeftLeg2.render(f5);
        this.FrontLeftLeg2.render(f5);
    }

    private static void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
            float headPitch, float scaleFactor, Entity entityIn) {
        this.FrontLeftLeg.rotateAngleZ = -((float) Math.PI / 4F);
        this.FrontRightLeg.rotateAngleZ = ((float) Math.PI / 4F);
        this.FrontLeftLeg2.rotateAngleZ = -0.58119464F;
        this.FrontRightLeg2.rotateAngleZ = 0.58119464F;
        this.BackLeftLeg2.rotateAngleZ = -0.58119464F;
        this.BackRightLeg2.rotateAngleZ = 0.58119464F;
        this.BackLeftLeg.rotateAngleZ = -((float) Math.PI / 4F);
        this.BackRightLeg.rotateAngleZ = ((float) Math.PI / 4F);
        this.FrontLeftLeg.rotateAngleY = ((float) Math.PI / 4F);
        this.FrontRightLeg.rotateAngleY = -((float) Math.PI / 4F);
        this.FrontLeftLeg2.rotateAngleY = 0.3926991F;
        this.FrontRightLeg2.rotateAngleY = -0.3926991F;
        this.BackLeftLeg2.rotateAngleY = -0.3926991F;
        this.BackRightLeg2.rotateAngleY = 0.3926991F;
        this.BackLeftLeg.rotateAngleY = -((float) Math.PI / 4F);
        this.BackRightLeg.rotateAngleY = ((float) Math.PI / 4F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float) Math.PI) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float) Math.PI * 3F / 2F)) * 0.4F)
                * limbSwingAmount;
        this.FrontLeftLeg.rotateAngleY += f3;
        this.FrontRightLeg.rotateAngleY += -f3;
        this.FrontLeftLeg2.rotateAngleY += f4;
        this.FrontRightLeg2.rotateAngleY += -f4;
        this.BackLeftLeg2.rotateAngleY += f5;
        this.BackRightLeg2.rotateAngleY += -f5;
        this.BackLeftLeg.rotateAngleY += f6;
        this.BackRightLeg.rotateAngleY += -f6;
        this.FrontLeftLeg.rotateAngleZ += f7;
        this.FrontRightLeg.rotateAngleZ += -f7;
        this.FrontLeftLeg2.rotateAngleZ += f8;
        this.FrontRightLeg2.rotateAngleZ += -f8;
        this.BackLeftLeg2.rotateAngleZ += f9;
        this.BackRightLeg2.rotateAngleZ += -f9;
        this.BackLeftLeg.rotateAngleZ += f10;
        this.BackRightLeg.rotateAngleZ += -f10;
    }

}

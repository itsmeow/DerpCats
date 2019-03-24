package its_meow.derpcats.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelChefCat extends ModelBase {
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
    ModelRenderer Shape1;
    ModelRenderer HatLower;
    ModelRenderer HatUpper;

    public ModelChefCat() {
        this.textureWidth = 128;
        this.textureHeight = 128;

        this.FrontLeftLeg = new ModelRenderer(this, 11, 61);
        this.FrontLeftLeg.addBox(0F, 0F, 0F, 2, 16, 2);
        this.FrontLeftLeg.setRotationPoint(4F, 8F, -14F);
        this.FrontLeftLeg.setTextureSize(128, 128);
        this.FrontLeftLeg.mirror = true;
        setRotation(this.FrontLeftLeg, 0F, 0F, 0F);
        this.FrontRightLeg = new ModelRenderer(this, 11, 61);
        this.FrontRightLeg.addBox(0F, 0F, 0F, 2, 16, 2);
        this.FrontRightLeg.setRotationPoint(-6F, 8F, -14F);
        this.FrontRightLeg.setTextureSize(128, 128);
        this.FrontRightLeg.mirror = true;
        setRotation(this.FrontRightLeg, 0F, 0F, 0F);
        this.BackLeftLeg = new ModelRenderer(this, 11, 61);
        this.BackLeftLeg.addBox(0F, 0F, 0F, 2, 16, 2);
        this.BackLeftLeg.setRotationPoint(4F, 8F, 12F);
        this.BackLeftLeg.setTextureSize(128, 128);
        this.BackLeftLeg.mirror = true;
        setRotation(this.BackLeftLeg, 0F, 0F, 0F);
        this.BackRightLeg = new ModelRenderer(this, 11, 61);
        this.BackRightLeg.addBox(0F, 0F, 0F, 2, 16, 2);
        this.BackRightLeg.setRotationPoint(-6F, 8F, 12F);
        this.BackRightLeg.setTextureSize(128, 128);
        this.BackRightLeg.mirror = true;
        setRotation(this.BackRightLeg, 0F, 0F, 0F);
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
        this.Shape1 = new ModelRenderer(this, 98, 77);
        this.Shape1.addBox(0F, 0F, 0F, 1, 1, 11);
        this.Shape1.setRotationPoint(0F, 1F, 21F);
        this.Shape1.setTextureSize(128, 128);
        this.Shape1.mirror = true;
        setRotation(this.Shape1, 0F, 0F, 0F);
        this.HatLower = new ModelRenderer(this, 35, 88);
        this.HatLower.addBox(0F, 0F, 0F, 6, 6, 6);
        this.HatLower.setRotationPoint(-3F, -12F, -22F);
        this.HatLower.setTextureSize(128, 128);
        this.HatLower.mirror = true;
        setRotation(this.HatLower, 0F, 0F, 0F);
        this.HatUpper = new ModelRenderer(this, 2, 44);
        this.HatUpper.addBox(0F, 0F, 0F, 8, 5, 8);
        this.HatUpper.setRotationPoint(-4F, -17F, -23F);
        this.HatUpper.setTextureSize(128, 128);
        this.HatUpper.mirror = true;
        setRotation(this.HatUpper, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
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
        this.Shape1.render(f5);
        this.HatLower.render(f5);
        this.HatUpper.render(f5);
    }

    private static void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.FrontLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.FrontRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
        this.BackRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.BackLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
    }

}

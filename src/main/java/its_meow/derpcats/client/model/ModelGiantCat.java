package its_meow.derpcats.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelGiantCat extends ModelBase {
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

    public ModelGiantCat() {
        this.textureWidth = 512;
        this.textureHeight = 512;

        this.FrontLeftLeg = new ModelRenderer(this, 11, 61);
        this.FrontLeftLeg.addBox(0F, 0F, 0F, 10, 80, 10);
        this.FrontLeftLeg.setRotationPoint(20F, -56F, -70F);
        this.FrontLeftLeg.setTextureSize(512, 512);
        this.FrontLeftLeg.mirror = true;
        setRotation(this.FrontLeftLeg, 0F, 0F, 0F);
        this.FrontRightLeg = new ModelRenderer(this, 11, 61);
        this.FrontRightLeg.addBox(0F, 0F, 0F, 10, 80, 10);
        this.FrontRightLeg.setRotationPoint(-30F, -56F, -70F);
        this.FrontRightLeg.setTextureSize(512, 512);
        this.FrontRightLeg.mirror = true;
        setRotation(this.FrontRightLeg, 0F, 0F, 0F);
        this.BackLeftLeg = new ModelRenderer(this, 11, 61);
        this.BackLeftLeg.addBox(0F, 0F, 0F, 10, 80, 10);
        this.BackLeftLeg.setRotationPoint(20F, -56F, 60F);
        this.BackLeftLeg.setTextureSize(512, 512);
        this.BackLeftLeg.mirror = true;
        setRotation(this.BackLeftLeg, 0F, 0F, 0F);
        this.BackRightLeg = new ModelRenderer(this, 11, 61);
        this.BackRightLeg.addBox(0F, 0F, 0F, 10, 80, 10);
        this.BackRightLeg.setRotationPoint(-30F, -56F, 60F);
        this.BackRightLeg.setTextureSize(512, 512);
        this.BackRightLeg.mirror = true;
        setRotation(this.BackRightLeg, 0F, 0F, 0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.addBox(0F, 0F, -2F, 60, 70, 140);
        this.Body.setRotationPoint(-30F, -126F, -70F);
        this.Body.setTextureSize(512, 512);
        this.Body.mirror = true;
        setRotation(this.Body, 0F, 0F, 0F);
        this.Neck = new ModelRenderer(this, 3, 87);
        this.Neck.addBox(0F, 0F, 0F, 50, 60, 15);
        this.Neck.setRotationPoint(-25F, -121F, -85F);
        this.Neck.setTextureSize(512, 512);
        this.Neck.mirror = true;
        setRotation(this.Neck, 0F, 0F, 0F);
        this.Head = new ModelRenderer(this, 0, 300);
        this.Head.addBox(0F, 0F, 0F, 60, 40, 45);
        this.Head.setRotationPoint(-30F, -126F, -125F);
        this.Head.setTextureSize(512, 512);
        this.Head.mirror = true;
        setRotation(this.Head, 0F, 0F, 0F);
        this.Nose = new ModelRenderer(this, 0, 380);
        this.Nose.addBox(0F, 0F, 0F, 40, 20, 15);
        this.Nose.setRotationPoint(-20F, -106F, -140F);
        this.Nose.setTextureSize(512, 512);
        this.Nose.mirror = true;
        setRotation(this.Nose, 0F, 0F, 0F);
        this.Ear1 = new ModelRenderer(this, 85, 0);
        this.Ear1.addBox(0F, 0F, 0F, 15, 10, 20);
        this.Ear1.setRotationPoint(-25F, -136F, -105F);
        this.Ear1.setTextureSize(512, 512);
        this.Ear1.mirror = true;
        setRotation(this.Ear1, 0F, 0F, 0F);
        this.Ear2 = new ModelRenderer(this, 85, 0);
        this.Ear2.addBox(0F, 0F, 0F, 15, 10, 20);
        this.Ear2.setRotationPoint(7F, -136F, -105F);
        this.Ear2.setTextureSize(512, 512);
        this.Ear2.mirror = true;
        setRotation(this.Ear2, 0F, 0F, 0F);
        this.Tail1 = new ModelRenderer(this, 98, 53);
        this.Tail1.addBox(0F, 0F, -2F, 5, 5, 55);
        this.Tail1.setRotationPoint(0F, -116F, 75F);
        this.Tail1.setTextureSize(512, 512);
        this.Tail1.mirror = true;
        setRotation(this.Tail1, -0.669215F, 0F, 0F);
        this.Shape1 = new ModelRenderer(this, 98, 77);
        this.Shape1.addBox(0F, 0F, 0F, 5, 5, 55);
        this.Shape1.setRotationPoint(0F, -85F, 113F);
        this.Shape1.setTextureSize(512, 512);
        this.Shape1.mirror = true;
        setRotation(this.Shape1, 0F, 0F, 0F);
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
    }

    private static void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    // just, don't bother with animations unless you can somehow figure this out.
    // Not even I can.
    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.FrontLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.FrontRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
        this.BackRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.BackLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
    }

}

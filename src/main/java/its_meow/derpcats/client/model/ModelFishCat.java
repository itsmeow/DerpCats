package its_meow.derpcats.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

//this thing is a massive failure.

public class ModelFishCat extends ModelBase {
    ModelRenderer Body;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer Ear1;
    ModelRenderer Ear2;
    ModelRenderer TailR;
    ModelRenderer TailL;
    ModelRenderer FinL;
    ModelRenderer FinR;

    public ModelFishCat() {
        this.textureWidth = 128;
        this.textureHeight = 128;

        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.addBox(0F, 0F, 0F, 12, 14, 28);
        this.Body.setRotationPoint(-6F, 10F, -14F);
        this.Body.setTextureSize(128, 128);
        this.Body.mirror = true;
        setRotation(this.Body, 0F, 0F, 0F);
        this.Neck = new ModelRenderer(this, 3, 87);
        this.Neck.addBox(0F, 0F, 0F, 10, 12, 3);
        this.Neck.setRotationPoint(-5F, 11F, -17F);
        this.Neck.setTextureSize(128, 128);
        this.Neck.mirror = true;
        setRotation(this.Neck, 0F, 0F, 0F);
        this.Head = new ModelRenderer(this, 37, 62);
        this.Head.addBox(0F, 0F, 0F, 12, 8, 9);
        this.Head.setRotationPoint(-6F, 10F, -25F);
        this.Head.setTextureSize(128, 128);
        this.Head.mirror = true;
        setRotation(this.Head, 0F, 0F, 0F);
        this.Ear1 = new ModelRenderer(this, 85, 0);
        this.Ear1.addBox(0F, 0F, 0F, 3, 2, 4);
        this.Ear1.setRotationPoint(-5F, 8F, -21F);
        this.Ear1.setTextureSize(128, 128);
        this.Ear1.mirror = true;
        setRotation(this.Ear1, 0F, 0F, 0F);
        this.Ear2 = new ModelRenderer(this, 85, 0);
        this.Ear2.addBox(0F, 0F, 0F, 3, 2, 4);
        this.Ear2.setRotationPoint(2F, 8F, -21F);
        this.Ear2.setTextureSize(128, 128);
        this.Ear2.mirror = true;
        setRotation(this.Ear2, 0F, 0F, 0F);
        this.TailR = new ModelRenderer(this, 98, 77);
        this.TailR.addBox(0F, 0F, 0F, 1, 1, 11);
        this.TailR.setRotationPoint(-4F, 15F, 14F);
        this.TailR.setTextureSize(128, 128);
        this.TailR.mirror = true;
        setRotation(this.TailR, 0F, 0F, 0F);
        this.TailL = new ModelRenderer(this, 98, 77);
        this.TailL.addBox(0F, 0F, 0F, 1, 1, 11);
        this.TailL.setRotationPoint(3F, 15F, 14F);
        this.TailL.setTextureSize(128, 128);
        this.TailL.mirror = true;
        setRotation(this.TailL, 0F, 0F, 0F);
        this.FinL = new ModelRenderer(this, 10, 47);
        this.FinL.addBox(0F, 0F, 0F, 7, 1, 3);
        this.FinL.setRotationPoint(6F, 15F, -4F);
        this.FinL.setTextureSize(128, 128);
        this.FinL.mirror = true;
        setRotation(this.FinL, 0F, 0F, 0F);
        this.FinR = new ModelRenderer(this, 10, 47);
        this.FinR.addBox(0F, 0F, 0F, 7, 1, 3);
        this.FinR.setRotationPoint(-13F, 15F, -4F);
        this.FinR.setTextureSize(128, 128);
        this.FinR.mirror = true;
        setRotation(this.FinR, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.Neck.render(f5);
        this.Head.render(f5);
        this.Ear1.render(f5);
        this.Ear2.render(f5);
        this.TailR.render(f5);
        this.TailL.render(f5);
        this.FinL.render(f5);
        this.FinR.render(f5);
    }

    private static void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.FinL.rotateAngleZ = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.FinR.rotateAngleZ = -1 * MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
    }

}

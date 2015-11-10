// Date: 2015/10/24 14:33:17
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.minecraft.src;

public class ModelSango extends ModelBase
{
  //fields
    ModelRenderer sangoHead;
    ModelRenderer sangoHairOrnament;
    ModelRenderer sangoRightEar;
    ModelRenderer sangoLeftEar;
    ModelRenderer sangoRightCheek;
    ModelRenderer sangoLeftCheek;
    ModelRenderer sangoRightArm;
    ModelRenderer sangoLeftArm;
    ModelRenderer sangoBody;
    ModelRenderer sangoNecklace;
    ModelRenderer sangoTailRoot;
    ModelRenderer sangoTailTip;
    ModelRenderer sangoRightThigh;
    ModelRenderer sangoRightFoot;
    ModelRenderer sangoLeftThigh;
    ModelRenderer sangoLeftFoot;
  
  public ModelSango()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      sangoHead = new ModelRenderer(this, 0, 0);
      sangoHead.addBox(-4F, -8F, -4F, 8, 8, 8);
      sangoHead.setRotationPoint(0F, 14F, 0F);
      sangoHead.setTextureSize(64, 32);
      sangoHead.mirror = true;
      setRotation(sangoHead, 0F, 0F, 0F);
      sangoHairOrnament = new ModelRenderer(this, 20, 22);
      sangoHairOrnament.addBox(0F, -9F, -4.1F, 5, 4, 1);
      sangoHairOrnament.setRotationPoint(0F, 14F, 0F);
      sangoHairOrnament.setTextureSize(64, 32);
      sangoHairOrnament.mirror = true;
      setRotation(sangoHairOrnament, 0F, 0F, 0F);
      sangoRightEar = new ModelRenderer(this, 21, 16);
      sangoRightEar.addBox(-5F, -10F, 0F, 4, 5, 1);
      sangoRightEar.setRotationPoint(0F, 14F, 0F);
      sangoRightEar.setTextureSize(64, 32);
      sangoRightEar.mirror = true;
      setRotation(sangoRightEar, 0F, -0.1745329F, 0F);
      sangoLeftEar.mirror = true;
      sangoLeftEar = new ModelRenderer(this, 21, 16);
      sangoLeftEar.addBox(1F, -10F, 0F, 4, 5, 1);
      sangoLeftEar.setRotationPoint(0F, 14F, 0F);
      sangoLeftEar.setTextureSize(64, 32);
      sangoLeftEar.mirror = true;
      setRotation(sangoLeftEar, 0F, 0.1745329F, 0F);
      sangoLeftEar.mirror = false;
      sangoRightCheek = new ModelRenderer(this, 0, 2);
      sangoRightCheek.addBox(-6F, -3F, 0F, 3, 3, 1);
      sangoRightCheek.setRotationPoint(0F, 14F, 0F);
      sangoRightCheek.setTextureSize(64, 32);
      sangoRightCheek.mirror = true;
      setRotation(sangoRightCheek, 0F, 0F, 0F);
      sangoLeftCheek.mirror = true;
      sangoLeftCheek = new ModelRenderer(this, 0, 2);
      sangoLeftCheek.addBox(3F, -3F, 0F, 3, 3, 1);
      sangoLeftCheek.setRotationPoint(0F, 14F, 0F);
      sangoLeftCheek.setTextureSize(64, 32);
      sangoLeftCheek.mirror = true;
      setRotation(sangoLeftCheek, 0F, 0F, 0F);
      sangoLeftCheek.mirror = false;
      sangoRightArm = new ModelRenderer(this, 24, 0);
      sangoRightArm.addBox(-1F, -1F, -1F, 2, 5, 2);
      sangoRightArm.setRotationPoint(-2.5F, 15F, 0F);
      sangoRightArm.setTextureSize(64, 32);
      sangoRightArm.mirror = true;
      setRotation(sangoRightArm, 0F, 0F, 0.6981317F);
      sangoLeftArm.mirror = true;
      sangoLeftArm = new ModelRenderer(this, 24, 0);
      sangoLeftArm.addBox(-1F, -1F, -1F, 2, 5, 2);
      sangoLeftArm.setRotationPoint(2.5F, 15F, 0F);
      sangoLeftArm.setTextureSize(64, 32);
      sangoLeftArm.mirror = true;
      setRotation(sangoLeftArm, 0F, 0F, -0.6981317F);
      sangoLeftArm.mirror = false;
      sangoBody = new ModelRenderer(this, 0, 18);
      sangoBody.addBox(-3F, 0F, -2F, 6, 8, 4);
      sangoBody.setRotationPoint(0F, 14F, 0F);
      sangoBody.setTextureSize(64, 32);
      sangoBody.mirror = true;
      setRotation(sangoBody, 0.3490659F, 0F, 0F);
      sangoNecklace = new ModelRenderer(this, 22, 27);
      sangoNecklace.addBox(-1F, 1F, -3F, 2, 3, 2);
      sangoNecklace.setRotationPoint(0F, 14F, 0F);
      sangoNecklace.setTextureSize(64, 32);
      sangoNecklace.mirror = true;
      setRotation(sangoNecklace, 0F, 0F, 0F);
      sangoTailRoot = new ModelRenderer(this, 50, 1);
      sangoTailRoot.addBox(-1F, -2F, 0F, 2, 2, 4);
      sangoTailRoot.setRotationPoint(0F, 21F, 2F);
      sangoTailRoot.setTextureSize(64, 32);
      sangoTailRoot.mirror = true;
      setRotation(sangoTailRoot, 0F, 0F, 0F);
      sangoTailTip = new ModelRenderer(this, 48, 8);
      sangoTailTip.addBox(-1F, 1F, 3F, 2, 2, 6);
      sangoTailTip.setRotationPoint(0F, 21F, 2F);
      sangoTailTip.setTextureSize(64, 32);
      sangoTailTip.mirror = true;
      setRotation(sangoTailTip, 0.7853982F, 0F, 0F);
      sangoRightThigh = new ModelRenderer(this, 33, 0);
      sangoRightThigh.addBox(-4F, -1F, -2F, 3, 4, 4);
      sangoRightThigh.setRotationPoint(0F, 21F, 2F);
      sangoRightThigh.setTextureSize(64, 32);
      sangoRightThigh.mirror = true;
      setRotation(sangoRightThigh, -0.7853982F, 0F, 0F);
      sangoRightFoot = new ModelRenderer(this, 34, 10);
      sangoRightFoot.addBox(-3F, 2F, -5F, 2, 1, 4);
      sangoRightFoot.setRotationPoint(0F, 21F, 2F);
      sangoRightFoot.setTextureSize(64, 32);
      sangoRightFoot.mirror = true;
      setRotation(sangoRightFoot, 0F, 0F, 0F);
      sangoLeftThigh.mirror = true;
      sangoLeftThigh = new ModelRenderer(this, 33, 0);
      sangoLeftThigh.addBox(1F, -1F, -2F, 3, 4, 4);
      sangoLeftThigh.setRotationPoint(0F, 21F, 2F);
      sangoLeftThigh.setTextureSize(64, 32);
      sangoLeftThigh.mirror = true;
      setRotation(sangoLeftThigh, -0.7853982F, 0F, 0F);
      sangoLeftThigh.mirror = false;
      sangoLeftFoot.mirror = true;
      sangoLeftFoot = new ModelRenderer(this, 34, 10);
      sangoLeftFoot.addBox(1F, 2F, -5F, 2, 1, 4);
      sangoLeftFoot.setRotationPoint(0F, 21F, 2F);
      sangoLeftFoot.setTextureSize(64, 32);
      sangoLeftFoot.mirror = true;
      setRotation(sangoLeftFoot, 0F, 0F, 0F);
      sangoLeftFoot.mirror = false;
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    sangoHead.render(f5);
    sangoHairOrnament.render(f5);
    sangoRightEar.render(f5);
    sangoLeftEar.render(f5);
    sangoRightCheek.render(f5);
    sangoLeftCheek.render(f5);
    sangoRightArm.render(f5);
    sangoLeftArm.render(f5);
    sangoBody.render(f5);
    sangoNecklace.render(f5);
    sangoTailRoot.render(f5);
    sangoTailTip.render(f5);
    sangoRightThigh.render(f5);
    sangoRightFoot.render(f5);
    sangoLeftThigh.render(f5);
    sangoLeftFoot.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}
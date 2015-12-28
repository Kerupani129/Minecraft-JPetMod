package net.kerupani129.jpetmod.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSapphie extends ModelJPet {

	//
	// コンストラクタ
	//
	public ModelSapphie() {

		super();

		jpetHairOrnament = new ModelRenderer(this);
		jpetHairOrnament.mirror = false;
		jpetHairOrnament.setTextureOffset(20, 16).addBox(2F, -10F, -1.9F, 3, 3, 3);
		jpetHairOrnament.setTextureOffset(20, 22).addBox(0F, -10.1F, -4.5F, 3, 3, 3);
		jpetHairOrnament.setTextureOffset(20, 16).addBox(-3F, -10.1F, -4.5F, 3, 3, 3);
		jpetHairOrnament.setTextureOffset(20, 22).addBox(-5F, -10F, -1.9F, 3, 3, 3);
		jpetHairOrnament.setTextureOffset(20, 16).addBox(-4.5F, -10F, 1.1F, 3, 3, 3);
		jpetHairOrnament.setTextureOffset(20, 22).addBox(-1.5F, -10F, 2F, 3, 3, 3);
		jpetHairOrnament.setTextureOffset(20, 16).addBox(1.5F, -10F, 1.1F, 3, 3, 3);
		jpetHairOrnament.setRotationPoint(0F, 14F, 0F);
		jpetHairOrnament.setTextureSize(64, 32);
		setRotationOffset(jpetHairOrnament, 0F, 0F, 0F);

		jpetRightEar = new ModelRenderer(this);
		jpetRightEar.mirror = false;
		jpetRightEar.setTextureOffset(33, 17).addBox(1F, -9F, 4F, 4, 1, 3);
		jpetRightEar.setTextureOffset(32, 22).addBox(1F, -8F, 4F, 4, 6, 4);
		jpetRightEar.setTextureOffset(48, 23).addBox(1F, -2F, 4F, 4, 5, 4);
		jpetRightEar.setRotationPoint(0F, 14F, 0F);
		jpetRightEar.setTextureSize(64, 32);
		setRotationOffset(jpetRightEar, 0.1745329F, -1.5707963F, 0F);

		jpetLeftEar = new ModelRenderer(this);
		jpetLeftEar.mirror = true;
		jpetLeftEar.setTextureOffset(33, 17).addBox(-5F, -9F, 4F, 4, 1, 3);
		jpetLeftEar.setTextureOffset(32, 22).addBox(-5F, -8F, 4F, 4, 6, 4);
		jpetLeftEar.setTextureOffset(48, 23).addBox(-5F, -2F, 4F, 4, 5, 4);
		jpetLeftEar.setRotationPoint(0F, 14F, 0F);
		jpetLeftEar.setTextureSize(64, 32);
		setRotationOffset(jpetLeftEar, 0.1745329F, 1.5707963F, 0F);

		jpetNecklace = new ModelRenderer(this);
		jpetNecklace.mirror = false;
		jpetNecklace.setTextureOffset(21, 28).addBox(-0.5F, 1F, -2.5F, 1, 1, 1);
		jpetNecklace.setTextureOffset(26, 29).addBox(-1F, 2F, -2.5F, 2, 2, 1);
		jpetNecklace.setTextureOffset(21, 30).addBox(-0.5F, 4F, -2.5F, 1, 1, 1);
		jpetNecklace.setRotationPoint(0F, 14F, 0F);
		jpetNecklace.setTextureSize(64, 32);
		setRotationOffset(jpetNecklace, 0F, 0F, 0F);

		jpetTailTip = new ModelRenderer(this);
		jpetTailTip.mirror = false;
		jpetTailTip.setTextureOffset(50, 9).addBox(-1.5F, 0F, 3F, 3, 3, 3);
		jpetTailTip.setTextureOffset(50, 16).addBox(-1.5F, 0F, 6F, 3, 3, 3);
		jpetTailTip.setRotationPoint(0F, 21F, 2F);
		jpetTailTip.setTextureSize(64, 32);
		setRotationOffset(jpetTailTip, 0.7853982F, 0F, 0F);

	}

	//
	// 様々な角度設定
	//
	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {

		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		jpetRightEar.rotateAngleX = 0.1745329F;
		jpetRightEar.rotateAngleY = jpetHead.rotateAngleY - 1.5707963F;
		jpetLeftEar.rotateAngleX  = 0.1745329F;
		jpetLeftEar.rotateAngleY  = jpetHead.rotateAngleY + 1.5707963F;

	}

}

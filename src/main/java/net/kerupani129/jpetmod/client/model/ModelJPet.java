package net.kerupani129.jpetmod.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class ModelJPet extends ModelBase {

	// 変数
	protected ModelRenderer jpetHead;
	protected ModelRenderer jpetHairOrnament;
	protected ModelRenderer jpetRightEar;
	protected ModelRenderer jpetLeftEar;
	protected ModelRenderer jpetRightCheek;
	protected ModelRenderer jpetLeftCheek;
	protected ModelRenderer jpetRightArm;
	protected ModelRenderer jpetLeftArm;
	protected ModelRenderer jpetBody;
	protected ModelRenderer jpetNecklace;
	protected ModelRenderer jpetTailRoot;
	protected ModelRenderer jpetTailTip;
	protected ModelRenderer jpetRightThigh;
	protected ModelRenderer jpetRightFoot;
	protected ModelRenderer jpetLeftThigh;
	protected ModelRenderer jpetLeftFoot;

	//
	// コンストラクタ
	//
	public ModelJPet() {

		// テクスチャサイズ
		textureWidth  = 64;
		textureHeight = 32;

		// 箱, 位置, 向き の設定
		jpetHead = new ModelRenderer(this, 0, 0);
		jpetHead.mirror = false;
		jpetHead.addBox(-4F, -8F, -4F, 8, 8, 8);
		jpetHead.setRotationPoint(0F, 14F, 0F);
		setRotationOffset(jpetHead, 0F, 0F, 0F);

		jpetHairOrnament = new ModelRenderer(this, 20, 22);
		jpetHairOrnament.mirror = false;
		jpetHairOrnament.addBox(0F, -9F, -4.1F, 5, 4, 1);
		jpetHairOrnament.setRotationPoint(0F, 14F, 0F);
		setRotationOffset(jpetHairOrnament, 0F, 0F, 0F);

		jpetRightEar = new ModelRenderer(this, 21, 16);
		jpetRightEar.mirror = false;
		jpetRightEar.addBox(-5F, -10F, 0F, 4, 5, 1);
		jpetRightEar.setRotationPoint(0F, 14F, 0F);
		setRotationOffset(jpetRightEar, 0F, -0.1745329F, 0F);

		jpetLeftEar = new ModelRenderer(this, 21, 16);
		jpetLeftEar.mirror = true;
		jpetLeftEar.addBox(1F, -10F, 0F, 4, 5, 1);
		jpetLeftEar.setRotationPoint(0F, 14F, 0F);
		setRotationOffset(jpetLeftEar, 0F, 0.1745329F, 0F);

		jpetRightCheek = new ModelRenderer(this, 0, 2);
		jpetRightCheek.mirror = false;
		jpetRightCheek.addBox(-6F, -3F, 0F, 3, 3, 1);
		jpetRightCheek.setRotationPoint(0F, 14F, 0F);
		setRotationOffset(jpetRightCheek, 0F, 0F, 0F);

		jpetLeftCheek = new ModelRenderer(this, 0, 2);
		jpetLeftCheek.mirror = true;
		jpetLeftCheek.addBox(3F, -3F, 0F, 3, 3, 1);
		jpetLeftCheek.setRotationPoint(0F, 14F, 0F);
		setRotationOffset(jpetLeftCheek, 0F, 0F, 0F);

		jpetRightArm = new ModelRenderer(this, 24, 0);
		jpetRightArm.mirror = false;
		jpetRightArm.addBox(-1F, -1F, -1F, 2, 5, 2);
		jpetRightArm.setRotationPoint(-2.5F, 15F, 0F);
		setRotationOffset(jpetRightArm, 0F, 0F, 0.6981317F);

		jpetLeftArm = new ModelRenderer(this, 24, 0);
		jpetLeftArm.mirror = true;
		jpetLeftArm.addBox(-1F, -1F, -1F, 2, 5, 2);
		jpetLeftArm.setRotationPoint(2.5F, 15F, 0F);
		setRotationOffset(jpetLeftArm, 0F, 0F, -0.6981317F);

		jpetBody = new ModelRenderer(this, 0, 18);
		jpetBody.mirror = false;
		jpetBody.addBox(-3F, 0F, -2F, 6, 8, 4);
		jpetBody.setRotationPoint(0F, 14F, 0F);
		setRotationOffset(jpetBody, 0.3490659F, 0F, 0F);

		jpetNecklace = new ModelRenderer(this, 22, 27);
		jpetNecklace.mirror = false;
		jpetNecklace.addBox(-1F, 1F, -3F, 2, 3, 2);
		jpetNecklace.setRotationPoint(0F, 14F, 0F);
		setRotationOffset(jpetNecklace, 0F, 0F, 0F);

		jpetTailRoot = new ModelRenderer(this, 50, 1);
		jpetTailRoot.mirror = false;
		jpetTailRoot.addBox(-1F, -2F, 0F, 2, 2, 4);
		jpetTailRoot.setRotationPoint(0F, 21F, 2F);
		setRotationOffset(jpetTailRoot, 0F, 0F, 0F);

		jpetTailTip = new ModelRenderer(this, 48, 8);
		jpetTailTip.mirror = false;
		jpetTailTip.addBox(-1F, 1F, 3F, 2, 2, 6);
		jpetTailTip.setRotationPoint(0F, 21F, 2F);
		setRotationOffset(jpetTailTip, 0.7853982F, 0F, 0F);

		jpetRightThigh = new ModelRenderer(this, 33, 0);
		jpetRightThigh.mirror = false;
		jpetRightThigh.addBox(-4F, -1F, -2F, 3, 4, 4);
		jpetRightThigh.setRotationPoint(0F, 21F, 2F);
		setRotationOffset(jpetRightThigh, -0.7853982F, 0F, 0F);

		jpetRightFoot = new ModelRenderer(this, 34, 10);
		jpetRightFoot.mirror = false;
		jpetRightFoot.addBox(-3F, 2F, -5F, 2, 1, 4);
		jpetRightFoot.setRotationPoint(0F, 21F, 2F);
		setRotationOffset(jpetRightFoot, 0F, 0F, 0F);

		jpetLeftThigh = new ModelRenderer(this, 33, 0);
		jpetLeftThigh.mirror = true;
		jpetLeftThigh.addBox(1F, -1F, -2F, 3, 4, 4);
		jpetLeftThigh.setRotationPoint(0F, 21F, 2F);
		setRotationOffset(jpetLeftThigh, -0.7853982F, 0F, 0F);

		jpetLeftFoot = new ModelRenderer(this, 34, 10);
		jpetLeftFoot.mirror = true;
		jpetLeftFoot.addBox(1F, 2F, -5F, 2, 1, 4);
		jpetLeftFoot.setRotationPoint(0F, 21F, 2F);
		setRotationOffset(jpetLeftFoot, 0F, 0F, 0F);

	}

	//
	// 様々な角度で表示
	//
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		// 様々な角度設定
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		// 描画
		jpetHead.render(f5);
		jpetHairOrnament.render(f5);
		jpetRightEar.render(f5);
		jpetLeftEar.render(f5);
		jpetRightCheek.render(f5);
		jpetLeftCheek.render(f5);
		jpetRightArm.render(f5);
		jpetLeftArm.render(f5);
		jpetBody.render(f5);
		jpetNecklace.render(f5);
		jpetTailRoot.render(f5);
		jpetTailTip.render(f5);
		jpetRightThigh.render(f5);
		jpetRightFoot.render(f5);
		jpetLeftThigh.render(f5);
		jpetLeftFoot.render(f5);

	}

	//
	// 角度を一括設定
	//
	protected static void setRotationOffset(ModelRenderer model, float x, float y, float z) {

		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;

	}

	//
	// 簡易独自アニメーション追加
	//
	@Override
	public void setLivingAnimations(EntityLivingBase entitylivingbase, float f, float f1, float f2) {

		// EntityJPet entityjpet = (EntityJPet)entitylivingbase;

		float rad = MathHelper.cos(f * 0.6662F) * 1.8F * f1;

		jpetRightArm.rotateAngleX = -rad;
		jpetLeftArm.rotateAngleX  = rad;

		// jpetTailRoot.rotateAngleZ = rad;
		// jpetTailTip.rotateAngleZ = jpetTailRoot.rotateAngleZ;

		jpetRightThigh.rotateAngleX = rad - 0.7853982F;
		jpetRightFoot.rotateAngleX  = rad;
		jpetLeftThigh.rotateAngleX  = -rad - 0.7853982F;
		jpetLeftFoot.rotateAngleX   = -rad;

	}

	//
	// 様々な角度設定
	//
	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {

		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		jpetHead.rotateAngleX = f4 / (180F / (float)Math.PI);
		jpetHead.rotateAngleY = f3 / (180F / (float)Math.PI);

		jpetHairOrnament.rotateAngleX = jpetHead.rotateAngleX;
		jpetHairOrnament.rotateAngleY = jpetHead.rotateAngleY;
		jpetRightEar.rotateAngleX     = jpetHead.rotateAngleX;
		jpetRightEar.rotateAngleY     = jpetHead.rotateAngleY - 0.1745329F;
		jpetLeftEar.rotateAngleX      = jpetHead.rotateAngleX;
		jpetLeftEar.rotateAngleY      = jpetHead.rotateAngleY + 0.1745329F;
		jpetRightCheek.rotateAngleX   = jpetHead.rotateAngleX;
		jpetRightCheek.rotateAngleY   = jpetHead.rotateAngleY;
		jpetLeftCheek.rotateAngleX    = jpetHead.rotateAngleX;
		jpetLeftCheek.rotateAngleY    = jpetHead.rotateAngleY;

	}

}


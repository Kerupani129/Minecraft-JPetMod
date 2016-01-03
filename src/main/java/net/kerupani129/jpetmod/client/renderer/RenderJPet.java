package net.kerupani129.jpetmod.client.renderer;

import net.kerupani129.jpetmod.client.model.ModelJPet;
import net.kerupani129.jpetmod.entity.passive.EntityJPet;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class RenderJPet<T extends EntityJPet> extends RenderLiving<T> {

	//
	// コンストラクタ
	//
	public RenderJPet(RenderManager rendermanager, ModelJPet modelbase, float f) {
		super(rendermanager, modelbase, f);
	}

	//
	// pct の割合に対する start と end の間の値を取得
	//
    private double interpolateValue(double start, double end, double pct)
    {
    	return start + (end - start) * pct;
    }

	//
	// リードの高さを調整
	//
    // ■メモ
    //     Yaw   角 : 上下方向の軸周りの回転角度
    //     Pitch 角 : 左右方向の軸周りの回転角度
    //
	@Override
    protected void renderLeash(T entityLivingIn, double x, double y, double z, float entityYaw, float partialTicks) {

		// リードが結ばれているフェンス・持っているプレイヤー等 取得
        Entity entity = entityLivingIn.getLeashedToEntity();

        if (entity != null) {

            // テッセレータ・レンダラを取得
        	Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldrenderer = tessellator.getWorldRenderer();

            // リードが結ばれているフェンス・持っているプレイヤー等の側の位置 算出
            double rotationYaw = this.interpolateValue((double)entity.prevRotationYaw, (double)entity.rotationYaw, (double)(partialTicks * 0.5F)) * Math.PI / 180D;
            double rotationPitch = this.interpolateValue((double)entity.prevRotationPitch, (double)entity.rotationPitch, (double)(partialTicks * 0.5F)) * Math.PI / 180D;

            double cosYaw = Math.cos(rotationYaw);
            double sinYaw = Math.sin(rotationYaw);
            double cosPitch = Math.cos(rotationPitch);
            double sinPitch = Math.sin(rotationPitch);

            if (entity instanceof EntityHanging) {
                cosYaw = 0.0D;
                sinYaw = 0.0D;
                sinPitch = -1.0D;
            }

            double posX = this.interpolateValue(entity.prevPosX, entity.posX, (double)partialTicks);
            double posY = this.interpolateValue(entity.prevPosY, entity.posY, (double)partialTicks) + (double)entity.getEyeHeight() * 0.7D;
            double posZ = this.interpolateValue(entity.prevPosZ, entity.posZ, (double)partialTicks);

            posX += - cosYaw * 0.7D - sinYaw * 0.5D * cosPitch;
            posY += - sinPitch * 0.5D - 0.25D;
            posZ += - sinYaw * 0.7D + cosYaw * 0.5D * cosPitch;

            // リードに繋がれている MOB 側の位置 算出
            double renderYawOffset = this.interpolateValue((double)entityLivingIn.prevRenderYawOffset, (double)entityLivingIn.renderYawOffset, (double)partialTicks) * Math.PI / 180;
            renderYawOffset += Math.PI / 2D;

            double renderXOffset = Math.cos(renderYawOffset) * (double)entityLivingIn.width * 0.4D;
            double renderZOffset = Math.sin(renderYawOffset) * (double)entityLivingIn.width * 0.4D;

            double renderX = this.interpolateValue(entityLivingIn.prevPosX, entityLivingIn.posX, (double)partialTicks);
            double renderY = this.interpolateValue(entityLivingIn.prevPosY, entityLivingIn.posY, (double)partialTicks);
            double renderZ = this.interpolateValue(entityLivingIn.prevPosZ, entityLivingIn.posZ, (double)partialTicks);

            renderX += renderXOffset;
            renderZ += renderZOffset;

            x += renderXOffset;
            y += - (1.6D - (double)entityLivingIn.height) / 2D;
            z += renderZOffset;

            /* JPetMod 独自 */
            renderY += (1.6D - (double)entityLivingIn.height) / 2D;
            y       += (1.6D - (double)entityLivingIn.height) / 2D;
            renderY += (double)((EntityJPet)entityLivingIn).getNeckHeight() - 1.5D;
            y       += (double)((EntityJPet)entityLivingIn).getNeckHeight() - 1.5D;

            // 描画
            /* 差分 */
            double diffX = posX - renderX;
            double diffY = posY - renderY;
            double diffZ = posZ - renderZ;

            /* 色々無効に */
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableCull();

            /* 描画 1 */
            worldrenderer.func_181668_a(5, DefaultVertexFormats.field_181706_f);

            for (int i = 0; i <= 24; ++i) {

                float f = 0.5F;
                float f1 = 0.4F;
                float f2 = 0.3F;

                if (i % 2 == 0) {
                    f *= 0.7F;
                    f1 *= 0.7F;
                    f2 *= 0.7F;
                }

                float f3 = (float)i / 24.0F;
                worldrenderer.func_181662_b(x + diffX * (double)f3 + 0.0D, y + diffY * (double)(f3 * f3 + f3) * 0.5D + (double)((24.0F - (float)i) / 18.0F + 0.125F), z + diffZ * (double)f3).func_181666_a(f, f1, f2, 1.0F).func_181675_d();
                worldrenderer.func_181662_b(x + diffX * (double)f3 + 0.025D, y + diffY * (double)(f3 * f3 + f3) * 0.5D + (double)((24.0F - (float)i) / 18.0F + 0.125F) + 0.025D, z + diffZ * (double)f3).func_181666_a(f, f1, f2, 1.0F).func_181675_d();

            }

            tessellator.draw();

            /* 描画 2 */
            worldrenderer.func_181668_a(5, DefaultVertexFormats.field_181706_f);

            for (int i = 0; i <= 24; ++i) {

                float f = 0.5F;
                float f1 = 0.4F;
                float f2 = 0.3F;

                if (i % 2 == 0) {
                    f *= 0.7F;
                    f1 *= 0.7F;
                    f2 *= 0.7F;
                }

                float f3 = (float)i / 24.0F;
                worldrenderer.func_181662_b(x + diffX * (double)f3 + 0.0D, y + diffY * (double)(f3 * f3 + f3) * 0.5D + (double)((24.0F - (float)i) / 18.0F + 0.125F) + 0.025D, z + diffZ * (double)f3).func_181666_a(f, f1, f2, 1.0F).func_181675_d();
                worldrenderer.func_181662_b(x + diffX * (double)f3 + 0.025D, y + diffY * (double)(f3 * f3 + f3) * 0.5D + (double)((24.0F - (float)i) / 18.0F + 0.125F), z + diffZ * (double)f3 + 0.025D).func_181666_a(f, f1, f2, 1.0F).func_181675_d();

            }

            tessellator.draw();

            /* 色々有効に */
            GlStateManager.enableLighting();
            GlStateManager.enableTexture2D();
            GlStateManager.enableCull();

        }

    }


}


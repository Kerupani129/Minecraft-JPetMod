package net.kerupani129.jpetmod.client.renderer;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSapphie extends RenderJPet {
	
	// 定数
    private static final ResourceLocation sapphieTextures = new ResourceLocation("jpetmod", "textures/entity/sapphie/sapphie.png");
	
	// 
	// コンストラクタ
	// 
	public RenderSapphie(RenderManager rendermanager, ModelBase modelbase, float f) {
		super(rendermanager, modelbase, f);
	}
	
	// 
	// テクスチャ設定
	// 
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return sapphieTextures;
	}
	
}
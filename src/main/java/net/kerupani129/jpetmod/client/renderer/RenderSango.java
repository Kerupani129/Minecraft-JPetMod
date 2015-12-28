package net.kerupani129.jpetmod.client.renderer;

import net.kerupani129.jpetmod.entity.passive.EntitySango;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSango extends RenderJPet<EntitySango> {

	// 定数
    private static final ResourceLocation sangoTextures = new ResourceLocation("jpetmod", "textures/entity/sango/sango.png");

	//
	// コンストラクタ
	//
	public RenderSango(RenderManager rendermanager, ModelBase modelbase, float f) {
		super(rendermanager, modelbase, f);
	}

	//
	// テクスチャ設定
	//
	@Override
	protected ResourceLocation getEntityTexture(EntitySango entity) {
		return sangoTextures;
	}

}

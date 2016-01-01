package net.kerupani129.jpetmod;

import net.kerupani129.jpetmod.client.model.ModelJPet;
import net.kerupani129.jpetmod.client.renderer.RenderJPet;
import net.kerupani129.jpetmod.entity.passive.EntityJPet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class JPetInfo {

	// 変数
	final public int id;
	final public String name;

	final public Class<? extends EntityJPet> entity;
	final public Class<? extends ModelJPet> model;
	final public Class<? extends RenderJPet<?>> renderer;

	final public int primaryEggColor;
	final public int secondaryEggColor;

	//
	// コンストラクタ
	//
	public JPetInfo(int id, String name, Class<? extends EntityJPet> entity, Class<? extends ModelJPet> model, Class<? extends RenderJPet<?>> renderer, int primaryEggColor, int secondaryEggColor) {

		this.id = id;
		this.name = name;

		this.entity = entity;
		this.model = model;
		this.renderer = renderer;

		this.primaryEggColor = primaryEggColor;
		this.secondaryEggColor = secondaryEggColor;

	}

	//
	// エンティティ を インスタンス化
	//
	public EntityJPet newEntity(World worldIn) {
		EntityJPet instance = null;
		try {
			if (entity != null) {
				instance = entity.getConstructor(World.class).newInstance(worldIn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instance;
	}

	//
	// モデル を インスタンス化
	//
	@SideOnly(Side.CLIENT)
	public ModelJPet newModel() {
		ModelJPet instance = null;
		try {
			if (model != null) {
				instance = model.getConstructor().newInstance();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instance;
	}

	//
	// レンダラ を インスタンス化
	//
	@SideOnly(Side.CLIENT)
	public RenderJPet<?> newRenderer(RenderManager rendermanager, ModelJPet modeljpet, float f) {
		RenderJPet<?> instance = null;
		try {
			if (renderer != null) {
				instance = renderer.getConstructor(RenderManager.class, ModelJPet.class, float.class).newInstance(rendermanager, modeljpet, f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instance;
	}

	//
	// レンダラ を インスタンス化
	//
	@SideOnly(Side.CLIENT)
	public RenderJPet<?> newRenderer() {
		return newRenderer(Minecraft.getMinecraft().getRenderManager(), newModel(), 0.5F);
	}

}

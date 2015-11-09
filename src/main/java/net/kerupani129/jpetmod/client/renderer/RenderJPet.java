package net.kerupani129.jpetmod.client.renderer;

import net.minecraft.entity.EntityLiving;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.model.ModelBase;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.kerupani129.jpetmod.entity.passive.EntityJPet;

@SideOnly(Side.CLIENT)
public abstract class RenderJPet extends RenderLiving {
	
	// 
	// コンストラクタ
	// 
	public RenderJPet(RenderManager rendermanager, ModelBase modelbase, float f) {
		super(rendermanager, modelbase, f);
	}
	
	// 
	// リードの高さを調整
	// 
	@Override
	protected void renderLeash(EntityLiving entityliving, double x, double y, double z, float f, float partialTicks) {
		
		y -= 1.5D;
		y += (double)((EntityJPet)entityliving).getNeckHeight();
		y += (1.6D - (double)entityliving.height) * 0.5D;
		
		super.renderLeash(entityliving, x, y, z, f, partialTicks);
		
	}
	
	
}


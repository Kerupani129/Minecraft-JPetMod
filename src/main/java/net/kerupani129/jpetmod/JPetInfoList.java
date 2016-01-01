package net.kerupani129.jpetmod;

import java.util.ArrayList;

import net.kerupani129.jpetmod.client.model.ModelSango;
import net.kerupani129.jpetmod.client.model.ModelSapphie;
import net.kerupani129.jpetmod.client.renderer.RenderSango;
import net.kerupani129.jpetmod.client.renderer.RenderSapphie;
import net.kerupani129.jpetmod.entity.passive.EntitySango;
import net.kerupani129.jpetmod.entity.passive.EntitySapphie;

public final class JPetInfoList extends ArrayList<JPetInfo> {

	private static final JPetInfoList list = new JPetInfoList();

	private JPetInfoList() {

		super();

		this.add(new JPetInfo(1, "Sango", EntitySango.class, ModelSango.class, RenderSango.class, 0xFFFAF6C7, 0xFFB67D48));
		this.add(new JPetInfo(2, "Sapphie", EntitySapphie.class, ModelSapphie.class, RenderSapphie.class, 0xFFFAF6C7, 0xFF6BCCEF));

	}

	public static JPetInfoList getInstance() {
		return list;
	}

}

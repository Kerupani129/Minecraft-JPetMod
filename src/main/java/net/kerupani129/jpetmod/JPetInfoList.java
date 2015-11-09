package net.kerupani129.jpetmod;

import java.util.*;
import java.awt.*;

import net.kerupani129.jpetmod.entity.passive.*;
import net.kerupani129.jpetmod.client.model.*;
import net.kerupani129.jpetmod.client.renderer.*;

public class JPetInfoList extends ArrayList<JPetInfo> {
	
	private static final JPetInfoList list = new JPetInfoList();
	
	private JPetInfoList() {
		
		super();
		
		this.add(new JPetInfo(1, "Sango", EntitySango.class, ModelSango.class, RenderSango.class, 0xFFFAF6C7, 0xFFB67D48));
		this.add(new JPetInfo(2, "Sapphie", EntitySapphie.class, ModelSapphie.class, RenderSapphie.class, 0xFFFAF6C7, 0xFF6BCCEF));
		
	}
	
	public static JPetInfoList getList() {
		return list;
	}
	
}

package net.kerupani129.jpetmod;

import java.util.ArrayList;
import java.util.List;

import net.kerupani129.jpetmod.item.ItemJPetPlacer;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(name = JPetMod.NAME, modid = JPetMod.MODID, version = JPetMod.VERSION)
public class JPetMod {

	// 定数
	public static final String NAME = "Jewelpet Mod";
	public static final String MODID = "jpetmod";
	public static final String VERSION = "1.0";

	// 変数
	public static Item itemJPetPlacer;

	//
	// MOD の初期化
	//
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		itemJPetPlacer = new ItemJPetPlacer().setUnlocalizedName(MODID + "." + "jpetPlacer");
		GameRegistry.registerItem(itemJPetPlacer, "jpet_spawn_egg");
		if(event.getSide().isClient()) {
			// ModelLoader.setCustomModelResourceLocation(itemJPetPlacer, 0, new ModelResourceLocation("minecraft:spawn_egg", "inventory"));
			ModelLoader.setCustomMeshDefinition(itemJPetPlacer, new ItemMeshDefinition() {
				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {
					return new ModelResourceLocation("minecraft:spawn_egg", "inventory");
				}
			});
		}

	}

	//
	// MOD の初期化
	//
	@EventHandler
	public void init(FMLInitializationEvent event) {

		// スポーンするバイオームの一覧の作成
		List<BiomeGenBase> biomeList = new ArrayList<BiomeGenBase>();
		for (BiomeGenBase biome: BiomeGenBase.getBiomeGenArray()) {
			if (biome != null) {
				biomeList.add(biome);
			}
		}
		BiomeGenBase[] biomeArray = biomeList.toArray(new BiomeGenBase[0]);

		// キャラごとに登録
		for (JPetInfo info : JPetInfoList.getInstance()) {
			EntityRegistry.registerModEntity(info.entity, info.name, info.id, this, 80, 3, true);
			EntityRegistry.addSpawn(info.entity, 100, 10, 20, EnumCreatureType.CREATURE, biomeArray);
			if(event.getSide().isClient()) {
				RenderingRegistry.registerEntityRenderingHandler(info.entity, info.newRenderer());
			}
		}

	}

}

package net.kerupani129.jpetmod.entity.passive;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.kerupani129.jpetmod.entity.ai.EntityAIJPetMate;

public class EntitySapphie extends EntityJPet {
	
	// 
	// コンストラクタ
	// 
	public EntitySapphie(World worldIn) {
		
		super(worldIn);
		
		((PathNavigateGround)this.getNavigator()).func_179690_a(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.2D));
		this.tasks.addTask(2, new EntityAIJPetMate(this, 1.0D));
		this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.cake, false));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		
	}
	
	// 
	// 繁殖用に与えられるアイテムかどうかチェック
	// 
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return (stack != null) && (stack.getItem() == Items.cake);
	}
	
}

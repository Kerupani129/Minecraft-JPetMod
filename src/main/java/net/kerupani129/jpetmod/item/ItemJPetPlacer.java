package net.kerupani129.jpetmod.item;

import java.util.List;

import net.kerupani129.jpetmod.JPetInfo;
import net.kerupani129.jpetmod.JPetInfoList;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemJPetPlacer extends ItemMonsterPlacer {

	//
	// コンストラクタ
	//
	public ItemJPetPlacer() {
		super();
	}

	//
	// 色の設定
	//
	@SideOnly(Side.CLIENT)
	@Override
	public int getColorFromItemStack(ItemStack stack, int renderPass) {
		JPetInfo info = JPetInfoList.getList().get(Integer.valueOf(stack.getMetadata()));
		return (renderPass == 0) ? (info.primaryEggColor) : (info.secondaryEggColor);
	}

	//
	// 表示名取得
	//
	@Override
	public String getItemStackDisplayName(ItemStack stack) {

		String s = ("" + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name")).trim();
		JPetInfo info = JPetInfoList.getList().get(Integer.valueOf(stack.getMetadata()));
		String s1 = (String)EntityList.classToStringMapping.get(info.entity);

		if (s1 != null) {
			s += " " + StatCollector.translateToLocal("entity." + s1 + ".name");
		}

		return s;

	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{

		if (worldIn.isRemote)
		{
			return true;
		}
		else if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
		{
			return false;
		}
		else
		{
			IBlockState iblockstate = worldIn.getBlockState(pos);

			if (iblockstate.getBlock() == Blocks.mob_spawner)
			{
				TileEntity tileentity = worldIn.getTileEntity(pos);

				if (tileentity instanceof TileEntityMobSpawner)
				{
					MobSpawnerBaseLogic mobspawnerbaselogic = ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic();
					mobspawnerbaselogic.setEntityName(EntityList.getStringFromID(stack.getMetadata()));
					tileentity.markDirty();
					worldIn.markBlockForUpdate(pos);

					if (!playerIn.capabilities.isCreativeMode)
					{
						--stack.stackSize;
					}

					return true;
				}
			}

			pos = pos.offset(side);
			double d0 = 0.0D;

			if (side == EnumFacing.UP && iblockstate instanceof BlockFence)
			{
				d0 = 0.5D;
			}

			Entity entity = spawnCreature(worldIn, stack.getMetadata(), (double)pos.getX() + 0.5D, (double)pos.getY() + d0, (double)pos.getZ() + 0.5D);

			if (entity != null)
			{
				if (entity instanceof EntityLivingBase && stack.hasDisplayName())
				{
					entity.setCustomNameTag(stack.getDisplayName());
				}

				if (!playerIn.capabilities.isCreativeMode)
				{
					--stack.stackSize;
				}
			}

			return true;
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{

		if (worldIn.isRemote)
		{
			return itemStackIn;
		}
		else
		{
			MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(worldIn, playerIn, true);

			if (movingobjectposition == null)
			{
				return itemStackIn;
			}
			else
			{
				if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
				{
					BlockPos blockpos = movingobjectposition.getBlockPos();

					if (!worldIn.isBlockModifiable(playerIn, blockpos))
					{
						return itemStackIn;
					}

					if (!playerIn.canPlayerEdit(blockpos, movingobjectposition.sideHit, itemStackIn))
					{
						return itemStackIn;
					}

					if (worldIn.getBlockState(blockpos).getBlock() instanceof BlockLiquid)
					{
						Entity entity = spawnCreature(worldIn, itemStackIn.getMetadata(), (double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.5D, (double)blockpos.getZ() + 0.5D);

						if (entity != null)
						{
							if (entity instanceof EntityLivingBase && itemStackIn.hasDisplayName())
							{
								((EntityLiving)entity).setCustomNameTag(itemStackIn.getDisplayName());
							}

							if (!playerIn.capabilities.isCreativeMode)
							{
								--itemStackIn.stackSize;
							}

							playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
						}
					}
				}

				return itemStackIn;
			}
		}
	}

	//
	// スポーン処理
	//
	public static Entity spawnCreature(World worldIn, int entityID, double x, double y, double z) {

		JPetInfo info = JPetInfoList.getList().get(entityID);

		Entity entity = info.newEntity(worldIn);

		if (entity instanceof EntityLivingBase) {
			EntityLiving entityliving = (EntityLiving)entity;
			entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(worldIn.rand.nextFloat() * 360.0F), 0.0F);
			entityliving.rotationYawHead = entityliving.rotationYaw;
			entityliving.renderYawOffset = entityliving.rotationYaw;
			entityliving.onInitialSpawn(worldIn.getDifficultyForLocation(new BlockPos(entityliving)), (IEntityLivingData)null);
			worldIn.spawnEntityInWorld(entity);
			entityliving.playLivingSound();
		}

		return entity;

	}

	//
	// 各スポーンエッグの登録
	//
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
		int size = JPetInfoList.getList().size();
		for (int i = 0; i < size; i++) {
			subItems.add(new ItemStack(itemIn, 1, i));
		}
	}

}

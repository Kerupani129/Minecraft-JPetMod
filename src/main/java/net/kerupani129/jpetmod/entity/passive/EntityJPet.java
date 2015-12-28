package net.kerupani129.jpetmod.entity.passive;

import net.kerupani129.jpetmod.JPetInfoList;
import net.kerupani129.jpetmod.item.ItemJPetPlacer;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class EntityJPet extends EntityTameable {

	//
	// コンストラクタ
	//
	public EntityJPet(World worldIn) {

		super(worldIn);
		this.setSize(0.625F, 1.125F);

	}

	//
	// プレイヤーとのかかわり
	//
	@Override
    public boolean interact(EntityPlayer player) {

		ItemStack itemstack = player.inventory.getCurrentItem();

		if (itemstack != null && itemstack.getItem() instanceof ItemJPetPlacer) { // ホントは実体を比較する？
			if (!this.worldObj.isRemote) {
				// JPetInfo info = JPetInfoList.getList().get(itemstack.getMetadata());

				EntityAgeable entityageable = this.createChild(this);

				if (entityageable != null) {
					entityageable.setGrowingAge(-24000);
					entityageable.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
					this.worldObj.spawnEntityInWorld(entityageable);

					if (itemstack.hasDisplayName()) {
						entityageable.setCustomNameTag(itemstack.getDisplayName());
					}

					if (!player.capabilities.isCreativeMode) {
						--itemstack.stackSize;

						if (itemstack.stackSize <= 0) {
							player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
						}
					}
				}
			}

			return true;
		}

		return super.interact(player);
	}

	//
	// アトリビュート設定
	//
	@Override
    protected void applyEntityAttributes() {

		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);

	}

	//
	// 繁殖用に与えられるアイテムかどうかチェック
	//
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return (stack != null) && (stack.getItem() == Items.cake);
	}

	//
	// 繁殖できる相手かどうかチェック
	//
	@Override
	public boolean canMateWith(EntityAnimal otherAnimal) {
		return (otherAnimal == this) ? (false) :
			(!(otherAnimal instanceof EntityJPet)) ? (false) :
			// (!(this instanceof EntityJPet)) ? (false) : // 当たり前なので省略
			(otherAnimal.isInLove() && this.isInLove());
	}

	//
	// 子供を生成
	//
	@Override
	public EntityJPet createChild(EntityAgeable ageable) {

		JPetInfoList list = JPetInfoList.getList();

		return list.get(this.rand.nextInt(list.size())).newEntity(this.worldObj);

	}

	//
	// 目の高さ設定
	//
	@Override
	public float getEyeHeight() {
		return 0.8F;
	}

	//
	// 首の高さ設定 (独自拡張)
	//
	public float getNeckHeight() {
		return 0.625F;
	}

}

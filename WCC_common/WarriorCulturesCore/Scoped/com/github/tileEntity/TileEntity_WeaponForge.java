package WarriorCulturesCore.Scoped.com.github.tileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import WarriorCulturesCore.Scoped.com.github.block.Block_WeaponForge;
import WarriorCulturesCore.Scoped.com.github.core.proxy.CommonProxy;
import WarriorCulturesCore.Scoped.com.github.lib.Resources;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntity_WeaponForge extends TileEntity implements ISidedInventory
{
	private String localizedName;
	
	private static final int[] slots_top = new int[]{};
	private static final int[] slots_bottom = new int[]{8};
	private static final int[] slots_sides = new int[]{2, 3, 4, 5, 6, 7};
	
	private ItemStack[] slots = new ItemStack[9];
	private ItemStack[] craftingGridContents = new ItemStack[36];
	
	/**Furnace speed*/
	public int furnaceSpeed = 100;
	
	/**How long the fual will continue burning*/
	public int burnTime1;
	public int burnTime2;
	public int burnTime3;
	public int burnTime4;
	public int burnTime5;
	public int burnTime6;
	
	/**The start time for this item*/
	public int itemBurnTime1;
	public int itemBurnTime2;
	public int itemBurnTime3;
	public int itemBurnTime4;
	public int itemBurnTime5;
	public int itemBurnTime6;
	
	/**How much time is left until cooked*/
	public int cookTime;
	
	private int inventoryWidth;
	private ItemStack[] stackList;
	private Container eventHandler;
	
    public void onInventoryChanged() {}
    
	public boolean isSlotOneBurning()
	{
		if (burnTime1 > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isSlotTwoBurning()
	{
		if (burnTime2 > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isSlotThreeBurning()
	{
		if (burnTime3 > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isSlotFourBurning()
	{
		if (burnTime4 > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isSlotFiveBurning()
	{
		if (burnTime5 > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isSlotSixBurning()
	{
		if (burnTime6 > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
    public boolean renderAsNormalBlock()
    {
        return false;
    }
	
    public boolean isOpaqueCube()
    {
        return false;
    }
    
	public int getSizeInventory()
	{
		return this.slots.length;
	}
	
	public int getGridInventory()
	{
		return this.craftingGridContents.length;
	}
	
	public String getInvName()
	{
		return this.isInvNameLocalized() ? this.localizedName : "container.weaponForge";
	}
	
	public boolean isInvNameLocalized()
	{
		return this.localizedName != null && this.localizedName.length() > 0;
	}
	
	public void setGuiDisplayName(String displayName)
	{
		this.localizedName = displayName;
	}
	
	public ItemStack getStackInSlot(int i)
	{
		return this.slots[i];
	}
	
	public ItemStack getStackInGrid(int i)
	{
		return i >= this.getGridInventory() ? null : this.stackList[i];
	}
	
	public ItemStack decrStackSize(int i, int j)
	{
		if (this.slots[i] != null)
		{
			ItemStack itemStack;
			
			if (this.slots[i].stackSize <= j)
			{
				itemStack = this.slots[i];
				this.slots[i] = null;
				return itemStack;
			}
			else
			{
				itemStack = this.slots[i].splitStack(j);
				
				if (this.slots[i].stackSize == 0)
				{
					this.slots[i] = null;
				}
				
				return itemStack;
			}
		}
		if (this.craftingGridContents[i] != null)
		{
			ItemStack itemStack;
			
			if (this.craftingGridContents[i].stackSize <= j)
			{
				itemStack = this.craftingGridContents[i];
				this.craftingGridContents[i] = null;
				return itemStack;
			}
			else
			{
				itemStack = this.craftingGridContents[i].splitStack(j);
				
				if (this.craftingGridContents[i].stackSize == 0)
				{
					this.craftingGridContents[i] = null;
				}
				
				return itemStack;
			}
		}
		else
		{
			return null;
		}
	}
	
	public ItemStack getStackInSlotOnClosing(int i)
	{
		if (this.slots[i] != null)
		{
			ItemStack itemStack = this.slots[i];
			this.slots[i] = null;
			return itemStack;
		}
		if (this.craftingGridContents[i] != null)
		{
			ItemStack itemStack = this.craftingGridContents[i];
			this.craftingGridContents[i] = null;
			return itemStack;
		}
		else
		{
			return null;
		}
	}
	
	public void setInventorySlotContents(int i, ItemStack itemStack)
	{
		this.slots[i] = itemStack;
		
		if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
		{
			itemStack.stackSize = this.getInventoryStackLimit();
		}
		
		this.craftingGridContents[i] = itemStack;
		
		if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
		{
			itemStack.stackSize = this.getInventoryStackLimit();
		}
	}
	
	public int getInventoryStackLimit()
	{
		return 64;
	}
	
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistance((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}
	
	public void openChest(){}
	
	public void closeChest(){}
	
	public void updateEntity()
	{
		boolean flag1 = this.burnTime1 > 0;
		boolean flag2 = this.burnTime2 > 0;
		boolean flag3 = this.burnTime3 > 0;
		boolean flag4 = this.burnTime4 > 0;
		boolean flag5 = this.burnTime5 > 0;
		boolean flag6 = this.burnTime6 > 0;
		
		boolean flag8 = false;
		
		if (this.burnTime1 > 0)
		{
			--this.burnTime1;
		}
		if (this.burnTime2 > 0)
		{
			--this.burnTime2;
		}
		if (this.burnTime3 > 0)
		{
			--this.burnTime3;
		}
		if (this.burnTime4 > 0)
		{
			--this.burnTime4;
		}
		if (this.burnTime5 > 0)
		{
			--this.burnTime5;
		}
		if (this.burnTime6 > 0)
		{
			--this.burnTime6;
		}
		
		if (!this.worldObj.isRemote)
		{
			if (this.burnTime1 == 0/* && this.canSmelt()*/)
			{
				this.itemBurnTime1 = this.burnTime1 = getItemBurnTime(this.slots[2]);
				
				if (this.burnTime1 > 0)
				{
					flag8 = true;
					
					if (this.slots[2] != null)
					{
						--this.slots[2].stackSize;
				
						if (this.slots[2].stackSize == 0)
						{
							this.slots[2] = this.slots[2].getItem().getContainerItemStack(this.slots[2]);
						}
					}
				}
			}
			if (this.burnTime2 == 0/* && this.canSmelt()*/)
			{
				this.itemBurnTime2 = this.burnTime2 = getItemBurnTime(this.slots[3]);
				
				if (this.burnTime2 > 0)
				{
					flag8 = true;
					
					if (this.slots[3] != null)
					{
						--this.slots[3].stackSize;
				
						if (this.slots[3].stackSize == 0)
						{
							this.slots[3] = this.slots[3].getItem().getContainerItemStack(this.slots[3]);
						}
					}
				}
			}
			if (this.burnTime3 == 0/* && this.canSmelt()*/)
			{
				this.itemBurnTime3 = this.burnTime3 = getItemBurnTime(this.slots[4]);
				
				if (this.burnTime3 > 0)
				{
					flag8 = true;
					
					if (this.slots[4] != null)
					{
						--this.slots[4].stackSize;
				
						if (this.slots[4].stackSize == 0)
						{
							this.slots[4] = this.slots[4].getItem().getContainerItemStack(this.slots[4]);
						}
					}
				}
			}
			if (this.burnTime4 == 0/* && this.canSmelt()*/)
			{
				this.itemBurnTime4 = this.burnTime4 = getItemBurnTime(this.slots[5]);
				
				if (this.burnTime4 > 0)
				{
					flag8 = true;
					
					if (this.slots[5] != null)
					{
						--this.slots[5].stackSize;
				
						if (this.slots[5].stackSize == 0)
						{
							this.slots[5] = this.slots[5].getItem().getContainerItemStack(this.slots[5]);
						}
					}
				}
			}
			if (this.burnTime5 == 0/* && this.canSmelt()*/)
			{
				this.itemBurnTime5 = this.burnTime5 = getItemBurnTime(this.slots[6]);
				
				if (this.burnTime5 > 0)
				{
					flag8 = true;
					
					if (this.slots[6] != null)
					{
						--this.slots[6].stackSize;
				
						if (this.slots[6].stackSize == 0)
						{
							this.slots[6] = this.slots[6].getItem().getContainerItemStack(this.slots[6]);
						}
					}
				}
			}
			if (this.burnTime6 == 0/* && this.canSmelt()*/)
			{
				this.itemBurnTime6 = this.burnTime6 = getItemBurnTime(this.slots[7]);
				
				if (this.burnTime6 > 0)
				{
					flag8 = true;
					
					if (this.slots[7] != null)
					{
						--this.slots[7].stackSize;
				
						if (this.slots[7].stackSize == 0)
						{
							this.slots[7] = this.slots[7].getItem().getContainerItemStack(this.slots[7]);
						}
					}
				}
			}
			
			if (this.isSlotOneBurning()/* && this.canSmelt()*/)
			{
				++this.cookTime;
				
				if (this.cookTime == this.furnaceSpeed)
				{
					this.cookTime = 0;
					//this.smeltItem();
					flag8 = true;
				}
			}
			else
			{
				this.cookTime = 0;
			}
			
			if (this.isSlotTwoBurning() /*&& this.canSmelt()*/)
			{
				++this.cookTime;
				
				if (this.cookTime == this.furnaceSpeed)
				{
					this.cookTime = 0;
					//this.smeltItem();
					flag8 = true;
				}
			}
			else
			{
				this.cookTime = 0;
			}
			
			if (this.isSlotThreeBurning() /*&& this.canSmelt()*/)
			{
				++this.cookTime;
				
				if (this.cookTime == this.furnaceSpeed)
				{
					this.cookTime = 0;
					//this.smeltItem();
					flag8 = true;
				}
			}
			else
			{
				this.cookTime = 0;
			}
			
			if (this.isSlotFourBurning() /*&& this.canSmelt()*/)
			{
				++this.cookTime;
				
				if (this.cookTime == this.furnaceSpeed)
				{
					this.cookTime = 0;
					//this.smeltItem();
					flag8 = true;
				}
			}
			else
			{
				this.cookTime = 0;
			}
			
			if (this.isSlotFiveBurning() /*&& this.canSmelt()*/)
			{
				++this.cookTime;
				
				if (this.cookTime == this.furnaceSpeed)
				{
					this.cookTime = 0;
					//this.smeltItem();
					flag8 = true;
				}
			}
			else
			{
				this.cookTime = 0;
			}
			
			if (this.isSlotSixBurning() /*&& this.canSmelt()*/)
			{
				++this.cookTime;
				
				if (this.cookTime == this.furnaceSpeed)
				{
					this.cookTime = 0;
					//this.smeltItem();
					flag8 = true;
				}
			}
			else
			{
				this.cookTime = 0;
			}
			
			if (flag1 != this.burnTime1 > 0)
			{
				flag8 = true;
				Block_WeaponForge.updateWeaponForgeBlockState(this.burnTime1 > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
			else if (flag2 != this.burnTime2 > 0)
			{
				flag8 = true;
				Block_WeaponForge.updateWeaponForgeBlockState(this.burnTime2 > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
			else if (flag3 != this.burnTime3 > 0)
			{
				flag8 = true;
				Block_WeaponForge.updateWeaponForgeBlockState(this.burnTime3 > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
			else if (flag4 != this.burnTime4 > 0)
			{
				flag8 = true;
				Block_WeaponForge.updateWeaponForgeBlockState(this.burnTime4 > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
			else if (flag5 != this.burnTime5 > 0)
			{
				flag8 = true;
				Block_WeaponForge.updateWeaponForgeBlockState(this.burnTime5 > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
			else if (flag6 != this.burnTime6 > 0)
			{
				flag8 = true;
				Block_WeaponForge.updateWeaponForgeBlockState(this.burnTime6 > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
			
		}
		
		if (flag8)
		{
			this.onInventoryChanged();
		}
	}
	
    public ItemStack getStackInRowAndColumn(int par1, int par2)
    {
        if (par1 >= 0 && par1 < this.inventoryWidth)
        {
            int k = par1 + par2 * this.inventoryWidth;
            return this.getStackInGrid(k);
        }
        else
        {
            return null;
        }
    }
	
	/*private boolean canSmelt()
	{
		if (this.slots[0] == null)
		{
			return false;
		}
		else
		{
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			
			if (itemstack == null)
			{
				return false;
			}
			if (this.slots[2] == null)
			{
				return true;
			}
			if (!this.slots[2].isItemEqual(itemstack))
			{
				return false;
			}
			
			int result = this.slots[2].stackSize + itemstack.stackSize;
			
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
	}*/
	/*
	public void smeltItem()
	{
		if(this.canSmelt())
		{
			ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			
			if (this.slots[2] == null)
			{
				this.slots[2] = itemstack.copy();
			}
			else if (this.slots[2].isItemEqual(itemstack))
			{
				this.slots[2].stackSize += itemstack.stackSize;
			}
			
			--this.slots[0].stackSize;
			
			if (this.slots[0].stackSize <= 0)
			{
				this.slots[0] = null;
			}
		}
	}
	*/
	public static int getItemBurnTime(ItemStack itemstack)
	{
		if (itemstack == null)
		{
			return 0;
		}
		else
		{
			int i = itemstack.getItem().itemID;
			Item item = itemstack.getItem();
			
			if (itemstack.getItem() instanceof ItemBlock && Block.blocksList[i] != null)
			{
				Block block = Block.blocksList[i];
				
				if (block == Block.woodSingleSlab)
				{
					return 150;
				}
				if (block.blockMaterial == Material.wood)
				{
					return 300;
				}
				if (block == Block.field_111034_cE)
				{
					return 16000;
				}
			}
			
			if (item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
			if (item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
			if (item instanceof ItemHoe && ((ItemHoe) item).getMaterialName().equals("WOOD")) return 200;
			
			if (i == Item.stick.itemID)
			{
				return 100;
			}
			if (i == Item.coal.itemID)
			{
				return 1600;
			}
			if (i == Item.bucketLava.itemID)
			{
				return 20000;
			}
			if (i == Block.blockNetherQuartz.blockID)
			{
				return 100;
			}
			if (i == Item.blazeRod.itemID)
			{
				return 2400;
			}
			
			//Not a real recipe
			if (i == Item.netherQuartz.itemID)
			{
				return 250;
			}
			
			return GameRegistry.getFuelValue(itemstack);
		}
	}
	
	public int getCookProgressScaled(int i)
	{
		return this.cookTime * i / 100;
	}
	
	public int getSlotOneBurnTimeRemainingScaled(int i)
	{
		if (this.itemBurnTime1 == 0)
		{
			this.itemBurnTime1 = 100;
		}
		
		return this.burnTime1 * i / this.itemBurnTime1;
	}
	public int getSlotTwoBurnTimeRemainingScaled(int i)
	{
		if (this.itemBurnTime2 == 0)
		{
			this.itemBurnTime2 = 100;
		}
		
		return this.burnTime2 * i / this.itemBurnTime2;
	}
	public int getSlotThreeBurnTimeRemainingScaled(int i)
	{
		if (this.itemBurnTime3 == 0)
		{
			this.itemBurnTime3 = 100;
		}
		
		return this.burnTime3 * i / this.itemBurnTime3;
	}
	public int getSlotFourBurnTimeRemainingScaled(int i)
	{
		if (this.itemBurnTime4 == 0)
		{
			this.itemBurnTime4 = 100;
		}
		
		return this.burnTime4 * i / this.itemBurnTime4;
	}
	public int getSlotFiveBurnTimeRemainingScaled(int i)
	{
		if (this.itemBurnTime5 == 0)
		{
			this.itemBurnTime5 = 100;
		}
		
		return this.burnTime5 * i / this.itemBurnTime5;
	}
	public int getSlotSixBurnTimeRemainingScaled(int i)
	{
		if (this.itemBurnTime6 == 0)
		{
			this.itemBurnTime6 = 100;
		}
		
		return this.burnTime6 * i / this.itemBurnTime6;
	}
	
	public void readFromNBT(NBTTagCompound NBTTagCompound)
	{
		super.readFromNBT(NBTTagCompound);
		NBTTagList nbtTagList = NBTTagCompound.getTagList("Items");
		this.slots = new ItemStack[this.getSizeInventory()];
		this.craftingGridContents = new ItemStack[this.getGridInventory()];
		
		for (int i = 0; i < nbtTagList.tagCount(); ++i)
		{
			NBTTagCompound nbtTagCompound1 = (NBTTagCompound)nbtTagList.tagAt(i);
			byte b0 = nbtTagCompound1.getByte("Slot");
		
			if (b0 >= 0 && b0 < this.slots.length)
			{
				this.slots[b0] = ItemStack.loadItemStackFromNBT(nbtTagCompound1);
			}
			
			NBTTagCompound nbtTagCompound2 = (NBTTagCompound)nbtTagList.tagAt(i);
			byte b1 = nbtTagCompound2.getByte("Grid");
			if (b1 >= 0 && b0 < this.craftingGridContents.length)
			{
				this.craftingGridContents[b1] = ItemStack.loadItemStackFromNBT(nbtTagCompound1);
			}
		}
		
		this.burnTime1 = NBTTagCompound.getShort("BurnTimeOne");
		this.burnTime2 = NBTTagCompound.getShort("BurnTimeTwo");
		this.burnTime3 = NBTTagCompound.getShort("BurnTimeThree");
		this.burnTime4 = NBTTagCompound.getShort("BurnTimeFour");
		this.burnTime5 = NBTTagCompound.getShort("BurnTimeFive");
		this.burnTime6 = NBTTagCompound.getShort("BurnTimeSix");
		//this.cookTime = NBTTagCompound.getShort("CookTime");
		this.itemBurnTime1 = getItemBurnTime(this.slots[2]);
		this.itemBurnTime2 = getItemBurnTime(this.slots[3]);
		this.itemBurnTime3 = getItemBurnTime(this.slots[4]);
		this.itemBurnTime4 = getItemBurnTime(this.slots[5]);
		this.itemBurnTime5 = getItemBurnTime(this.slots[6]);
		this.itemBurnTime6 = getItemBurnTime(this.slots[7]);
		
		if (NBTTagCompound.hasKey("CustomName"))
		{
			this.localizedName = NBTTagCompound.getString("CustomName");
		}
	}
	
	public void writeToNBT(NBTTagCompound NBTTagCompound)
	{
		super.writeToNBT(NBTTagCompound);
		NBTTagCompound.setShort("BurnTimeOne", (short)this.burnTime1);
		NBTTagCompound.setShort("BurnTimeTwo", (short)this.burnTime2);
		NBTTagCompound.setShort("BurnTimeThree", (short)this.burnTime3);
		NBTTagCompound.setShort("BurnTimeFour", (short)this.burnTime4);
		NBTTagCompound.setShort("BurnTimeFive", (short)this.burnTime5);
		NBTTagCompound.setShort("BurnTimeSix", (short)this.burnTime6);
		//NBTTagCompound.setShort("CookTime", (short)this.cookTime);
		NBTTagList nbttaglist = new NBTTagList();
		
		for (int i = 0; i < this.slots.length; ++i)
		{
			if (this.slots[i] != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				this.slots[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		
		for (int i = 0; i < this.craftingGridContents.length; ++i)
		{
			if (this.craftingGridContents[i] != null)
			{
				NBTTagCompound nbttagcompound2 = new NBTTagCompound();
				nbttagcompound2.setByte("Grid", (byte)i);
				this.craftingGridContents[i].writeToNBT(nbttagcompound2);
				nbttaglist.appendTag(nbttagcompound2);
			}
		}
		
		NBTTagCompound.setTag("Items", nbttaglist);
		
		if (this.isInvNameLocalized())
		{
			NBTTagCompound.setString("CustomName", this.localizedName);
		}
	}
	
	public static boolean isItemFuel(ItemStack itemstack)
	{
		return getItemBurnTime(itemstack) > 0;
	}
	
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		return i == 8 ? false : (i == 2 ? isItemFuel(itemstack) : (i == 3 ? isItemFuel(itemstack) : (i == 4 ? isItemFuel(itemstack) : (i == 5 ? isItemFuel(itemstack) : (i == 6 ? isItemFuel(itemstack) : (i == 7 ? isItemFuel(itemstack) : true))))));
	}
	
	public int[] getAccessibleSlotsFromSide(int var1)
	{
		return var1 == 0 ? slots_bottom : (var1 == 1 ? slots_top : slots_sides);
	}
	
	public boolean canInsertItem(int i, ItemStack itemstack, int j)
	{
		return this.isItemValidForSlot(i, itemstack);
	}
	
	public boolean canExtractItem(int i, ItemStack itemstack, int j)
	{
		return j != 0 || i != 1 || itemstack.itemID == Item.bucketEmpty.itemID;
	}
	
}

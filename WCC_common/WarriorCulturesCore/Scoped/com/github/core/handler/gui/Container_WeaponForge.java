package WarriorCulturesCore.Scoped.com.github.core.handler.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import WarriorCulturesCore.Scoped.com.github.tileEntity.TileEntity_WeaponForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Container_WeaponForge extends Container
{
	private TileEntity_WeaponForge furnace;
	private int cookTime;
	
	private int itemBurnTime1;
	private int itemBurnTime2;
	private int itemBurnTime3;
	private int itemBurnTime4;
	private int itemBurnTime5;
	private int itemBurnTime6;
	
	private int burnTime1;
	private int burnTime2;
	private int burnTime3;
	private int burnTime4;
	private int burnTime5;
	private int burnTime6;
	
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 6, 6);
	public IInventory craftResult = new InventoryCraftResult();
	private World worldObj;
	
	public Container_WeaponForge(InventoryPlayer inventoryPlayer, TileEntity_WeaponForge tileEntityFurnace)
	{
		this.furnace = tileEntityFurnace;
		
		/**
		 * Plaiers slot
		 */
		this.addSlotToContainer(new Slot(tileEntityFurnace, 0, 163, 46));
		
		/**
		 * Hammer slot
		 */
		this.addSlotToContainer(new Slot(tileEntityFurnace, 1, 163, 64));
		
		/**
		 * Fuel slot
		 */
		this.addSlotToContainer(new Slot(tileEntityFurnace, 2, 15, 136));
		this.addSlotToContainer(new Slot(tileEntityFurnace, 3, 33, 136));
		this.addSlotToContainer(new Slot(tileEntityFurnace, 4, 51, 136));
		this.addSlotToContainer(new Slot(tileEntityFurnace, 5, 69, 136));
		this.addSlotToContainer(new Slot(tileEntityFurnace, 6, 87, 136));
		this.addSlotToContainer(new Slot(tileEntityFurnace, 7, 105, 136));
		
		/**
		 * Finished product slot
		 */
		this.addSlotToContainer(new Slot_WeaponForgeCrafting(inventoryPlayer.player, this.craftMatrix, this.craftResult, 8, 163, 96));
		int i;
		int j;
		
		
		/**
		 * Crafting Grid
		 */
		for (i = 0; i < 6; ++i)
		{
			for (j = 0; j < 6; ++j)
			{
				this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 6, 15 + j * 18, 10 + i * 18));
			}
		}
		
		/**
		 * Inventory
		 */
		for (i = 0; i < 3; ++i)
		{
			for (j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 13 + j * 18, 173 + i * 18));
			}
		}
		
		/**
		 * Inventory hotbar
		 */
		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 13 + i * 18, 231));
		}
		
		this.onCraftMatrixChanged(this.craftMatrix);
	}
	
	public void addCraftingToCrafters(ICrafting crafting)
	{
		super.addCraftingToCrafters(crafting);
		//crafting.sendProgressBarUpdate(this, 0, this.furnace.cookTime);
		crafting.sendProgressBarUpdate(this, 2, this.furnace.burnTime1);
		crafting.sendProgressBarUpdate(this, 3, this.furnace.burnTime2);
		crafting.sendProgressBarUpdate(this, 4, this.furnace.burnTime3);
		crafting.sendProgressBarUpdate(this, 5, this.furnace.burnTime4);
		crafting.sendProgressBarUpdate(this, 6, this.furnace.burnTime5);
		crafting.sendProgressBarUpdate(this, 7, this.furnace.burnTime6);
		crafting.sendProgressBarUpdate(this, 8, this.furnace.itemBurnTime1);
	}
	
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		
		for (int i = 0; i < this.crafters.size(); ++i)
		{
			ICrafting crafting = (ICrafting)this.crafters.get(i);
			
			/*if (this.cookTime != this.furnace.cookTime)
			{
				crafting.sendProgressBarUpdate(this, 0, this.furnace.cookTime);
			}*/
			if (this.burnTime1 != this.furnace.burnTime1)
			{
				crafting.sendProgressBarUpdate(this, 2, this.furnace.burnTime1);
			}
			if (this.burnTime2 != this.furnace.burnTime2)
			{
				crafting.sendProgressBarUpdate(this, 3, this.furnace.burnTime2);
			}
			if (this.burnTime3 != this.furnace.burnTime3)
			{
				crafting.sendProgressBarUpdate(this, 4, this.furnace.burnTime3);
			}
			if (this.burnTime4 != this.furnace.burnTime4)
			{
				crafting.sendProgressBarUpdate(this, 5, this.furnace.burnTime4);
			}
			if (this.burnTime5 != this.furnace.burnTime5)
			{
				crafting.sendProgressBarUpdate(this, 6, this.furnace.burnTime5);
			}
			if (this.burnTime6 != this.furnace.burnTime6)
			{
				crafting.sendProgressBarUpdate(this, 7, this.furnace.burnTime6);
			}
			if (this.itemBurnTime1 != this.furnace.itemBurnTime1)
			{
				crafting.sendProgressBarUpdate(this, 8, this.furnace.itemBurnTime1);
			}
			if (this.itemBurnTime2 != this.furnace.itemBurnTime2)
			{
				crafting.sendProgressBarUpdate(this, 8, this.furnace.itemBurnTime2);
			}
			if (this.itemBurnTime3 != this.furnace.itemBurnTime3)
			{
				crafting.sendProgressBarUpdate(this, 8, this.furnace.itemBurnTime3);
			}
			if (this.itemBurnTime4 != this.furnace.itemBurnTime4)
			{
				crafting.sendProgressBarUpdate(this, 8, this.furnace.itemBurnTime4);
			}
			if (this.itemBurnTime5 != this.furnace.itemBurnTime5)
			{
				crafting.sendProgressBarUpdate(this, 8, this.furnace.itemBurnTime5);
			}
			if (this.itemBurnTime6 != this.furnace.itemBurnTime6)
			{
				crafting.sendProgressBarUpdate(this, 8, this.furnace.itemBurnTime6);
			}
			
		}
		
		//this.cookTime = this.furnace.cookTime;
		this.burnTime1 = this.furnace.burnTime1;
		this.burnTime2 = this.furnace.burnTime2;
		this.burnTime3 = this.furnace.burnTime3;
		this.burnTime4 = this.furnace.burnTime4;
		this.burnTime5 = this.furnace.burnTime5;
		this.burnTime6 = this.furnace.burnTime6;
		this.itemBurnTime1 = this.furnace.itemBurnTime1;
		this.itemBurnTime2 = this.furnace.itemBurnTime2;
		this.itemBurnTime3 = this.furnace.itemBurnTime3;
		this.itemBurnTime4 = this.furnace.itemBurnTime4;
		this.itemBurnTime5 = this.furnace.itemBurnTime5;
		this.itemBurnTime6 = this.furnace.itemBurnTime6;
		
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot, int nextValue)
	{
		/*if (slot == 0)
		{
			this.furnace.cookTime = nextValue;
		}*/
		if (slot == 2)
		{
			this.furnace.burnTime1 = nextValue;
		}
		if (slot == 3)
		{
			this.furnace.burnTime2 = nextValue;
		}
		if (slot == 4)
		{
			this.furnace.burnTime3 = nextValue;
		}
		if (slot == 5)
		{
			this.furnace.burnTime4 = nextValue;
		}
		if (slot == 6)
		{
			this.furnace.burnTime5 = nextValue;
		}
		if (slot == 7)
		{
			this.furnace.burnTime6 = nextValue;
		}
		if (slot == 8)
		{
			this.furnace.itemBurnTime1 = nextValue;
		}
	}
	
    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory par1IInventory)
    {
        this.craftResult.setInventorySlotContents(8, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    }
	
	public boolean canInteractWith(EntityPlayer entityPlayer)
	{
		return this.furnace.isUseableByPlayer(entityPlayer);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int i)
	{
		return null;
	}
}

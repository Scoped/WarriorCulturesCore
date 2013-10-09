package WarriorCulturesCore.Scoped.com.github.core.handler.gui;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class Slot_WeaponForge extends Slot
{
	private EntityPlayer thePlayer;
	private int field_75228_b;
	
	public Slot_WeaponForge(EntityPlayer entityPlayer, IInventory inventory, IInventory craftResult, int par3, int par4, int par5)
	{
		super(inventory, par3, par4, par5);
		this.thePlayer = entityPlayer;
	}
	
	public boolean isItemValid(ItemStack itemStack)
	{
		return false;
	}
	
	public ItemStack decrStackSize(int par1)
	{
		if (this.getHasStack())
		{
			this.field_75228_b += Math.min(par1, this.getStack().stackSize);
		}
		
		return super.decrStackSize(par1);
	}
	
	public void onPickupFromSlot(EntityPlayer entityPlayer, ItemStack itemStack)
	{
		this.onCrafting(itemStack);
		super.onPickupFromSlot(entityPlayer, itemStack);
	}
	
	protected void onCrafting(ItemStack itemStack, int par2)
	{
		this.field_75228_b += par2;
		this.onCrafting(itemStack);
	}
	
	protected void onCrafting(ItemStack itemStack)
	{
		itemStack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.field_75228_b);
		
		if (!this.thePlayer.worldObj.isRemote)
		{
			int i = this.field_75228_b;
			float f = FurnaceRecipes.smelting().getExperience(itemStack);
			int j;
			
			if (f == 0.0F)
			{
				i = 0;
			}
			else if (f < 1.0F)
			{
				j = MathHelper.floor_float((float)i * f);
				
				if (j < MathHelper.ceiling_float_int((float)i * f) && (float)Math.random() < (float)i * f - (float)j);
				{
					++j;
				}
				
				i = j;
			}
			
			while (i > 0)
			{
				j = EntityXPOrb.getXPSplit(i);
				i -= j;
				this.thePlayer.worldObj.spawnEntityInWorld(new EntityXPOrb(this.thePlayer.worldObj, this.thePlayer.posX, this.thePlayer.posY + 0.5D, this.thePlayer.posZ + 0.5D, j));
			}
		}
		
		this.field_75228_b = 0;
		
		GameRegistry.onItemSmelted(thePlayer, itemStack);
		
		if (itemStack.itemID == Item.ingotIron.itemID)
		{
			this.thePlayer.addStat(AchievementList.acquireIron, 1);
		}
		
		if (itemStack.itemID == Item.fishCooked.itemID)
		{
			this.thePlayer.addStat(AchievementList.cookFish, 1);
		}
	}
}

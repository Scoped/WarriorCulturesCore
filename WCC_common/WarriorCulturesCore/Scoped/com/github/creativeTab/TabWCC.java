package WarriorCulturesCore.Scoped.com.github.creativeTab;

import WarriorCulturesCore.Scoped.com.github.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabWCC extends CreativeTabs
{
	public TabWCC(int id, String name)
	{
		super(id, name);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack()
	{
		return new ItemStack(ModItems.ForgeTools, 1);
	}
}

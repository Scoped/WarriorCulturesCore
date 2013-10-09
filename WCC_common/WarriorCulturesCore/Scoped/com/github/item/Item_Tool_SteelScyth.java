package WarriorCulturesCore.Scoped.com.github.item;

import net.minecraft.item.EnumToolMaterial;
import WarriorCulturesCore.Scoped.com.github.lib.Strings;

public class Item_Tool_SteelScyth extends Super_Item_Hoe
{
	
	public Item_Tool_SteelScyth(int par1, EnumToolMaterial par3EnumToolMaterial)
	{
		super(par1, par3EnumToolMaterial);
        this.maxStackSize = 1;
		this.setUnlocalizedName(Strings.ITEM_TOOL_STEELSCYTHE_NAME);
	}
	
}

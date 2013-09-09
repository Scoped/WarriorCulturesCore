package WarriorCulturesCore.Scoped.com.github.recipes;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class WCCRecipes
{
	public static void recipesInit()
	{
		for(int i = 0;i < 16;i++)
		{
			//GameRegistry.addRecipe(new ItemStack(ModBlocks.MetaMineralBlocks, 1, i), "XXX","XXX","XXX", Character.valueOf('X'), new ItemStack(ModBlocks.MetaMineralBlocks, 1, i));
		}
	}
}

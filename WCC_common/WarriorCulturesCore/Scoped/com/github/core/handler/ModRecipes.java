package WarriorCulturesCore.Scoped.com.github.core.handler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import WarriorCulturesCore.Scoped.com.github.item.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipes
{
	public static void recipesInit()
	{
		for(int i = 0;i < 16;i++)
		{
			/*GameRegistry.addRecipe(new ItemStack(ModBlocks.MetaMineralBlocks, 1, i),
			"XXX",
			"XXX",
			"XXX",
			Character.valueOf('X'),new ItemStack(ModBlocks.MetaMineralBlocks, 1, i));*/
		}
/**
 * Forge Recipes
 */
	/**
	 * Test
	 */
		/**
		 * Test
		 */
		GameRegistry.addRecipe(new ItemStack(ModItems.SteelPickAxe),
				"------",
				"------",
				"------",
				"------",
				"------",
				"------",
				Character.valueOf('-'), new ItemStack(Item.stick));;
		
/**
 * Shape Recipes
 */
	 /**
	  * Tools
	  */
		/**
		 * Hammer
		 */ /*
		GameRegistry.addRecipe(new ItemStack(ModItems.Hammer),
				"   ",
				"II ",
				"SI ",
				Character.valueOf('I'), new ItemStack(Item.ingotIron),
				Character.valueOf('S'), new ItemStack(Item.stick));*/
		/**
		 * Plaier
		 */ /*
		GameRegistry.addRecipe(new ItemStack(ModItems.Plaier),
				" I ",
				"III",
				" I ",
				Character.valueOf('I'), new ItemStack(Item.ingotIron));*/
	/**
	 * Weapons
	 */
		/**
		 * Steel PickAxe
		 */ /*
		GameRegistry.addRecipe(new ItemStack(ModItems.SteelPickAxe),
				"  H",
				" S ",
				"S  ",
				Character.valueOf('S'), new ItemStack(Item.stick),
				Character.valueOf('H'), new ItemStack(ModItems.SteelPickAxeHead));*/
		/**
		 * Steel Scythe
		 */ /*
		GameRegistry.addRecipe(new ItemStack(ModItems.SteelScythe),
				"  H",
				" S ",
				"S  ",
				Character.valueOf('S'), new ItemStack(Item.stick),
				Character.valueOf('H'), new ItemStack(ModItems.SteelScytheHead));*/
		/**
		 * Steel Shovel
		 */ /*
		GameRegistry.addRecipe(new ItemStack(ModItems.SteelShovel),
				"  H",
				" S ",
				"S  ",
				Character.valueOf('S'), new ItemStack(Item.stick),
				Character.valueOf('H'), new ItemStack(ModItems.SteelShovel));*/
		
		
	}
}

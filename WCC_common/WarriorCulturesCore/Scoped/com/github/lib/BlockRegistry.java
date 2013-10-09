package WarriorCulturesCore.Scoped.com.github.lib;

import net.minecraftforge.common.MinecraftForge;
import WarriorCulturesCore.Scoped.com.github.block.ModBlocks;
import WarriorCulturesCore.Scoped.com.github.item.Item_Mineral_MetaMinerals;
import WarriorCulturesCore.Scoped.com.github.item.Item_Ore_MetaOres;
import WarriorCulturesCore.Scoped.com.github.tileEntity.TileEntity_WeaponForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegistry
{
	public static void blockRegistry()
	{
		/**
		 * Block Registration
		 */
		GameRegistry.registerBlock(ModBlocks.blockQuartsFurnaceIdle, Strings.BLOCK_WEAPONFORGE_IDLE_NAME);
		GameRegistry.registerBlock(ModBlocks.blockQuartsFurnaceActive, Strings.BLOCK_WEAPONFORGE_ACTIVE_NAME);
		
		/**
		 * TileEntity Registration
		 */
		GameRegistry.registerTileEntity(TileEntity_WeaponForge.class, Strings.TILEENTITY_WEAPONFORGE_NAME);
		
		/**
		 * MetaBlock Registration
		 */
		GameRegistry.registerBlock(ModBlocks.MetaOreBlocks, Item_Ore_MetaOres.class, Strings.BLOCK_META_ORE_METAORES_NAME);
		GameRegistry.registerBlock(ModBlocks.MetaMineralBlocks, Item_Mineral_MetaMinerals.class, Strings.BLOCK_META_MINERAL_METAMINERALS_NAME);
		
		/**
		 * Block Harvest Level
		 */
		MinecraftForge.setBlockHarvestLevel(ModBlocks.MetaOreBlocks, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(ModBlocks.MetaOreBlocks, 1, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(ModBlocks.MetaOreBlocks, 2, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(ModBlocks.MetaOreBlocks, 3, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(ModBlocks.MetaOreBlocks, 4, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(ModBlocks.MetaOreBlocks, 5, "pickaxe", 2);
	}
}

package WarriorCulturesCore.Scoped.com.github.block;

import net.minecraft.block.Block;
import WarriorCulturesCore.Scoped.com.github.item.Item_Mineral_MetaMinerals;
import WarriorCulturesCore.Scoped.com.github.item.Item_Ore_MetaOres;
import WarriorCulturesCore.Scoped.com.github.lib.BlockIDs;
import WarriorCulturesCore.Scoped.com.github.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;


public class ModBlocks
{
	public static Block MetaMineralBlocks;
	public static Block MetaOreBlocks;
	
	public static void BlocksInit()
	{
		MetaOreBlocks = new Block_Meta_OreBlocks(BlockIDs.BLOCK_META_OREBLOCKS_ID);
		MetaMineralBlocks = new Block_Meta_MineralBlocks(BlockIDs.BLOCK_META_MINERALBLOCKS_ID_DEFAULT);
		
		/**
		 * MetaBlock Registration
		 */
		GameRegistry.registerBlock(ModBlocks.MetaOreBlocks, Item_Ore_MetaOres.class, Strings.BLOCK_META_ORE_METAORES_NAME);
		GameRegistry.registerBlock(ModBlocks.MetaMineralBlocks, Item_Mineral_MetaMinerals.class, Strings.BLOCK_META_MINERAL_METAMINERALS_NAME);
	}
}

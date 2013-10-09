package WarriorCulturesCore.Scoped.com.github.core.handler;


import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import WarriorCulturesCore.Scoped.com.github.lib.BlockIDs;
import WarriorCulturesCore.Scoped.com.github.lib.ItemIDs;
import WarriorCulturesCore.Scoped.com.github.lib.Reference;
import WarriorCulturesCore.Scoped.com.github.lib.Strings;
import cpw.mods.fml.common.FMLLog;

public class ConfigurationHandler
{
	public static Configuration config;
	
	public static void init(File file)
	{
		config = new Configuration(file);
		
		try
		{
			config.load();
			
			/**
			 * Block Configuration
			 */
			BlockIDs.BLOCK_META_OREBLOCKS_ID = config.getBlock(Strings.BLOCK_META_ORE_METAORES_NAME, BlockIDs.BLOCK_META_OREBLOCKS_ID_DEFAULT).getInt(BlockIDs.BLOCK_META_OREBLOCKS_ID_DEFAULT);			
			BlockIDs.BLOCK_META_MINERALBLOCKS_ID = config.getBlock(Strings.BLOCK_META_MINERAL_METAMINERALS_NAME, BlockIDs.BLOCK_META_MINERALBLOCKS_ID_DEFAULT).getInt(BlockIDs.BLOCK_META_MINERALBLOCKS_ID_DEFAULT);
			BlockIDs.BLOCK_WEAPONFORGE_ACTIVE_ID = config.getBlock(Strings.BLOCK_WEAPONFORGE_ACTIVE_NAME, BlockIDs.BLOCK_WEAPONFORGE_ACTIVE_ID_DEFAULT).getInt(BlockIDs.BLOCK_WEAPONFORGE_ACTIVE_ID_DEFAULT);
			BlockIDs.BLOCK_WEAPONFORGE_IDLE_ID = config.getBlock(Strings.BLOCK_WEAPONFORGE_IDLE_NAME, BlockIDs.BLOCK_WEAPONFORGE_IDLE_ID_DEFAULT).getInt(BlockIDs.BLOCK_WEAPONFORGE_IDLE_ID_DEFAULT);
			
			/**
			 * Item Configuration
			 */
			ItemIDs.ITEM_ITEMS_OREVALUABLES_ID = config.getItem(Strings.ITEM_ITEMS_OREVALUABLES_NAME, ItemIDs.ITEM_ITEMS_OREVALUABLES_ID_DEFAULT).getInt(ItemIDs.ITEM_ITEMS_OREVALUABLES_ID_DEFAULT);
			ItemIDs.ITEM_ITEMS_ROCKVALUABLES_ID = config.getItem(Strings.ITEM_ITEMS_ROCKVALUABLES_NAME, ItemIDs.ITEM_ITEMS_ROCKVALUABLES_ID_DEFAULT).getInt(ItemIDs.ITEM_ITEMS_ROCKVALUABLES_ID_DEFAULT);
			
			/**
			 * Tool Configuration
			 */
			ItemIDs.ITEM_TOOLS_FORGETOOLS_ID = config.getItem(Strings.ITEM_TOOLS_FORGETOOLS_NAME, ItemIDs.ITEM_TOOLS_FORGETOOLS_ID_DEFAULT).getInt(ItemIDs.ITEM_TOOLS_FORGETOOLS_ID_DEFAULT);
			ItemIDs.ITEM_TOOLS_WCCTOOLHEADS_ID = config.getItem(Strings.ITEM_TOOLS_WCCTOOLS_NAME, ItemIDs.ITEM_TOOLS_WCCTOOLS_ID_DEFAULT).getInt(ItemIDs.ITEM_TOOLS_WCCTOOLS_ID_DEFAULT);
			ItemIDs.ITEM_TOOL_STEELPICKAXE_ID = config.getItem(Strings.ITEM_TOOL_STEELPICKAXE_NAME, ItemIDs.ITEM_TOOL_STEELPICKAXE_ID_DEFAULT).getInt(ItemIDs.ITEM_TOOL_STEELPICKAXE_ID_DEFAULT);
			ItemIDs.ITEM_TOOL_STEELHATCHET_ID = config.getItem(Strings.ITEM_TOOL_STEELHATCHET_NAME, ItemIDs.ITEM_TOOL_STEELHATCHET_ID_DEFAULT).getInt(ItemIDs.ITEM_TOOL_STEELHATCHET_ID_DEFAULT);
			ItemIDs.ITEM_TOOL_STEELSCYTHE_ID = config.getItem(Strings.ITEM_TOOL_STEELSCYTHE_NAME, ItemIDs.ITEM_TOOL_STEELSCYTH_ID_DEFAULT).getInt(ItemIDs.ITEM_TOOL_STEELSCYTH_ID_DEFAULT);
			ItemIDs.ITEM_TOOL_STEELSHOVEL_ID = config.getItem(Strings.ITEM_TOOL_STEELSHOVEL_NAME, ItemIDs.ITEM_TOOL_STEELSHOVEL_ID_DEFAULT).getInt(ItemIDs.ITEM_TOOL_STEELSHOVEL_ID_DEFAULT);
			
		}
		catch(Exception e)
		{
			FMLLog.log(Level.SEVERE, e, Reference.MOD_ID + "Has a problem loading the cofig file!");
		}
		finally
		{
			config.save();
		}
	}
}

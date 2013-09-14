package WarriorCulturesCore.Scoped.com.github.core.handler;


import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import WarriorCulturesCore.Scoped.com.github.lib.BlockIDs;
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
			
			/**
			 * Item Configuration
			 */
			//ItemIDs.ITEM_DUST_BLUESTONE_ID = config.getItem(Strings.ITEM_DUST_BLUESTONE_NAME, ItemIDs.ITEM_DUST_BLUESTONE_ID_DEFAULT).getInt(ItemIDs.ITEM_DUST_BLUESTONE_ID_DEFAULT);
			
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

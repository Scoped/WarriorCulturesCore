package WarriorCulturesCore.Scoped.com.github;


import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import WarriorCulturesCore.Scoped.com.github.block.ModBlocks;
import WarriorCulturesCore.Scoped.com.github.core.handler.ConfigurationHandler;
import WarriorCulturesCore.Scoped.com.github.core.handler.LocalizationHandler;
import WarriorCulturesCore.Scoped.com.github.core.proxy.CommonProxy;
import WarriorCulturesCore.Scoped.com.github.creativeTab.TabWCC;
import WarriorCulturesCore.Scoped.com.github.item.WCCItems;
import WarriorCulturesCore.Scoped.com.github.lib.Reference;
import WarriorCulturesCore.Scoped.com.github.recipes.WCCRecipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(
		modid = Reference.MOD_ID ,
		name = Reference.MOD_NAME,
		version = Reference.VERSION)
	
	@NetworkMod(
		channels = (Reference.CHANNEL_NAME),
		serverSideRequired = false,
		clientSideRequired = true)

public class WarriorCultures_Core
{
	
	@SidedProxy(
		clientSide = Reference.CLIENT_PROXY_LOCATION,
		serverSide = Reference.COMMON_PROXY_LOCATION)
	
	public static CommonProxy proxy;
	
	public static CreativeTabs TabWCC = new TabWCC(CreativeTabs.getNextID(), Reference.MOD_ID);
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsoluteFile() + File.separator + Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));
		
		LocalizationHandler.loadLanguages();
		
		ModBlocks.BlocksInit();
		
		WCCItems.ItemInit();
		
		WCCRecipes.recipesInit();
	}
	
	@Init
	public void init(FMLInitializationEvent event)
	{
		
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}

package WarriorCulturesCore.Scoped.com.github;


import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;
import WarriorCulturesCore.Scoped.com.github.block.ModBlocks;
import WarriorCulturesCore.Scoped.com.github.core.handler.ConfigurationHandler;
import WarriorCulturesCore.Scoped.com.github.core.handler.LocalizationHandler;
import WarriorCulturesCore.Scoped.com.github.core.handler.ModRecipes;
import WarriorCulturesCore.Scoped.com.github.core.handler.craftingManager.WeaponForgeSmeltingManager;
import WarriorCulturesCore.Scoped.com.github.core.handler.gui.GuiHandler;
import WarriorCulturesCore.Scoped.com.github.core.proxy.CommonProxy;
import WarriorCulturesCore.Scoped.com.github.creativeTab.TabWCC;
import WarriorCulturesCore.Scoped.com.github.item.ModItems;
import WarriorCulturesCore.Scoped.com.github.lib.BlockRegistry;
import WarriorCulturesCore.Scoped.com.github.lib.Reference;
import WarriorCulturesCore.Scoped.com.github.lib.Strings;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
	
	/**
	 * CreativeTab
	 */
	public static CreativeTabs TabWCC = new TabWCC(CreativeTabs.getNextID(), Strings.TAB_WCC_NAME);
	
	/**
	 * EnumToolMaterial
	 * String: name (WOOD, STONE, IRON, GOLD, DIAMOND)
	 * First int: harvest level (0 = WOOD/GOLD, 1 = STONE, 2 = IRON, 3 = DIAMOND)
	 * Second int: number of uses (wood = 59, gold = 32, stone = 131, iron = 250, diamond = 1561)
	 * First float: block breaking speed (2.0F, 12.0F, 4.0F, 6.0F, 8.0F)
	 * Second float: damage vs entities (0.0F, 0.0F, 1.0F, 2.0F, 3.0F,)
	 * Third int: enchantability (15, 22, 5, 14, 10)
	 */
	public static EnumToolMaterial WCC_Steel = EnumHelper.addToolMaterial("STEEL", 2, 500, 7.0F, 3.0F, 12);
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		LocalizationHandler.loadLanguages();
		
		ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsoluteFile() + File.separator + Reference.MOD_ID + File.separator + Reference.MOD_ID + ".cfg"));
		
		ModBlocks.BlocksInit();
		
		BlockRegistry.blockRegistry();
		
		ModItems.ItemInit();
		
		GuiHandler guiHandler = new GuiHandler();
		
		ModRecipes.recipesInit();
		
		LanguageRegistry.instance().addStringLocalization("container.weaponForge", "Weapon Forge");
	}
	
	@Init //@@EventHandler
	public void init(FMLInitializationEvent event)
	{
		  proxy.registerRenderers();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}

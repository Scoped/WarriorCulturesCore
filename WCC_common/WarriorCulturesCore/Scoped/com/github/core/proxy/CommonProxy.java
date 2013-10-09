package WarriorCulturesCore.Scoped.com.github.core.proxy;

import WarriorCulturesCore.Scoped.com.github.WarriorCultures_Core;
import WarriorCulturesCore.Scoped.com.github.lib.Reference;
import WarriorCulturesCore.Scoped.com.github.tileEntity.TESR_WeaponForge;
import WarriorCulturesCore.Scoped.com.github.tileEntity.TESR_WeaponForgeActive;
import WarriorCulturesCore.Scoped.com.github.tileEntity.TileEntity_WeaponForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod.Instance;

public class CommonProxy
{
	@Instance(Reference.MOD_ID)
	public static WarriorCultures_Core WCCoreInstance;
	
	public void registerRenderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntity_WeaponForge.class, new TESR_WeaponForge());
		ClientRegistry.registerTileEntity(TileEntity_WeaponForge.class, "WeaponForge1", new TESR_WeaponForge());
		
		//ClientRegistry.registerTileEntity(TileEntityQuartsFurnace.class, "WeaponForgeActive", new TESR_WeaponForgeActive());
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityQuartsFurnace.class, new TESR_WeaponForgeActive());
	}
}

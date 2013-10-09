package WarriorCulturesCore.Scoped.com.github.core.handler.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import WarriorCulturesCore.Scoped.com.github.WarriorCultures_Core;
import WarriorCulturesCore.Scoped.com.github.core.proxy.CommonProxy;
import WarriorCulturesCore.Scoped.com.github.lib.GUIIDs;
import WarriorCulturesCore.Scoped.com.github.tileEntity.TileEntity_WeaponForge;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler
{
	public GuiHandler()
	{
		NetworkRegistry.instance().registerGuiHandler(CommonProxy.WCCoreInstance, this);
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		if (entity != null)
		{
			switch(ID)
			{
			case GUIIDs.guiWeaponForge:
				if (entity instanceof TileEntity_WeaponForge)
				{
					return new Container_WeaponForge(player.inventory, (TileEntity_WeaponForge) entity);
				}
			}
		}
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		if (entity != null)
		{
			switch(ID)
			{
			case GUIIDs.guiWeaponForge:
				if (entity instanceof TileEntity_WeaponForge)
				{
					return new Gui_WeaponForge(player.inventory, (TileEntity_WeaponForge) entity);
				}
			}
		}
		
		return null;
	}
	
}

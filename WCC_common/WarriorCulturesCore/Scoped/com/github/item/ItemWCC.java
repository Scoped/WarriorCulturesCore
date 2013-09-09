package WarriorCulturesCore.Scoped.com.github.item;

import WarriorCulturesCore.Scoped.com.github.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWCC extends Item
{

	public ItemWCC(int id)
	{
		super(id);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(" , ")+1));
	}
}

package WarriorCulturesCore.Scoped.com.github.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemTool;
import WarriorCulturesCore.Scoped.com.github.WarriorCultures_Core;
import WarriorCulturesCore.Scoped.com.github.lib.Reference;
import WarriorCulturesCore.Scoped.com.github.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Super_Item_Tool extends ItemTool
{
	protected Super_Item_Tool(int par1, float par2, EnumToolMaterial par3EnumToolMaterial, Block[] par4ArrayOfBlock)
	{
		super(par1, par2, par3EnumToolMaterial, par4ArrayOfBlock);
		this.setUnlocalizedName(Strings.CORE_ITEMWCC_NAME);
		this.setCreativeTab(WarriorCultures_Core.TabWCC);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
	public void registerIcons(IconRegister icon)
	{
		itemIcon = icon.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
	}
}

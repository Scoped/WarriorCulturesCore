package WarriorCulturesCore.Scoped.com.github.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import WarriorCulturesCore.Scoped.com.github.WarriorCultures_Core;
import WarriorCulturesCore.Scoped.com.github.lib.Reference;
import WarriorCulturesCore.Scoped.com.github.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Super_Block_Meta extends Block
{

	@SideOnly(Side.CLIENT)
	public Icon[] icons;
	
	int numberOfBlocks;
	
	public int setNumberOfBlocks(int number)
	{
		return numberOfBlocks = number;
	}
	
	public int getNumberOfBlocks()
	{
		return numberOfBlocks;
	}
	
	public Super_Block_Meta(int id, Material par2Material)
	{
		super(id, Material.rock);
		this.setResistance(10.0F);
		this.setHardness(5.0F);
		this.setStepSound(soundStoneFootstep);
		this.setCreativeTab(WarriorCultures_Core.TabWCC);
		this.setUnlocalizedName(Strings.CORE_BLOCKWCC_NAME);
	}
	
    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
	public int damageDropped(int meta)
	{
		  return meta;
	}
	
	@SideOnly(Side.CLIENT)
	
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
	public void getSubBlocks(int id, CreativeTabs creativeTab, List list)
	{
		for(int i = 0; i < this.getNumberOfBlocks(); ++i)
		{
			list.add(new ItemStack(id, 1, i));
		}
	}
	
	@SideOnly(Side.CLIENT)
	
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
	public Icon getIcon(int i, int j)
	{
		return icons[j];
	}
	
    @Override
	@SideOnly(Side.CLIENT)
	
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
	public void registerIcons(IconRegister iconRegister)
	{
		icons = new Icon[this.getNumberOfBlocks()];
		
		for (int i = 0; i < icons.length; ++i)
		{
			icons[i] = iconRegister.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(this.getUnlocalizedName()+i)));
		}
	}
    
	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
	}
}

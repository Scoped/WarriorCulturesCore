package WarriorCulturesCore.Scoped.com.github.item;

import WarriorCulturesCore.Scoped.com.github.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;


public class Item_Tool_SteelShovel extends Super_Item_Tool
{
    /** an array of the blocks this spade is effective against */
    public static final Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};
    
	public Item_Tool_SteelShovel(int par1, EnumToolMaterial par3EnumToolMaterial)
	{
		super(par1, 1.0F, par3EnumToolMaterial, blocksEffectiveAgainst);
		this.setUnlocalizedName(Strings.ITEM_TOOL_STEELSHOVEL_NAME);
	}
	
    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Block.snow ? true : par1Block == Block.blockSnow;
    }
}

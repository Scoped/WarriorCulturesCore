package WarriorCulturesCore.Scoped.com.github.item;

import WarriorCulturesCore.Scoped.com.github.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;


public class Item_Tool_SteelHatchet extends Super_Item_Tool
{
    /** an array of the blocks this axe is effective against */
    public static final Block[] blocksEffectiveAgainst = new Block[] {Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern};
	
	public Item_Tool_SteelHatchet(int par1, EnumToolMaterial par3EnumToolMaterial)
	{
		super(par1, 3.0F, par3EnumToolMaterial, blocksEffectiveAgainst);
		this.setUnlocalizedName(Strings.ITEM_TOOL_STEELHATCHET_NAME);
	}
	
    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        return par2Block != null && (par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.plants || par2Block.blockMaterial == Material.vine) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
    }
}

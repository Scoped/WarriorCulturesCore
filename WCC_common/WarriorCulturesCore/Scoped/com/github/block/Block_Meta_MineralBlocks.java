package WarriorCulturesCore.Scoped.com.github.block;

import net.minecraft.block.material.Material;
import WarriorCulturesCore.Scoped.com.github.lib.Strings;

public class Block_Meta_MineralBlocks extends Super_Block_Meta
{
	
	public Block_Meta_MineralBlocks(int id)
	{
		super(id, Material.iron);
		this.setNumberOfBlocks(8);
		this.setUnlocalizedName(Strings.BLOCK_META_MINERAL_METAMINERALS_NAME);
	}
	
}

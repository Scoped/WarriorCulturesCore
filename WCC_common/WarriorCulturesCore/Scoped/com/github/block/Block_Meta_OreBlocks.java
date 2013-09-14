package WarriorCulturesCore.Scoped.com.github.block;

import net.minecraft.block.material.Material;
import WarriorCulturesCore.Scoped.com.github.lib.Strings;

public class Block_Meta_OreBlocks extends Super_Block_Meta
{

	public Block_Meta_OreBlocks(int id)
	{
		super(id, Material.rock);
		this.setNumberOfBlocks(6);
		this.setUnlocalizedName(Strings.BLOCK_META_ORE_METAORES_NAME);
	}

}

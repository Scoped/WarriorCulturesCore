package WarriorCulturesCore.Scoped.com.github.block;

import net.minecraft.block.Block;
import WarriorCulturesCore.Scoped.com.github.WarriorCultures_Core;
import WarriorCulturesCore.Scoped.com.github.lib.BlockIDs;
import WarriorCulturesCore.Scoped.com.github.lib.Resources;
import WarriorCulturesCore.Scoped.com.github.lib.Strings;


public class ModBlocks
{
	public static Block MetaMineralBlocks;
	public static Block MetaOreBlocks;
	
	public static Block blockQuartsFurnaceIdle;
	public static Block blockQuartsFurnaceActive;
	
	public static void BlocksInit()
	{
		MetaOreBlocks = new Block_Meta_OreBlocks(BlockIDs.BLOCK_META_OREBLOCKS_ID);
		MetaMineralBlocks = new Block_Meta_MineralBlocks(BlockIDs.BLOCK_META_MINERALBLOCKS_ID);
		
		blockQuartsFurnaceIdle = new Block_WeaponForge(BlockIDs.BLOCK_WEAPONFORGE_IDLE_ID, false, Resources.textureLocation_WeaponForge_Idle).setUnlocalizedName(Strings.BLOCK_WEAPONFORGE_IDLE_NAME).setHardness(3.5F).setCreativeTab(WarriorCultures_Core.TabWCC);
		blockQuartsFurnaceActive = new Block_WeaponForge(BlockIDs.BLOCK_WEAPONFORGE_ACTIVE_ID, true, Resources.textureLocation_WeaponForge_Active).setUnlocalizedName(Strings.BLOCK_WEAPONFORGE_ACTIVE_NAME).setHardness(3.5F).setLightValue(0.9F);
		
	}
}

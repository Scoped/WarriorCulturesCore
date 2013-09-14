package WarriorCulturesCore.Scoped.com.github.item;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class Item_Mineral_MetaMinerals extends ItemBlock
{
	
	private String defaultName = "Block";
	
	public Item_Mineral_MetaMinerals(int id)
	{
		super(id);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	
    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
	public int getMetadata(int meta)
	{
		return meta;
	}
	
    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
	public String getUnlocalizedName(ItemStack itemStack)
	{
		String name = "";
		
		switch(itemStack.getItemDamage())
		{
		case 0: {name = "Turquoise" + defaultName; break;}
		case 1: {name = "Chalcedony" + defaultName; break;}
		case 2: {name = "Jade" + defaultName; break;}
		case 3: {name = "Silver" + defaultName; break;}
		case 4: {name = "Copper" + defaultName; break;}
		case 5: {name = "Tin" + defaultName; break;}
		case 6: {name = "Gold" + defaultName; break;}
		}
		return this.getUnlocalizedName() + name;
	}
}

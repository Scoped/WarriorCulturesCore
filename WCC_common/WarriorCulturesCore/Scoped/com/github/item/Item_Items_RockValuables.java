package WarriorCulturesCore.Scoped.com.github.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import WarriorCulturesCore.Scoped.com.github.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Item_Items_RockValuables extends Super_Item
{
	/** List of types. */
    public static final String[] valuableTypes = new String[] {"Chalcedony", "Jade", "Turquoise"};
    public static final String[] field_94595_b = new String[] {"Chalcedony", "Jade", "Turquoise"};
    @SideOnly(Side.CLIENT)
    private Icon[] field_94594_d;
	
	public Item_Items_RockValuables(int id)
	{
		super(id);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	
	@SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value
     */
    public Icon getIconFromDamage(int par1)
    {
        int j = MathHelper.clamp_int(par1, 0, valuableTypes.length);
        return this.field_94594_d[j];
    }
	
    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, valuableTypes.length);
        return super.getUnlocalizedName() + valuableTypes[i] + "Stone";
    }
	
    @SideOnly(Side.CLIENT)

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int j = 0; j < valuableTypes.length; ++j)
        {
            par3List.add(new ItemStack(par1, 1, j));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister icon)
    {
        this.field_94594_d = new Icon[field_94595_b.length];

        for (int i = 0; i < field_94595_b.length; ++i)
        {
            this.field_94594_d[i] = icon.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), this.func_111208_A() + field_94595_b[i] + "Stone"));
        }
    }
    
	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
	}
}

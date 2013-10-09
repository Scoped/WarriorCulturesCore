package WarriorCulturesCore.Scoped.com.github.core.handler.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import WarriorCulturesCore.Scoped.com.github.lib.Reference;
import WarriorCulturesCore.Scoped.com.github.tileEntity.TileEntity_WeaponForge;

public class Gui_WeaponForge extends GuiContainer
{
	public static final ResourceLocation texture = new ResourceLocation(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "textures/gui/WeaponForge_GUI.png"));
	
	public TileEntity_WeaponForge weaponForge;
	
	public Gui_WeaponForge(InventoryPlayer inventoryPlayer, TileEntity_WeaponForge entity)
	{
		super(new Container_WeaponForge(inventoryPlayer, entity));
		
		this.weaponForge = entity;
		
		this.xSize = 214;
		this.ySize = 256;
	}
	
	public void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		String name = this.weaponForge.isInvNameLocalized() ? this.weaponForge.getInvName() : I18n.func_135053_a(this.weaponForge.getInvName());
		
		this.fontRenderer.drawString(name, this.xSize / 3 - this.fontRenderer.getStringWidth(name) / 20 + 65, 24, 4210752);
		this.fontRenderer.drawString(I18n.func_135053_a("container.inventory"), 13, this.ySize - 96, 4210752);
	}
	
	public void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.func_110434_K().func_110577_a(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;
		
		if (this.weaponForge.isSlotOneBurning())
		{
			i1 = this.weaponForge.getSlotOneBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(k + 16, l + 130 - i1, 214, 15 - i1, 14, i1 + 5);
		}
		if (this.weaponForge.isSlotTwoBurning())
		{
			i1 = this.weaponForge.getSlotTwoBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(k + 34, l + 130 - i1, 214, 15 - i1, 14, i1 + 5);
		}
		if (this.weaponForge.isSlotThreeBurning())
		{
			i1 = this.weaponForge.getSlotThreeBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(k + 52, l + 130 - i1, 214, 15 - i1, 14, i1 + 5);
		}
		if (this.weaponForge.isSlotFourBurning())
		{
			i1 = this.weaponForge.getSlotFourBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(k + 70, l + 130 - i1, 214, 15 - i1, 14, i1 + 5);
		}
		if (this.weaponForge.isSlotFiveBurning())
		{
			i1 = this.weaponForge.getSlotFiveBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(k + 88, l + 130 - i1, 214, 15 - i1, 14, i1 + 5);
		}
		if (this.weaponForge.isSlotSixBurning())
		{
			i1 = this.weaponForge.getSlotSixBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(k + 106, l + 130 - i1, 214, 15 - i1, 14, i1 + 5);
		}
		
		i1 = this.weaponForge.getCookProgressScaled(24);
		this.drawTexturedModalRect(k + 129, l + 95, 216 - 2, 17, i1 + 1, 16);
	}
}

package WarriorCulturesCore.Scoped.com.github.tileEntity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import WarriorCulturesCore.Scoped.com.github.block.Block_WeaponForge;
import WarriorCulturesCore.Scoped.com.github.block.ModBlocks;
import WarriorCulturesCore.Scoped.com.github.lib.Model_WeaponForge;
import WarriorCulturesCore.Scoped.com.github.lib.Reference;

public class TESR_WeaponForgeActive extends TileEntitySpecialRenderer
{
	private static final float pixelSize = 0.0625f;
	public Model_WeaponForge model= new Model_WeaponForge();
		
	//private static final ResourceLocation textureLocation = new ResourceLocation(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "textures/entity/WeaponForge_Active.png"));
    
	@Override
	public void renderTileEntityAt(TileEntity var1, double x, double y, double z, float partialTickTime)
	  {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 8 * pixelSize, (float)y + 24 * pixelSize, (float)z + 8 * pixelSize);
		GL11.glRotatef(180, 1, 0, 0);
		//this.func_110628_a(textureLocation);
		this.model.Shape1.render(pixelSize);
		this.model.Shape2.render(pixelSize);
		this.model.Shape3.render(pixelSize);
		this.model.Shape4.render(pixelSize);
		this.model.Shape5.render(pixelSize);
		this.model.Shape6.render(pixelSize);
		this.model.Shape7.render(pixelSize);
		GL11.glPopMatrix();
	  }
}

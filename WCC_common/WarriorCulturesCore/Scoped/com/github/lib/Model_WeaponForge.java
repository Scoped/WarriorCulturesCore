package WarriorCulturesCore.Scoped.com.github.lib;

//Java generated by Techne
//- ZeuX

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.Entity;

public class Model_WeaponForge extends ModelBase
{
	//fields
	 public ModelRenderer Shape1;
	 public ModelRenderer Shape2;
	 public ModelRenderer Shape3;
	 public ModelRenderer Shape4;
	 public ModelRenderer Shape5;
	 public ModelRenderer Shape6;
	 public ModelRenderer Shape7;
	
	public Model_WeaponForge()
	{
		textureWidth = 128;
		textureHeight = 128;
		
		//Top block
		Shape1 = new ModelRenderer(this, 44, 15);
		Shape1.addBox(0F, 0F, 0F, 10, 16, 9);
		Shape1.setRotationPoint(-5F, -8F, -3F);
		Shape1.setTextureSize(128, 128);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		
		//Out hang bottom
		Shape2 = new ModelRenderer(this, 45, 100);
		Shape2.addBox(0F, 0F, 0F, 14, 3, 3);
		Shape2.setRotationPoint(-7F, 21F, -8F);
		Shape2.setTextureSize(128, 128);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		
		//Out hang right
		Shape3 = new ModelRenderer(this, 84, 89);
		Shape3.addBox(0F, 0F, 0F, 3, 8, 3);
		Shape3.setRotationPoint(4F, 13F, -8F);
		Shape3.setTextureSize(128, 128);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		
		//Out hang top
		Shape4 = new ModelRenderer(this, 49, 82);
		Shape4.addBox(0F, 0F, 0F, 12, 2, 3);
		Shape4.setRotationPoint(-6F, 12F, -8F);
		Shape4.setTextureSize(128, 128);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		
		//Out hang left
		Shape5 = new ModelRenderer(this, 28, 89);
		Shape5.addBox(0F, 0F, 0F, 3, 8, 3);
		Shape5.setRotationPoint(-7F, 13F, -8F);
		Shape5.setTextureSize(128, 128);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		
		//Out Hang top top
		Shape6 = new ModelRenderer(this, 51, 74);
		Shape6.addBox(0F, 0F, 0F, 10, 3, 3);
		Shape6.setRotationPoint(-5F, 11F, -8F);
		Shape6.setTextureSize(128, 128);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		
		//BaseBlock
		Shape7 = new ModelRenderer(this, 34, 44);
		Shape7.addBox(0F, 0F, 0F, 16, 16, 13);
		Shape7.setRotationPoint(-8F, 8F, -5F);
		Shape7.setTextureSize(128, 128);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
	}
	
	public void renderTopBlock()
	{
		  Shape1.render(0.0625F);
	}
	public void renderOutHangBottom()
	{
		  Shape2.render(0.0625F);
	}
	public void renderOutHangRight()
	{
		  Shape3.render(0.0625F);
	}
	public void renderOutHangTop()
	{
		  Shape4.render(0.0625F);
	}
	public void renderOutHangLeft()
	{
		  Shape5.render(0.0625F);
	}
	public void renderOutHangTopTop()
	{
		  Shape6.render(0.0625F);
	}
	public void renderBaseBlock()
	{
		  Shape7.render(0.0625F);
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		  
	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
	 
	}

}


package WarriorCulturesCore.Scoped.com.github.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import WarriorCulturesCore.Scoped.com.github.core.proxy.CommonProxy;
import WarriorCulturesCore.Scoped.com.github.lib.GUIIDs;
import WarriorCulturesCore.Scoped.com.github.lib.Reference;
import WarriorCulturesCore.Scoped.com.github.tileEntity.TileEntity_WeaponForge;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Block_WeaponForge extends BlockContainer
{
    private final boolean isActive;
    /***/
    private final String texture;
	
	@SideOnly(Side.CLIENT)
	private Icon iconFront;
	
	private final Random quartsRandom = new Random();
	private static boolean keepInventory;
	
	public static boolean active;
	
	public Block_WeaponForge(int ID, boolean isLit, String location)
	{
		super(ID, Material.rock);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.isActive = isLit;
		this.texture = location;
	}
	
	public String getTextureLocation()
	{
		return texture;
	}
	
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
	   return false;
	}
	
	public boolean isOpaqueCube()
	{
	   return false;
	}
	
	public int getRenderType()
	{
		return -1;
	}
	
	@SideOnly(Side.CLIENT)
	
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
	public void registerIcons(IconRegister register)
	{
		this.blockIcon = register.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), "WeaponForge_Icon"));
		//this.iconFront = register.registerIcon(String.format("%s:%s", Reference.MOD_ID.toLowerCase(), (this.isActive ? "QuartsFurnace_Front_Lit" : "QuartsFurnace_Front")));
	}
	
    public void setBlockBoundsForItemRender()
    {
    	this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
    }
	
	public int idDropped(int par1, Random random, int par3)
	{
		return ModBlocks.blockQuartsFurnaceIdle.blockID;
	}
	
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z)
	{
		if (world.isRemote)
		{
			int l = world.getBlockId(x, y, z - 1); // Block Behind
			int il = world.getBlockId(x, y, z + 1); // Block Front
			int jl = world.getBlockId(x - 1, y, z); // Block Left
			int kl = world.getBlockId(x + 1, y, z); // Block Right
			byte b0 = 3;
			
			if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[il])
			{
				b0 = 3;
			}
			if (Block.opaqueCubeLookup[il] && !Block.opaqueCubeLookup[l])
			{
				b0 = 2;
			}
			if (Block.opaqueCubeLookup[kl] && !Block.opaqueCubeLookup[jl])
			{
				b0 = 5;
			}
			if (Block.opaqueCubeLookup[jl] && !Block.opaqueCubeLookup[kl])
			{
				b0 = 4;
			}
			
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			FMLNetworkHandler.openGui(player, CommonProxy.WCCoreInstance, GUIIDs.guiWeaponForge, world, x, y, z);
		}
		
		return true;
	}
	
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntity_WeaponForge();
	}
	
    /**
     * Called when the block is placed in the world.
     */
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack)
	{
		int l = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		if (l == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if (l == 1)
		{
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		if (l == 2)
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if (l == 3)
		{
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		if (itemStack.hasDisplayName())
		{
			((TileEntity_WeaponForge)world.getBlockTileEntity(x, y, z)).setGuiDisplayName(itemStack.getDisplayName());
		}
	}
	
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		if (this.isActive)
		{
			int l = world.getBlockMetadata(x, y,z);
			float fx = (float)x + 0.5F;
			float fy = (float)y + 0.4F + random.nextFloat() * 2.0F / 20.0F;
			float fz = (float)z + 0.5F;
			float f3 = 0.52F;
			float f4 = random.nextFloat() * 0.6F - 0.3F;
			
			if (l == 4)
			{
				world.spawnParticle("smoke", (double)(fx - f3), (double)fy, (double)(fz + f4), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double)(fx - f3), (double)fy, (double)(fz + f4), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("largesmoke", (double)(fx + f4), (double)fy + 1.7, (double)((fz - 0.6) + f3), 0.0D, 0.1D, 0.0D);
			}
			else if (l == 5)
			{
				world.spawnParticle("smoke", (double)(fx + f3), (double)fy, (double)(fz + f4), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double)(fx + f3), (double)fy, (double)(fz + f4), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("largesmoke", (double)(fx + f4), (double)fy + 1.7, (double)((fz - 0.6) + f3), 0.0D, 0.1D, 0.0D);
			}
			else if (l == 2)
			{
				world.spawnParticle("smoke", (double)(fx + f4), (double)fy, (double)(fz - f3), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double)(fx + f4), (double)fy, (double)(fz - f3), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("largesmoke", (double)(fx + f4), (double)fy + 1.7, (double)((fz - 0.6) + f3), 0.0D, 0.1D, 0.0D);
			}
			else if (l == 3)
			{
				world.spawnParticle("smoke", (double)(fx + f4), (double)fy, (double)(fz + f3), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("flame", (double)(fx + f4), (double)fy, (double)(fz + f3), 0.0D, 0.0D, 0.0D);
				world.spawnParticle("largesmoke", (double)(fx+ f4), (double)fy + 1.7, (double)((fz - 0.6) + f3), 0.0D, 0.1D, 0.0D);
			}
		}
	}
	
	public static void updateWeaponForgeBlockState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord)
	{
		int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		
		TileEntity tileEntity = worldObj.getBlockTileEntity(xCoord, yCoord, zCoord);
		keepInventory = true;
		
		if (active)
		{
			worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.blockQuartsFurnaceActive.blockID);
		}
		else
		{
			worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.blockQuartsFurnaceIdle.blockID);
		}
		
		keepInventory = false;
		
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
		
		if (tileEntity != null)
		{
			tileEntity.validate();
			worldObj.setBlockTileEntity(xCoord, yCoord, zCoord, tileEntity);
		}
	}
	
	public void breakBlock(World world, int x, int y, int z, int par5, int par6)
	{
		if (!keepInventory)
		{
			TileEntity_WeaponForge tileEntity = (TileEntity_WeaponForge)world.getBlockTileEntity(x, y, z);
			
			if (tileEntity != null)
			{
				for (int i = 0; i < tileEntity.getSizeInventory(); ++i)
				{
					ItemStack itemStack = tileEntity.getStackInSlot(i);
					
					if (itemStack != null)
					{
						float f = this.quartsRandom.nextFloat() * 0.8F + 0.1F;
						float f1 = this.quartsRandom.nextFloat() * 0.8F + 0.1F;
						float f2 = this.quartsRandom.nextFloat() * 0.8F + 0.1F;
						
						while (itemStack.stackSize > 0)
						{
							int k1 = this.quartsRandom.nextInt(21) + 10;
							
							if (k1 > itemStack.stackSize)
							{
								k1 = itemStack.stackSize;
							}
							
							itemStack.stackSize -= k1;
							EntityItem entityItem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemStack.itemID, k1, itemStack.getItemDamage()));
							
							if (itemStack.hasTagCompound())
							{
								entityItem.getEntityItem().setTagCompound((NBTTagCompound)itemStack.getTagCompound().copy());
							}
							
							float f3 = 0.05F;
							entityItem.motionX = (double)((float)this.quartsRandom.nextGaussian() * f3);
							entityItem.motionY = (double)((float)this.quartsRandom.nextGaussian() * f3 + 0.2F);
							entityItem.motionZ = (double)((float)this.quartsRandom.nextGaussian() * f3);
							world.spawnEntityInWorld(entityItem);
						}
					}
				}
				
				world.func_96440_m(x, y, z, par5);
			}
		}
		
		super.breakBlock(world, x, y, z, par5, par6);
	}
	
	public boolean hasComparatorInputOverride()
	{
		return true;
	}
	
	public int getComparatorInputOverride(World world, int x, int y, int z, int i)
	{
		return Container.calcRedstoneFromInventory((IInventory)world.getBlockTileEntity(x, y, z));
	}
	
	public int idPicked(World world, int x, int y, int z)
	{
		return ModBlocks.blockQuartsFurnaceIdle.blockID;
	}
	
	
}

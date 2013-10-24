package WarriorCulturesCore.Scoped.com.github;

import static org.objectweb.asm.Opcodes.FDIV;

import java.util.Iterator;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public class WCC_ClassTransformer implements net.minecraft.launchwrapper.IClassTransformer
{
	
	public byte[] transform(String nameOfClass, String newNameOfClass, byte[] arg2)
	{
		if (nameOfClass.equals("abq"))
		{
			return patchClassASM(nameOfClass, arg2, true);
		}
		
		if (nameOfClass.equals("new.minecraft.world.Explosion"))
		{
			System.out.println("************ INSIDE EXPLOSION TRANSFORMER ABOUT TO PATCH:" + nameOfClass);
			return patchClassASM(nameOfClass, arg2, false);
		}
		
		return arg2;
	}

	private byte[] patchClassASM(String name, byte[] bytes, boolean obfuscated)
	{
		String targetMethodName = "";
		
		if (obfuscated == true)
		{
			targetMethodName = "a";
		}
		else
		{
			targetMethodName = "doExplosionB";
		}
		
		ClassNode classNode = new ClassNode();
		ClassReader classReader = new ClassReader(bytes);
		classReader.accept(classNode, 0);
		
		Iterator<MethodNode> methods = classNode.methods.iterator();
		
		while (methods.hasNext())
		{
			MethodNode m = methods.next();
			int fdiv_index = -1;
			
			if ((m.name.equals(targetMethodName) && m.desc.equals("(Z)V")))
			{
				System.out.println("********** Inside target method!");
				
				AbstractInsnNode currentNode = null;
				AbstractInsnNode targetNode = null;
				
				@SuppressWarnings("unchecked")
				Iterator<AbstractInsnNode> iter = m.instructions.iterator();
				
				int index = -1;
				
				while (iter.hasNext())
				{
					index++;
					currentNode = iter.next();
					
					if (currentNode.getOpcode() == FDIV)
					{
						targetNode = currentNode;
						fdiv_index = index;
					}
				}
				
				/*
					FCONST_1
					ALOAD 0
				    GETFIELD net/minecraft/world/Explosion.explosionSize : F
				    FDIV
				    ICONST_0
				    INVOKEVIRTUAL net/minecraft/block/Block.dropBlockAsItemWithChance(Lnet/minecraft/world/World;IIIIFI)V
				 */
				
				AbstractInsnNode remNode1 = m.instructions.get(fdiv_index-2); // ALOAD 0
				AbstractInsnNode remNode2 = m.instructions.get(fdiv_index-1); // GETFIELD net/minecraft/world/Explosion.explosionSize : F
				AbstractInsnNode remNode3 = m.instructions.get(fdiv_index); // FDIV
				
				m.instructions.remove(remNode1);
				m.instructions.remove(remNode2);
				m.instructions.remove(remNode3);
				
				System.out.println("Patching Complete!");
				break;
			}
		}
		
		ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
		classNode.accept(writer);
		
		return writer.toByteArray();
	}
	
}

package WarriorCulturesCore.Scoped.com.github;

import java.util.Map;

public class WCC_LoadingPlugin implements cpw.mods.fml.relauncher.IFMLLoadingPlugin
{
	
	@Deprecated
	public String[] getLibraryRequestClass()
	{
		return null;
	}
	
	public String[] getASMTransformerClass()
	{
		return new String[]
				{
					WCC_ClassTransformer.class.getName()
				};
	}
	
	public String getModContainerClass()
	{
		return WCC_DummyContainer.class.getName();
	}
	
	public String getSetupClass()
	{
		return null;
	}
	
	public void injectData(Map<String, Object> data)
	{
		
	}
	
}

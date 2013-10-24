package WarriorCulturesCore.Scoped.com.github;

import java.util.Arrays;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class WCC_DummyContainer extends DummyModContainer
{
	public WCC_DummyContainer()
	{
		super(new ModMetadata());
		ModMetadata meta = getMetadata();
		meta.modId = "WCM";
		meta.name = "WarriorCultures Main";
		meta.version = "1.0.0a";
		meta.credits = "culegooner";
		meta.authorList = Arrays.asList("CraftedScorpio");
		meta.description = "Overrides several methods in MineCraft";
		meta.url = "";
		meta.updateUrl = "";
		meta.screenshots = new String[0];
		meta.logoFile = "";
	}
	
	public boolean registerBus(EventBus bus, LoadController controller)
	{
		bus.register(this);
		return true;
	}
	
	@Subscribe
	public void modConstruction(FMLConstructionEvent event)
	{
		
	}
	
	@Subscribe
	public void preInit(FMLPreInitializationEvent event)
	{
		
	}
	
	@Subscribe
	public void init(FMLInitializationEvent event)
	{
		
	}
	
	@Subscribe
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}

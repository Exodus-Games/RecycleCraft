package com.deltastrium.deltacraft.recyclecraft.core;

import com.deltastrium.deltacraft.recyclecraft.proxies.IProxy;
import com.deltastrium.deltacraft.recyclecraft.reference.ModInformation;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION)
public class RecycleCraft {

    @Mod.Instance(ModInformation.ID)
	public static RecycleCraft instance;
	
	@SidedProxy(clientSide = ModInformation.CLIENT_PROXY_PATH, serverSide = ModInformation.SERVER_PROXY_PATH)
	public static IProxy proxy;

	public static CreativeTabs modTap = new RecycleCraftTab();

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {

        /*
		// config
		ConfigData.init();
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		ConfigData.load();
		*/
		
		// proxy
		proxy.init();
		proxy.registerRenderers();
		proxy.registerEvents();
		
	//	Recipes.registerRecipes();
	}

    @Mod.EventHandler
	public void load(FMLInitializationEvent event) {

		proxy.registerTileEntities();
		//PacketData.init();
		//NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
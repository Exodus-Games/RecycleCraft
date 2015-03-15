package com.deltastrium.deltacraft.recyclecraft.config;

import java.io.File;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	private static final String CAREGORY_TWEAKS = "Tweaks";
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		try {
			config.load();
			
			// Example
			// ConfigData.useNewTab = config.get(CAREGORY_TWEAKS, "useNewTab", true, "whether this mod should use its own creative tab").getBoolean(true);

		}
		catch(Exception e) {
			System.out.println("RecycleCraft: Exception trying to load the config file!");
		}
		finally {
			config.save();
		}
	}
}

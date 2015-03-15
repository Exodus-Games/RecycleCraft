package com.deltastrium.deltacraft.recyclecraft.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ClientProxy extends CommonProxy {

	@Override
	public void init() {
		
	}

	@Override
	public void registerRenderers() {

	}

	@Override
	public void registerEvents() {

	}

    @Override
    public EntityPlayer getPlayer() {
        return Minecraft.getMinecraft().thePlayer;
    }
}

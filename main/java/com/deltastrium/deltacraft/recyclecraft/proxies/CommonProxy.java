package com.deltastrium.deltacraft.recyclecraft.proxies;

import net.minecraft.entity.player.EntityPlayer;

public abstract class CommonProxy implements IProxy {
	
	@Override
	public void registerRenderers() {

    }

    @Override
    public EntityPlayer getPlayer() {
        return null;
    }
}

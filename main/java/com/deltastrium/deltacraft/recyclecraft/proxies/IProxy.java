package com.deltastrium.deltacraft.recyclecraft.proxies;


import net.minecraft.entity.player.EntityPlayer;

public interface IProxy {

	public void init();
	public void registerRenderers();
	public void registerTileEntities();
	public void registerEvents();
    public EntityPlayer getPlayer();

}

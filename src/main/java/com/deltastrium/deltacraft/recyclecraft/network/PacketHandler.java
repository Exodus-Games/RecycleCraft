package com.deltastrium.deltacraft.recyclecraft.network;

import com.deltastrium.deltacraft.recyclecraft.reference.ModInformation;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {

	private static SimpleNetworkWrapper wrapper = new SimpleNetworkWrapper(ModInformation.CHANNEL);
	private static int counter = 0;

	public static void registerPacket(CustomPacket packet) {
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			wrapper.registerMessage((Class<? extends IMessageHandler<CustomPacket, IMessage>>) packet.getClass(), (Class<CustomPacket>) packet.getClass(), counter++, Side.CLIENT);
		}
		else {
			wrapper.registerMessage((Class<? extends IMessageHandler<CustomPacket, IMessage>>) packet.getClass(), (Class<CustomPacket>) packet.getClass(), counter++, Side.SERVER);
		}
	}
	
	public static void sendToAllInDimension(CustomPacket packet, int dimID) {
        wrapper.sendToDimension(packet, dimID);
	}
	
	public static void sendToServer(CustomPacket packet) {
        wrapper.sendToServer(packet);
	}

}

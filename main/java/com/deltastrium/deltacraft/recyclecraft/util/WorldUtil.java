package com.deltastrium.deltacraft.recyclecraft.util;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class WorldUtil {

    /** Sets the last bit of metadata at the specified coordinates. */
    public static void setBit4(World world, int x, int y, int z, boolean value, int flag) {
        int meta = world.getBlockMetadata(x, y, z);
        world.setBlockMetadataWithNotify(x, y, z, value ? (meta | 8) : (meta & 7), flag);
    }

    /** Sets the last bit of metadata at the specified tileentity. */
    public static void setBit4(TileEntity tile, boolean value, int flag) {
        setBit4(tile.getWorldObj(), tile.xCoord, tile.yCoord, tile.zCoord, value, flag);
    }

    /** Checks whether the last bit of metadata is set or not. */
    public static boolean isBit4Set(World world, int x, int y, int z) {
        return (world.getBlockMetadata(x, y, z) & 8) != 0;
    }

    /** Checks whether the last bit of metadata is set or not. */
    public static boolean isBit4Set(TileEntity tile) {
        return isBit4Set(tile.getWorldObj(), tile.xCoord, tile.yCoord, tile.zCoord);
    }

    public static boolean dropBlock(World world, int x, int y, int z) {
        if (!world.isRemote) {
            Block block = world.getBlock(x, y, z);
            if (block != null) {
                int meta = world.getBlockMetadata(x, y, z);
                block.dropBlockAsItemWithChance(world, x, y, z, meta, 1F, 1);
                world.setBlockToAir(x, y, z);
                return true;
            }
        }
        return false;
    }

    /** removes block without dropping things */
    public static void cleanBlock(World world, int x, int y, int z) {
        boolean remote = world.isRemote;
        world.isRemote = true;
        world.setBlockToAir(x, y, z);
        world.isRemote = remote;
    }
}

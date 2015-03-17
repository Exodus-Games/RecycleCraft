package com.deltastrium.deltacraft.recyclecraft.util;

import net.minecraft.world.World;

public class WorldUtil {

    /** Sets the last bit of metadata at the specified coordinates */
    public static void setBit4(World world, int x, int y, int z, boolean value, int flag) {
        int meta = world.getBlockMetadata(x, y, z);
        world.setBlockMetadataWithNotify(x, y, z, value ? (meta | 8) : (meta & 7), flag);
    }

}

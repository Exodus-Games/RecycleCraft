package com.deltastrium.deltacraft.recyclecraft.data;

import com.deltastrium.deltacraft.recyclecraft.tiles.TileIncinerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileData {

    public static void init() {
        GameRegistry.registerTileEntity(TileIncinerator.class, "rcTileIncinerator");
    }

}

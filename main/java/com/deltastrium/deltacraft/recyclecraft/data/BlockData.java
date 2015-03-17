package com.deltastrium.deltacraft.recyclecraft.data;

import com.deltastrium.deltacraft.recyclecraft.blocks.BIncinerator;
import com.deltastrium.deltacraft.recyclecraft.itemblocks.BITexted;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockData {

    public static BIncinerator incinerator;

    public static void init() {
        GameRegistry.registerBlock(incinerator = new BIncinerator(), BITexted.class, incinerator.getUnlocalizedName());
    }
}

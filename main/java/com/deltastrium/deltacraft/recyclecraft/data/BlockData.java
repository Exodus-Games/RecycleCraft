package com.deltastrium.deltacraft.recyclecraft.data;

import com.deltastrium.deltacraft.recyclecraft.blocks.BCompactor;
import com.deltastrium.deltacraft.recyclecraft.blocks.BIncinerator;
import com.deltastrium.deltacraft.recyclecraft.blocks.BMultiblockPart;
import com.deltastrium.deltacraft.recyclecraft.itemblocks.BITexted;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockData {

    public static BIncinerator incinerator;
    public static BCompactor compactor;
    public static BMultiblockPart multiblockPart;

    public static void init() {
        GameRegistry.registerBlock(incinerator = new BIncinerator(), BITexted.class, incinerator.getUnlocalizedName());
        GameRegistry.registerBlock(compactor = new BCompactor(), BITexted.class, compactor.getUnlocalizedName());
        GameRegistry.registerBlock(multiblockPart = new BMultiblockPart(), multiblockPart.getUnlocalizedName());
    }
}

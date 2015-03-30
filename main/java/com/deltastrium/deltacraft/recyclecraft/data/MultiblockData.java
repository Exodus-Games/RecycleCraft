package com.deltastrium.deltacraft.recyclecraft.data;

import net.minecraft.init.Blocks;

public class MultiblockData {

    public static Multiblock compactor;

    public static void init() {
        compactor = new Multiblock();
        compactor.setCore(BlockData.compactor, 3);
        compactor.addPart(Blocks.planks, 1, 0, 0, 0, false);
     /*   compactor.addPart(Blocks.planks, -1, 0, 0, 1, false);
        compactor.addPart(Blocks.planks, 0, 1, 0, 2, false);
        compactor.addPart(Blocks.planks, 0, -1, 0, 3, false);
        compactor.addPart(Blocks.piston, 1, 0, 1, 4, true);
        compactor.addPart(Blocks.piston, -1, 0, 1, 5, true);
        compactor.addPart(Blocks.piston, 0, 1, 1, 0, true);
        compactor.addPart(Blocks.piston, 0, -1, 1, 1, true);*/

    }

}

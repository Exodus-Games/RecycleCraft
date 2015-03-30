package com.deltastrium.deltacraft.recyclecraft.data;

import net.minecraft.init.Blocks;

public class MultiblockData {

    public static Multiblock compactor;

    public static void init() {
        compactor = new Multiblock();
        compactor.setCore(BlockData.compactor, 3);
        compactor.addPart(Blocks.stonebrick, 1, 0, 0, 0, false);
        compactor.addPart(Blocks.stonebrick, -1, 0, 0, 0, false);
        compactor.addPart(Blocks.stonebrick, 1, 0, -2, 0, false);
        compactor.addPart(Blocks.stonebrick, -1, 0, -2, 0, false);
        compactor.addPart(Blocks.stonebrick, 1, 2, 0, 0, false);
        compactor.addPart(Blocks.stonebrick, -1, 2, 0, 0, false);
        compactor.addPart(Blocks.stonebrick, 1, 2, -2, 0, false);
        compactor.addPart(Blocks.stonebrick, -1, 2, -2, 0, false);

        compactor.addPart(Blocks.planks, 1, 0, -1, 0, false);
        compactor.addPart(Blocks.planks, -1, 0, -1, 0, false);
        compactor.addPart(Blocks.planks, 0, 0, -2, 0, false);

        compactor.addPart(Blocks.planks, 1, 1, 0, 0, false);
        compactor.addPart(Blocks.planks, -1, 1, 0, 0, false);
        compactor.addPart(Blocks.planks, 1, 1, -2, 0, false);
        compactor.addPart(Blocks.planks, -1, 1, -2, 0, false);

        compactor.addPart(Blocks.planks, 1, 2, -1, 0, false);
        compactor.addPart(Blocks.planks, -1, 2, -1, 0, false);
        compactor.addPart(Blocks.planks, 0, 2, 0, 0, false);
        compactor.addPart(Blocks.planks, 0, 2, -2, 0, false);

        compactor.addPart(Blocks.piston, 1, 1, -1, 4, true);
        compactor.addPart(Blocks.piston, -1, 1, -1, 5, true);
        compactor.addPart(Blocks.piston, 0, 2, -1, 0, true);
        compactor.addPart(Blocks.piston, 0, 0, -1, 1, true);

        compactor.addPart(Blocks.piston, 0, 1, 0, 2, true);
        compactor.addPart(Blocks.piston, 0, 1, -2, 3, true);
    }

}

package com.deltastrium.deltacraft.recyclecraft.data;

import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.ArrayList;

public class Multiblock {

    public Multiblock(ArrayList<PartInfo> parts) {
        this.parts = parts;
    }

    private class PartInfo {
        public Block block;
        public int x, y, z, metadata;

        public PartInfo(Block block, int x, int y, int z, int metadata) {
            this.block = block;
            this.x = x;
            this.y = y;
            this.z = z;
            this.metadata = metadata;
        }
    }

    private ArrayList<PartInfo> parts = new ArrayList<PartInfo>();
    private PartInfo core;

    public void addPart(Block block, int x, int y, int z, int metadata) {
        parts.add(new PartInfo(block, x, y, z, metadata));
    }

    public void setCore(Block block, int x, int y, int z, int metadata) {
        core = new PartInfo(block, x, y, z, metadata);
    }

    public boolean checkPattern(World world, int x, int y, int z) {
        int facing = world.getBlockMetadata(x, y, z) & 7;

        for (PartInfo part : parts) {
            world.getBlock(x + part)
        }
    }
}

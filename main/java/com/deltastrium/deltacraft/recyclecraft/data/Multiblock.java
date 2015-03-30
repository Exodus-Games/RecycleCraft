package com.deltastrium.deltacraft.recyclecraft.data;

import com.deltastrium.deltacraft.recyclecraft.tiles.TileMultiblockPart;
import com.deltastrium.deltacraft.recyclecraft.util.FacingUtil;
import com.deltastrium.deltacraft.recyclecraft.util.Vector3;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import org.lwjgl.Sys;

import java.util.ArrayList;

public class Multiblock {

    private int indexCounter = 0;

    private class PartInfo {
        public int index;
        public Block block;
        public int x, y, z, metadata;
        public boolean rotateMeta;

        public PartInfo(Block block, int x, int y, int z, int metadata, boolean rotateMeta, int index) {
            this.block = block;
            this.x = x;
            this.y = y;
            this.z = z;
            this.metadata = metadata;
            this.rotateMeta = rotateMeta;
        }

        public boolean isPartThere(World world, int x, int y, int z) {
            if (!rotateMeta && world.getBlockMetadata(x, y, z) != metadata) return false;
            return world.getBlock(x, y, z) == block;
        }
    }

    private ArrayList<PartInfo> parts = new ArrayList<PartInfo>();
    private PartInfo core;

    public void addPart(Block block, int x, int y, int z, int metadata, boolean rotateMeta) {
        parts.add(new PartInfo(block, x, y, z, metadata, rotateMeta, indexCounter++));
    }

    public void setCore(Block block, int metadata) {
        core = new PartInfo(block, 0, 0, 0, metadata, true, -1);
    }

    public boolean checkPattern(World world, int x, int y, int z) {

        if (!core.isPartThere(world, x, y, z)) return false;
        int facing = world.getBlockMetadata(x, y, z) & 7;

        for (PartInfo part : parts) {
            Vector3 rotatedPos = new Vector3(part.x, part.y, part.z).rotateToMeta(core.metadata & 7, facing);

            if (!part.isPartThere(world, rotatedPos.x + x, rotatedPos.y + y, rotatedPos.z + z)) return false;

            int rotatedMeta = part.rotateMeta ? FacingUtil.getSynchedFurnaceFacing(core.metadata & 7, facing, part.metadata & 7) : part.metadata;
            if (rotatedMeta != (world.getBlockMetadata(rotatedPos.x + x, rotatedPos.y + y, rotatedPos.z + z) & 7)) return false;
        }

        return true;
    }

    public int synchSide(int facing, int side) {
        return FacingUtil.getSynchedFurnaceFacing(core.metadata & 7, facing, side);
    }

    public boolean tryCreate(World world, int x, int y, int z) {
        if (!checkPattern(world, x, y, z)) return false;

        int facing = world.getBlockMetadata(x, y, z) & 7;

        for (PartInfo part : parts) {
            Vector3 rotatedPos = new Vector3(part.x, part.y, part.z).rotateToMeta(core.metadata & 7, facing);
            int storedMeta = world.getBlockMetadata(x + rotatedPos.x, y + rotatedPos.y, z + rotatedPos.z);
            world.setBlock(x + rotatedPos.x, y + rotatedPos.y, z + rotatedPos.z, BlockData.multiblockPart);
            TileMultiblockPart tile = (TileMultiblockPart) world.getTileEntity(x + rotatedPos.x, y + rotatedPos.y, z + rotatedPos.z);
            tile.setCore(x, y, z);
            tile.setStoredBlock(part.block, storedMeta);
            tile.setIndex(part.index);
        }

        return true;
    }
}

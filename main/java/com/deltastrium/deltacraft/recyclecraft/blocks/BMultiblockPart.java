package com.deltastrium.deltacraft.recyclecraft.blocks;

import com.deltastrium.deltacraft.recyclecraft.core.RecycleCraft;
import com.deltastrium.deltacraft.recyclecraft.tiles.TileMultiblockPart;
import com.deltastrium.deltacraft.recyclecraft.util.Vector3;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

import java.util.Vector;

public class BMultiblockPart extends BlockContainer implements IRecycleCraftBlock {

    public BMultiblockPart() {
        super(Material.rock);
        setHardness(3.5F);
        setStepSound(Block.soundTypePiston);
        setBlockName("rc_multiblock_part");
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public boolean canBePickedUpWithWrench() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileMultiblockPart();
    }

    public Vector3 findCoreWithMeta(World world, Vector3 coords) {
        return findCoreWithMeta(world, coords.x, coords.y, coords.z);
    }

    public Vector3 findCoreWithMeta(World world, int x, int y, int z) {

        Vector3 result = new Vector3(x, y, z);

        while (world.getBlock(x, y, z) instanceof BMultiblockPart) {
            result.offsetForSide(world.getBlockMetadata(x, y, z));
            if (world.getBlock(x, y, z) instanceof BMultiblockCore) {
                return result;
            }
        }

        return null;
    }
}

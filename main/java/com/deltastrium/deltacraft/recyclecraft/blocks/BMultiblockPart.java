package com.deltastrium.deltacraft.recyclecraft.blocks;

import com.deltastrium.deltacraft.recyclecraft.core.RecycleCraft;
import com.deltastrium.deltacraft.recyclecraft.reference.ModInformation;
import com.deltastrium.deltacraft.recyclecraft.reference.Textures;
import com.deltastrium.deltacraft.recyclecraft.tiles.TileMultiblockCore;
import com.deltastrium.deltacraft.recyclecraft.tiles.TileMultiblockPart;
import com.deltastrium.deltacraft.recyclecraft.util.Vector3;
import com.deltastrium.deltacraft.recyclecraft.util.WorldUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
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
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(ModInformation.RESOURCE_LOCATION + ":" + Textures.COMPACTOR_FRONT);
    }

    /*
    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
       /* TileMultiblockPart tile = WorldUtil.getTile(world, x, y, z, TileMultiblockPart.class);
        if (tile != null) {
            System.out.println("A");
            Vector3 coreCoords = tile.getCoreCoords();
            if (coreCoords != null) {
                Block core = world.getBlock(coreCoords.x, coreCoords.y, coreCoords.z);
                if (core != null && core instanceof BMultiblockCore) {
                    System.out.println("B");
                    return ((BMultiblockCore) core).getPartTextureRaw(world, x, y, z, tile.getIndex(), side);
                }
            }
        return super.getIcon(world, x, y, z, side);
    }*/

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

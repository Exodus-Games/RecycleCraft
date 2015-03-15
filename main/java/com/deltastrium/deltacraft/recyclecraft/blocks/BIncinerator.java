package com.deltastrium.deltacraft.recyclecraft.blocks;

import com.deltastrium.deltacraft.recyclecraft.core.RecycleCraft;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BIncinerator extends BlockContainer implements IRecycleCraftBlock {

    public BIncinerator() {
        super(Material.rock);
        setCreativeTab(RecycleCraft.modTap);
        setBlockName("rc_incinerator");
    }

    @Override
    public void getKey() {

    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return null;
    }


}

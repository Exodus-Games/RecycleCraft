package com.deltastrium.deltacraft.recyclecraft.blocks;

import com.deltastrium.deltacraft.recyclecraft.core.RecycleCraft;
import com.deltastrium.deltacraft.recyclecraft.tiles.TileIncinerator;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BIncinerator extends BlockContainer implements IRecycleCraftBlock {

    public BIncinerator() {
        super(Material.rock);
        setCreativeTab(RecycleCraft.modTap);
        setBlockName("rc_incinerator");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        // temporary
        return Blocks.furnace.getIcon(0, 0);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileIncinerator();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xHit, float yHit, float zHit) {

        player.openGui(RecycleCraft.instance, 0, world, x, y, z);
        return true;
    }
}

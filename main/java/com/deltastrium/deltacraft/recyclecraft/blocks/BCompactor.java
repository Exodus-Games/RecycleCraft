package com.deltastrium.deltacraft.recyclecraft.blocks;

import com.deltastrium.deltacraft.recyclecraft.core.RecycleCraft;
import com.deltastrium.deltacraft.recyclecraft.data.Multiblock;
import com.deltastrium.deltacraft.recyclecraft.data.MultiblockData;
import com.deltastrium.deltacraft.recyclecraft.reference.ModInformation;
import com.deltastrium.deltacraft.recyclecraft.reference.Textures;
import com.deltastrium.deltacraft.recyclecraft.tiles.TileIncinerator;
import com.deltastrium.deltacraft.recyclecraft.util.FacingUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BCompactor extends BMultiblockCore {

    // TODO: Someone make this sound good
    public static final String DESCRIPTION = "Makes blocks more compact!";

    private IIcon frontTexture, sideTexture, topTexture, bottomTexture;

    public BCompactor() {
        super(Material.rock);
        setHardness(3.5F);
        setStepSound(Block.soundTypePiston);
        setCreativeTab(RecycleCraft.modTap);
        setBlockName("rc_compactor");
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = this.frontTexture = iconRegister.registerIcon(ModInformation.RESOURCE_LOCATION + ":" + Textures.COMPACTOR_FRONT);
        this.sideTexture = iconRegister.registerIcon(ModInformation.RESOURCE_LOCATION + ":" + Textures.COMPACTOR_SIDE);
        this.topTexture = iconRegister.registerIcon(ModInformation.RESOURCE_LOCATION + ":" + Textures.COMPACTOR_TOP);
        this.bottomTexture = iconRegister.registerIcon(ModInformation.RESOURCE_LOCATION + ":" + Textures.COMPACTOR_BOTTOM);
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (side == 0) return bottomTexture;
        if (side == 1) return topTexture;
        // uses meta = 3 for inventory
        if (side == meta || (meta == 0 && side == 3)) return frontTexture;
        return sideTexture;
    }

    @Override
    public IIcon getPartTexture(int index, int side) {
        return bottomTexture;
    }

    @Override
    public Multiblock getMultiblock() { return MultiblockData.compactor; }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileIncinerator();
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public boolean canBePickedUpWithWrench() {
        return true;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xHit, float yHit, float zHit) {
        if (super.onBlockActivated(world, x, y, z, player, side, xHit, yHit, zHit)) return true;

        player.openGui(RecycleCraft.instance, 0, world, x, y, z);
        return true;
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        world.setBlockMetadataWithNotify(x, z, y, 2, 2);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int z, int y, EntityLivingBase player, ItemStack stack) {
        world.setBlockMetadataWithNotify(x, z, y, FacingUtil.getFurnaceMeta(player), 2);
    }
}

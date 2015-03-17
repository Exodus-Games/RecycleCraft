package com.deltastrium.deltacraft.recyclecraft.blocks;

import com.deltastrium.deltacraft.recyclecraft.config.ConfigData;
import com.deltastrium.deltacraft.recyclecraft.core.RecycleCraft;
import com.deltastrium.deltacraft.recyclecraft.itemblocks.BITexted;
import com.deltastrium.deltacraft.recyclecraft.reference.ModInformation;
import com.deltastrium.deltacraft.recyclecraft.reference.Textures;
import com.deltastrium.deltacraft.recyclecraft.tiles.TileIncinerator;
import com.deltastrium.deltacraft.recyclecraft.util.FacingUtil;
import com.deltastrium.deltacraft.recyclecraft.util.WorldUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BIncinerator extends BlockContainer implements IRecycleCraftBlock {

    // TODO: Someone make this sound good
    public static final String DESCRIPTION = "Destroys all items that are placed inside.";
    public static final int BURN_TIME = 60;

    private IIcon frontTexture, sideTexture, topTexture, bottomTexture;

    public BIncinerator() {
        super(Material.rock);
        setHardness(3.5F);
        setStepSound(Block.soundTypePiston);
        setCreativeTab(RecycleCraft.modTap);
        setBlockName("rc_incinerator");
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = this.frontTexture = iconRegister.registerIcon(ModInformation.RESOURCE_LOCATION + ":" + Textures.INCINERATOR_FRONT);
        this.sideTexture = iconRegister.registerIcon(ModInformation.RESOURCE_LOCATION + ":" + Textures.INCINERATOR_SIDE);
        this.topTexture = iconRegister.registerIcon(ModInformation.RESOURCE_LOCATION + ":" + Textures.INCINERATOR_TOP);
        this.bottomTexture = iconRegister.registerIcon(ModInformation.RESOURCE_LOCATION + ":" + Textures.INCINERATOR_BOTTOM);
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
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileIncinerator();
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xHit, float yHit, float zHit) {
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

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {

        if (ConfigData.machineParticles && WorldUtil.isBit4Set(world, x, y, z)) {
            float xPos = (float) x + 0.25F + (0.5F * rand.nextFloat());
            float yPos = (float) y + 0.9F + (0.2F * rand.nextFloat());
            float zPos = (float) z + 0.25F + (0.5F * rand.nextFloat());

            world.spawnParticle("smoke", (double) xPos, (double) yPos, (double) zPos, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("smoke", (double) xPos, (double) yPos, (double) zPos, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", (double) xPos, (double) yPos, (double) zPos, 0.0D, 0.0D, 0.0D);
        }
    }
}

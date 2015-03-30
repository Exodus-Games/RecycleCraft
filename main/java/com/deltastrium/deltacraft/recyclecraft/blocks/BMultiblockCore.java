package com.deltastrium.deltacraft.recyclecraft.blocks;

import com.deltastrium.deltacraft.recyclecraft.core.RecycleCraft;
import com.deltastrium.deltacraft.recyclecraft.data.ItemData;
import com.deltastrium.deltacraft.recyclecraft.data.Multiblock;
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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BMultiblockCore extends BlockContainer implements IRecycleCraftBlock {

    protected BMultiblockCore(Material material) {
        super(material);
    }

    public abstract Multiblock getMultiblock();
    public abstract IIcon getPartTexture(int index, int side);

    public IIcon getPartTextureRaw(IBlockAccess world, int x, int y, int z, int index, int unrotatedSide) {
        int facing = world.getBlockMetadata(x, y, z) & 7;
        return this.getPartTexture(index, getMultiblock().synchSide(facing, unrotatedSide));
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xHit, float yHit, float zHit) {
        ItemStack stack = player.getCurrentEquippedItem();
        if (stack.getItem() == ItemData.wrench) {
            getMultiblock().tryCreate(world, x, y, z);
            return true;
        }

        return false;
    }
}

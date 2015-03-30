package com.deltastrium.deltacraft.recyclecraft.items;

import com.deltastrium.deltacraft.recyclecraft.blocks.IRecycleCraftBlock;
import com.deltastrium.deltacraft.recyclecraft.core.RecycleCraft;
import com.deltastrium.deltacraft.recyclecraft.data.MultiblockData;
import com.deltastrium.deltacraft.recyclecraft.reference.ModInformation;
import com.deltastrium.deltacraft.recyclecraft.reference.Textures;
import com.deltastrium.deltacraft.recyclecraft.util.WorldUtil;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemWrench extends Item {

    public ItemWrench() {
        setCreativeTab(RecycleCraft.modTap);
        setMaxStackSize(1);
        setUnlocalizedName("rc_wrench");
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(ModInformation.RESOURCE_LOCATION + ":" + Textures.WRENCH);
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (player.isSneaking()) {
            Block block = world.getBlock(x, y, z);
            if (block != null && block instanceof IRecycleCraftBlock && ((IRecycleCraftBlock) block).canBePickedUpWithWrench()) {
                WorldUtil.dropBlock(world, x, y, z);
            }
        }

        return false;
    }
}

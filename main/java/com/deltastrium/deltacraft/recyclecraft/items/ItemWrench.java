package com.deltastrium.deltacraft.recyclecraft.items;

import com.deltastrium.deltacraft.recyclecraft.core.RecycleCraft;
import com.deltastrium.deltacraft.recyclecraft.reference.ModInformation;
import com.deltastrium.deltacraft.recyclecraft.reference.Textures;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

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
}

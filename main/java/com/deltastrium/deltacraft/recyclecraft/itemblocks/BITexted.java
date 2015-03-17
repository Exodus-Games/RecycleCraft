package com.deltastrium.deltacraft.recyclecraft.itemblocks;

import com.deltastrium.deltacraft.recyclecraft.blocks.IRecycleCraftBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class BITexted extends ItemBlock {

    private String description;

    public BITexted(Block block) {
        super(block);
        this.description = ((IRecycleCraftBlock) block).getDescription();
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(description);
    }
}

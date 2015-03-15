package com.deltastrium.deltacraft.recyclecraft.core;

import com.deltastrium.deltacraft.recyclecraft.reference.ModInformation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class RecycleCraftTab extends CreativeTabs {

	public RecycleCraftTab() {
		super(ModInformation.NAME);
	}

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(Blocks.stone);
    }

}

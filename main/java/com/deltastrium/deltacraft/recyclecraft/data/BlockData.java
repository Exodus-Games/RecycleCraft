package com.deltastrium.deltacraft.recyclecraft.data;

import com.deltastrium.deltacraft.recyclecraft.blocks.BIncinerator;
import com.deltastrium.deltacraft.recyclecraft.blocks.IRecycleCraftBlock;
import com.deltastrium.deltacraft.recyclecraft.core.RecycleCraft;
import com.deltastrium.deltacraft.recyclecraft.reference.ModInformation;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BlockData {

    public static BIncinerator incinerator;

    public static void init() {
        GameRegistry.registerBlock(incinerator = new BIncinerator(), incinerator.getUnlocalizedName());
    }
}

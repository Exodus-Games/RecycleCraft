package com.deltastrium.deltacraft.recyclecraft.data;

import com.deltastrium.deltacraft.recyclecraft.items.ItemWrench;
import com.deltastrium.deltacraft.recyclecraft.reference.ModInformation;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemData {

    public static ItemWrench wrench;

    public static void init() {
        GameRegistry.registerItem(wrench = new ItemWrench(), wrench.getUnlocalizedName(), ModInformation.ID);
    }
}

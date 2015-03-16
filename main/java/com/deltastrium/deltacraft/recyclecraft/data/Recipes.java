package com.deltastrium.deltacraft.recyclecraft.data;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class Recipes {

    public static void registerRecipes() {

        // BLOCKS //

        // temporary Recipe
        GameRegistry.addShapedRecipe(new ItemStack(BlockData.incinerator),
                "ABA", "B B", "ABA",
                'A', Blocks.cobblestone,
                'B', Blocks.furnace);

    }

}

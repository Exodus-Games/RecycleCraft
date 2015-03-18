package com.deltastrium.deltacraft.recyclecraft.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class FacingUtil {

    /** returns a new facing for a block depending on the given rotation example. */
    public static int getSynchedFacing(int exampleOld, int exampleNew, int currentFacing) {

    }

    public static int getFurnaceMeta(EntityLivingBase player) {
        int l = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        switch(l) {
            case 0: return 2;
            case 1: return 5;
            case 2: return 3;
            default: return 4;
        }
    }
}

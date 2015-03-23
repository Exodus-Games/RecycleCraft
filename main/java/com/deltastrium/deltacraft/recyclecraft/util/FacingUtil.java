package com.deltastrium.deltacraft.recyclecraft.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class FacingUtil {

    private static final int[][] sideToData = {{0,1,2,3,4,5},{1,0,3,2,5,4},{2,3,0,1,4,5},{3,2,1,0,5,4},{4,5,2,3,0,1},{5,4,3,2,1,0}};

    /** returns a new facing for a furnace like block depending on the given rotation example. */
    public static int getSynchedFurnaceFacing(int exampleOld, int exampleNew, int currentFacing) {

        int rotation = findRotation(exampleOld, exampleNew);

        if (currentFacing == 0 || currentFacing == 1 || rotation == -2) return currentFacing;
        if (rotation == -1) return currentFacing ^ 1;
        return sideToData[rotation][currentFacing];
    }

    /** finds the applied rotation depending on the given example.
     *  returns -1 for mirrored facing and -2 for no changes.
     */
    public static int findRotation(int exampleOld, int exampleNew) {
        if (exampleOld < 0 || exampleNew < 0 || exampleOld > 5 || exampleNew > 5) {
            throw new IllegalArgumentException("not a valid facing");
        }

        if (exampleOld == exampleNew) return -2;
        if (exampleOld == (exampleNew ^ 1)) return -1;

        for (int i = 0; i < 6; i++) {
            if (sideToData[i][exampleOld] == exampleNew) {
                return i;
            }
        }

        return 0;
    }

    /** returns a facing depended on the players view for a furnace like block */
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

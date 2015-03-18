package com.deltastrium.deltacraft.recyclecraft.util;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Facing;
import net.minecraftforge.common.util.Constants;

public class Vector3 {

    public int x, y, z;

    public Vector3() {
        this.x = this.y = this.z = 0;
    }

    public Vector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void offsetForSide(int side) {
        if (side >= 0 && side <= 5) {
            this.x = Facing.offsetsXForSide[side];
            this.y = Facing.offsetsYForSide[side];
            this.z = Facing.offsetsZForSide[side];
        }
    }

    public NBTTagCompound writeToNBT() {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("x", x);
        nbt.setInteger("y", y);
        nbt.setInteger("z", z);
        return nbt;
    }

    public void readFromNBT(NBTTagCompound nbt) {
        this.x = nbt.getInteger("x");
        this.y = nbt.getInteger("y");
        this.z = nbt.getInteger("z");
    }

    public static Vector3 createFromNBT(NBTTagCompound compound) {
        Vector3 vector = new Vector3();
        vector.readFromNBT(compound);
        return vector;
    }
}

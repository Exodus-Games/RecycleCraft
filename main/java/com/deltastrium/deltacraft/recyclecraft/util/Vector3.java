package com.deltastrium.deltacraft.recyclecraft.util;

import net.minecraft.nbt.NBTTagCompound;

public class Vector3 {

    public int x, y, z;

    public Vector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
}

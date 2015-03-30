package com.deltastrium.deltacraft.recyclecraft.util;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Facing;
import net.minecraftforge.common.util.Constants;

import static com.deltastrium.deltacraft.recyclecraft.util.FacingUtil.findRotation;

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

    /** Shifts the vector in the spcified direction (0,1,2,3,4,5). Modifies the current instance. */
    public void offsetForSide(int side) {
        if (side >= 0 && side <= 5) {
            this.x = Facing.offsetsXForSide[side];
            this.y = Facing.offsetsYForSide[side];
            this.z = Facing.offsetsZForSide[side];
        }
    }

    /** Rotates the vector on the specified axis (0,1,2,3,4,5). Returns a new instance. */
    public Vector3 rotate(int axis) {
        switch (axis) {
            case 0: return new Vector3(z, y, -x);
            case 1: return new Vector3(-z, y, x);
            case 2: return new Vector3(y, -x, z);
            case 3: return new Vector3(-y, x, z);
            case 4: return new Vector3(x, z, -y);
            case 5: return new Vector3(x, -z, y);
        }

        return null;
    }

    /** Rotates the vector based ont the given rotation example. Returns a new instance. */
    public Vector3 rotateToMeta(int oldMeta, int newMeta) {
        Vector3 result = copy();
        int rotation = findRotation(oldMeta, newMeta);

        if (rotation == -2) return result;
        if (rotation == -1) return result.rotate(rotation).rotate(rotation);
        return result.rotate(rotation);
    }

    public Vector3 copy() {
        return new Vector3(x, y, z);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector3 vector3 = (Vector3) o;

        if (x != vector3.x) return false;
        if (y != vector3.y) return false;
        if (z != vector3.z) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    public String toString() {
        return "Vector(" + x + ", " + y + ", " + z + ")";
    }
}

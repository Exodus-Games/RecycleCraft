package com.deltastrium.deltacraft.recyclecraft.tiles;

import com.deltastrium.deltacraft.recyclecraft.data.BlockData;
import com.deltastrium.deltacraft.recyclecraft.util.Vector3;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import javax.vecmath.Vector3d;

public class TileMultiblockPart extends TileEntity {

    private Block block;
    private int metadata;
    private Vector3 coreCoords;

    @Override
    public void updateEntity() {
        if (coreCoords == null) {
            coreCoords = BlockData.multiblockPart.findCoreWithMeta(worldObj, xCoord, yCoord, zCoord);
            if (coreCoords == null) {
                loadBlock();
            }
        }
    }

    public void setStoredBlock(Block block, int metadata) {
        this.block = block;
        this.metadata = metadata;
    }

    public void setCore(int x, int y, int z) {
        this.coreCoords = new Vector3(x, y, z);
    }

    public void setCore(Vector3 coreCoords) {
        this.coreCoords = coreCoords;
    }

    public boolean loadBlock() {
        if (block == null) {
            worldObj.setBlockToAir(xCoord, yCoord, zCoord);
            return false;
        }
        else {
            worldObj.setBlock(xCoord, yCoord, zCoord, block, metadata, 3);
            return true;
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("metadata", metadata);

        if (block != null) compound.setInteger("blockID", Block.getIdFromBlock(block));
        if (coreCoords != null) compound.setTag("coreCoords", coreCoords.writeToNBT());
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.metadata = compound.getInteger("metadata");
        if (compound.hasKey("blockID")) this.block = Block.getBlockById(compound.getInteger("blockID"));
        if (compound.hasKey("coreCoords")) this.coreCoords = Vector3.createFromNBT(compound.getCompoundTag("coreCoords"));
    }
}

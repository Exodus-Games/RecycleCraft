package com.deltastrium.deltacraft.recyclecraft.tiles;

import com.deltastrium.deltacraft.recyclecraft.blocks.BIncinerator;
import com.deltastrium.deltacraft.recyclecraft.data.BlockData;
import com.deltastrium.deltacraft.recyclecraft.util.WorldUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileIncinerator extends TileEntity implements IInventory {

    public int burnTime = 0;

    @Override
    public void updateEntity() {
        if (burnTime > 0) burnTime--;
        else if (!worldObj.isRemote) WorldUtil.setBit4(this, false, 3);
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return true;
    }

    @Override
    public String getInventoryName() {
        return BlockData.incinerator.getUnlocalizedName();
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public ItemStack getStackInSlot(int slot) { return null; }

    @Override
    public ItemStack decrStackSize(int slot, int amt) { return null; }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) { return null; }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        if (stack != null) {
            WorldUtil.setBit4(this, true, 3);
            this.burnTime = BIncinerator.BURN_TIME;
        }
    }

    @Override
    public Packet getDescriptionPacket() {
        super.getDescriptionPacket();
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("burnTime", burnTime);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.burnTime = compound.getInteger("burnTime");
    }
}

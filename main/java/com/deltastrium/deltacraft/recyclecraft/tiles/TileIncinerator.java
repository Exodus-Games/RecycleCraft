package com.deltastrium.deltacraft.recyclecraft.tiles;

import com.deltastrium.deltacraft.recyclecraft.data.BlockData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileIncinerator extends TileEntity implements IInventory {

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
    public void setInventorySlotContents(int slot, ItemStack stack) {}
}

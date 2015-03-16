package com.deltastrium.deltacraft.recyclecraft.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public abstract class ContainerBase extends Container {

    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    public int getInventorySize() {
        return 0;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {

        ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);
        int invSize = this.getInventorySize();

        // null checks and checks if the item can be stacked (maxStackSize > 1)
        if (slotObject != null && slotObject.getHasStack()) {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();

            // merges the item into player inventory since its in the tileEntity
            if (slot < invSize) {
                if (!this.mergeItemStack(stackInSlot, invSize, 35, true)) {
                    return null;
                }
            }
            // place the item into the tileEntity since its in the player inventory
            else if (!this.mergeItemStack(stackInSlot, 0, invSize, false)) {
                return null;
            }

            if (stackInSlot.stackSize == 0) {
                slotObject.putStack(null);
            } else {
                slotObject.onSlotChanged();
            }

            if (stackInSlot.stackSize == stack.stackSize) {
                return null;
            }
            slotObject.onPickupFromSlot(player, stackInSlot);
        }
        return null;
    }
}

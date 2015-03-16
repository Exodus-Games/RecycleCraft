package com.deltastrium.deltacraft.recyclecraft.gui;

import com.deltastrium.deltacraft.recyclecraft.tiles.TileIncinerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;

public class ConIncinerator extends ContainerBase {

    private TileIncinerator tile;

    public ConIncinerator(InventoryPlayer inventoryPlayer, TileIncinerator tile) {
        this.tile = tile;

        addSlotToContainer(new Slot(tile, 0, 6 * 18 + 26, 18));

        bindPlayerInventory(inventoryPlayer);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tile.isUseableByPlayer(player);
    }
}

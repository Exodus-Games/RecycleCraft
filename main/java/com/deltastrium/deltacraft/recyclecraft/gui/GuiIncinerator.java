package com.deltastrium.deltacraft.recyclecraft.gui;

import com.deltastrium.deltacraft.recyclecraft.blocks.BIncinerator;
import com.deltastrium.deltacraft.recyclecraft.data.BlockData;
import com.deltastrium.deltacraft.recyclecraft.reference.Textures;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.StatCollector;

public class GuiIncinerator extends GuiContainer {

    public GuiIncinerator(Container container) {
        super(container);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
        fontRendererObj.drawString(BlockData.incinerator.getLocalizedName(), 8, 6, 4210752);
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        this.mc.getTextureManager().bindTexture(Textures.GUI_INCINERATOR);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}

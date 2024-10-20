//currently does not work,or maybe I'm just using it wrong

package net.eaglymc.gui;

import net.lax1dude.eaglercraft.v1_8.opengl.GlStateManager;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class NewBackground extends GuiScreen { 
    private static final ResourceLocation newBackgroundTexture = new ResourceLocation("eagler", "eaglymc/gui/panorama.png");

    public void drawNewBackground() {
        this.mc.getTextureManager().bindTexture(newBackgroundTexture);
        
        // Set the color
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        
        // Draw the texture across the screen
        this.drawTexturedModalRect(0, 0, 0, 0, this.width, this.height);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        // Calls the custom background drawing method
        this.drawNewBackground();  // Draw the new background

        // Calls the super method to render the rest of the GUI
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}

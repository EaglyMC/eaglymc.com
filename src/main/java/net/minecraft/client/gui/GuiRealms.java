package net.minecraft.client.gui;

//import net.minecraft.client.gui.GuiScreen;

//import net.minecraft.client.gui.GuiButton;

public class GuiRealms extends GuiScreen {

    @Override
    public void initGui() {

        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 2 - 10, "Close"));
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            this.mc.displayGuiScreen(null); // This closes the GUI
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground(); // Draw default background
        this.drawCenteredString(this.fontRendererObj, "One day...", this.width / 2, 20, 0xFFFFFF);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return true; // If true, game pauses when the GUI is open
    }
}

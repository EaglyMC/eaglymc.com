package net.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ItemShield extends Item {
    
    public ItemShield() {
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }
    
    // Detect right-click usage
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        player.motionX *= 0.6; // Slow down player movement
        player.motionZ *= 0.6;
        
        return itemStack;
    }
    
    // Use duration for holding the item
    public int getMaxItemUseDuration(ItemStack stack) {
        return 72000; // Arbitrary large value for continuous usage
    }
    
    // Update method for continuous behavior
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (player.isUsingItem() && isSelected) {
                player.motionX *= 0.5; // Applies slow effect while shield is selected
                player.motionZ *= 0.5;
            }
        }
    }
}

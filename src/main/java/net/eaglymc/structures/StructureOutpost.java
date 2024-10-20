package net.eaglymc.structures;

import net.lax1dude.eaglercraft.v1_8.EaglercraftRandom;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

//currently generates in plains,dessert,taiga,savanna

public class StructureOutpost extends WorldGenerator {

    public boolean generate(World worldIn, EaglercraftRandom rand, BlockPos position) {
        // Base: 5x5 stone floor
        for (int x = 0; x < 5; x++) {
            for (int z = 0; z < 5; z++) {
                BlockPos blockPos = position.add(x, 0, z);
                worldIn.setBlockState(blockPos, Blocks.stone.getDefaultState(), 2);
            }
        }

        // Pillars: four wooden columns at each corner, 3 blocks high
        for (int y = 1; y < 4; y++) {
            worldIn.setBlockState(position.add(0, y, 0), Blocks.log.getDefaultState(), 2);
            worldIn.setBlockState(position.add(4, y, 0), Blocks.log.getDefaultState(), 2);
            worldIn.setBlockState(position.add(0, y, 4), Blocks.log.getDefaultState(), 2);
            worldIn.setBlockState(position.add(4, y, 4), Blocks.log.getDefaultState(), 2);
        }

        // Walls: create walls with cobblestone and windows with glass panes
        for (int x = 0; x < 5; x++) {
            for (int y = 1; y < 4; y++) {
                BlockPos blockPos1 = position.add(x, y, 0);
                BlockPos blockPos2 = position.add(x, y, 4);
                BlockPos blockPos3 = position.add(0, y, x);
                BlockPos blockPos4 = position.add(4, y, x);

                if ((y == 2 && (x == 1 || x == 3))) {
                    // Windows
                    worldIn.setBlockState(blockPos1, Blocks.glass_pane.getDefaultState(), 2);
                    worldIn.setBlockState(blockPos2, Blocks.glass_pane.getDefaultState(), 2);
                    worldIn.setBlockState(blockPos3, Blocks.glass_pane.getDefaultState(), 2);
                    worldIn.setBlockState(blockPos4, Blocks.glass_pane.getDefaultState(), 2);
                } else {
                    // Solid walls
                    worldIn.setBlockState(blockPos1, Blocks.cobblestone.getDefaultState(), 2);
                    worldIn.setBlockState(blockPos2, Blocks.cobblestone.getDefaultState(), 2);
                    worldIn.setBlockState(blockPos3, Blocks.cobblestone.getDefaultState(), 2);
                    worldIn.setBlockState(blockPos4, Blocks.cobblestone.getDefaultState(), 2);
                }
            }
        }

        // Roof: flat roof made of wood planks
        for (int x = 0; x < 5; x++) {
            for (int z = 0; z < 5; z++) {
                BlockPos blockPos = position.add(x, 4, z);
                worldIn.setBlockState(blockPos, Blocks.planks.getDefaultState(), 2);
            }
        }
        
        return true;
    }
}

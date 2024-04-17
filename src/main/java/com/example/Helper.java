package com.example;

import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public static List<BlockPos> getAroundCore(BlockPos center) {
        ArrayList<BlockPos> blocks = new ArrayList<>();
        blocks.add(center.up());
        blocks.add(center.down());
        blocks.add(center.north());
        blocks.add(center.south());
        blocks.add(center.west());
        blocks.add(center.east());
        blocks.add(center.up().north());
        blocks.add(center.up().south());
        blocks.add(center.up().east());
        blocks.add(center.up().west());
        blocks.add(center.up().north().east());
        blocks.add(center.up().north().west());
        blocks.add(center.up().south().east());
        blocks.add(center.up().south().west());
        blocks.add(center.down().north());
        blocks.add(center.down().south());
        blocks.add(center.down().east());
        blocks.add(center.down().west());
        blocks.add(center.down().north().east());
        blocks.add(center.down().north().west());
        blocks.add(center.down().south().east());
        blocks.add(center.down().south().west());
        blocks.add(center.north().east());
        blocks.add(center.north().west());
        blocks.add(center.south().east());
        blocks.add(center.south().west());
        return blocks;
    }
}

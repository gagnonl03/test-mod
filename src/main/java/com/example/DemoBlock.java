package com.example;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DemoBlock extends Block implements BlockEntityProvider {

    public DemoBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DemoBlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient) {
            return ActionResult.SUCCESS;
        }
        BlockEntity block = world.getBlockEntity(pos);
        if(block instanceof DemoBlockEntity demoBlock) {
            demoBlock.print();
        } else {
            System.out.println("AAAAA");
        }
        return ActionResult.CONSUME;
    }
}

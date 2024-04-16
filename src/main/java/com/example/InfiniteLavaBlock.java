package com.example;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InfiniteLavaBlock extends Block {

    public InfiniteLavaBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.isClient) {
            return ActionResult.SUCCESS;
        }
        ItemStack inHand = player.getStackInHand(hand);
        if(inHand.isOf(Items.BUCKET)) {
            player.getInventory().offerOrDrop(new ItemStack(Items.LAVA_BUCKET, 1));
            inHand.decrement(1);
        }
        return ActionResult.CONSUME;
    }
}

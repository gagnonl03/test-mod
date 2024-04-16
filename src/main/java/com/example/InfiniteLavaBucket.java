package com.example;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class InfiniteLavaBucket extends Item {


    public InfiniteLavaBucket(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        BlockHitResult hitResult = Item.raycast(world, user, RaycastContext.FluidHandling.NONE);
        BlockPos pos1 = hitResult.getBlockPos();
        Direction pos2 = hitResult.getSide();
        BlockPos pos3 = pos1.offset(pos2);
        world.setBlockState(pos3, Blocks.LAVA.getDefaultState().getFluidState().getBlockState());
        return TypedActionResult.success(user.getMainHandStack());
    }
}

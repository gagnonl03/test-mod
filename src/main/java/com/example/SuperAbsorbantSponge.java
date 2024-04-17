package com.example;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class SuperAbsorbantSponge extends Item {
    public SuperAbsorbantSponge(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        BlockHitResult hitResult = Item.raycast(world, user, RaycastContext.FluidHandling.ANY);
        BlockPos core = hitResult.getBlockPos();
        BlockState blockAt = world.getBlockState(core).getBlock().getDefaultState();
        List<BlockPos> aroundCore = Helper.getAroundCore(core);
        if(blockAt.isOf(Blocks.WATER)) {
            world.setBlockState(core, Blocks.AIR.getDefaultState());
            for(BlockPos pos : aroundCore) {
                if(world.getBlockState(pos).getBlock().getDefaultState().isOf(Blocks.WATER)) {
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                }
            }
        }
        return TypedActionResult.success(user.getMainHandStack());
    }
}

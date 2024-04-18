package com.example;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class HandheldSponge extends Item {

    public HandheldSponge(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        BlockHitResult hitResult = Item.raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);
        BlockPos pos1 = hitResult.getBlockPos();
        BlockState blockAt = world.getBlockState(pos1).getBlock().getDefaultState();
        if(blockAt.isOf(Blocks.WATER) || blockAt.isOf(Blocks.LAVA)) {
            world.setBlockState(pos1, Blocks.AIR.getDefaultState());
            world.playSound(user, pos1, SoundEvents.BLOCK_SPONGE_ABSORB, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        return TypedActionResult.success(user.getMainHandStack());
    }
}

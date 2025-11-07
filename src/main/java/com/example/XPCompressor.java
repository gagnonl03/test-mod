package com.example;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class XPCompressor extends Block {

    public static final IntProperty REMAINING = IntProperty.of("remaining", 0 ,10);

    public XPCompressor(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(REMAINING, 10));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        /*
        int exp = player.experienceLevel;
        ItemStack item = new ItemStack(ExampleMod.BOOK_ITEM, 1);
        if(exp < 10 && !player.getAbilities().creativeMode) {
            player.sendMessage(Text.literal("You need at least 10 levels to compress your XP"), true);
        } else {
            player.getInventory().offerOrDrop(item);
            player.experienceLevel -= 10;
            if(world.getBlockState(pos).get(REMAINING) <= 1) {
                world.breakBlock(pos, false);
            } else {
                world.setBlockState(pos, state.with(REMAINING, world.getBlockState(pos).get(REMAINING) - 1));
            }
        }

         */
        int exp = player.totalExperience;
        ItemStack item;
        if(exp < 160) {
            player.sendMessage(Text.literal("You need at least 160 XP to compress"), true);
        } else {
            item = new ItemStack(ExampleMod.EXTRA_XP_BOOK_ITEM, 1);
            player.giveItemStack(item);
            player.totalExperience -= 160;
        }


        /*
        int exp = player.totalExperience;
        ItemStack item;
        if(exp == 0) {
            player.sendMessage(Text.literal("You need XP to compress"), true);
        } else {
            if(exp < 160) {
                item = new ItemStack(ExampleMod.EXTRA_XP_BOOK_ITEM, 1);
                item.setDamage(160 - exp);
                player.addExperience(-player.totalExperience);
                player.addExperienceLevels(-player.experienceLevel);
            } else {
                item = new ItemStack(ExampleMod.BOOK_ITEM, 1);
                player.addExperience(-160);
                player.totalExperience -= 160;
            }
            player.getInventory().offerOrDrop(item);
            if(world.getBlockState(pos).get(REMAINING) <= 1) {
                world.breakBlock(pos, false);
            } else {
                world.setBlockState(pos, state.with(REMAINING, world.getBlockState(pos).get(REMAINING) - 1));
            }
        }

         */

        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(REMAINING);
    }
}

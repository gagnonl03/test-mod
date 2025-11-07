package com.example;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BookItem extends Item {


    public BookItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {


        ItemStack stack = player.getMainHandStack();
        player.addExperience(160);
        if(!player.getAbilities().creativeMode) {
            stack.decrement(1);
        }

        return TypedActionResult.success(player.getStackInHand(hand));
    }
}

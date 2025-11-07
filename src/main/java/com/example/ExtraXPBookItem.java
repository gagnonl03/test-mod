package com.example;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ExtraXPBookItem extends Item {

    public ExtraXPBookItem(Item.Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

        ItemStack stack = player.getMainHandStack();
        player.addExperience(160);
        stack.decrement(1);

        return TypedActionResult.success(player.getStackInHand(hand));
    }
}

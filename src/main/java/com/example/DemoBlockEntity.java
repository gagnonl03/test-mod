package com.example;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class DemoBlockEntity extends BlockEntity {

    private int number = 7;

    public DemoBlockEntity(BlockPos pos, BlockState state) {
        super(ExampleMod.DEMO_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        nbt.putInt("number", number);
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        number = nbt.getInt("number");
    }

    public void print() {
        System.out.println("hit!");
        System.out.println(number);
        number--;
        markDirty();
    }



}

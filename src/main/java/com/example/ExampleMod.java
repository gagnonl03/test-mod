package com.example;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	public static final Item CUSTOM_ITEM = new CustomItem(new FabricItemSettings().maxCount(16));
	public static final Block CUSTOM_BLOCK = new ExampleBlock(FabricBlockSettings.create().strength(2.0f).pistonBehavior(PistonBehavior.DESTROY).requiresTool());

	//or (also remove register method from onInitialize
	/*
	public static final Item CUSTOM_ITEM = Registry.register(Registries.ITEM, new Identifier("tutorial",
						"custom_item"), new Item(new FabricItemSettings()));
	 */


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registries.ITEM, new Identifier("tutorial", "custom_item"), CUSTOM_ITEM);
		Registry.register(Registries.BLOCK, new Identifier("tutorial", "example_block"), CUSTOM_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("tutorial", "example_block"), new BlockItem(CUSTOM_BLOCK, new FabricItemSettings()));

		LOGGER.info("Hello Fabric world!");
	}
}
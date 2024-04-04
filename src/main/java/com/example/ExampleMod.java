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
	public static final Item IRON_APPLE = new Item(new FabricItemSettings().food(ModFoodComponents.IRON_APPLE));
	public static final Item DIAMOND_NUGGET = new CustomItem(new FabricItemSettings());
	public static final Item DIAMOND_APPLE = new Item(new FabricItemSettings().food(ModFoodComponents.DIAMOND_APPLE));
	public static final Item EMERALD_APPLE = new Item(new FabricItemSettings().food(ModFoodComponents.EMERALD_APPLE));
	public static final Item LAPIS_APPLE = new Item(new FabricItemSettings().food(ModFoodComponents.LAPIS_APPLE));
	public static final Item COPPER_APPLE = new Item(new FabricItemSettings().food(ModFoodComponents.COPPER_APPLE));


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
		registerBlock("example_block", CUSTOM_BLOCK);
		registerItem("custom_item", CUSTOM_ITEM);
		registerItem("diamond_nugget", DIAMOND_NUGGET);
		registerItem("diamond_apple", DIAMOND_APPLE);
		registerItem("iron_apple", IRON_APPLE);
		registerItem("emerald_apple", EMERALD_APPLE);
		registerItem("lapis_apple", LAPIS_APPLE);
		registerItem("copper_apple", COPPER_APPLE);
	}
	private void registerItem(String name, Item item) {
		Registry.register(Registries.ITEM, new Identifier("tutorial", name), item);
	}

	private void registerBlock(String name, Block block) {
		Registry.register(Registries.BLOCK, new Identifier("tutorial", name), block);
		Registry.register(Registries.ITEM, new Identifier("tutorial", name), new BlockItem(block, new FabricItemSettings()));
	}
}
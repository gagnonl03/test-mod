package com.example;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.*;
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
	public static final Block XP_BLOCK = new XPCompressor(FabricBlockSettings.create().pistonBehavior(PistonBehavior.DESTROY));
	public static final Item IRON_APPLE = new Item(new FabricItemSettings().food(ModFoodComponents.IRON_APPLE));
	public static final Item DIAMOND_NUGGET = new CustomItem(new FabricItemSettings());
	public static final Item DIAMOND_APPLE = new Item(new FabricItemSettings().food(ModFoodComponents.DIAMOND_APPLE));
	public static final Item EMERALD_APPLE = new Item(new FabricItemSettings().food(ModFoodComponents.EMERALD_APPLE));
	public static final Item LAPIS_APPLE = new Item(new FabricItemSettings().food(ModFoodComponents.LAPIS_APPLE));
	public static final Item COPPER_APPLE = new Item(new FabricItemSettings().food(ModFoodComponents.COPPER_APPLE));
	public static final Item GLOWSTONE_APPLE = new Item(new FabricItemSettings().food(ModFoodComponents.GLOWSTONE_APPLE));
	public static final Item BOOK_ITEM = new BookItem(new FabricItemSettings().maxCount(32));
	public static final Block DEMO_BLOCK = new DemoBlock(FabricBlockSettings.create().pistonBehavior(PistonBehavior.IGNORE));
	public static final Block REPAIRER_BLOCK = new RepairerBlock(FabricBlockSettings.create());
	public static final Item INFINITE_LAVA_BUCKET = new InfiniteLavaBucket(new FabricItemSettings().maxCount(1));
	public static final Item EXTRA_XP_BOOK_ITEM = new ExtraXPBookItem(new FabricItemSettings().maxDamage(160));
	public static final BlockEntityType<DemoBlockEntity> DEMO_BLOCK_ENTITY = Registry.register(
			Registries.BLOCK_ENTITY_TYPE,
			new Identifier("tutorial", "demo_block_entity"),
			FabricBlockEntityTypeBuilder.create(DemoBlockEntity::new, DEMO_BLOCK).build()
	);

	public static final Block INFINITE_LAVA_BLOCK = new InfiniteLavaBlock(FabricBlockSettings.create().pistonBehavior(PistonBehavior.BLOCK));
	public static final Item INFINITE_WATER_BUCKET = new InfiniteWaterBucket(new FabricItemSettings().maxCount(1));
	public static final Item HANDHELD_SPONGE = new HandheldSponge(new FabricItemSettings().maxCount(1));
	public static final Item SUPER_ABSORBENT_SPONGE = new SuperAbsorbantSponge(new FabricItemSettings().maxCount(1));
	public static final Block FLUSH_XP_BLOCK = new FlushXPBlock(FabricBlockSettings.create());


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
		registerBlock("xp_compressor", XP_BLOCK);
		registerItem("custom_item", CUSTOM_ITEM);
		registerItem("diamond_nugget", DIAMOND_NUGGET);
		registerItem("diamond_apple", DIAMOND_APPLE);
		registerItem("iron_apple", IRON_APPLE);
		registerItem("emerald_apple", EMERALD_APPLE);
		registerItem("lapis_apple", LAPIS_APPLE);
		registerItem("copper_apple", COPPER_APPLE);
		registerItem("book", BOOK_ITEM);
		registerBlock("entity_block", DEMO_BLOCK);
		registerBlock("infinite_lava_block", INFINITE_LAVA_BLOCK);
		registerItem("glowstone_apple", GLOWSTONE_APPLE);
		registerItem("infinite_lava_bucket", INFINITE_LAVA_BUCKET);
		registerItem("infinite_water_bucket", INFINITE_WATER_BUCKET);
		registerItem("handheld_sponge", HANDHELD_SPONGE);
		registerItem("super_absorbent_sponge", SUPER_ABSORBENT_SPONGE);
		registerItem("extra_xp_book_item", EXTRA_XP_BOOK_ITEM);
		registerBlock("flush_xp", FLUSH_XP_BLOCK);
		registerBlock("repairer_block", REPAIRER_BLOCK);
	}
	private void registerItem(String name, Item item) {
		Registry.register(Registries.ITEM, new Identifier("tutorial", name), item);
	}

	private void registerBlock(String name, Block block) {
		Registry.register(Registries.BLOCK, new Identifier("tutorial", name), block);
		Registry.register(Registries.ITEM, new Identifier("tutorial", name), new BlockItem(block, new FabricItemSettings()));
	}
}

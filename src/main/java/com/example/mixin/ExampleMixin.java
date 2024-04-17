package com.example.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Items.class)
public class ExampleMixin {
	/**
	//@Inject(at = @At("HEAD"), method = "register(Lnet/minecraft/item/BlockItem)")
	private void init(CallbackInfo info) {
		// This code is injected into the start of MinecraftServer.loadWorld()V
	}
	*/
	/*
	@ModifyConstant(method = "<clinit>", constant = @Constant(stringValue = "ender_pearl"))
	private static String injectEPInto(String test) {
		return "old_ender_pearl";
	}

	@ModifyConstant(method = "<clinit>", constant = @Constant(stringValue = "splash_potion"))
	private static String injectSplashInto(String test) {
		return "old_splash_potion";
	}

	 */


}
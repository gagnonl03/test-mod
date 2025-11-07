package com.example.mixin;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(Item.class)
public class ExampleMixin {

	private static final String MINECRAFT = "minecraft";
	@Shadow @Final @Mutable private int maxCount;
	@Shadow private String translationKey;
	private final List<Identifier> singleStack16 = List.of(
			identifier("potion"),
			identifier("splash_potion"),
			identifier("lingering_potion"),
			identifier("mushroom_stew"),
			identifier("water_bucket"),
			identifier("lava_bucket"),
			identifier("powder_snow_bucket"),
			identifier("milk_bucket"),
			identifier("pufferfish_bucket"),
			identifier("salmon_bucket"),
			identifier("cod_bucket"),
			identifier("tropical_fish_bucket"),
			identifier("salmon_bucket"),
			identifier("axolotl_bucket"),
			identifier("tadpole_bucket"),
			identifier("rabbit_stew"),
			identifier("iron_horse_armor"),
			identifier("golden_horse_armor"),
			identifier("diamond_horse_armor"),
			identifier("leather_horse_armor"),
			identifier("beetroot_soup"),
			identifier("totem_of_undying"),
			identifier("music_disc_13"),
			identifier("music_disc_cat"),
			identifier("music_disc_blocks"),
			identifier("music_disc_chirp"),
			identifier("music_disc_far"),
			identifier("music_disc_mall"),
			identifier("music_disc_mellohi"),
			identifier("music_disc_stal"),
			identifier("music_disc_strad"),
			identifier("music_disc_ward"),
			identifier("music_disc_11"),
			identifier("music_disc_wait"),
			identifier("music_disc_otherside"),
			identifier("music_disc_relic"),
			identifier("music_disc_5"),
			identifier("music_disc_pigstep"),
			identifier("suspicious_stew")


	);
	private final List<Identifier> stack64 = List.of(
			identifier("saddle"),
			identifier("minecart"),
			identifier("chest_minecart"),
			identifier("tnt_minecart"),
			identifier("hopper_minecart"),
			identifier("oak_boat"),
			identifier("oak_chest_boat"),
			identifier("spruce_boat"),
			identifier("spruce_chest_boat"),
			identifier("birch_boat"),
			identifier("birch_chest_boat"),
			identifier("jungle_boat"),
			identifier("jungle_chest_boat"),
			identifier("acacia_boat"),
			identifier("acacia_chest_boat"),
			identifier("cherry_boat"),
			identifier("cherry_chest_boat"),
			identifier("dark_oak_boat"),
			identifier("dark_oak_chest_boat"),
			identifier("mangrove_boat"),
			identifier("mangrove_chest_boat"),
			identifier("bamboo_raft"),
			identifier("bamboo_chest_raft"),
			identifier("cake"),
			identifier("flower_banner_pattern"),
			identifier("creeper_banner_pattern"),
			identifier("skull_banner_pattern"),
			identifier("mojang_banner_pattern"),
			identifier("globe_banner_pattern"),
			identifier("piglin_banner_pattern")
	);

	@Inject(method = "getMaxCount", at = @At("HEAD"), cancellable = true)
	private void injectGetMaxCount(CallbackInfoReturnable<Integer> cir) {
		if(maxCount == 16) {
			cir.setReturnValue(64);
		}
		Identifier id = Registries.ITEM.getId((Item)(Object)this);
		for(Identifier otherId : singleStack16) {
			if(id.equals(otherId)) {
				cir.setReturnValue(16);
			}
		}
		for(Identifier otherId : stack64) {
			if(id.equals(otherId)) {
				cir.setReturnValue(64);
			}
		}
	}


	/*
	@Inject(method = "<init>", at = @At("TAIL"))
	private void injectConstructor(Item.Settings settings, CallbackInfo ci) {
		if(((SettingsMixin) settings).getMaxCount() == 16) {
			this.maxCount = 64;
		}
		Identifier id = Registries.ITEM.getId((Item)(Object)this);
		System.out.println("checking: " + id.getPath());
		for(Identifier otherId : singleStack16) {
			if(id.equals(otherId)) {
				this.maxCount = 16;
				break;
			}
		}
		for(Identifier otherId : stack64) {
			if(id.equals(otherId)) {
				this.maxCount = 64;
				break;
			}
		}
	}
	*/



	private Identifier identifier(String name) {
		return new Identifier("minecraft", name);
	}

}

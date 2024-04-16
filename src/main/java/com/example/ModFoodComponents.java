package com.example;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent IRON_APPLE = new FoodComponent.Builder().hunger(3)
            .saturationModifier(2.0f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200), 1.0f)
            .build();

    public static final FoodComponent DIAMOND_APPLE = new FoodComponent.Builder().hunger(3)
            .saturationModifier(2.0f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1000), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1000), 1.0f)
            .build();

    public static final FoodComponent EMERALD_APPLE = new FoodComponent.Builder().hunger(3)
            .saturationModifier(2.0f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1000), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 1000), 1.0f)
            .build();

    public static final FoodComponent LAPIS_APPLE = new FoodComponent.Builder().hunger(3)
            .saturationModifier(2.0f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1000), 1.0f)
            .build();

    public static final FoodComponent COPPER_APPLE = new FoodComponent.Builder().hunger(5)
            .saturationModifier(3.0f)
            .alwaysEdible()
            .build();

    public static final FoodComponent GLOWSTONE_APPLE = new FoodComponent.Builder().hunger(1)
            .saturationModifier(1.0f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1000), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1000), 1.0f)
            .build();

    public static final FoodComponent DULL_MELON = new FoodComponent.Builder().hunger(5)
            .saturationModifier(4.0f)
            .build();

    public static final FoodComponent SHINING_MELON = new FoodComponent.Builder().hunger(5)
            .saturationModifier(4.0f)
            .build();

    public static final FoodComponent IRON_CARROT = new FoodComponent.Builder().hunger(5)
            .saturationModifier(1.0f)
            .build();

    public static final FoodComponent DIAMOND_CARROT = new FoodComponent.Builder().hunger(5)
            .saturationModifier(1.0f)
            .build();

    public static final FoodComponent COPPER_CARROT = new FoodComponent.Builder().hunger(6)
            .saturationModifier(1.0f)
            .build();

}

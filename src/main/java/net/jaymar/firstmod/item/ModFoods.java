package net.jaymar.firstmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RAW_ONION =
            new FoodProperties.Builder().fast()
                    .nutrition(1)
                    .saturationMod(0.1f)
                    .effect(()->new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100), 0.1f).build();
    public static final FoodProperties CHOPPED_ONION =
            new FoodProperties.Builder().fast()
                    .nutrition(1)
                    .saturationMod(0.1f)
                    .effect(()->new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120), 0.1f).build();

    public static final FoodProperties CHEESE =
            new FoodProperties.Builder().fast()
                    .nutrition(2)
                    .saturationMod(0.2f)
                    .effect(()->new MobEffectInstance(MobEffects.REGENERATION, 20, 2), 0.2f).build();

    public static final FoodProperties LETTUCE =
            new FoodProperties.Builder().fast()
                    .nutrition(1)
                    .saturationMod(0.2f).build();

    public static final FoodProperties RAW_BEEF_PATTY =
            new FoodProperties.Builder().meat()
                    .nutrition(3)
                    .saturationMod(0.4f).build();

    public static final FoodProperties COOKED_BEEF_PATTY =
            new FoodProperties.Builder().meat()
                    .nutrition(5)
                    .saturationMod(0.5f).build();

    public static final FoodProperties BURGER =
            new FoodProperties.Builder().meat()
                    .nutrition(7)
                    .saturationMod(0.6f)
                    .effect(()-> new MobEffectInstance(MobEffects.REGENERATION, 100, 2), 1f)
                    .effect(()-> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 1), 1f).build();

    public static final FoodProperties STRAWBERRY =
            new FoodProperties.Builder().fast()
                    .nutrition(1)
                    .saturationMod(0.5f).build();
}

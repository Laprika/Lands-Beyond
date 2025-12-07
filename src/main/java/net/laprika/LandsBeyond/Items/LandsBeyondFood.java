package net.laprika.LandsBeyond.Items;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class LandsBeyondFood {

    public static final FoodProperties DAWNGOLD_APPLE = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.5F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 400), 1)
            .alwaysEdible().build();

}

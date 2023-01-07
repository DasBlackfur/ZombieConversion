package me.blackfur.zombieconversion;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.GameRules;

public class Zombieconversion implements ModInitializer {
    public static GameRules.RuleKey<GameRules.BooleanRule> GUARANTEED_CONVERSION;

    @Override
    public void onInitialize() {
        GUARANTEED_CONVERSION = GameRules.register("guaranteedConversion", GameRules.BooleanRule.create(false));
    }
}
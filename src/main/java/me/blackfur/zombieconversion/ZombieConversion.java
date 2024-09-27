package me.blackfur.zombieconversion;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class ZombieConversion implements ModInitializer {
    public static GameRules.Key<GameRules.BooleanRule> GUARANTEED_CONVERSION;

    @Override
    public void onInitialize() {
        GUARANTEED_CONVERSION = GameRuleRegistry.register("guaranteedConversion", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(false));
    }
}
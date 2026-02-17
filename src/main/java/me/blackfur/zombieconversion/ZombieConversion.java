package me.blackfur.zombieconversion;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.rule.GameRule;

public class ZombieConversion implements ModInitializer {
    public static final GameRule<ConversionSetting> GUARANTEED_CONVERSION = GameRuleBuilder.forEnum(ConversionSetting.VANILLA).buildAndRegister(Identifier.of("zombieconversion", "guaranteed_conversion"));
    @Override
    public void onInitialize() {
    }
}
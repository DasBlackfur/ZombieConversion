package me.blackfur.zombieconversion;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.gamerules.GameRule;

public class ZombieConversion implements ModInitializer {
    public static final GameRule<ConversionSetting> GUARANTEED_CONVERSION = GameRuleBuilder.forEnum(ConversionSetting.VANILLA).buildAndRegister(Identifier.fromNamespaceAndPath("zombieconversion", "guaranteed_conversion"));
    @Override
    public void onInitialize() {
    }
}
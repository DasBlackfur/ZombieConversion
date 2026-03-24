package me.blackfur.zombieconversion.mixin;

import me.blackfur.zombieconversion.ConversionSetting;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.monster.zombie.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static me.blackfur.zombieconversion.ZombieConversion.GUARANTEED_CONVERSION;

@Mixin(Zombie.class)
public class ZombieConversionMixin {
    @Redirect(method = "killedEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;getDifficulty()Lnet/minecraft/world/Difficulty;"))
    private Difficulty injected(ServerLevel serverWorld) {
        var gameRuleSetting = serverWorld.getGameRules().get(GUARANTEED_CONVERSION);
        if (gameRuleSetting == ConversionSetting.ALWAYS) {
            return Difficulty.HARD;
        } else if (gameRuleSetting == ConversionSetting.NEVER) {
            return Difficulty.EASY;
        }
        return serverWorld.getDifficulty();
    }
}

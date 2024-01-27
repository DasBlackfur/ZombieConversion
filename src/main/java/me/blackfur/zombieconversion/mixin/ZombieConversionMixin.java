package me.blackfur.zombieconversion.mixin;

import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static me.blackfur.zombieconversion.Zombieconversion.GUARANTEED_CONVERSION;

@Mixin(ZombieEntity.class)
public class ZombieConversionMixin {
    @Redirect(method = "onKilledOther", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;getDifficulty()Lnet/minecraft/world/Difficulty;"))
    private Difficulty injected(ServerWorld serverWorld) {
        if (serverWorld.getGameRules().getBoolean(GUARANTEED_CONVERSION)) {
            return Difficulty.HARD;
        }
        return serverWorld.getDifficulty();
    }
}

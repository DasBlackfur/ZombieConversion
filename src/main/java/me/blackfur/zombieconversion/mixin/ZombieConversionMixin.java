package me.blackfur.zombieconversion.mixin;

import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static me.blackfur.zombieconversion.Zombieconversion.GUARANTEED_CONVERSION;

@Mixin(ZombieEntity.class)
public class ZombieConversionMixin {
    @Redirect(method = "onKilledOther(Lnet/minecraft/entity/LivingEntity;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getDifficulty()Lnet/minecraft/world/Difficulty;"))
    private Difficulty injected(World instance) {
        if (instance.getGameRules().getBoolean(GUARANTEED_CONVERSION)) {
            return Difficulty.HARD;
        }
        return instance.getDifficulty();
    }
}

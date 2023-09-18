package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.mixin;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.tool.ModComponents;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

import static com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.data.PlayerData.BASE_HEALTH_LIST;
import static com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.data.PlayerData.TRAINING_LEVEL_LIST;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin {
    @Inject(method = "onPlayerRespawned", at = @At("TAIL"))
    public void injectOnPlayerRespawned(ServerPlayerEntity player, CallbackInfo info) {
        int training = player.getComponent(ModComponents.PLAYER_DATA).getTraining();

        // Set health
        for (int i = 0; i < TRAINING_LEVEL_LIST.length; i++) {
            if (training < TRAINING_LEVEL_LIST[i]) {
                Objects.requireNonNull(player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(BASE_HEALTH_LIST[i]);
                player.setHealth((float) Objects.requireNonNull(player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).getValue());
                break;
            }
        }

        // Set spirit root
        if (!player.server.getGameRules().getBoolean(GameRules.KEEP_INVENTORY)) {
            player.getComponent(ModComponents.PLAYER_DATA).syncProvider(player);
            player.getComponent(ModComponents.PLAYER_DATA).emptyPlayerSpiritRoot();
            player.getComponent(ModComponents.PLAYER_DATA).initPlayerSpiritRoot();
        }

        // set energy
        player.getComponent(ModComponents.PLAYER_DATA).syncProvider(player);
        player.getComponent(ModComponents.PLAYER_DATA).initPlayerMaxEnergy();
        player.getComponent(ModComponents.PLAYER_DATA).initPlayerEnergy();
    }

    @Inject(method = "onPlayerConnected", at = @At("TAIL"))
    public void injectOnPlayerConnected(ServerPlayerEntity player, CallbackInfo info) {
        // Set spirit root
        while (!player.getComponent(ModComponents.PLAYER_DATA).ifContainsSpiritRoot()) {
            player.getComponent(ModComponents.PLAYER_DATA).syncProvider(player);
            player.getComponent(ModComponents.PLAYER_DATA).initPlayerSpiritRoot();
        }

        // set energy
        player.getComponent(ModComponents.PLAYER_DATA).syncProvider(player);
        player.getComponent(ModComponents.PLAYER_DATA).initPlayerMaxEnergy();
        player.getComponent(ModComponents.PLAYER_DATA).initPlayerEnergy();
    }
}

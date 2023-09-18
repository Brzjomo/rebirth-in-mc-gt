package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.network;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.RebirthInMCIHaveASystemForCultivatingImmortals;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.network.packet.TrainingC2SPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModPacketsC2S {
    public static final Identifier TRAINING_S2C = new Identifier(RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID, "training_s2c");
    public static final Identifier TRAINING_C2S = new Identifier(RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID, "training_c2s");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(TRAINING_C2S, TrainingC2SPacket::receive);
    }
}

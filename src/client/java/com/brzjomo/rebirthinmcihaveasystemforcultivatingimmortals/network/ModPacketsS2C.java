package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.network;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.RebirthInMCIHaveASystemForCultivatingImmortals;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

public class ModPacketsS2C {
    public static final Identifier TRAINING_S2C = new Identifier(RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID, "training_s2c");
    public static final Identifier TRAINING_C2S = new Identifier(RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID, "training_c2s");

    public static void registerS2CPackets() {
//        ClientPlayNetworking.registerGlobalReceiver(TRAINING_S2C, TrainingS2CPacket::receive);
    }
}

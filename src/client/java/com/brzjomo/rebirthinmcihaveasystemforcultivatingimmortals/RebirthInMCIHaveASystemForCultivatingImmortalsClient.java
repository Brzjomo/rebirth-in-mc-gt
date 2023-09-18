package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.client.gui.hud.EnergyHud;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.client.gui.hud.TrainingHud;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.event.KeyInputHandler;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.network.ModPacketsS2C;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class RebirthInMCIHaveASystemForCultivatingImmortalsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Register KeyBinding
        KeyInputHandler.register();

        // Register Packets
        ModPacketsS2C.registerS2CPackets();

        // Register Events
        HudRenderCallback.EVENT.register(new TrainingHud());
        HudRenderCallback.EVENT.register(new EnergyHud());
    }
}
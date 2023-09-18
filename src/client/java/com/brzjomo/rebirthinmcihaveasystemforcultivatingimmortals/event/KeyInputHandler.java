package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.event;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.RebirthInMCIHaveASystemForCultivatingImmortals;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.client.gui.screen.PlayerStatisticsScreen;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.network.ModPacketsS2C;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import java.util.Objects;

public class KeyInputHandler {
    public static final String KEY_REBIRTH_IN_MC_I_HAVE_A_SYSTEM_FOR_CULTIVATING_IMMORTALS_CATEGORY = "key." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".category";
    public static final String KEY_MAIN_SYSTEM = "key." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".main_system";

    // KeyBinding
    public static KeyBinding mainSystemKey;

    // Key Function
    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (mainSystemKey.isPressed()) {
                if (client.currentScreen instanceof PlayerStatisticsScreen) {
                    Objects.requireNonNull(client.player).closeHandledScreen();
                } else {
                    client.setScreen(new PlayerStatisticsScreen(client.currentScreen));
                }
                // test
                ClientPlayNetworking.send(ModPacketsS2C.TRAINING_C2S, PacketByteBufs.create());
            }
        });
    }

    // Register KeyBinding
    public static void register() {
        mainSystemKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(KEY_MAIN_SYSTEM, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_Z, KEY_REBIRTH_IN_MC_I_HAVE_A_SYSTEM_FOR_CULTIVATING_IMMORTALS_CATEGORY));

        registerKeyInputs();
    }
}

package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.init.ModItemGroups;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.init.ModItems;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.network.ModPacketsC2S;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Objects;

public class RebirthInMCIHaveASystemForCultivatingImmortals implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("rebirthinmcihaveasystemforcultivatingimmortals");
    public static final String MOD_ID = "rebirthinmcihaveasystemforcultivatingimmortals";
    public static final boolean IS_DEBUG = true;

    @Override
    public void onInitialize() {
        // Debug
        LOGGER.info("EquipmentSlot Type Enum Num: " + EquipmentSlot.Type.values().length);
        LOGGER.info("EquipmentSlot Type Enum: " + Arrays.toString(EquipmentSlot.Type.values()));

        LOGGER.info("EquipmentSlot Enum Num: " + EquipmentSlot.values().length);
        LOGGER.info("EquipmentSlot Enum: " + Arrays.toString(EquipmentSlot.values()));

        // Register Packets
        ModPacketsC2S.registerC2SPackets();

        // Register Items
        for (Item i : ModItems.ITEM_LIST) {
            Registry.register(Registries.ITEM, ModItems.getId(i), i);
        }

        // Register Item Groups
        for (ItemGroup i : ModItemGroups.MOD_ITEM_GROUP_LIST) {
            Registry.register(Registries.ITEM_GROUP, ModItemGroups.getId(i), i);

            // Modify Item Groups
            if (Objects.equals(ModItemGroups.getPath(i), ModItemGroups.MOD_GROUP_MAIN_PATH)) {
                ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID, Objects.requireNonNull(ModItemGroups.getPath(i))))).register(content -> {
                    content.add(Items.EGG);
                });
            }
        }
    }
}
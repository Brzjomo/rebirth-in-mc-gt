package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.asm;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.RebirthInMCIHaveASystemForCultivatingImmortals;
import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.entity.EquipmentSlot;

public class EarlyRiser implements Runnable {
    @Override
    public void run() {
        MappingResolver mappingResolver = FabricLoader.getInstance().getMappingResolver();

        // EquipmentSlotType
//        String equipmentSlotType = mappingResolver.mapClassName("intermediary", "net.minecraft.class_1304$class_1305");
//        ClassTinkerers.enumBuilder(equipmentSlotType).addEnum("ORNAMENT").build();
//        ClassTinkerers.enumBuilder(equipmentSlotType).addEnum("PROP").build();
//        ClassTinkerers.enumBuilder(equipmentSlotType).addEnum("TALISMAN").build();

        // EquipmentSlot
        String equipmentSlotTypePath = 'L' + mappingResolver.mapClassName("intermediary", "net.minecraft.class_1304$class_1305") + ';';
        String equipmentSlot = mappingResolver.mapClassName("intermediary", "net.minecraft.class_1304");
        ClassTinkerers.enumBuilder(equipmentSlot, equipmentSlotTypePath, int.class, int.class, String.class).addEnum("FACE", () -> new Object[] {EquipmentSlot.Type.ARMOR, 0, 6, "face"}).build();
    }
}

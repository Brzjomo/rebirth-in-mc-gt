package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.mixin;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.tool.ISlot;
import net.minecraft.screen.ScreenHandler;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ScreenHandler.class)
public class ScreenHandlerMixin implements ISlot {
    @Override
    public void removeSlot(int count) {
        int lastSerialNumForSlots = ((ScreenHandler) (Object) this).slots.size() - 1;
        int lastSerialNumForTrackedStacks = ((ScreenHandler) (Object) this).trackedStacks.size() - 1;
        int lastSerialNumForPreviousTrackedStacks = ((ScreenHandler) (Object) this).previousTrackedStacks.size() - 1;

        for (int i = 0; i < count; i++) {
            ((ScreenHandler) (Object) this).slots.remove(lastSerialNumForSlots);
            lastSerialNumForSlots--;

            ((ScreenHandler) (Object) this).trackedStacks.remove(lastSerialNumForTrackedStacks);
            lastSerialNumForTrackedStacks--;

            ((ScreenHandler) (Object) this).previousTrackedStacks.remove(lastSerialNumForPreviousTrackedStacks);
            lastSerialNumForPreviousTrackedStacks--;
        }
    }

    @Override
    public void clearSlot() {
        ((ScreenHandler) (Object) this).slots.clear();
        ((ScreenHandler) (Object) this).trackedStacks.clear();
        ((ScreenHandler) (Object) this).previousTrackedStacks.clear();
    }
}

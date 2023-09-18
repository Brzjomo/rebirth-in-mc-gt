package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.slot.CraftingResultSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerScreenHandler.class)
public class PlayerScreenHandlerMixin {
    private static final EquipmentSlot[] EQUIPMENT_SLOT_ORDER = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
    private static final Identifier[] EMPTY_ARMOR_SLOT_TEXTURES = new Identifier[]{PlayerScreenHandler.EMPTY_BOOTS_SLOT_TEXTURE, PlayerScreenHandler.EMPTY_LEGGINGS_SLOT_TEXTURE, PlayerScreenHandler.EMPTY_CHESTPLATE_SLOT_TEXTURE, PlayerScreenHandler.EMPTY_HELMET_SLOT_TEXTURE};

    @Inject(method = "<init>*", at = @At("TAIL"))
    public void injectedConstructorInit(PlayerInventory inventory, boolean onServer, final PlayerEntity owner, CallbackInfo info) {
        // Remove All Inventory Slots
//        ((PlayerScreenHandler) (Object) this).removeSlot(1 + 9 + 27 + 4 + 4 + 1);
        ((PlayerScreenHandler) (Object) this).clearSlot();

        // Add Crafting Result Slots - 0
        ((PlayerScreenHandler) (Object) this).addSlot(new CraftingResultSlot(inventory.player, ((PlayerScreenHandler) (Object) this).craftingInput, ((PlayerScreenHandler) (Object) this).craftingResult, 0, 135, 74));

        // Add Crafting Input Slots - 0-3
        int i;
        for (i = 0; i < 2; ++i) {
            for (int j = 0; j < 2; ++j) {
                ((PlayerScreenHandler) (Object) this).addSlot(new Slot(((PlayerScreenHandler) (Object) this).craftingInput, j + i * 2, 126 + j * 18, 16 + i * 18));
            }
        }

        // Add Equipment Slots - 36-39
        // Base
        for (i = 0; i < 4; ++i) {
            final EquipmentSlot equipmentSlot = EQUIPMENT_SLOT_ORDER[i];
            ((PlayerScreenHandler) (Object) this).addSlot(new Slot(inventory, 39 - i, 8, 8 + i * 18) {

                @Override
                public void setStack(ItemStack stack) {
                    PlayerScreenHandler.onEquipStack(owner, equipmentSlot, stack, this.getStack());
                    super.setStack(stack);
                }

                @Override
                public int getMaxItemCount() {
                    return 1;
                }

                @Override
                public boolean canInsert(ItemStack stack) {
                    return equipmentSlot == MobEntity.getPreferredEquipmentSlot(stack);
                }

                @Override
                public boolean canTakeItems(PlayerEntity playerEntity) {
                    ItemStack itemStack = this.getStack();
                    if (!itemStack.isEmpty() && !playerEntity.isCreative() && EnchantmentHelper.hasBindingCurse(itemStack)) {
                        return false;
                    }
                    return super.canTakeItems(playerEntity);
                }

                @Override
                public Pair<Identifier, Identifier> getBackgroundSprite() {
                    return Pair.of(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE, EMPTY_ARMOR_SLOT_TEXTURES[equipmentSlot.getEntitySlotId()]);
                }
            });
        }

        // Add Main Inventory Slots - 9-35
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                ((PlayerScreenHandler) (Object) this).addSlot(new Slot(inventory, j + (i + 1) * 9, 8 + j * 18, 102 + i * 18));
            }
        }

        // Add HotBar Slots - 0-8
        for (i = 0; i < 9; ++i) {
            ((PlayerScreenHandler) (Object) this).addSlot(new Slot(inventory, i, 8 + i * 18, 160));
        }

        // Add OffHand Slots - 40
        ((PlayerScreenHandler) (Object) this).addSlot(new Slot(inventory, 40, 77, 62) {

            @Override
            public void setStack(ItemStack stack) {
                PlayerScreenHandler.onEquipStack(owner, EquipmentSlot.OFFHAND, stack, this.getStack());
                super.setStack(stack);
            }

            @Override
            public Pair<Identifier, Identifier> getBackgroundSprite() {
                return Pair.of(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE, PlayerScreenHandler.EMPTY_OFFHAND_ARMOR_SLOT);
            }
        });
    }
}

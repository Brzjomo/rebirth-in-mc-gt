package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.init;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.RebirthInMCIHaveASystemForCultivatingImmortals;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class ModItemGroups {
    // ItemGroup List Path
    public static final String MOD_GROUP_MAIN_PATH = "group_main";

    // ItemGroups
    public static final ItemGroup MOD_GROUP_MAIN = FabricItemGroup.builder().icon(() -> new ItemStack(Items.ACACIA_SIGN)).displayName(Text.translatable("itemGroup." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + "." + MOD_GROUP_MAIN_PATH)).build();

    // ItemGroup List
    public static final ItemGroup[] MOD_ITEM_GROUP_LIST = {MOD_GROUP_MAIN};

    // Get Path
    public static String getPath(ItemGroup itemGroupIn) {
        if (itemGroupIn.equals(MOD_GROUP_MAIN)) {
            return MOD_GROUP_MAIN_PATH;
        } else {
            return null;
        }
    }

    // Get ID
    public static Identifier getId(ItemGroup itemGroupIn) {
        return new Identifier(RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID, Objects.requireNonNull(getPath(itemGroupIn)));
    }
}

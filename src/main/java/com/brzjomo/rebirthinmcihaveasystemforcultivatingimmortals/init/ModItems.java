package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.init;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.RebirthInMCIHaveASystemForCultivatingImmortals;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class ModItems {
    // Items

    // ItemList
    public static final Item[] ITEM_LIST = {};

    // Item Path

    // Get Path
    public static String getPath(Item itemIn) {
        if (itemIn.equals(null)) {
            return null;
        } else if (itemIn.equals(null)) {
            return null;
        } else {
            return null;
        }
    }

    // Get ID
    public static Identifier getId(Item itemIn) {
        return new Identifier(RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID, Objects.requireNonNull(getPath(itemIn)));
    }
}

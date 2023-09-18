package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.tool;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.RebirthInMCIHaveASystemForCultivatingImmortals;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.data.PlayerData;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import net.minecraft.util.Identifier;

public final class ModComponents implements EntityComponentInitializer {
    public static final ComponentKey<IPlayerData> PLAYER_DATA = ComponentRegistry.getOrCreate(new Identifier(RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID, "player_data"), IPlayerData.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(PLAYER_DATA, playerEntity -> new PlayerData(), RespawnCopyStrategy.ALWAYS_COPY);
    }
}

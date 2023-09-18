package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.network.packet;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.RebirthInMCIHaveASystemForCultivatingImmortals;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.data.PlayerData;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.tool.ModComponents;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Objects;

import static com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.data.PlayerData.BASE_HEALTH_LIST;
import static com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.data.PlayerData.TRAINING_LEVEL_LIST;

public class TrainingC2SPacket {
//    public static final EntityAttributeModifier TEST_MODIFY = new EntityAttributeModifier("custom_max_health", 50.0D, EntityAttributeModifier.Operation.ADDITION);
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender sender) {
        if (server.getTicks() % 2 == 0) {
            Objects.requireNonNull(player).sendMessage(Text.translatable("message." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".test", player.getComponent(ModComponents.PLAYER_DATA).getTraining()).formatted(Formatting.BOLD), true);
            player.getComponent(ModComponents.PLAYER_DATA).syncProvider(player);
            player.getComponent(ModComponents.PLAYER_DATA).addTraining(1);

//            player.getComponent(ModComponents.PLAYER_DATA).addPlayerSpiritRoot(PlayerData.SPIRIT_ROOT_THUNDER, 100);
            player.sendMessageToClient(Text.of(player.getComponent(ModComponents.PLAYER_DATA).printPlayerSpiritRoot()), true);

            // Player fly speed change test -> Work well
//            player.abilities.flySpeed = 0.15F;
//            player.sendAbilitiesUpdate();
//            RebirthInMCIHaveASystemForCultivatingImmortals.LOGGER.info("Y: " + player.getAbilities().flySpeed);

            // Player max health modify test -> Work well
//            if (player.getMaxHealth() < 50) {
//                Objects.requireNonNull(player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(50D);
//                Objects.requireNonNull(player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).addPersistentModifier(TrainingC2SPacket.TEST_MODIFY);
//            }
//            if (player.getHealth() <= 10) {
////                Objects.requireNonNull(player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).clearModifiers();
//                Objects.requireNonNull(player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).removeModifier(TrainingC2SPacket.TEST_MODIFY);
//            }

            // add MaxHealth
            int training = player.getComponent(ModComponents.PLAYER_DATA).getTraining();

            for (int i = 0; i < TRAINING_LEVEL_LIST.length; i++) {
                if (training < TRAINING_LEVEL_LIST[i]) {
                    Objects.requireNonNull(player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(BASE_HEALTH_LIST[i]);
                    player.setHealth((float) Objects.requireNonNull(player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).getValue());
                    break;
                }
            }
        }
    }
}

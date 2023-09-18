package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.client.gui.hud;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.data.PlayerData;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.tool.ColorConvertTool;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.tool.ModComponents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

import java.util.Objects;

public class EnergyHud implements HudRenderCallback {
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        int windowWidth = client.getWindow().getScaledWidth();
        int windowHeight = client.getWindow().getScaledHeight();
        TextRenderer textRenderer = client.textRenderer;

        // Energy Bar
        // In game window
        int drawingPositionX = windowWidth / 2 - 91;
        int drawingPositionY = windowHeight - 48 - 1;

        // In texture map
        int emptyBarTexturePositionX = 0;
        int emptyBarTexturePositionY = 36;
        int valuedBarTexturePositionX = 0;
        int valuedBarTexturePositionY = 45;
        int textureWidth = 100;
        int textureHeight = 9;

        boolean ifForceUnicodeFont = client.options.getForceUnicodeFont().getValue();

        // Energy Text
        String energyText = Objects.requireNonNull(client.player).getComponent(ModComponents.PLAYER_DATA).getEnergy() + "/" + Objects.requireNonNull(client.player).getComponent(ModComponents.PLAYER_DATA).getMaxEnergy();
        // In texture map
        int energyTextDrawingPositionX = drawingPositionX + textureWidth / 2 - textRenderer.getWidth(energyText) / 2;
        int energyTextDrawingPositionY = windowHeight - 48;

        // init color
        String mostTalentedSpiritRoot = client.player.getComponent(ModComponents.PLAYER_DATA).getMostTalentedSpiritRoot();

        emptyBarTexturePositionY = switch (mostTalentedSpiritRoot) {
            case PlayerData.SPIRIT_ROOT_METAL -> 36;
            case PlayerData.SPIRIT_ROOT_WOOD -> 36 + 18;
            case PlayerData.SPIRIT_ROOT_WATER -> 36 + 18 * 2;
            case PlayerData.SPIRIT_ROOT_FIRE -> 36 + 18 * 3;
            case PlayerData.SPIRIT_ROOT_EARTH -> 36 + 18 * 4;
            case PlayerData.SPIRIT_ROOT_THUNDER -> 36 + 18;
            case PlayerData.SPIRIT_ROOT_WIND -> 36 + 18;
            case PlayerData.SPIRIT_ROOT_ICE -> 36 + 18 * 2;
            case PlayerData.SPIRIT_ROOT_BLOOD -> 36 + 18;
            default -> 0;
        };

        valuedBarTexturePositionY = switch (mostTalentedSpiritRoot) {
            case PlayerData.SPIRIT_ROOT_METAL -> 45;
            case PlayerData.SPIRIT_ROOT_WOOD -> 45 + 18;
            case PlayerData.SPIRIT_ROOT_WATER -> 45 + 18 * 2;
            case PlayerData.SPIRIT_ROOT_FIRE -> 45 + 18 * 3;
            case PlayerData.SPIRIT_ROOT_EARTH -> 45 + 18 * 4;
            case PlayerData.SPIRIT_ROOT_THUNDER -> 45 + 18;
            case PlayerData.SPIRIT_ROOT_WIND -> 45 + 18;
            case PlayerData.SPIRIT_ROOT_ICE -> 45 + 18 * 2;
            case PlayerData.SPIRIT_ROOT_BLOOD -> 45 + 18;
            default -> 0;
        };

        // Calc Energy Bar Progress
        int energy = client.player.getComponent(ModComponents.PLAYER_DATA).getEnergy();
        int maxEnergy = client.player.getComponent(ModComponents.PLAYER_DATA).getMaxEnergy();
        int progress = (int) (((float) energy / maxEnergy) * 100.0F);

        if (!client.player.isCreative() && !client.player.isSpectator()) {
            // Draw Energy Bar
            // Draw Empty Bar
            drawContext.drawTexture(ModHuds.STATUS_BAR, drawingPositionX, drawingPositionY, emptyBarTexturePositionX, emptyBarTexturePositionY, textureWidth, textureHeight);

            // Draw valued Bar
            if (progress > 0) {
                drawContext.drawTexture(ModHuds.STATUS_BAR, drawingPositionX, drawingPositionY, valuedBarTexturePositionX, valuedBarTexturePositionY, progress, textureHeight);
            }

            // Adjust position for force unicode
            if (ifForceUnicodeFont) {
                energyTextDrawingPositionY -= 1;
            }

            // Draw text
            drawContext.drawText(textRenderer, energyText, energyTextDrawingPositionX, energyTextDrawingPositionY, ColorConvertTool.convertRGBTextToInt("245,245,245"), false);
        }
    }
}

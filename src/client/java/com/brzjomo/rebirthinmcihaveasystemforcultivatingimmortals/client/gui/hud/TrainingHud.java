package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.client.gui.hud;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.tool.ColorConvertTool;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.tool.ModComponents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.MutableText;

import java.util.Objects;

public class TrainingHud implements HudRenderCallback {
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        int windowWidth = client.getWindow().getScaledWidth();
        int windowHeight = client.getWindow().getScaledHeight();
        TextRenderer textRenderer = client.textRenderer;

        // Training Level Bar
        // In game window
        int drawingPositionX = windowWidth / 2 - 91;
        int drawingPositionY = windowHeight - 48 - 1;

        // In texture map
        int emptyBarTexturePositionX = 0;
        int emptyBarTexturePositionY = 18;
        int valuedBarTexturePositionX = 0;
        int valuedBarTexturePositionY = 27;
        int textureWidth = 100;
        int textureHeight = 9;

        // Training Level Text
        MutableText trainingLevel = Objects.requireNonNull(client.player).getComponent(ModComponents.PLAYER_DATA).getTrainingLevel();
        // In texture map
        int trainingLevelTextDrawingPositionX = drawingPositionX + textureWidth / 2 - textRenderer.getWidth(trainingLevel) / 2;
        int trainingLevelTextDrawingPositionY = windowHeight - 48 - 1;

        // Change elements Y
        if (client.player.getComponent(ModComponents.PLAYER_DATA).getEnergy() > 0) {
            drawingPositionY -= 10;
            trainingLevelTextDrawingPositionY -= 10;
        }

        // Calc Training Bar Progress
        int training = client.player.getComponent(ModComponents.PLAYER_DATA).getTraining();
        int trainingBarMin = client.player.getComponent(ModComponents.PLAYER_DATA).getTrainingBarMin();
        int trainingBarMax = client.player.getComponent(ModComponents.PLAYER_DATA).getTrainingBarMax();
        int progress = (int) (((float) (training - trainingBarMin) / (trainingBarMax - trainingBarMin)) * 100.0F);

        if (!client.player.isCreative() && !client.player.isSpectator()) {
            // Draw Training Bar
            // Draw Empty Bar
            drawContext.drawTexture(ModHuds.STATUS_BAR, drawingPositionX, drawingPositionY, emptyBarTexturePositionX, emptyBarTexturePositionY, textureWidth, textureHeight);

            // Draw valued Bar
            if (progress > 0) {
                drawContext.drawTexture(ModHuds.STATUS_BAR, drawingPositionX, drawingPositionY, valuedBarTexturePositionX, valuedBarTexturePositionY, progress, textureHeight);
            }

            // Draw text
            drawContext.drawText(textRenderer, trainingLevel, trainingLevelTextDrawingPositionX, trainingLevelTextDrawingPositionY, ColorConvertTool.convertRGBTextToInt(client.player.getComponent(ModComponents.PLAYER_DATA).updateTrainingLevelNameColor()), false);
        }
    }
}

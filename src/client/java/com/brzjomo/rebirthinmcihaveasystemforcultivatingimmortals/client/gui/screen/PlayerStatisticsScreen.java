package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.client.gui.screen;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.RebirthInMCIHaveASystemForCultivatingImmortals;
import com.google.common.collect.Lists;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Objects;

@Environment(EnvType.CLIENT)
public class PlayerStatisticsScreen extends Screen {
    public static final Identifier PLAYER_STATISTICS_SCREEN_TEXTURE = new Identifier(RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID, "textures/gui/screen/player_statistics_screen.png");
    private final Screen parent;
    private final int backgroundWidth = 176;
    private final int backgroundHeight = 184;
    MinecraftClient client = MinecraftClient.getInstance();
    private final int windowWidth = client.getWindow().getScaledWidth();
    private final int windowHeight = client.getWindow().getScaledHeight();
    private final int drawingPositionX = (windowWidth - backgroundWidth) / 2;
    private final int drawingPositionY = (windowHeight - backgroundHeight) / 4;
    private final List<Drawable> drawables = Lists.newArrayList();

    @Override
    public <T extends Element & Drawable & Selectable> T addDrawableChild(T drawableElement) {
        this.drawables.add(drawableElement);
        return super.addDrawableChild(drawableElement);
    }

    public PlayerStatisticsScreen(Screen parent) {
        super(Text.translatable("text." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".mod_name"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        TexturedButtonWidget backToInventoryButton = new TexturedButtonWidget(drawingPositionX + 178, drawingPositionY + 5, 20, 18, 0, 185, 19, PLAYER_STATISTICS_SCREEN_TEXTURE, button -> {
            client.setScreen(new InventoryScreen(Objects.requireNonNull(client.player)));
        });

        addDrawableChild(backToInventoryButton);
    }

    @Override
    public void renderBackground(DrawContext context) {
        context.fillGradient(0, 0, windowWidth, windowHeight, -1072689136, -804253680);
    }

    @Override
    public void renderBackgroundTexture(DrawContext context) {
        context.drawTexture(PLAYER_STATISTICS_SCREEN_TEXTURE, drawingPositionX, drawingPositionY, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        renderBackgroundTexture(context);

        for (Drawable drawable : this.drawables) {
            drawable.render(context, mouseX, mouseY, delta);
        }
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}

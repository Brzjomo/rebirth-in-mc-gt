package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.mixin.client;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.client.gui.screen.PlayerStatisticsScreen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(InventoryScreen.class)
public class PlayerInventoryScreenMixin {
    private static final int backgroundWidth = 176;
    private static final int backgroundHeight = 184;

    /**
     * @param context
     * @param delta
     * @param mouseX
     * @param mouseY  {@code @reason} change gui
     * @author Brzjomo
     */
    @Overwrite
    public void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int i = ((InventoryScreen) (Object) this).x;
        int j = ((InventoryScreen) (Object) this).y;
        context.drawTexture(PlayerStatisticsScreen.PLAYER_STATISTICS_SCREEN_TEXTURE, i, j, 0, 0, backgroundWidth, backgroundHeight);
        InventoryScreen.drawEntity(context, i + 51, j + 75, 30, (float) (i + 51) - ((InventoryScreen) (Object) this).mouseX, (float) (j + 75 - 50) - ((InventoryScreen) (Object) this).mouseY, ((InventoryScreen) (Object) this).client.player);
    }

    /**
     * {@code @reason} adjust
     *
     * @author Brzjomo
     */
    @Overwrite
    public void init() {
        if (((InventoryScreen) (Object) this).client.interactionManager.hasCreativeInventory()) {
            ((InventoryScreen) (Object) this).client.setScreen(new CreativeInventoryScreen(((InventoryScreen) (Object) this).client.player, ((InventoryScreen) (Object) this).client.player.networkHandler.getEnabledFeatures(), ((InventoryScreen) (Object) this).client.options.getOperatorItemsTab().getValue()));
            return;
        }
        ((InventoryScreen) (Object) this).x = (((InventoryScreen) (Object) this).width - backgroundWidth) / 2;
        ((InventoryScreen) (Object) this).y = (((InventoryScreen) (Object) this).height - backgroundHeight) / 2;
        ((InventoryScreen) (Object) this).narrow = ((InventoryScreen) (Object) this).width < 379;
        ((InventoryScreen) (Object) this).recipeBook.initialize(((InventoryScreen) (Object) this).width, ((InventoryScreen) (Object) this).height, ((InventoryScreen) (Object) this).client, ((InventoryScreen) (Object) this).narrow, ((InventoryScreen) (Object) this).handler);
        ((InventoryScreen) (Object) this).x = ((InventoryScreen) (Object) this).recipeBook.findLeftEdge(((InventoryScreen) (Object) this).width, backgroundWidth);
        ((InventoryScreen) (Object) this).addDrawableChild(new TexturedButtonWidget(((InventoryScreen) (Object) this).x + 178, ((InventoryScreen) (Object) this).y + 5, 20, 18, 0, 185, 19, PlayerStatisticsScreen.PLAYER_STATISTICS_SCREEN_TEXTURE, button -> {
            ((InventoryScreen) (Object) this).recipeBook.toggleOpen();
            ((InventoryScreen) (Object) this).x = ((InventoryScreen) (Object) this).recipeBook.findLeftEdge(((InventoryScreen) (Object) this).width, backgroundWidth);
            button.setPosition(((InventoryScreen) (Object) this).x + 178, ((InventoryScreen) (Object) this).y + 5);
            ((InventoryScreen) (Object) this).mouseDown = true;
        }));
        ((InventoryScreen) (Object) this).addSelectableChild(((InventoryScreen) (Object) this).recipeBook);
        ((InventoryScreen) (Object) this).setInitialFocus(((InventoryScreen) (Object) this).recipeBook);
    }

    /**
     * @param mouseX
     * @param mouseY
     * @param left
     * @param top
     * @param button {@code @reason} update size
     * @return
     * @author Brzjomo
     */
    @Overwrite
    public boolean isClickOutsideBounds(double mouseX, double mouseY, int left, int top, int button) {
        boolean bl = mouseX < (double) left || mouseY < (double) top || mouseX >= (double) (left + backgroundWidth) || mouseY >= (double) (top + backgroundHeight);
        return ((InventoryScreen) (Object) this).recipeBook.isClickOutsideBounds(mouseX, mouseY, ((InventoryScreen) (Object) this).x, ((InventoryScreen) (Object) this).y, backgroundWidth, backgroundHeight, button) && bl;
    }

    /**
     * @param context
     * @param mouseX
     * @param mouseY  {@code @reason} adjust text position
     * @author Brzjomo
     */
    @Overwrite
    public void drawForeground(DrawContext context, int mouseX, int mouseY) {
        context.drawText(((InventoryScreen) (Object) this).textRenderer, ((InventoryScreen) (Object) this).title, 143 - ((InventoryScreen) (Object) this).textRenderer.getWidth(((InventoryScreen) (Object) this).title) / 2, 5, 0x404040, false);
    }
}

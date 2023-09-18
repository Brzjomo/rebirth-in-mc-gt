package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.mixin.client;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.client.gui.hud.ModHuds;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.tool.ColorConvertTool;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(InGameHud.class)
public class PlayerStatusBarClientMixin {
    /**
     * @param context
     * @param player
     * @param x
     * @param y
     * @param lines
     * @param regeneratingHeartIndex
     * @param maxHealth
     * @param lastHealth
     * @param health
     * @param absorption
     * @param blinking               {@code @reason}  重写玩家血条，以容纳更大的值。
     * @author Brzjomo
     */
    @Overwrite
    public void renderHealthBar(DrawContext context, PlayerEntity player, int x, int y, int lines, int regeneratingHeartIndex, float maxHealth, int lastHealth, int health, int absorption, boolean blinking) {
        // In game window
        int drawingPositionX = x;
        int drawingPositionY = y;

        // In texture map
        int emptyBarTexturePositionX = 0;
        int emptyBarTexturePositionY = 0;
        int valuedBarTexturePositionX = 0;
        int valuedBarTexturePositionY = 9;
        int textureWidth = 100;
        int textureHeight = 9;

        boolean ifForceUnicodeFont = ((InGameHud) (Object) this).client.options.getForceUnicodeFont().getValue();

        if (absorption > 0) {
            if (health <= 0) {
                absorption = 0;
            }

            health += absorption;
            maxHealth += absorption;
        }

        int progress = (int) (health / maxHealth * textureWidth);

        // Draw Empty Bar
        context.drawTexture(ModHuds.STATUS_BAR, drawingPositionX, drawingPositionY, emptyBarTexturePositionX, emptyBarTexturePositionY, textureWidth, textureHeight);

        // Draw valued Bar
        context.drawTexture(ModHuds.STATUS_BAR, drawingPositionX, drawingPositionY, valuedBarTexturePositionX, valuedBarTexturePositionY, progress, textureHeight);

        // Text
        String healthText = health + "/" + (int) maxHealth;
        int healthTextDrawingPositionX = x + (textureWidth / 2) - (((InGameHud) (Object) this).getTextRenderer().getWidth(healthText) / 2);
        int healthTextDrawingPositionY = y + 1;

        // Adjust position for force unicode
        if (ifForceUnicodeFont) {
            healthTextDrawingPositionY -= 1;
        }

        // Draw text
        context.drawText(((InGameHud) (Object) this).getTextRenderer(), healthText, healthTextDrawingPositionX, healthTextDrawingPositionY, ColorConvertTool.convertRGBTextToInt("245,245,245"), false);
    }

    /**
     * @param context {@code @reason}  提高血条刷新率，及时反馈血量变化。
     * @author Brzjomo
     */
    @Overwrite
    private void renderStatusBars(DrawContext context) {
        int ac;
        int ab;
        int aa;
        int z;
        int y;
        int x;
        PlayerEntity playerEntity = ((InGameHud) (Object) this).getCameraPlayer();
        if (playerEntity == null) {
            return;
        }
        int i = MathHelper.ceil(playerEntity.getHealth());
        boolean bl = ((InGameHud) (Object) this).heartJumpEndTick > (long) ((InGameHud) (Object) this).ticks && (((InGameHud) (Object) this).heartJumpEndTick - (long) ((InGameHud) (Object) this).ticks) / 3L % 2L == 1L;
        long l = Util.getMeasuringTimeMs();
        if (i < ((InGameHud) (Object) this).lastHealthValue && playerEntity.timeUntilRegen > 0) {
            ((InGameHud) (Object) this).lastHealthCheckTime = l;
            ((InGameHud) (Object) this).heartJumpEndTick = ((InGameHud) (Object) this).ticks + 20;
        } else if (i > ((InGameHud) (Object) this).lastHealthValue && playerEntity.timeUntilRegen > 0) {
            ((InGameHud) (Object) this).lastHealthCheckTime = l;
            ((InGameHud) (Object) this).heartJumpEndTick = ((InGameHud) (Object) this).ticks + 10;
        }
        if (l - ((InGameHud) (Object) this).lastHealthCheckTime > 10L) {
            ((InGameHud) (Object) this).lastHealthValue = i;
            ((InGameHud) (Object) this).renderHealthValue = i;
            ((InGameHud) (Object) this).lastHealthCheckTime = l;
        }
        ((InGameHud) (Object) this).lastHealthValue = i;
        int j = ((InGameHud) (Object) this).renderHealthValue;
        ((InGameHud) (Object) this).random.setSeed(((InGameHud) (Object) this).ticks * 312871L);
        HungerManager hungerManager = playerEntity.getHungerManager();
        int k = hungerManager.getFoodLevel();
        int m = ((InGameHud) (Object) this).scaledWidth / 2 - 91;
        int n = ((InGameHud) (Object) this).scaledWidth / 2 + 91;
        int o = ((InGameHud) (Object) this).scaledHeight - 39;
        float f = Math.max((float) playerEntity.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH), (float) Math.max(j, i));
        int p = MathHelper.ceil(playerEntity.getAbsorptionAmount());
        int q = MathHelper.ceil((f + (float) p) / 2.0f / 10.0f);
        int r = Math.max(10 - (q - 2), 3);
        int s = o - (q - 1) * r - 10;
        int t = o - 10;
        int u = playerEntity.getArmor();
        int v = -1;
        if (playerEntity.hasStatusEffect(StatusEffects.REGENERATION)) {
            v = ((InGameHud) (Object) this).ticks % MathHelper.ceil(f + 5.0f);
        }
        ((InGameHud) (Object) this).client.getProfiler().push("armor");
        // Block style armor bar
        int armor = playerEntity.getArmor();

        if (armor > 0) {
            int bgWidth = 25;
            int bgHeight = 22;
            int drawingPositionX = m - bgWidth - 5;
            int drawingPositionY = o + bgHeight - 5;

            boolean isOffHandHasItem = !((InGameHud) (Object) this).client.player.getOffHandStack().isEmpty();
            boolean ifForceUnicodeFont = ((InGameHud) (Object) this).client.options.getForceUnicodeFont().getValue();

            // Leave space for offhand item
            if (isOffHandHasItem) {
                drawingPositionY -= 25;
            }

            // Draw armor bar
            context.drawTexture(ModHuds.STATUS_BAR, drawingPositionX, drawingPositionY, 100, 0, bgWidth, bgHeight);

            // Text
            String armorText = String.valueOf(armor);
            int armorTextDrawingPositionX = drawingPositionX + (bgWidth / 2) - (((InGameHud) (Object) this).getTextRenderer().getWidth(armorText) / 2) + 1;
            int armorTextDrawingPositionY = drawingPositionY + (bgHeight / 2) - 7 / 2 - 1;

            // Adjust position for force unicode
            if (ifForceUnicodeFont) {
                armorTextDrawingPositionY -= 1;
            }

            // Draw text
            context.drawText(((InGameHud) (Object) this).getTextRenderer(), armorText, armorTextDrawingPositionX, armorTextDrawingPositionY, ColorConvertTool.convertRGBTextToInt("245,245,245"), false);
        }
        // Armor bar end

        ((InGameHud) (Object) this).client.getProfiler().swap("health");
        ((InGameHud) (Object) this).renderHealthBar(context, playerEntity, m, o, r, v, f, i, j, p, bl);
        LivingEntity livingEntity = ((InGameHud) (Object) this).getRiddenEntity();
        x = ((InGameHud) (Object) this).getHeartCount(livingEntity);
        if (x == 0) {
            ((InGameHud) (Object) this).client.getProfiler().swap("food");
            for (y = 0; y < 10; ++y) {
                z = o;
                aa = 16;
                ab = 0;
                if (playerEntity.hasStatusEffect(StatusEffects.HUNGER)) {
                    aa += 36;
                    ab = 13;
                }
                if (playerEntity.getHungerManager().getSaturationLevel() <= 0.0f && ((InGameHud) (Object) this).ticks % (k * 3 + 1) == 0) {
                    z += ((InGameHud) (Object) this).random.nextInt(3) - 1;
                }
                ac = n - y * 8 - 9;
                context.drawTexture(InGameHud.ICONS, ac, z, 16 + ab * 9, 27, 9, 9);
                if (y * 2 + 1 < k) {
                    context.drawTexture(InGameHud.ICONS, ac, z, aa + 36, 27, 9, 9);
                }
                if (y * 2 + 1 != k) continue;
                context.drawTexture(InGameHud.ICONS, ac, z, aa + 45, 27, 9, 9);
            }
            t -= 10;
        }
        ((InGameHud) (Object) this).client.getProfiler().swap("air");
        y = playerEntity.getMaxAir();
        z = Math.min(playerEntity.getAir(), y);
        if (playerEntity.isSubmergedIn(FluidTags.WATER) || z < y) {
            aa = ((InGameHud) (Object) this).getHeartRows(x) - 1;
            t -= aa * 10;
            ab = MathHelper.ceil((double) (z - 2) * 10.0 / (double) y);
            ac = MathHelper.ceil((double) z * 10.0 / (double) y) - ab;
            for (int ad = 0; ad < ab + ac; ++ad) {
                if (ad < ab) {
                    context.drawTexture(InGameHud.ICONS, n - ad * 8 - 9, t, 16, 18, 9, 9);
                    continue;
                }
                context.drawTexture(InGameHud.ICONS, n - ad * 8 - 9, t, 25, 18, 9, 9);
            }
        }
        ((InGameHud) (Object) this).client.getProfiler().pop();
    }
}
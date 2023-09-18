package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.data;

import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.RebirthInMCIHaveASystemForCultivatingImmortals;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.tool.IPlayerData;
import com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.tool.ModComponents;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.math.random.Random;

public class PlayerData implements IPlayerData, AutoSyncedComponent {
    // training level
    public static final float TRAINING_MULTIPLY = 2.05F;
    public static final int TRAINING_LEVEL_0 = 100;
    public static final int TRAINING_LEVEL_1 = 300;
    public static final int TRAINING_LEVEL_1_2 = (int) (TRAINING_LEVEL_1 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_1_3 = (int) (TRAINING_LEVEL_1_2 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_1_4 = (int) (TRAINING_LEVEL_1_3 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_1_5 = (int) (TRAINING_LEVEL_1_4 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_1_6 = (int) (TRAINING_LEVEL_1_5 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_1_7 = (int) (TRAINING_LEVEL_1_6 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_1_8 = (int) (TRAINING_LEVEL_1_7 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_1_9 = (int) (TRAINING_LEVEL_1_8 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_2 = (int) (TRAINING_LEVEL_1_9 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_2_2 = (int) (TRAINING_LEVEL_2 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_2_3 = (int) (TRAINING_LEVEL_2_2 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_2_4 = (int) (TRAINING_LEVEL_2_3 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_2_5 = (int) (TRAINING_LEVEL_2_4 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_3 = (int) (TRAINING_LEVEL_2_5 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_3_2 = (int) (TRAINING_LEVEL_3 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_3_3 = (int) (TRAINING_LEVEL_3_2 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_3_4 = (int) (TRAINING_LEVEL_3_3 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_3_5 = (int) (TRAINING_LEVEL_3_4 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_4 = (int) (TRAINING_LEVEL_3_5 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_5 = (int) (TRAINING_LEVEL_4 * TRAINING_MULTIPLY);
    public static final int TRAINING_LEVEL_6 = (int) (TRAINING_LEVEL_5 * TRAINING_MULTIPLY);

    public static final int[] TRAINING_LEVEL_LIST = {TRAINING_LEVEL_0, TRAINING_LEVEL_1, TRAINING_LEVEL_1_2, TRAINING_LEVEL_1_3, TRAINING_LEVEL_1_4,
            TRAINING_LEVEL_1_5, TRAINING_LEVEL_1_6, TRAINING_LEVEL_1_7, TRAINING_LEVEL_1_8, TRAINING_LEVEL_1_9, TRAINING_LEVEL_2, TRAINING_LEVEL_2_2,
            TRAINING_LEVEL_2_3, TRAINING_LEVEL_2_4, TRAINING_LEVEL_2_5, TRAINING_LEVEL_3, TRAINING_LEVEL_3_2, TRAINING_LEVEL_3_3, TRAINING_LEVEL_3_4,
            TRAINING_LEVEL_3_5, TRAINING_LEVEL_4, TRAINING_LEVEL_5, TRAINING_LEVEL_6};

    // level
    //
    public static final MutableText TRAINING_NAME_LEVEL_0 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_0");
    //
    public static final MutableText TRAINING_NAME_LEVEL_1 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_1");
    public static final MutableText TRAINING_NAME_LEVEL_1_2 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_1_2");
    public static final MutableText TRAINING_NAME_LEVEL_1_3 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_1_3");
    public static final MutableText TRAINING_NAME_LEVEL_1_4 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_1_4");
    public static final MutableText TRAINING_NAME_LEVEL_1_5 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_1_5");
    public static final MutableText TRAINING_NAME_LEVEL_1_6 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_1_6");
    public static final MutableText TRAINING_NAME_LEVEL_1_7 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_1_7");
    public static final MutableText TRAINING_NAME_LEVEL_1_8 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_1_8");
    public static final MutableText TRAINING_NAME_LEVEL_1_9 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_1_9");
    //
    public static final MutableText TRAINING_NAME_LEVEL_2 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_2");
    public static final MutableText TRAINING_NAME_LEVEL_2_2 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_2_2");
    public static final MutableText TRAINING_NAME_LEVEL_2_3 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_2_3");
    public static final MutableText TRAINING_NAME_LEVEL_2_4 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_2_4");
    public static final MutableText TRAINING_NAME_LEVEL_2_5 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_2_5");
    //
    public static final MutableText TRAINING_NAME_LEVEL_3 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_3");
    public static final MutableText TRAINING_NAME_LEVEL_3_2 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_3_2");
    public static final MutableText TRAINING_NAME_LEVEL_3_3 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_3_3");
    public static final MutableText TRAINING_NAME_LEVEL_3_4 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_3_4");
    public static final MutableText TRAINING_NAME_LEVEL_3_5 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_3_5");
    //
    public static final MutableText TRAINING_NAME_LEVEL_4 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_4");
    //
    public static final MutableText TRAINING_NAME_LEVEL_5 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_5");
    //
    public static final MutableText TRAINING_NAME_LEVEL_6 = Text.translatable("name." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".level_6");

    public static final MutableText[] TRAINING_LEVEL_NAME_LIST = {TRAINING_NAME_LEVEL_0, TRAINING_NAME_LEVEL_1, TRAINING_NAME_LEVEL_1_2, TRAINING_NAME_LEVEL_1_3,
            TRAINING_NAME_LEVEL_1_4, TRAINING_NAME_LEVEL_1_5, TRAINING_NAME_LEVEL_1_6, TRAINING_NAME_LEVEL_1_7, TRAINING_NAME_LEVEL_1_8, TRAINING_NAME_LEVEL_1_9,
            TRAINING_NAME_LEVEL_2, TRAINING_NAME_LEVEL_2_2, TRAINING_NAME_LEVEL_2_3, TRAINING_NAME_LEVEL_2_4, TRAINING_NAME_LEVEL_2_5, TRAINING_NAME_LEVEL_3,
            TRAINING_NAME_LEVEL_3_2, TRAINING_NAME_LEVEL_3_3, TRAINING_NAME_LEVEL_3_4, TRAINING_NAME_LEVEL_3_5, TRAINING_NAME_LEVEL_4, TRAINING_NAME_LEVEL_5,
            TRAINING_NAME_LEVEL_6};

    // color
    public static final String TRAINING_NAME_COLOR_LEVEL_0 = "160,160,160";
    public static final String TRAINING_NAME_COLOR_LEVEL_1 = "170,170,170";
    public static final String TRAINING_NAME_COLOR_LEVEL_1_2 = "180,180,180";
    public static final String TRAINING_NAME_COLOR_LEVEL_1_3 = "190,190,190";
    public static final String TRAINING_NAME_COLOR_LEVEL_1_4 = "200,200,200";
    public static final String TRAINING_NAME_COLOR_LEVEL_1_5 = "210,210,210";
    public static final String TRAINING_NAME_COLOR_LEVEL_1_6 = "220,220,220";
    public static final String TRAINING_NAME_COLOR_LEVEL_1_7 = "230,230,230";
    public static final String TRAINING_NAME_COLOR_LEVEL_1_8 = "240,240,240";
    public static final String TRAINING_NAME_COLOR_LEVEL_1_9 = "250,250,250";
    public static final String TRAINING_NAME_COLOR_LEVEL_2 = "135,150,225";
    public static final String TRAINING_NAME_COLOR_LEVEL_2_2 = "114,133,225";
    public static final String TRAINING_NAME_COLOR_LEVEL_2_3 = "96,117,225";
    public static final String TRAINING_NAME_COLOR_LEVEL_2_4 = "78,101,225";
    public static final String TRAINING_NAME_COLOR_LEVEL_2_5 = "60,85,225";
    public static final String TRAINING_NAME_COLOR_LEVEL_3 = "240,195,120";
    public static final String TRAINING_NAME_COLOR_LEVEL_3_2 = "240,186,95";
    public static final String TRAINING_NAME_COLOR_LEVEL_3_3 = "240,179,70";
    public static final String TRAINING_NAME_COLOR_LEVEL_3_4 = "240,172,45";
    public static final String TRAINING_NAME_COLOR_LEVEL_3_5 = "240,165,20";
    public static final String TRAINING_NAME_COLOR_LEVEL_4 = "149,0,232";
    public static final String TRAINING_NAME_COLOR_LEVEL_5 = "202,0,149";
    public static final String TRAINING_NAME_COLOR_LEVEL_6 = "185,0,0";

    public static final String[] TRAINING_NAME_COLOR_LIST = {TRAINING_NAME_COLOR_LEVEL_0, TRAINING_NAME_COLOR_LEVEL_1, TRAINING_NAME_COLOR_LEVEL_1_2,
            TRAINING_NAME_COLOR_LEVEL_1_3, TRAINING_NAME_COLOR_LEVEL_1_4, TRAINING_NAME_COLOR_LEVEL_1_5, TRAINING_NAME_COLOR_LEVEL_1_6, TRAINING_NAME_COLOR_LEVEL_1_7,
            TRAINING_NAME_COLOR_LEVEL_1_8, TRAINING_NAME_COLOR_LEVEL_1_9, TRAINING_NAME_COLOR_LEVEL_2, TRAINING_NAME_COLOR_LEVEL_2_2, TRAINING_NAME_COLOR_LEVEL_2_3,
            TRAINING_NAME_COLOR_LEVEL_2_4, TRAINING_NAME_COLOR_LEVEL_2_5, TRAINING_NAME_COLOR_LEVEL_3, TRAINING_NAME_COLOR_LEVEL_3_2, TRAINING_NAME_COLOR_LEVEL_3_3,
            TRAINING_NAME_COLOR_LEVEL_3_4, TRAINING_NAME_COLOR_LEVEL_3_5, TRAINING_NAME_COLOR_LEVEL_4, TRAINING_NAME_COLOR_LEVEL_5, TRAINING_NAME_COLOR_LEVEL_6};

    // health
    public static final double BASE_HEALTH_LEVEL_0 = 20;
    public static final double BASE_HEALTH_LEVEL_1 = 22;
    public static final double BASE_HEALTH_LEVEL_1_2 = 25;
    public static final double BASE_HEALTH_LEVEL_1_3 = 28;
    public static final double BASE_HEALTH_LEVEL_1_4 = 32;
    public static final double BASE_HEALTH_LEVEL_1_5 = 36;
    public static final double BASE_HEALTH_LEVEL_1_6 = 40;
    public static final double BASE_HEALTH_LEVEL_1_7 = 45;
    public static final double BASE_HEALTH_LEVEL_1_8 = 50;
    public static final double BASE_HEALTH_LEVEL_1_9 = 55;
    public static final double BASE_HEALTH_LEVEL_2 = 65;
    public static final double BASE_HEALTH_LEVEL_2_2 = 70;
    public static final double BASE_HEALTH_LEVEL_2_3 = 75;
    public static final double BASE_HEALTH_LEVEL_2_4 = 80;
    public static final double BASE_HEALTH_LEVEL_2_5 = 85;
    public static final double BASE_HEALTH_LEVEL_3 = 100;
    public static final double BASE_HEALTH_LEVEL_3_2 = 110;
    public static final double BASE_HEALTH_LEVEL_3_3 = 120;
    public static final double BASE_HEALTH_LEVEL_3_4 = 130;
    public static final double BASE_HEALTH_LEVEL_3_5 = 140;
    public static final double BASE_HEALTH_LEVEL_4 = 160;
    public static final double BASE_HEALTH_LEVEL_5 = 200;
    public static final double BASE_HEALTH_LEVEL_6 = 260;

    public static final double[] BASE_HEALTH_LIST = {BASE_HEALTH_LEVEL_0, BASE_HEALTH_LEVEL_1, BASE_HEALTH_LEVEL_1_2, BASE_HEALTH_LEVEL_1_3, BASE_HEALTH_LEVEL_1_4,
            BASE_HEALTH_LEVEL_1_5, BASE_HEALTH_LEVEL_1_6, BASE_HEALTH_LEVEL_1_7, BASE_HEALTH_LEVEL_1_8, BASE_HEALTH_LEVEL_1_9, BASE_HEALTH_LEVEL_2, BASE_HEALTH_LEVEL_2_2,
            BASE_HEALTH_LEVEL_2_3, BASE_HEALTH_LEVEL_2_4, BASE_HEALTH_LEVEL_2_5, BASE_HEALTH_LEVEL_3, BASE_HEALTH_LEVEL_3_2, BASE_HEALTH_LEVEL_3_3, BASE_HEALTH_LEVEL_3_4,
            BASE_HEALTH_LEVEL_3_5, BASE_HEALTH_LEVEL_4, BASE_HEALTH_LEVEL_5, BASE_HEALTH_LEVEL_6};

    // power
    public static final int BASE_ENERGY_LEVEL_0 = 0;
    public static final int BASE_ENERGY_LEVEL_1 = 10;
    public static final int BASE_ENERGY_LEVEL_1_2 = 15;
    public static final int BASE_ENERGY_LEVEL_1_3 = 20;
    public static final int BASE_ENERGY_LEVEL_1_4 = 25;
    public static final int BASE_ENERGY_LEVEL_1_5 = 30;
    public static final int BASE_ENERGY_LEVEL_1_6 = 35;
    public static final int BASE_ENERGY_LEVEL_1_7 = 40;
    public static final int BASE_ENERGY_LEVEL_1_8 = 45;
    public static final int BASE_ENERGY_LEVEL_1_9 = 50;
    public static final int BASE_ENERGY_LEVEL_2 = 100;
    public static final int BASE_ENERGY_LEVEL_2_2 = 120;
    public static final int BASE_ENERGY_LEVEL_2_3 = 150;
    public static final int BASE_ENERGY_LEVEL_2_4 = 190;
    public static final int BASE_ENERGY_LEVEL_2_5 = 240;
    public static final int BASE_ENERGY_LEVEL_3 = 360;
    public static final int BASE_ENERGY_LEVEL_3_2 = 400;
    public static final int BASE_ENERGY_LEVEL_3_3 = 450;
    public static final int BASE_ENERGY_LEVEL_3_4 = 510;
    public static final int BASE_ENERGY_LEVEL_3_5 = 600;
    public static final int BASE_ENERGY_LEVEL_4 = 900;
    public static final int BASE_ENERGY_LEVEL_5 = 1500;
    public static final int BASE_ENERGY_LEVEL_6 = 2000;

    public static final int[] BASE_ENERGY_LIST = {BASE_ENERGY_LEVEL_0, BASE_ENERGY_LEVEL_1, BASE_ENERGY_LEVEL_1_2, BASE_ENERGY_LEVEL_1_3, BASE_ENERGY_LEVEL_1_4,
            BASE_ENERGY_LEVEL_1_5, BASE_ENERGY_LEVEL_1_6, BASE_ENERGY_LEVEL_1_7, BASE_ENERGY_LEVEL_1_8, BASE_ENERGY_LEVEL_1_9, BASE_ENERGY_LEVEL_2, BASE_ENERGY_LEVEL_2_2,
            BASE_ENERGY_LEVEL_2_3, BASE_ENERGY_LEVEL_2_4, BASE_ENERGY_LEVEL_2_5, BASE_ENERGY_LEVEL_3, BASE_ENERGY_LEVEL_3_2, BASE_ENERGY_LEVEL_3_3, BASE_ENERGY_LEVEL_3_4,
            BASE_ENERGY_LEVEL_3_5, BASE_ENERGY_LEVEL_4, BASE_ENERGY_LEVEL_5, BASE_ENERGY_LEVEL_6};

    // spirit
    public static final String SPIRIT_ENERGY_METAL = "spirit_energy_metal";
    public static final String SPIRIT_ENERGY_WOOD = "spirit_energy_wood";
    public static final String SPIRIT_ENERGY_WATER = "spirit_energy_water";
    public static final String SPIRIT_ENERGY_FIRE = "spirit_energy_fire";
    public static final String SPIRIT_ENERGY_EARTH = "spirit_energy_earth";
    public static final String[] SPIRIT_ENERGY_LIST = {SPIRIT_ENERGY_METAL, SPIRIT_ENERGY_WOOD, SPIRIT_ENERGY_WATER, SPIRIT_ENERGY_FIRE, SPIRIT_ENERGY_EARTH};

    public static final MutableText SPIRIT_ENERGY_NAME_METAL = Text.translatable("spirit_energy." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".metal");
    public static final MutableText SPIRIT_ENERGY_NAME_WOOD = Text.translatable("spirit_energy." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".wood");
    public static final MutableText SPIRIT_ENERGY_NAME_WATER = Text.translatable("spirit_energy." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".water");
    public static final MutableText SPIRIT_ENERGY_NAME_FIRE = Text.translatable("spirit_energy." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".fire");
    public static final MutableText SPIRIT_ENERGY_NAME_EARTH = Text.translatable("spirit_energy." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".earth");
    public static final MutableText[] SPIRIT_ENERGY_NAME_LIST = {SPIRIT_ENERGY_NAME_METAL, SPIRIT_ENERGY_NAME_WOOD, SPIRIT_ENERGY_NAME_WATER, SPIRIT_ENERGY_NAME_FIRE,
            SPIRIT_ENERGY_NAME_EARTH};

    //
    public static final String SPIRIT_ROOT_METAL = "spirit_root_metal";
    public static final String SPIRIT_ROOT_WOOD = "spirit_root_wood";
    public static final String SPIRIT_ROOT_WATER = "spirit_root_water";
    public static final String SPIRIT_ROOT_FIRE = "spirit_root_fire";
    public static final String SPIRIT_ROOT_EARTH = "spirit_root_earth";
    public static final String SPIRIT_ROOT_THUNDER = "spirit_root_thunder";
    public static final String SPIRIT_ROOT_WIND = "spirit_root_wind";
    public static final String SPIRIT_ROOT_ICE = "spirit_root_ice";
    public static final String SPIRIT_ROOT_BLOOD = "spirit_root_blood";
    public static final String[] SPIRIT_ROOT_LIST = {SPIRIT_ROOT_METAL, SPIRIT_ROOT_WOOD, SPIRIT_ROOT_WATER, SPIRIT_ROOT_FIRE, SPIRIT_ROOT_EARTH, SPIRIT_ROOT_THUNDER,
            SPIRIT_ROOT_WIND, SPIRIT_ROOT_ICE, SPIRIT_ROOT_BLOOD};

    public static final MutableText SPIRIT_ROOT_NAME_METAL = Text.translatable("spirit_root." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".metal");
    public static final MutableText SPIRIT_ROOT_NAME_WOOD = Text.translatable("spirit_root." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".wood");
    public static final MutableText SPIRIT_ROOT_NAME_WATER = Text.translatable("spirit_root." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".water");
    public static final MutableText SPIRIT_ROOT_NAME_FIRE = Text.translatable("spirit_root." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".fire");
    public static final MutableText SPIRIT_ROOT_NAME_EARTH = Text.translatable("spirit_root." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".earth");
    public static final MutableText SPIRIT_ROOT_NAME_THUNDER = Text.translatable("spirit_root." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".thunder");
    public static final MutableText SPIRIT_ROOT_NAME_WIND = Text.translatable("spirit_root." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".wind");
    public static final MutableText SPIRIT_ROOT_NAME_ICE = Text.translatable("spirit_root." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".ice");
    public static final MutableText SPIRIT_ROOT_NAME_BLOOD = Text.translatable("spirit_root." + RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID + ".blood");
    public static final MutableText[] SPIRIT_ROOT_NAME_LIST = {SPIRIT_ROOT_NAME_METAL, SPIRIT_ROOT_NAME_WOOD, SPIRIT_ROOT_NAME_WATER, SPIRIT_ROOT_NAME_FIRE, SPIRIT_ROOT_NAME_EARTH,
            SPIRIT_ROOT_NAME_THUNDER, SPIRIT_ROOT_NAME_WIND, SPIRIT_ROOT_NAME_ICE, SPIRIT_ROOT_NAME_BLOOD};

    public Entity provider;
    public NbtCompound modRootNBT = new NbtCompound();

    @Override
    public void syncProvider(Entity provider) {
        this.provider = provider;
    }

    @Override
    public NbtCompound getModRootNBT() {
        return this.modRootNBT;
    }

    // training
    @Override
    public void addTraining(int value) {
        if (!this.modRootNBT.contains("training_data")) {
            this.modRootNBT.put("training_data", new NbtCompound());
        }

        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");

        if (nbtTrainingData.getInt("training") >= TRAINING_LEVEL_LIST[TRAINING_LEVEL_LIST.length - 1]) {
            nbtTrainingData.putInt("training", TRAINING_LEVEL_LIST[TRAINING_LEVEL_LIST.length - 1]);
        } else {
            nbtTrainingData.putInt("training", nbtTrainingData.getInt("training") + value);
        }

        ModComponents.PLAYER_DATA.sync(this.provider);
    }

    @Override
    public int getTraining() {
        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        return nbtTrainingData.getInt("training");
    }

    @Override
    public void setTraining(int value) {
        if (!this.modRootNBT.contains("training_data")) {
            this.modRootNBT.put("training_data", new NbtCompound());
        }

        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        nbtTrainingData.putInt("training", value);

        ModComponents.PLAYER_DATA.sync(this.provider);
    }

    @Override
    public int getTrainingBarMin() {
        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        int training = nbtTrainingData.getInt("training");

        for (int i = 0; i < TRAINING_LEVEL_LIST.length; i++) {
            if (training < TRAINING_LEVEL_LIST[i]) {
                if (i != 0) {
                    return TRAINING_LEVEL_LIST[i - 1];
                } else {
                    return 0;
                }
            }
        }

        return 0;
    }

    @Override
    public int getTrainingBarMax() {
        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        int training = nbtTrainingData.getInt("training");

        for (int j : TRAINING_LEVEL_LIST) {
            if (training < j) {
                return j;
            }
        }

        return TRAINING_LEVEL_LIST[TRAINING_LEVEL_LIST.length - 1];
    }

    @Override
    public MutableText getTrainingLevel() {
        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        int training = nbtTrainingData.getInt("training");

        for (int i = 0; i < TRAINING_LEVEL_LIST.length; i++) {
            if (training < TRAINING_LEVEL_LIST[i]) {
                return TRAINING_LEVEL_NAME_LIST[i];
            }
        }

        return TRAINING_LEVEL_NAME_LIST[TRAINING_LEVEL_NAME_LIST.length - 1];
    }

    @Override
    public String updateTrainingLevelNameColor() {
        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        int training = nbtTrainingData.getInt("training");

        for (int i = 0; i < TRAINING_LEVEL_LIST.length; i++) {
            if (training < TRAINING_LEVEL_LIST[i]) {
                return TRAINING_NAME_COLOR_LIST[i];
            }
        }

        return TRAINING_NAME_COLOR_LIST[TRAINING_NAME_COLOR_LIST.length - 1];
    }

    //
    @Override
    public void initPlayerMaxEnergy() {
        if (!this.modRootNBT.contains("training_data")) {
            this.modRootNBT.put("training_data", new NbtCompound());
        }

        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        int training = this.getTraining();

        for (int i = 0; i < TRAINING_LEVEL_LIST.length; i++) {
            if (training < TRAINING_LEVEL_LIST[i]) {
                nbtTrainingData.putInt("max_energy", BASE_ENERGY_LIST[i]);
                return;
            }
        }

        ModComponents.PLAYER_DATA.sync(this.provider);
    }

    @Override
    public void initPlayerEnergy() {
        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        int maxEnergy = nbtTrainingData.getInt("max_energy");
        nbtTrainingData.putInt("energy", maxEnergy);

        ModComponents.PLAYER_DATA.sync(this.provider);
    }

    @Override
    public void addEnergy(int value) {
        if (!this.modRootNBT.contains("training_data")) {
            this.modRootNBT.put("training_data", new NbtCompound());
        }

        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        int maxEnergy = nbtTrainingData.getInt("max_energy");
        int energy = nbtTrainingData.getInt("energy");

        if (energy >= maxEnergy) {
            nbtTrainingData.putInt("energy", maxEnergy);
        } else {
            nbtTrainingData.putInt("energy", energy + value);
        }

        ModComponents.PLAYER_DATA.sync(this.provider);
    }

    @Override
    public void costEnergy(int value) {
        if (!this.modRootNBT.contains("training_data")) {
            this.modRootNBT.put("training_data", new NbtCompound());
        }

        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        int energy = nbtTrainingData.getInt("energy");

        if (energy >= value) {
            nbtTrainingData.putInt("energy", energy - value);
        } else {
            nbtTrainingData.putInt("energy", 0);
        }

        ModComponents.PLAYER_DATA.sync(this.provider);
    }

    @Override
    public int getEnergy() {
        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");

        return nbtTrainingData.getInt("energy");
    }

    @Override
    public void setEnergy(int value) {
        if (!this.modRootNBT.contains("training_data")) {
            this.modRootNBT.put("training_data", new NbtCompound());
        }

        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        int maxEnergy = nbtTrainingData.getInt("max_energy");
        int energy = nbtTrainingData.getInt("energy");

        if (value > maxEnergy) {
            value = maxEnergy;
        }

        nbtTrainingData.putInt("energy", value);

        ModComponents.PLAYER_DATA.sync(this.provider);
    }

    @Override
    public int getMaxEnergy() {
        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");

        return nbtTrainingData.getInt("max_energy");
    }

    // root
    @Override
    public String getRandomSpiritRoot() {
        int minRange = 0;
        int range = 0;
        int maxRange = SPIRIT_ROOT_LIST.length - 1;
        float possibility = Random.create().nextFloat();

        // 灵根稀有度
        if (possibility < 0.85F) {
            range = 4;
        } else if (possibility < 0.95F) {
            minRange = 5;
            range = 7;
        } else {
            minRange = 8;
            range = maxRange;
        }

        int serialNum = Random.create().nextBetween(minRange, range);
        return SPIRIT_ROOT_LIST[serialNum];
    }

    @Override
    public boolean ifContainsSpiritRoot() {
        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        return nbtTrainingData.contains("spirit_root");
    }

    @Override
    public boolean ifContainsSpiritRoot(String spiritRoot) {
        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        NbtCompound nbtSpiritRoot = nbtTrainingData.getCompound("spirit_root");

        return nbtSpiritRoot.contains(spiritRoot);
    }

    @Override
    public void emptyPlayerSpiritRoot() {
        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        if (nbtTrainingData.contains("spirit_root")) {
            nbtTrainingData.remove("spirit_root");
        }

        ModComponents.PLAYER_DATA.sync(this.provider);
    }

    @Override
    public void removePlayerSpiritRoot(String spiritRoot) {
        if (!this.modRootNBT.contains("training_data")) {
            this.modRootNBT.put("training_data", new NbtCompound());
        }

        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        if (nbtTrainingData.contains("spirit_root")) {
            nbtTrainingData.put("spirit_root", new NbtCompound());
        }

        NbtCompound nbtSpiritRoot = nbtTrainingData.getCompound("spirit_root");
        nbtSpiritRoot.remove(spiritRoot);

        ModComponents.PLAYER_DATA.sync(this.provider);
    }

    @Override
    public void initPlayerSpiritRoot() {
        if (!this.modRootNBT.contains("training_data")) {
            this.modRootNBT.put("training_data", new NbtCompound());
        }

        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        if (!nbtTrainingData.contains("spirit_root")) {
            nbtTrainingData.put("spirit_root", new NbtCompound());
        }

        int count = 1;
        float possibility = Random.create().nextFloat();

        //
        if (possibility < 0.15F) {
            count = Random.create().nextBetween(1, 3);
        } else if (possibility < 0.75F) {
            count = Random.create().nextBetween(3, 5);
        } else {
            count = Random.create().nextBetween(5, SPIRIT_ROOT_LIST.length);
        }

        for (int i = 0; i < count; i++) {
            NbtCompound nbtSpiritRoot = nbtTrainingData.getCompound("spirit_root");
            String newSpiritRoot = provider.getComponent(ModComponents.PLAYER_DATA).getRandomSpiritRoot();

            //
            int talent = 0;
            float possibility2 = Random.create().nextFloat();
            if (possibility2 < 0.1F) {
                talent = Random.create().nextBetween(70, 100);
            } else if (possibility2 < 0.85F) {
                talent = Random.create().nextBetween(30, 70);
            } else {
                talent = Random.create().nextBetween(1, 30);
            }

            if (!nbtSpiritRoot.contains(newSpiritRoot)) {
                nbtSpiritRoot.putInt(newSpiritRoot, talent);
            }
        }

        ModComponents.PLAYER_DATA.sync(this.provider);
    }

    @Override
    public void addPlayerSpiritRoot(String spiritRoot, int talent) {
        if (!this.modRootNBT.contains("training_data")) {
            this.modRootNBT.put("training_data", new NbtCompound());
        }

        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        NbtCompound nbtSpiritRoot = nbtTrainingData.getCompound("spirit_root");
        if (!nbtSpiritRoot.contains(spiritRoot)) {
            nbtSpiritRoot.putInt(spiritRoot, talent);
        }

        ModComponents.PLAYER_DATA.sync(this.provider);
    }

    @Override
    public void setPlayerSpiritRoot(String spiritRoot, int talent) {
        if (!this.modRootNBT.contains("training_data")) {
            this.modRootNBT.put("training_data", new NbtCompound());
        }

        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");

        if (!nbtTrainingData.contains("spirit_root")) {
            nbtTrainingData.put("spirit_root", new NbtCompound());
        }

        nbtTrainingData.getCompound("spirit_root").putInt(spiritRoot, talent);

        ModComponents.PLAYER_DATA.sync(this.provider);
    }

    @Override
    public String printPlayerSpiritRoot() {
        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        return nbtTrainingData.getCompound("spirit_root").toString();
    }

    @Override
    public String getMostTalentedSpiritRoot() {
        NbtCompound nbtTrainingData = this.modRootNBT.getCompound("training_data");
        NbtCompound nbtSpiritRoot = nbtTrainingData.getCompound("spirit_root");
        int highestTalent = 0;
        String mostTalentedSpiritRoot = "";
        for (String spiritRoot : nbtSpiritRoot.getKeys()) {
            int talent = nbtSpiritRoot.getInt(spiritRoot);
            if (talent > highestTalent) {
                highestTalent = talent;
                mostTalentedSpiritRoot = spiritRoot;
            }
        }
        return mostTalentedSpiritRoot;
    }

    @Override
    public void readFromNbt(NbtCompound nbt) {
        this.modRootNBT = nbt.getCompound(RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID);
    }

    @Override
    public void writeToNbt(NbtCompound nbt) {
        nbt.put(RebirthInMCIHaveASystemForCultivatingImmortals.MOD_ID, this.modRootNBT);
    }
}

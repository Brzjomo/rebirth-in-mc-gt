package com.brzjomo.rebirthinmcihaveasystemforcultivatingimmortals.tool;

import dev.onyxstudios.cca.api.v3.component.Component;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.MutableText;

public interface IPlayerData extends Component {
    void syncProvider(Entity provider);

    NbtCompound getModRootNBT();

    void addTraining(int value);

    int getTraining();

    void setTraining(int value);

    int getTrainingBarMin();

    int getTrainingBarMax();

    MutableText getTrainingLevel();

    String updateTrainingLevelNameColor();

    void initPlayerMaxEnergy();

    void initPlayerEnergy();

    void addEnergy(int value);

    void costEnergy(int value);

    int getEnergy();

    void setEnergy(int value);

    int getMaxEnergy();

    String getRandomSpiritRoot();

    boolean ifContainsSpiritRoot();

    boolean ifContainsSpiritRoot(String spiritRoot);

    void emptyPlayerSpiritRoot();

    void removePlayerSpiritRoot(String value);

    void initPlayerSpiritRoot();

    void addPlayerSpiritRoot(String value, int talent);

    void setPlayerSpiritRoot(String value, int talent);

    String printPlayerSpiritRoot();

    String getMostTalentedSpiritRoot();
}

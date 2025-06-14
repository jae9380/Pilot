package com.step03.problem04.entity;

public abstract class EnergySource {
    private final String sourceName;
    int energyAmount;

    public EnergySource(String sourceName) {
        this.sourceName = sourceName;
        this.energyAmount = 0;
    }

    public void useEnergy(int amount) {
        if (energyAmount >= amount) {
            energyAmount -= amount;
            System.out.printf("[EnergySource] SUCCESS - %1$s 에너지를 %2$d 사용했습니다.\n", sourceName, amount);
        } else {
            System.out.printf("[EnergySource] FAILURE - %1$s 에너지가 %2$d 만큼 부족합니다.\n", sourceName, amount - energyAmount);
        }
    }

    public abstract void produceEnergy(int element);

    public String getSourceName() {
        return sourceName;
    }

    public int getEnergyAmount() {
        return energyAmount;
    }
}

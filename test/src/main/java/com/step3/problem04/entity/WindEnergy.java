package com.step3.problem04.entity;


public class WindEnergy extends EnergySource {

    public WindEnergy() {
        super("풍력");
    }

    @Override
    public void produceEnergy(int windSpeed) {
        int produced = windSpeed * 5;
        energyAmount += produced;
        System.out.printf("%1$s 에너지를 %2$d 생산했습니다.\n", getSourceName(), produced);
    }
}

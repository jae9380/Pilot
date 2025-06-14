package com.step03.problem04.entity;

public class SolarEnergy extends EnergySource {

    public SolarEnergy() {
        super("태양광");
    }

    @Override
    public void produceEnergy(int time) {
        int produced = time * 10;
        energyAmount += produced;
        System.out.printf("%1$s 에너지를 %2$d 생산했습니다.\n", getSourceName(), produced);
    }
}

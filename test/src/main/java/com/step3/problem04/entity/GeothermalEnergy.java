package com.step3.problem04.entity;


public class GeothermalEnergy extends EnergySource {

    public GeothermalEnergy() {
        super("지열");
    }

    @Override
    public void produceEnergy(int temperature) {
        int produced = temperature * 5 + 20;
        energyAmount += produced;
        System.out.printf("%1$s 에너지를 %2$d 생산했습니다.\n", getSourceName(), produced);
    }
}

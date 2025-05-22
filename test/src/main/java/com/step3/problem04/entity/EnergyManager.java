package com.step3.problem04.entity;

public class EnergyManager {
    public static void calculateTotalEnergy(EnergySource... sources) { // 매개값의 수를 특정하지 않고 여러개를 넘겨 줄 경우 ... 사용
        int total = 0;
        for (EnergySource source : sources) {
            total += source.getEnergyAmount();
            System.out.printf("[EnergyManager] 남은 %1$s 에너지 : %2$d \t", source.getSourceName(), source.getEnergyAmount());
        }
        System.out.printf("\n[EnergyManager] 남은 전체 에너지 : %1$d", total);
    }
}

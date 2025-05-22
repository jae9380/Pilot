package com.step3.problem04;

import com.step3.problem04.entity.*;

public class BiodomeFamily04 {
    public static void main(String[] args) {
        EnergySource solar = new SolarEnergy();
        EnergySource wind = new WindEnergy();
        EnergySource geo = new GeothermalEnergy();

        System.out.println("---- 에너지 생산 예시 ----");
        solar.produceEnergy(5);
        wind.produceEnergy(12);
        geo.produceEnergy(4);

        System.out.println("---- 에너시 소비 성공 예시 ----");
        solar.useEnergy(30);
        wind.useEnergy(30);
        geo.useEnergy(30);

        System.out.println("---- 에너지 소비 실패 예시 ----");
        solar.useEnergy(30);
        wind.useEnergy(30);
        geo.useEnergy(30);

        System.out.println("---- 남은 에너지 확인 ----");
        EnergyManager.calculateTotalEnergy(solar, wind, geo);
    }
}

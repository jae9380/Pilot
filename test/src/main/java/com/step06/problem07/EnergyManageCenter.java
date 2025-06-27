package com.step06.problem07;

public class EnergyManageCenter {
    private static EnergyManageCenter instance = null;
    private int totalEnergy;

    private EnergyManageCenter() {
        this.totalEnergy = 5000;
    }

    public static EnergyManageCenter getInstance() {
        if (instance == null) instance = new EnergyManageCenter();
        return instance;
    }

    public boolean allocateEnergy(String cityName, int amount) {
        if (amount < 0) {
            System.out.print("에너지 요청량은 음수일 수 없습니다.\n");
            return false;
        }

        if (amount > totalEnergy) {
            System.out.print("중앙 에너지 센터의 보유 에너지가 부족합니다.\n");
            return false;
        }

        totalEnergy -= amount;
        System.out.printf("%s에 %d의 에너지가 할당되었습니다.\n", cityName, amount);
        return true;
    }

    public int getTotalEnergy() {
        return totalEnergy;
    }
}

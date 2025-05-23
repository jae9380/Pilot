package com.step3.problem05.entity.ability;

public interface Chargeable {
    default void charge(int amount) {}

    default void checkChargedEnergy() {}

    static void showChargingTips() {
        System.out.printf("에너지를 효율적으로 충전하려면 마법사의 기분이 좋아야합니다.\n");
    }
}
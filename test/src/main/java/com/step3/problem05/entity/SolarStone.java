package com.step3.problem05.entity;

import com.step3.problem05.entity.ability.Chargeable;
import com.step3.problem05.entity.ability.EnergyGenerator;

public class SolarStone extends AncientArtifact implements EnergyGenerator, Chargeable {
    private int chargedEnergy = 0;
    public SolarStone() {
        super("태양의 돌");
        System.out.printf("태양의 돌 유물이 생성되었습니다.\n");
    }

    @Override
    public void describe() {
        System.out.printf("[태양의 돌] 이 돌은 빛을 받아 에너지 생성한다. (빛을 받은 시간에 따라 에너지의 양이 달라진다.)\n");
    }

    @Override
    public void generateEnergy() {
        System.out.printf("[태양의 돌] 에너지 생성 중! 빛을 받은 시간에 따라 에너지의 양이 달라집니다.\n");
    }


    @Override
    public void charge(int amount) {
        chargedEnergy += amount;
        System.out.printf("[태양의 돌] %d만큼 에너지를 충전했습니다.\n", amount);
    }

    @Override
    public void checkChargedEnergy() {
        System.out.printf("[태양의 돌] 충전된 에너지는 %d 만큼 있습니다.\n", chargedEnergy);
    }


}

package com.step3.problem05.entity;

import com.step3.problem05.entity.ability.EnergyGenerator;

public class SolarStone extends AncientArtifact implements EnergyGenerator {
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
        System.out.printf("\"태양의 돌로 에너지 생성 중! 빛을 받은 시간에 따라 에너지의 양이 달라집니다.\"\n");
    }
}

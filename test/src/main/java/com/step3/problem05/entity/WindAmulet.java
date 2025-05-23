package com.step3.problem05.entity;

import com.step3.problem05.entity.ability.Chargeable;
import com.step3.problem05.entity.ability.WeatherController;

public class WindAmulet extends AncientArtifact implements WeatherController, Chargeable {
    private int chargedEnergy = 0;

    public WindAmulet() {
        super("바람의 부적");
        System.out.printf("바람의 부적 유물이 생성되었습니다.\n");
    }

    @Override
    public void describe() {
        System.out.printf("[바람의 부적] 이 부적은 주변 공기의 흐름을 이용해 날씨를 조절한다. (예: 저기압, 고기압, 강풍 등)\n");
    }

    @Override
    public void controlWeather() {
        System.out.printf("[바람의 부적] 주변 공기의 흐름을 이용해 날씨를 조절한다! (기압과 풍속을 조절한다.)\n");
    }

    @Override
    public void charge(int amount) {
        chargedEnergy += amount;
        System.out.printf("[바람의 부적] %d만큼 에너지를 충전했습니다.\n", amount);
    }

    @Override
    public void checkChargedEnergy() {
        System.out.printf("[바람의 부적] 충전된 에너지는 %d 만큼 있습니다.\n", chargedEnergy);
    }
}

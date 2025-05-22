package com.step3.problem05.entity;

import com.step3.problem05.entity.ability.EnergyGenerator;
import com.step3.problem05.entity.ability.WeatherController;

public class WaterMirror extends AncientArtifact implements EnergyGenerator, WeatherController {
    public WaterMirror() {
        super("물의 거울");
        System.out.printf("물의 거울 유물이 생성되었습니다.\n");
    }

    @Override
    public void describe() {
        System.out.printf("[물의 거울] 이 거울은 수증기를 모아 에너지를 생성하고, 날씨를 조절한다. (예. 습도에 영향을 받으며, 비와 눈을 내림)\n");
    }

    @Override
    public void generateEnergy() {
        System.out.printf("\"물의 거울을 이용해 수증기로 에너지를 생성했습니다!\"\n");
    }

    @Override
    public void controlWeather() {

    }
}

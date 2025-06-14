package com.step03.problem05.entity;

import com.step03.problem05.entity.ability.EnergyGenerator;
import com.step03.problem05.entity.ability.WeatherController;

import java.util.ArrayList;
import java.util.List;

public class Sorcerer {
    private String name;
    private List<AncientArtifact> artifacts;

    public Sorcerer(String name) {
        this.name = name;
        this.artifacts = new ArrayList<>();
        System.out.printf("마법사 \'%s\'이 소환되었습니다.\n", name);
    }

    public void addArtifact(AncientArtifact artifact) {
        artifacts.add(artifact);
        System.out.printf("마법사 \'%1$s\'이 %2$s 유물을 획득 했습니다.\n", name, artifact.getName());
    }

    public void useArtifacts(boolean useGenerateEnergy, boolean useControlWeather) {
        artifacts.stream().forEach(a ->{
            a.describe();
            if (useGenerateEnergy && a instanceof EnergyGenerator) {
                System.out.printf("마법사 \'%1$s\'이 %2$s 유물의 에너지 생성 능력을 사용합니다.\n", name, a.getName());
                ((EnergyGenerator) a).generateEnergy();
            }
            if (useControlWeather && a instanceof WeatherController) {
                System.out.printf("마법사 \'%1$s\'이 %2$s 유물의 날씨 변경 능력을 사용합니다.\n", name, a.getName());
                ((WeatherController) a).controlWeather();
            }
        });
    }
}



package com.step4.problem04;

import com.step4.problem04.species.AnimalFeature;
import com.step4.problem04.species.PlantFeature;

public class RuleOfBiodome04 {
    public static void main(String[] args) {
        /*
        고양이 동물 야행성 포유류 코요테 쥐 20년
        얼룩말 동물 진단생활 포유류 사자 풀 10년

        로즈마리 식물 보라색 없음 7월
        벚꽃 식물 분홍색 있음 3월

        이콜라이 미생물 약산성 있음 호흡, 발효
        바실러스 미생물 약산성 없음 호흡
        이콜라이 미생물 약산성 없음 호흡 및 발효 대사

         */

        BiologicalEntity<AnimalFeature> entity1 = new BiologicalEntity<>("고양이", "동물", "야행성", "포유류", "코요테", "쥐", "20");

        BiologicalSystem<BiologicalEntity> bs = new BiologicalSystem<>();
    }
}

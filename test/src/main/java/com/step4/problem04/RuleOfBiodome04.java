package com.step4.problem04;

import com.step4.problem04.species.AnimalFeature;
import com.step4.problem04.species.PlantFeature;

public class RuleOfBiodome04 {
    public static void main(String[] args) {

        BiologicalEntity<AnimalFeature> entity1 = new BiologicalEntity<>("고양이", "동물", "야행성", "포유류", "코요테", "쥐", "20");
        BiologicalEntity<AnimalFeature> entity2 = new BiologicalEntity<>("얼룩말", "동물", "진단생활", "포유류", "사자", "풀", "10");
        BiologicalEntity<AnimalFeature> entity3 = new BiologicalEntity<>("로즈마리", "식물", "보라색", "없음", "7월");
        BiologicalEntity<AnimalFeature> entity4 = new BiologicalEntity<>("벚꽃", "식물", "분홍색", "있음", "3월");
        BiologicalEntity<AnimalFeature> entity5 = new BiologicalEntity<>("이콜라이", "미생물", "약산성", "있음", "호흡 및 발효");
        BiologicalEntity<AnimalFeature> entity6 = new BiologicalEntity<>("바실러스", "미생물", "약산성", "없음", "호흡");

        BiologicalSystem<BiologicalEntity> bs = new BiologicalSystem<>();

        bs.add(entity1);
        bs.add(entity2, entity3, entity3, entity4, entity5, entity6);

        bs.delete(entity6);

        bs.isEmpty();

        bs.show();

        bs.clear();

        bs.isEmpty();
    }
}

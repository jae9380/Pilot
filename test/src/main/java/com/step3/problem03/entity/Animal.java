package com.step3.problem03.entity;

import com.step3.problem03.entity.baseEntity.Organism;
import com.step3.problem03.entity.type.DigestionType;

import java.util.Map;

public class Animal extends Organism {
    private DigestionType digestionType;
    private String diet;

    public Animal(String[] info) {
        super(info[0], info[1], info[2]);
        this.digestionType = DigestionType.fromKoreanName(info[3]);
        this.diet = info[4];
    }
    public Animal(String name, String species, String habitat, String digestionType, String diet) {
        super(name, species, habitat);
        this.digestionType = DigestionType.fromKoreanName(digestionType);
        this.diet = diet;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("소화 방식: %1$-6s\t 먹이: %2$-6s\n",
                digestionType.getKoreanName(), diet);
    }

    @Override
    public Map<String, String> getAllInfo() {
        Map<String, String> info = super.getAllInfo();
        info.put("digestionType", digestionType != null ? digestionType.getKoreanName() : "정보 없음");
        info.put("diet", diet);
        return info;
    }
}

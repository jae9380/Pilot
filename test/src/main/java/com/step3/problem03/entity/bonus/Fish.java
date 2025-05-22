package com.step3.problem03.entity.bonus;

import com.step3.problem03.entity.Animal;

public class Fish extends Animal {
    private int finsCount;
    public Fish(String[] info) {
        super(info);
        finsCount = Integer.parseInt(info[5]);
    }

    public Fish(String name, String species, String habitat, String digestionType, String diet, String finsCount) {
        super(name, species, habitat, digestionType, diet);
        this.finsCount = Integer.parseInt(finsCount);
    }

    public void swim() {
        System.out.printf("%1$s는 %2$d개의 지느러미로 수영을 합니다.\n", getName(), finsCount);
    }
}
package com.step3.problem03;

import com.step3.problem03.entity.Animal;
import com.step3.problem03.entity.Plant;
import com.step3.problem03.entity.baseEntity.Organism;

public class BiodomeFamily03 {
    public static void main(String[] args) {
        Organism organism;
        LifeNest lifeNest = new LifeNest();
        for (String arg : args) {
            String[] inputData = arg.split("/");
            if (inputData[1].equals("동물")) {
                organism = new Animal(inputData);
            }else if (inputData[1].equals("식물")) {
                organism = new Plant(inputData);
            }else {
             organism = null;  // 20번 줄을 위해 null 주입
            }
            lifeNest.addOrganism(organism);
            System.out.println();
        }

        lifeNest.removeOrganism("펭귄");
        lifeNest.displayAll();
    }
}

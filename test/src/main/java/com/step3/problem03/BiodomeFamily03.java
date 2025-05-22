package com.step3.problem03;

import com.step3.problem03.entity.Animal;
import com.step3.problem03.entity.Plant;
import com.step3.problem03.entity.baseEntity.Organism;
import com.step3.problem03.entity.bonus.Bird;
import com.step3.problem03.entity.bonus.Fish;
import com.step3.problem03.entity.bonus.Mammal;

import java.util.Optional;

public class BiodomeFamily03 {
    public static void main(String[] args) {
        Organism organism;
        LifeNest lifeNest = new LifeNest();
        for (String arg : args) {
            String[] inputData = arg.split("/");

            if (inputData.length == 5) {
                if (inputData[1].equals("동물")) {
                    organism = new Animal(inputData);
                } else if (inputData[1].equals("식물")) {
                    organism = new Plant(inputData);
                }else organism = invalidInput();
            }else if (inputData.length == 6){
                String last = inputData[5];
                // int → Fish
                if (isInteger(last)) {
                    organism = new Fish(inputData);
                    ((Fish) organism).swim();
                }
                // double → Bird
                else if (isDouble(last)) {
                    organism = new Bird(inputData);
                    ((Bird) organism).fly();
                }
                // boolean → Mammal
                else if (isBoolean(last)) {
                    organism = new Mammal(inputData);
                    ((Mammal) organism).giveBirth();
                }else organism = invalidInput();
            } else {
                organism = invalidInput();
            }
            lifeNest.addOrganism(organism);
            System.out.println();
        }

        lifeNest.removeOrganism("펭귄");
        lifeNest.displayAll();
    }
    private static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isBoolean(String s) {
        return s.equalsIgnoreCase("true") || s.equalsIgnoreCase("false");
    }

    private static Organism invalidInput() {
        System.out.println("정보를 잘 못 입력 했습니다. \n 다시 입력하세요.");
        System.exit(1);
        return null;
    }
}

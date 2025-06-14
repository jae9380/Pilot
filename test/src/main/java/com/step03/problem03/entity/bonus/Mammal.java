//package com.step3.problem03.entity.bonus;
//
//import com.step3.problem03.entity.Animal;
//
//public class Mammal extends Animal {
//    private boolean warmBlooded;
//    public Mammal(String[] info) {
//        super(info);
//        warmBlooded = Boolean.parseBoolean(info[5]);
//    }
//
//    public Mammal(String name, String species, String habitat, String digestionType, String diet, String warmBlooded) {
//        super(name, species, habitat, digestionType, diet);
//        this.warmBlooded = Boolean.parseBoolean(warmBlooded);
//    }
//
//    public void giveBirth() {
//        System.out.printf("%1$s는 새끼를 낳습니다.\n", getName());
//    }
//}
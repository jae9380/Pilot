//package com.step3.problem03.entity.baseEntity;
//
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Objects;
//
//public class Organism {
//    private String name;
//    private String species;
//    private String habitat;
//
//    public Organism(String name, String species, String habitat) {
//        this.name = name;
//        this.species = species;
//        this.habitat = habitat;
//    }
//    public void displayInfo() {
//        System.out.printf("이름: %1$-6s \t 분류: %2$-6s \t 서식지: %3$-6s ",
//                this.name, this.species, this.habitat);
//    }
//    public Map<String, String> getAllInfo() {
//        Map<String, String> info = new LinkedHashMap<>(); // 순서를 보장하기 위해 Liked선언
//        info.put("name", name);
//        info.put("species", species);
//        info.put("habitat", habitat);
//        return info;
//    }
//
//    public String getName() {
//        return name;
//    }
//}

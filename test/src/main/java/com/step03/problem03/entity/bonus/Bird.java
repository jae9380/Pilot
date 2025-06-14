//package com.step3.problem03.entity.bonus;
//
//import com.step3.problem03.entity.Animal;
//
//public class Bird extends Animal {
//    private double wingSpan;
//    public Bird(String[] info) {
//        super(info);
//        wingSpan = Double.parseDouble(info[5]);
//    }
//
//    public Bird(String name, String species, String habitat, String digestionType, String diet, String wingSpan) {
//        super(name, species, habitat, digestionType, diet);
//        this.wingSpan = Double.parseDouble(wingSpan);
//    }
//    public void fly() {
//        System.out.printf("%1$s은 %2$.1fm의 크기의 날개로 날개짓을 합니다.\n", getName(), this.wingSpan);
//    }
//}
//package com.step05.problem07;
//
//public class EnvironmentData {
//    private String date;
//    private String time;
//    private String oxygen;
//    private String humidity;
//    private String temperature;
//
//    public EnvironmentData(String... ele) {
//        String[] dateTimeParts = ele[0].split(" ");
//        this.date = dateTimeParts[0];
//        this.time = dateTimeParts[1];
//        this.oxygen = ele[1];
//        this.humidity = ele[2];
//        this.temperature = ele[3];
//    }
//
//    public void displayInfo() {
//        System.out.printf("→ 검색 결과 : %1$s %2$s, %3$s, %4$s, %5$s\n",
//                date, time, oxygen, humidity, temperature);
//    }
//    public static EnvironmentData fromData(String ele) {
//        return new EnvironmentData(ele.split(","));
//    }
//}
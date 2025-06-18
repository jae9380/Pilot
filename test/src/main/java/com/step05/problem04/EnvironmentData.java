//package com.step05.problem04;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//public class EnvironmentData implements Comparable<EnvironmentData> {
//    private String dateTime;
//    private double temperature;
//    private double humidity;
//    private double oxygenLevel;
//    private String location;
//
//    public EnvironmentData(String temperature, String humidity, String oxygenLevel, String location) {
//        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//        this.temperature = Double.parseDouble(temperature);
//        this.humidity = Double.parseDouble(humidity);
//        this.oxygenLevel = Double.parseDouble(oxygenLevel);
//        this.location = location;
//    }
//
//    public EnvironmentData(String dateTime, String temperature, String humidity, String oxygenLevel, String location) {
//        this.dateTime = dateTime;
//        this.temperature = Double.parseDouble(temperature);
//        this.humidity = Double.parseDouble(humidity);
//        this.oxygenLevel = Double.parseDouble(oxygenLevel);
//        this.location = location;
//    }
//
//    public String[] getAllDate() {
//        return new String[] {dateTime, String.valueOf(temperature), String.valueOf(humidity),
//                String.valueOf(oxygenLevel), location};
//    }
//
//    public void displayInfo() {
//        System.out.printf("%1$s, %2$s, %3$s, %4$s, %5$s\n",
//                dateTime, temperature, humidity, oxygenLevel, location.replaceAll("\\|", ","));
//    }
//
//    public void displayInfo_2() {
//        System.out.printf("%1$s - %2$s - %3$s\n",
//                dateTime, oxygenLevel, location.replaceAll("\\|", ","));
//    }
//
//    private LocalDateTime getDateTime() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        return LocalDateTime.parse(dateTime, formatter);
//    }
//
//    @Override
//    public int compareTo(EnvironmentData o) {
//        return this.getDateTime().compareTo(o.getDateTime());
//    }
//}
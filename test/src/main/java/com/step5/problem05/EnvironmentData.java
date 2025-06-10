package com.step5.problem05;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnvironmentData implements Serializable, Comparable<EnvironmentData> {
    private static final long serialVersionUID = 1L;
    private String dateTime;
    private double temperature;
    private double humidity;
    private double oxygenLevel;
    private String location;

    public EnvironmentData(String temperature, String humidity, String oxygenLevel, String location) {
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.temperature = Double.parseDouble(temperature);
        this.humidity = Double.parseDouble(humidity);
        this.oxygenLevel = Double.parseDouble(oxygenLevel);
        this.location = location;
    }

    public EnvironmentData(String dateTime, String temperature, String humidity, String oxygenLevel, String location) {
        this.dateTime = dateTime;
        this.temperature = Double.parseDouble(temperature);
        this.humidity = Double.parseDouble(humidity);
        this.oxygenLevel = Double.parseDouble(oxygenLevel);
        this.location = location;
    }

    public String[] getAllDate() {
        return new String[] {dateTime, String.valueOf(temperature), String.valueOf(humidity),
                String.valueOf(oxygenLevel), location};
    }

    public void displayInfo() {
        System.out.printf("%s, %.1f°C, %.1f%% 습도, %.1f%% 산소 농도, %s \n",
                dateTime, temperature, humidity, oxygenLevel, location.replaceAll("\\|", ","));
    }

    public void displayInfo_2() {
        System.out.printf("%1$s - %2$s - %3$s\n",
                dateTime, oxygenLevel, location.replaceAll("\\|", ","));
    }

    public void displayInfo_3() {
        System.out.printf("%1$s - %2$s : %3$.2f\n",
                dateTime, location.replaceAll("\\|", ","), LifeIndexCalc.calculateLifeIndex(this));
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getOxygenLevel() {
        return oxygenLevel;
    }

    private LocalDateTime getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(dateTime, formatter);
    }



    @Override
    public int compareTo(EnvironmentData o) {
        return this.getDateTime().compareTo(o.getDateTime());
    }
}
package com.step05.problem08;

public class EnvironmentData {
    private String dateTime;
    private String temperature;
    private String oxygen;
    private String humidity;


    public EnvironmentData(String... ele) {
        this.dateTime = ele[0];
        this.oxygen = ele[1];
        this.humidity = ele[2];
        this.temperature = ele[3];
    }

    public EnvironmentData update(String temperature , String oxygen , String humidity) {
        return new EnvironmentData(
                this.dateTime,
                this.temperature.equals(temperature) ? this.temperature : temperature,
                this.oxygen.equals(oxygen) ? this.oxygen : oxygen,
                this.humidity.equals(humidity) ? this.humidity : humidity
        );
    }

    public EnvironmentData update(String...elements) {
        return new EnvironmentData(
                this.dateTime,
                this.temperature.equals(elements[0]) ? this.temperature : elements[0],
                this.oxygen.equals(elements[1]) ? this.oxygen : elements[1],
                this.humidity.equals(elements[2]) ? this.humidity : elements[2]
        );
    }

    public void displayInfo() {
        System.out.printf("→ 검색 결과 : %1$s, %2$s, %3$s, %4$s\n",
                dateTime, oxygen, humidity, temperature);
    }
    public static EnvironmentData fromData(String ele) {
        return new EnvironmentData(ele.split(","));
    }

    public String toLine() {
        return String.format("%1$s,%2$s,%3$s,%4$s",
                this.dateTime, this.temperature, this.oxygen, this.humidity);
    }
    public String getDateTime() {
        return dateTime;
    }

    public String getDate() {
        return dateTime.split(" ")[0];
    }
}
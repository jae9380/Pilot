package com.step06.problem05;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Sensor extends Thread{
    private final String type;
    private final double minValue;
    private final double maxValue;
    private double currentValue;
    private long interval;


    public Sensor(String type, double minValue, double maxValue) {
        this.type = type;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.interval = 5000;
        System.out.printf("%s 센서 모니터링을 시작합니다...\n\n", type);
    }

    private double generateData() {
        Random rand = new Random();
        currentValue = minValue + (maxValue - minValue) * rand.nextDouble()*1.5;
        return currentValue;
    }

    private void printData() {
        String timeStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 M월 d일 HH시 mm분 ss초"));

        String valueStr = String.format("%.1f", currentValue);
        String unit = type.equals("온도") ? "°C" : "%";

        if (currentValue < minValue) {
            System.out.printf("%s %s: %s%s [경고: %s 하한 미달]%n", timeStr, type, valueStr, unit, type);
        } else if (currentValue > maxValue) {
            System.out.printf("%s %s: %s%s [경고: %s 상한 초과]%n", timeStr, type, valueStr, unit, type);
        } else {
            System.out.printf("%s %s: %s%s%n", timeStr, type, valueStr, unit);
        }
    }

    private long isValueOutOfThreshold() {
        return (currentValue < minValue || currentValue > maxValue) ? 1000 : 5000;
    }


    @Override
    public void run() {
        while (true) {
            generateData();
            printData();

            interval = isValueOutOfThreshold();

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                System.out.println(type + " 센서 스레드 중단됨.");
                break;
            }
        }
    }
}

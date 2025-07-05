package com.step06.problem08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElephantSensor implements SensorSubject {
    private List<SensorObserver> observers = new ArrayList<>();
    private Random random = new Random();

    @Override
    public void registerObserver(SensorObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(SensorObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(double temperature, int heartRate) {
        for (SensorObserver observer : observers) {
            observer.update(temperature, heartRate);
        }
    }

    public void startMonitoring() {
        while (true) {
            double temperature = 35 + random.nextDouble() * 5; // 35~40도
            int heartRate = 20 + random.nextInt(25); // 20~44 bpm

            LocalDateTime now = LocalDateTime.now();
            String formatted = now.format(DateTimeFormatter.ofPattern("yyyy년 M월 d일 HH시 mm분 ss초"));

            System.out.printf("%s 체온 : %.1f°C, 심박수 : %dbpm%n", formatted, temperature, heartRate);

            notifyObservers(temperature, heartRate);

            try {
                Thread.sleep(10000); // 10초 간격
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}


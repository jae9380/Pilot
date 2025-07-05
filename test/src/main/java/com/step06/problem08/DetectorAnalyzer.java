package com.step06.problem08;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DetectorAnalyzer implements SensorObserver {
    private List<String> alerts = new ArrayList<>();

    @Override
    public void update(double temperature, int heartRate) {
        Stream.of(temperature)
                .filter(t -> t < 35.9 || t > 37.5)
                .forEach(t -> {
                    String alert = String.format("[분석기 1] 임계치 이상 체온 : %.1f°C", t);
                    alerts.add(alert);
                    System.out.println(alert);
                });

        Stream.of(heartRate)
                .filter(h -> h < 25 || h > 40)
                .forEach(h -> {
                    String alert = String.format("[분석기 1] 임계치 이상 심박수 : %dbpm", h);
                    alerts.add(alert);
                    System.out.println(alert);
                });
    }
}

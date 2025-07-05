package com.step06.problem08;

import java.util.ArrayList;
import java.util.List;

public class CalculationAnalyzer implements SensorObserver {
    private List<Double> temperatures = new ArrayList<>();

    @Override
    public void update(double temperature, int heartRate) {
        temperatures.add(temperature);

        double average = Math.round(
                temperatures.stream().mapToDouble(Double::doubleValue).average().orElse(0.0) * 10.0
        ) / 10.0;

        double max = temperatures.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
        double min = temperatures.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);

        System.out.printf("[분석기 2] 평균 체온 : %.1f°C%n", average);
        System.out.printf("[분석기 2] 최대 체온 : %.1f°C%n", max);
        System.out.printf("[분석기 2] 최소 체온 : %.1f°C%n\n", min);
    }
}

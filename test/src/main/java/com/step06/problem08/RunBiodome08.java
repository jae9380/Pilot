package com.step06.problem08;

public class RunBiodome08 {
    public static void main(String[] args) {
        ElephantSensor sensor = new ElephantSensor();

        DetectorAnalyzer detector = new DetectorAnalyzer();
        CalculationAnalyzer calculation = new CalculationAnalyzer();

        sensor.registerObserver(detector);
        sensor.registerObserver(calculation);

        sensor.startMonitoring();
    }
}

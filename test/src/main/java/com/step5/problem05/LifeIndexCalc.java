package com.step5.problem05;

public class LifeIndexCalc {
    private static final double BIONETTI_CONSTANT = 0.415;

    public static double calculateLifeIndex(EnvironmentData data) {
        return BIONETTI_CONSTANT * Math.abs(Math.sqrt(data.getHumidity()) - data.getTemperature()) + data.getOxygenLevel() / Math.pow(Math.PI, 2);
    }
}

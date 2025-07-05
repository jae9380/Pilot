package com.step06.problem08;

public interface SensorSubject {
    void registerObserver(SensorObserver observer);
    void removeObserver(SensorObserver observer);
    void notifyObservers(double temperature, int heartRate);
}

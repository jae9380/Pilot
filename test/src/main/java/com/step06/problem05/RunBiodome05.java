package com.step06.problem05;

public class RunBiodome05 {
    public static void main(String[] args) {
        Sensor sensor1 = new Sensor("온도", -5, 32.5);
        Sensor sensor2 = new Sensor("산소 농도", 18.5, 23.5);

        sensor1.start();
        sensor2.start();
    }
}

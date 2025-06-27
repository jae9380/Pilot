package com.step06.problem07;

public class City {
    private final String name;
    private int energy;

    public City(String name) {
        this.name = name;
        this.energy = 0;
    }

    public void requestEnergy(int amount) {
        EnergyManageCenter center = EnergyManageCenter.getInstance();
        if (center.allocateEnergy(name, amount)) {
            energy += amount;
        }
    }

    public void printStatus() {
        System.out.println(name + ": " + energy);
    }

    public String getName() {
        return name;
    }
}

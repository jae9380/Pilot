package com.step3.problem02;

public class Organism {
    private String name;
    private String species;
    private String habitat;
    private String characteristic;
    private int lifeSpan;

    public Organism(String name, String species, String habitat, String characteristic, String lifeSpan) {
        this.name = name;
        this.species = species;
        this.habitat = habitat;
        this.characteristic = characteristic;
        this.lifeSpan = Integer.parseInt(lifeSpan);
    }
    public void displayInfo() {
        System.out.printf("이름: %1$-6s \t 분류: %2$-6s \t 서식지: %3$-6s \t 특징: %4$-6s \t 수명: %5$d년\n",
                this.name, this.species, this.habitat, this.characteristic, this.lifeSpan);
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }
}

package com.step3.problem06;

public class Animal {
    private String name;
    private String species;
    private int age;

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public Animal(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public Animal(String[] arr) {
        name = arr[0];
        species = arr[1];
        age = Integer.parseInt(arr[2]);
    }

    public void introduction() {
        System.out.printf("%1$s(%2$s, %3$d) ", name, species, age);
    }
}

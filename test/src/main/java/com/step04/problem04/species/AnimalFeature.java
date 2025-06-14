package com.step04.problem04.species;

public class AnimalFeature {
    private String behavior;
    private String reproduction;
    private String predator;
    private String prey;
    private int averageLifespan;

    public AnimalFeature(String behavior, String reproduction, String predator, String prey, String averageLifespan) {
        this.behavior = behavior;
        this.reproduction = reproduction;
        this.predator = predator;
        this.prey = prey;
        this.averageLifespan = Integer.parseInt(averageLifespan);
        System.out.printf("%1$s\t %2$s\t %3$s\t %4$s\t %5$s년\n", behavior, reproduction, predator, prey, averageLifespan);

    }
}

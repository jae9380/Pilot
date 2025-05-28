package com.step4.problem04.species;

public class PlantFeature {
    private String flowerColor;
    private boolean hasFruit;
    private String bloomSeason;

    public PlantFeature(String flowerColor, String hasFruit, String bloomSeason) {
        this.flowerColor = flowerColor;
        this.hasFruit = Boolean.parseBoolean(hasFruit);
        this.bloomSeason = bloomSeason;
    }
}

package com.step4.problem04.species;

public class PlantFeature {
    private String flowerColor;
    private boolean hasFruit;
    private String bloomSeason;

    public PlantFeature(String flowerColor, String hasFruit, String bloomSeason) {
        this.flowerColor = flowerColor;
        this.hasFruit = Boolean.parseBoolean(hasFruit);
        this.bloomSeason = bloomSeason;
        System.out.printf("%1$s\t %2$s\t %3$s\n", flowerColor, this.hasFruit ? "열매 있음":"열매 없음", bloomSeason);
    }
}

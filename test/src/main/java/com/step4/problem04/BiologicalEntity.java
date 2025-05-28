package com.step4.problem04;

import com.step4.problem04.species.AnimalFeature;
import com.step4.problem04.species.MicrobeFeature;
import com.step4.problem04.species.PlantFeature;

public class BiologicalEntity<G> {
    private String name;
    private String classification;
    private G species;

    public BiologicalEntity(String name, String classification, G species) {
        System.out.printf("[BiologicalEntity] %1$s\t %2$s\t", name, classification);
        this.name = name;
        this.classification = classification;
        this.species = species;
    }
    public BiologicalEntity(String... info) {
        System.out.printf("[BiologicalEntity] %1$s\t %2$s\t", info[0], info[1]);
        this.name = info[0];
        this.classification = info[1];
        this.species = getObject(info);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public G getSpecies() {
        return species;
    }

    public void setSpecies(G species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "BiologicalEntity{" +
                "name='" + name + '\'' +
                ", classification='" + classification + '\'' +
                ", species=" + species +
                '}';
    }

    @SuppressWarnings("unchecked")
    private G getObject(String... info) {
        G g;
        switch (info[1]) {
            case "동물" : g = (G) new AnimalFeature(info[2], info[3], info[4], info[5], info[6]);
                break;
            case "식물" : g = (G) new PlantFeature(info[2], info[3], info[4]);
                break;
            case "미생물" : g = (G) new MicrobeFeature(info[2], info[3], info[4]);
                break;
            default:
                throw new IllegalArgumentException("분류 기준에 없는 타입을 입력 했습니다 : "+ info[1]);
        }
        return g;
    }
}

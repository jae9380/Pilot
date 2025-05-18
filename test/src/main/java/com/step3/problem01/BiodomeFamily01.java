package com.step3.problem01;

public class BiodomeFamily01 {
    public static void main(String[] args) {
        Organism organism;
        LifeNest lifeNest = new LifeNest();
        for (String arg : args) {
            String[] inputData = arg.split(" ");
            organism = new Organism(inputData[0], inputData[1], inputData[2]);
            organism.displayInfo();
            System.out.println("LifeNest에 organism 데이터 저장");
            lifeNest.addOrganism(organism);
            System.out.println();
        }
        lifeNest.removeOrganism("코알라1");
        lifeNest.displayAll();

        lifeNest.findByName("펭귄").setHabitat("남극");
        lifeNest.displayAll();
        System.out.println();
        lifeNest.searchOrganismByName("페퍼민트");
    }
}


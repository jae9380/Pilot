//package com.step3.problem02;
//
//public class BiodomeFamily02 {
//    public static void main(String[] args) {
//        Organism organism;
//        LifeNest lifeNest = new LifeNest();
//        for (String arg : args) {
//            String[] inputData = arg.split("/");
//            organism = new Organism(inputData[0].trim(), inputData[1].trim(), inputData[2].trim(), inputData[3].trim(), inputData[4].trim());
//            organism.displayInfo();
//            lifeNest.addOrganism(organism);
//            System.out.println();
//        }
//        lifeNest.removeOrganism("코알라1");
//        lifeNest.displayAll();
//
//        lifeNest.findByName("펭귄").setHabitat("남극");
//        lifeNest.displayAll();
//        System.out.println();
//        lifeNest.searchOrganismByName("페퍼민트");
//        lifeNest.changeHabitatByName("펭귄", "냉장고");
//    }
//}

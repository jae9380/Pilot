package com.step04.problem07;

public class RuleOfBiodome07 {
    public static void main(String[] args) {
        Plant p1 = new Plant("백합", "식물", 100, 15, "2130-03-12 12:00");
        Plant p2 = new Plant("나무딸기", "식물", 200, 20, "2130-03-12 14:20");
        Plant p3 = new Plant("선인장", "식물", 5, 30, "2130-03-12 09:00");
        Plant p4 = new Plant("라일락", "식물", 20, 25, "2130-03-12 11:00");
        Plant p5 = new Plant("대나무", "식물", 15, 50, "2130-03-11 19:00");

        PlantManagementSystem pms = new PlantManagementSystem(new PlantPriorityQueue());

        pms.addPlant(p1);
        pms.addPlant(p2);
        pms.addPlant(p3);
        pms.addPlant(p4);
        pms.addPlant(p5);

        pms.showAllPlants();

        pms.waterTopPriorityPlant();
        pms.waterTopPriorityPlant();
        pms.waterTopPriorityPlant();

        pms.showAllPlants();
    }
}

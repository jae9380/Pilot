package com.step4.problem07;

public class PlantManagementSystem {
    private PlantPriorityQueue ppq;

    public PlantManagementSystem(PlantPriorityQueue ppq) {
        this.ppq = ppq;
        System.out.println("[ManagementSystem] 식물 관리 시스템이 생성되었습니다.");
    }

    public void addPlant(Plant plant) { // 식물 추가
        ppq.add(plant);
        System.out.printf("[ManagementSystem] %s이 관리 대상에 추가되었습니다.\n", plant.getName());

    }
    public void waterTopPriorityPlant() { // 가장 먼저 물 줘야 할 식물에게 물 주고 리스트에서 제거
//        우선 관리 대상: 백합, 필요한 물의 양: 100
//        백합에 물을 공급했습니다. 마지막 물 공급 일자 업데이트: [현재 시각]
        Plant plant = ppq.poll();
        if (plant == null) {
            System.out.println("[ManagementSystem] 물을 줄 식물이 없습니다.");
            return;
        }
        plant.water(); // 현재 시간으로 업데이트
        System.out.printf("[ManagementSystem] 우선 관리 대상 : %1$s \t 필요한 양 : %2$d \n%1$s에거 물을 공급했습니다. 마지막 공급 일자 현재 시간 기준으로 업데이트\n",plant.getName(), plant.getWaterAmount());
    }
    public void showTopPriorityPlant() { // 가장 우선순위 높은 식물 정보 출력
        Plant plant = ppq.peek();
        if (plant != null)
            System.out.printf("[ManagementSystem] 가장 먼저 물을 줘야 하는 식물: %1$s \t 필요한 양 : %2$d \t 마지막 공급 : %3$s\n",
                    plant.getName(), plant.getWaterAmount(), plant.getLastWateredToString());

    }

    public void showAllPlants() { // 모든 식물 정보 출력
        System.out.println("[ManagementSystem] 관리 대상 식물 전체 출력");
        ppq.showAll();
        System.out.println("------------------------------------");
    }

}

package com.step3.problem01;

import java.util.ArrayList;
import java.util.List;

public class LifeNest {
    private List<Organism> organismList;

    public LifeNest() {
        organismList = new ArrayList<>();
    }

    public void addOrganism(Organism organism) {
        organismList.add(organism);
        System.out.printf("[LifeNest] 데이터 추가 이름: %1$s \t 분류: %2$s \t 서식지: %3$s \n", organism.getName(), organism.getSpecies(), organism.getHabitat());
    }

    public void removeOrganism(String name) {
        organismList.removeIf(org -> {
            if (org.getName().equals(name)) {
                System.out.printf("[LifeNest] 데이터 삭제 성공 이름: %s\n", name);
                return true;
            }
            return false;
        });
        System.out.printf("[LifeNest] 데이터 삭제 실패 \"%s\" 해당 이름의 데이터는 없습니다.\n", name);
    }

    public void displayAll() {
        System.out.println("---- 현재 저장된 모든 정보 ----");
        for (Organism org : organismList) {
            org.displayInfo();
        }
    }

    public Organism findByName(String name) {
        for (Organism org : organismList) {
            if (org.getName().equals(name)) {
                return org;
            }
        }
        return null;
    }

    public void searchOrganismByName(String target) {
        System.out.printf("\"%s\" 이름의 Organism 정보 찾는 중..\n", target);
        organismList.forEach(organism -> {
            if (organism.getName().equals(target)) organism.displayInfo();
        });
    }
}

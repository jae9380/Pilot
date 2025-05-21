package com.step3.problem02;

import java.util.ArrayList;
import java.util.List;

public class LifeNest {
    private List<Organism> organismList;

    public LifeNest() {
        organismList = new ArrayList<>();
    }

    public void addOrganism(Organism organism) {
        organismList.add(organism);
        System.out.printf("[LifeNest] 새로운 데이터 추가 이름: %1$-6s \t 분류: %2$-6s \t 서식지: %3$-6s \t 특징: %4$-6s \t 수명: %5$d년\n",
                organism.getName(), organism.getSpecies(), organism.getHabitat(),organism.getCharacteristic(), organism.getLifeSpan());
    }

    public void removeOrganism(String name) {
        boolean removed = organismList.removeIf(org -> org.getName().equals(name));
        if (removed) {
            System.out.printf("[LifeNest] 데이터 삭제 성공 이름: %s\n", name);
        } else {
            System.out.printf("[LifeNest] 데이터 삭제 실패 \"%s\" 해당 이름의 데이터는 없습니다.\n", name);
        }

//        삭제 성공을 했어도 삭제 실패 메세지 출력되는 문제 발생
//        organismList.removeIf(org -> {
//            if (org.getName().equals(name)) {
//                System.out.printf("[LifeNest] 데이터 삭제 성공 이름: %s\n", name);
//                return true;
//            }
//            return false;
//        });
//        System.out.printf("[LifeNest] 데이터 삭제 실패 \"%s\" 해당 이름의 데이터는 없습니다.\n", name);
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
            if (organism.getName().equals(target)) {
                organism.displayInfo();
                return;
            }
        });
        System.out.printf("[LifeNest] \"%s\" 이름의 Organism 정보를 찾을 수 없습니다.\n",target);
    }

    public void changeHabitatByName(String target, String newHabitat) {
        System.out.printf("[LifeNest] \"%s\" 이름의 Organism 정보 찾는 중..\n", target);
        try {
            organismList.forEach(organism -> {
                if (organism.getName().equals(target)) {
                    organism.setHabitat(newHabitat);
                    System.out.printf("[LifeNest] \"%s\" 이름의 Organism 서식지를 수정 했습니다.\n", target);
                    organism.displayInfo();
                    throw new RuntimeException("_break");
                }
            });
        } catch (RuntimeException e) {
            if (!"_break".equals(e.getMessage())) throw e;
            return;
        }
        System.out.printf("[LifeNest] \"%s\" 이름의 Organism 정보를 찾을 수 없습니다.\n", target);

    }
}

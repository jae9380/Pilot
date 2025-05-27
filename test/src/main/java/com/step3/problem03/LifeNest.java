//package com.step3.problem03;
//
//import com.step3.problem03.entity.Animal;
//import com.step3.problem03.entity.Plant;
//import com.step3.problem03.entity.baseEntity.Organism;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class LifeNest {
//    private List<Organism> organismList;
//
//    public LifeNest() {
//        organismList = new ArrayList<>();
//    }
//
//    public void addOrganism(Organism organism) {
//        organismList.add(organism);
//        String[] info = organism.getAllInfo().values().toArray(new String[0]);
//        String extraInfo = organism instanceof Animal
//                ? "\t 주식: "+info[3]+" \t 먹이: " + info[4]
//                : organism instanceof Plant
//                ? "\t 개화 시기: "+info[3]+"월 \t 열매 여부: " + info[4]
//                : "\t [기타]";
//        System.out.printf("[LifeNest] 새로운 데이터 추가 이름: %1$-6s \t 분류: %2$-6s \t 서식지: %3$-6s %4$s",
//                info[0], info[1], info[2],extraInfo);
//    }
//
//    public void removeOrganism(String name) {
//        boolean removed = organismList.removeIf(org -> org.getName().equals(name));
//        if (removed) {
//            System.out.printf("[LifeNest] 데이터 삭제 성공 이름: %s\n", name);
//        } else {
//            System.out.printf("[LifeNest] 데이터 삭제 실패 \"%s\" 해당 이름의 데이터는 없습니다.\n", name);
//        }
//    }
//
//    public void displayAll() {
//        System.out.println("---- 현재 저장된 모든 정보 ----");
//        for (Organism org : organismList) {
//            System.out.print("[LifeNest] ");
//            org.displayInfo();
//        }
//    }
//
////    public Organism findByName(String name) {
////        for (Organism org : organismList) {
////            if (org.getName().equals(name)) {
////                return org;
////            }
////        }
////        return null;
////    }
//
////    public void searchOrganismByName(String target) {
////        System.out.printf("\"%s\" 이름의 Organism 정보 찾는 중..\n", target);
////        organismList.forEach(organism -> {
////            if (organism.getName().equals(target)) {
////                organism.displayInfo();
////                return;
////            }
////        });
////        System.out.printf("[LifeNest] \"%s\" 이름의 Organism 정보를 찾을 수 없습니다.\n",target);
////    }
//
////    public void changeHabitatByName(String target, String newHabitat) {
////        System.out.printf("[LifeNest] \"%s\" 이름의 Organism 정보 찾는 중..\n", target);
////        try {
////            organismList.forEach(organism -> {
////                if (organism.getName().equals(target)) {
////                    organism.setHabitat(newHabitat);
////                    System.out.printf("[LifeNest] \"%s\" 이름의 Organism 서식지를 수정 했습니다.\n", target);
////                    organism.displayInfo();
////                    throw new RuntimeException("_break");
////                }
////            });
////        } catch (RuntimeException e) {
////            if (!"_break".equals(e.getMessage())) throw e;
////            return;
////        }
////        System.out.printf("[LifeNest] \"%s\" 이름의 Organism 정보를 찾을 수 없습니다.\n", target);
////
////    }
//}

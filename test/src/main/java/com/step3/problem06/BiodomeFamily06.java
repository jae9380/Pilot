package com.step3.problem06;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BiodomeFamily06 {
//    제니(원숭이, 4살), 고먀(코끼리, 4살), 타이(호랑이, 9살), 로아(코뿔소, 5살), 바비(사슴, 7살)

/*
호랑이는 사슴의 포식자로, 사슴 뒤에 호랑이가 올 수 없다.
코끼리는 적대 관계의 동물이 없지만, 5살 이하 코끼리는 호랑이 앞에 올 수 없다.
일렬 이동 중 동물은 앞만 볼 수 있고 뒤는 볼 수 없다.

[로아(코뿔소, 5살), 타이(호랑이, 9살), 고먀(코끼리, 4살), 제니(원숭이, 4살), 바비(사슴, 7살)]
[제니(원숭이, 4살), 타이(호랑이, 9살), 로아(코뿔소, 5살), 고먀(코끼리, 4살), 바비(사슴, 7살)]
*/
    public static void main(String[] args) {
        Animal animal;
        List<Animal> animals = new LinkedList<>();

        for (String arg : args) {
            animal = new Animal(arg.split(","));
            animals.add(animal);
        }
        List<Animal> safeOrder = reorderAnimals(animals);

        if (safeOrder != null) {
            System.out.println("안전한 동물 순서:");
            for (Animal a : safeOrder) {
                a.introduction();
            }
        } else {
            System.out.println("안전한 순서를 만들 수 없습니다.");
        }
    }

    // 문제에서 5 종류의 동물로 제한되어 있다.
    // 그렇기 때문에 만들 수 있는 조합의 list는 5!
    // 하나의 list를 정렬하는 방법이 아닌 120개의 list에서 필터링을 통하여 만족하는 list 추출
    private static List<Animal> reorderAnimals(List<Animal> animals) {
        List<Animal> permutations = new LinkedList<>(animals);

        List<List<Animal>> allPermutations = new LinkedList<>();
//        가능한 조합의 list를 이중 list에 저장
        permute(permutations, 0, allPermutations);

        System.out.println(allPermutations.size()); // 5!개의 list 생성 확인

        for (List<Animal> list : allPermutations) {
            if (isSafeOrder(list)) { // 필터링을 통하여 만족하는 list를 반환
                return list;
            }
        }
        return null;
    }

    private static void permute(List<Animal> list, int index, List<List<Animal>> result) {
        if (index == list.size() - 1) {
            result.add(new LinkedList<>(list)); // 다른 조합의 list를 추가
            return;
        }

        for (int i = index; i < list.size(); i++) {
//            {A, B, C} -> {A, B, C}, {A, C, B}, {B, A, C}, {B, C, A}, ... 처럼 여러 list 생성
            Collections.swap(list, i, index); // list에서 i번 쨰 요소와 index번 째 요소를 바꿔주는 메서드
            permute(list, index + 1, result); // 재귀 함수를 이용하여 list 전체 요소를 바꿈
            Collections.swap(list, i, index); // 백트래킹 (바꾼 요소를 다시 원위치 시킨다.)
        }
    }

    private static boolean isSafeOrder(List<Animal> animals) {
        for (int i = 0; i < animals.size(); i++) {
            Animal current = animals.get(i);
            if (current.getSpecies().equals("사슴")) {
                for (int j = i + 1; j < animals.size(); j++) {
                    if (animals.get(j).getSpecies().equals("호랑이")) {
                        return false;
                    }
                }
            }
            if (current.getSpecies().equals("코끼리") && current.getAge() <= 5) {
                for (int j = i + 1; j < animals.size(); j++) {
                    if (animals.get(j).getSpecies().equals("호랑이")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

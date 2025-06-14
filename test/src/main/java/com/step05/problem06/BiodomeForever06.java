package com.step05.problem06;

import java.util.Scanner;

public class BiodomeForever06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResearcherManager rm = new ResearcherManager();

        System.out.println("========================================");
        System.out.println("\t\t연구원 정보 관리 시스템");

        while (true) {
            System.out.print("1. 새로운 연구자 등록\n2. 모든 연구자 조회\n3. 조건 기반 연구자 검색\n4. 프로그램 종료\n선택: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.print("연구원의 이름을 입력하세요: ");
                    String name = scanner.nextLine();

                    System.out.print("연구원의 담당 위치를 입력하세요: ");
                    String responsibleArea = scanner.nextLine();

                    rm.register(name,responsibleArea);
                    System.out.println("========================================");

                    break;
                case "2":
                    rm.showResearcherList();
                    System.out.println("========================================");

                    break;
                case "3":
                    System.out.print("검색할 연구원의 ID를 입력하세요: ");
                    String id = scanner.nextLine();
                    rm.showResearcherById(id);
                    System.out.println("========================================");

                    break;
                case "4":
                    System.out.println("프로그램을 종료합니다. 감사합니다.");
                    System.out.println("========================================");

                    return;
                default:
                    System.out.println("잘못된 입력입니다. 1, 2, 3 중 하나를 선택해주세요.");
                    System.out.println("========================================");

            }
        }
    }
}

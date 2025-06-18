package com.step06.problem02;

import java.util.Scanner;

public class RunBiodome02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EnergyDistributor ed = new EnergyDistributor();

        while (true) {
            System.out.println("1. 전체 에너지 조회하기\n2. 특정 구역 에너지 할당하기\n3. 구역별 에너지 조회하기\n4. 종료하기\n");
            System.out.print("메뉴를 선택하세요: ");
            String input = sc.nextLine();

            switch(input) {
                case "1":
                    ed.getTotalE();
                    break;
                case "2":
                    System.out.print("할당하려는 구역 이름을 입력하세요: ");
                    String zone = sc.nextLine();

                    System.out.print("할당하려는 에너지량을 입력하세요: ");
                    String e = sc.nextLine();

                    ed.allocateE(zone, e);
                    break;
                case "3":
                    ed.displayZoneEnergy();
                    break;
                case "4":
                    System.out.println("→ 바이오도메 에너지 관리 시스템을 종료합니다. 감사합니다.");
                    return;
                default:
                    System.out.println("→ 1번에서 4번 메뉴를 선택해주세요.\n");

            }
        }
    }
}

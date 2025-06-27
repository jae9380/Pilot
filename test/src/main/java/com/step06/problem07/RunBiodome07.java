package com.step06.problem07;

import java.util.Scanner;

public class RunBiodome07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("에너지 관리 시스템에 오신걸 환영합니다.\n");

        City terraNova = new City("TerraNova");
        City luminaBay = new City("LuminaBay");
        City flowBridges = new City("FlowBridges");

        while (true) {
            System.out.println("1. 중앙 에너지 센터와 3개 도시 에너지양 조회하기");
            System.out.println("2. 도시에 에너지 할당하기");
            System.out.println("3. 프로그램 종료하기");
            System.out.print("메뉴 선택: ");

            String input = sc.nextLine().trim();
            System.out.println();
            switch (input) {
                case "1":
                    System.out.println("중앙 에너지 센터와 3개 도시 에너지양 조회");
                    System.out.println("중앙 에너지 센터: " + EnergyManageCenter.getInstance().getTotalEnergy());
                    terraNova.printStatus();
                    luminaBay.printStatus();
                    flowBridges.printStatus();
                    break;

                case "2":
                    System.out.print("도시 이름 입력: ");
                    String cityName = sc.nextLine().trim();

                    System.out.print("할당할 에너지양 입력: ");
                    String energyStr = sc.nextLine().trim();

                    int amount;
                    try {
                        amount = Integer.parseInt(energyStr);
                    } catch (NumberFormatException e) {
                        System.out.print("숫자를 입력해 주세요.\n");
                        break;
                    }

                    if (cityName.equalsIgnoreCase("TerraNova")) {
                        terraNova.requestEnergy(amount);
                    } else if (cityName.equalsIgnoreCase("LuminaBay")) {
                        luminaBay.requestEnergy(amount);
                    } else if (cityName.equalsIgnoreCase("FlowBridges")) {
                        flowBridges.requestEnergy(amount);
                    } else {
                        System.out.printf("%s는 존재하지 않는 도시입니다.\n", cityName);
                    }
                    break;

                case "3":
                    System.out.print("프로그램을 종료합니다.\n");
                    sc.close();
                    return;

                default:
                    System.out.print("유효한 메뉴 번호를 입력하세요.\n");
                    break;
            }
            System.out.println();
        }
    }
}

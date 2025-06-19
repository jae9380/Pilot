package com.step06.problem04;

import java.util.Scanner;

public class RunBiodome04 {
    public static void main(String[] args) {
        FruitStore1 fs = new FruitStore1();
        Scanner sc = new Scanner(System.in);

        System.out.println("1. 모든 과일 재고 조회하기\n2. 가장 많이 팔린 과일 조회하기\n3. 총 판매 과일 수 조회하기\n4. 과일별 평균 판매 개수 조회하기\n5. 종료하기\n");

        while (true) {
            System.out.print("메뉴를 선택하세요: ");
            String input = sc.nextLine();

            switch (input) {
                case "1":
                    fs.showList();
                    break;
                case "2":
                    fs.bestSellingsItem();
                    break;
                case "3":
                    fs.showTotalSales();
                    break;
                case "4":
                    fs.averageSalesVolumeOfEach();
                    break;
                case "5":
                    fs.saveDataToFile();
                    return;
                default:
                    System.out.println("→ 1번에서 4번 메뉴를 선택해주세요.\n");
            }
        }
    }
}

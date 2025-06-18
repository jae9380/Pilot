package com.step06.problem03;

import java.util.Scanner;

public class RunBiodome03 {
    public static void main(String[] args) {
        FruitStore fs = new FruitStore();
        Scanner sc = new Scanner(System.in);

        System.out.println("1. 과일 판매하기\n2. 과일 재고 추가하기\n3. 모든 과일 재고 조회하기\n4. 특정 과일 최근 판매 정보\n5. 종료하기\n");

        while (true) {
            System.out.print("메뉴를 선택하세요: ");
            String input = sc.nextLine();

            switch (input) {
                case "1":
                    System.out.print("판매할 과일의 이름을 입력하세요: ");
                    String name = sc.nextLine();
                    System.out.print("판매할 수량을 입력하세요: ");
                    String quantity = sc.nextLine();

                    fs.sale(name, quantity);
                    break;
                case "2":
                    System.out.print("재고를 추가할 과일 이름을 입력하세요: ");
                    String addName = sc.nextLine();
                    System.out.print("추가할 수량을 입력하세요: ");
                    String addQuantity = sc.nextLine();

                    fs.addStock(addName, addQuantity);
                    break;
                case "3":
                    fs.showList();
                    break;
                case "4":
                    System.out.print("최든 판매 이력을 확인할 과일 이름을 입력하세요: ");
                    String saleName = sc.nextLine();
                    fs.previousSalesHistory(saleName);
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

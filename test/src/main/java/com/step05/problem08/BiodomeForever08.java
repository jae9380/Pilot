package com.step05.problem08;

import java.util.Scanner;

public class BiodomeForever08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EnvironmentManager em = new EnvironmentManager();
        System.out.print("환경 데이터 검색 및 수정 프로그램에 오신 것을 환영합니다!\n 검색하고 싶은 날짜를 입력하세요: ");
        String date = sc.nextLine();

        Node node = em.getNodeByDate(date);
        if (node == null) System.exit(1);

        System.out.print("데이터를 수정하시겠습니까? (Y/N): ");
        String input = sc.nextLine();

        switch (input.toUpperCase()) {
            case "Y" :
                System.out.print("새로운 데이터 값을 입력하세요: ");
                String elements = sc.nextLine();
                em.updateData(node, elements.split(","));
                break;
            case "N" : System.out.println("프로그램을 종료 합니다.");
                return;
            default: System.out.println("Y/N 중 하나만 입력하세요.");
        }
    }
}

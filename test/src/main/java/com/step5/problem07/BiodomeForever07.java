package com.step5.problem07;

import java.util.Scanner;

public class BiodomeForever07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EnvironmentManager em = new EnvironmentManager();

        System.out.print("환경 데이터 검색 프로그램을 시작합니다.\n검색하고 싶은 날짜를 입력하세요: ");
        String request = sc.nextLine();

        em.showDataByDateTime(request);
    }
}
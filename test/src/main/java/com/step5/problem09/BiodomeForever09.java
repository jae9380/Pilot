package com.step5.problem09;

import java.util.Scanner;

public class BiodomeForever09 {
    public static void main(String[] args) {
/*
    중복인 시나리오        src/main/resources/step05/problem09/scenario1
    중복이 아닌 시나리오    src/main/resources/step05/problem09/scenario2
    파일이 없는 시나리오     src/main/resources/step05/problem09/scenario3
    틀린 주소 시나리오      src/main/resources/step05/problem09/scenario4
*/

        FileUtil fu = new FileUtil();
        Scanner sc = new Scanner(System.in);

        System.out.print("중복 파일 검색기에 오신 걸 환영합니다.\n탐색할 폴더를 입력하세요: ");
        fu.findAndPrintDuplicates(sc.nextLine());
    }
}

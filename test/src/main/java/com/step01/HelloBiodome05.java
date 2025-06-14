package com.step01;

public class HelloBiodome05 {
    static int g, h;
    public static void main(String[] args) {
        find();
        calc();
    }

    private static void find() {
        for (int i = 0; i <16 ; i++) {      //  변수의 최대 데이터의 크기가 4 bit이기 때문에 0 ~ 15
            for (int j = 0; j <16 ; j++) {

                int a = i & 1 >> i << 2 | j + i ^ j;
                int b = i % 2 << j >> i | 1 & 0 ^ 0; // o ^ o 를 0 ^ 0으로 가정하여 일단 진행


                if(a == 1 && b == 2) {
                    g = i;
                    h = j;
                    return;
                }
            }
        }
    }
    private static void calc() {
        System.out.println(((h * h + g) * (h << h) + (g << g)));
    }
}
/* 보너스 문제 x
각 변수는 4bit로 한정되었기 때문에 반복문에서 0~15까지만 반복하도록 설정했다.

연산에 사용되는 g와 h는 필드 인스턴스로 먼저 선언하고, 메서드를 통하여 수식에 대한 연산 결과를 변수 a, b에 일단 저장하고, 각각 a, b에 적합한 정답이 나올 경우에
옳은 값이라 판단하여 g와 h에 저장한다.
 */

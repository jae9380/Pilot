package com.step01;

public class HelloBiodome03 {
    static final Double PI = 3.14;
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("입력값은 총 3개 입니다. [온도][습도][산소농도] 순서 대로 숫자 값을 다시 입력해주세요.");
            return;
        }
        for (String arg : args) {
            if (arg.matches(".*[^0-9.].*")) {
                System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서 대로 숫자 값을 다시 입력해주세요");
                return;
            }
        }

        double t = Double.parseDouble(args[0]),
                h = Double.parseDouble(args[1]),
                o = Double.parseDouble(args[2]);

        System.out.println(calc(h, t, o));
        System.out.printf("생명지수 H = %.2f",calc(h, t, o));
    }
    private static double squareRoot = 1.0;
    static void root(double value) {    // 제곱근 계산
        if (squareRoot == (squareRoot+(value/squareRoot))/2) return;
        squareRoot = (squareRoot+(value/squareRoot))/2;
        root(value);
        return;
    }

    static double absoluteValue(double h, double t) { // 절댓값 계산
        root(h);
        double answer = squareRoot - t;
        return answer < 0 ? -answer : answer;
    }

    static double calc(double h, double t, double o) { // 최종 연산
        return 0.415*absoluteValue(h,t)+(o/(PI*PI));
    }
}
/*      보너스 해결 o
* 제곱근 계산
    제곱근을 계산하는 로직은 뉴턴-랩슨 방법을 사용하여, 반복적으로 평균값 (s + x/s) / 2을 계산해 제곱근의 근사값에 수렴해 가는 방식으로 제곱근을 구했다.
    특히, 반복문 사용 제한이 있기 때문에 이를 해결하기 위한 방법으로 재귀호출하여 반복문을 재체해서 근삿값을 구했다.
* 절댓값 계산
    계산된 제곱근을 이용하여 빼기 연산을 하고 도출된 결과를 기준으로 삼항연산자를 이용하여 해당 값이 음수일 경우 "-"를 붙이고, 양수일 경우 그냥 반환했다.
* 필드 상수 선언
    워주율 같은 경우에는 불변값이기 때문에 static final 상수로 선언하여 사용 했다.
* 반올림 연산
    최종 값을 출력할 때, 소수점 셋째 자리에서 반올림을 위해서 printf()를 이용하여 %.2f 조건을 걸어 출력 시 자동으로 반올림 연산을 하도록 함
 */
package com.step1;

public class HelloBiodome04 {
    static final Double PI = 3.14;
    private static double[][] rangeOfElements = {{10.0, 27.5}, {40.0, 60.1}, {19.5, 23.5}};

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
        double[] elements = new double[3];
        boolean[] proper = new boolean[3];
        for (int i = 0; i <args.length ; i++) {
            elements[i] = Double.parseDouble(args[i]);


            proper[i] = isItProper(i, elements[i]);
        }

        for (int i = 0; i <proper.length ; i++) {
            if(!proper[i]) {
                String ele = "";
                switch (i) {
                    case 0 :
                        ele = "온도";
                        break;
                    case 1 :
                        ele = "습도";
                        break;
                    case 2 :
                        ele = "산소 농도";
                        break;
                }
                System.out.printf("%s 값이 정상 범위를 벗어났습니다. 확인이 필요합니다.", ele);
                return;
            }
        }

        System.out.println(calc(elements[1], elements[0], elements[2]));
        System.out.printf("생명의 나무는 안정적인 상태입니다. 건강지수는 %.2f입니다.", calc(elements[1], elements[0], elements[2]));


    }

    private static boolean isItProper(int i, double elements ){
        return  i == 0 ? (elements >= rangeOfElements[i][0] && elements < rangeOfElements[i][1]) :
                i == 1 ? (elements > rangeOfElements[i][0] && elements < rangeOfElements[i][1]) :
                        (elements >= rangeOfElements[i][0] && elements <= rangeOfElements[i][1]);
    }
    private static double squareRoot = 1.0;
    static void root(double value) {
        if (squareRoot == (squareRoot+(value/squareRoot))/2) return;
        squareRoot = (squareRoot+(value/squareRoot))/2;
        root(value);
        return;
    }

    static double absoluteValue(double h, double t) {
        root(h);
        double answer = squareRoot - t;
        return answer < 0 ? -answer : answer;
    }

    static double calc(double h, double t, double o) {
        return 0.415*absoluteValue(h,t)+(o/(PI*PI));
    }

}

/* 보너스 문제 o
* 습도, 온도, 산소농도를 double 타입의 배열을 선언하여 해당 값들을 관리하였고, 각 요소들 마다 적절한 임계값 또한 2차원 배열을 선언하여 저장했다.
* 각 요소들을 배열에 저장하면서 동시에 논리값 배열을 선언하여 해당 요소들 마다 적절한 임계값에 해당하는지 검사하여 적접성을 저장하였다.
* 각 요소들의 임계값을 검사에 있어서 각 요소들 마다 비교하는 메서드를 선언하여 검증하는 방법을 시도 했지만, 해당 방법은 중복되는 코드가 많다고 판단하여
    반복문 i값을 기준으로 이상, 이하, 초과, 미만 조건에 맞게 작성하여 하나의 메서드에서 각 요소를 비교하였다.
* 이후 proper배열을 반복문을 통하여 돌면서 switch문을 작성하여 false인 값이 있을 경우 해당하는 요소의 이름을 넣어서 출력하도록 작성하여
    하나의 출력문을 이용하여 각기 다른 요소들의 이름이 들어가도록 작성하였다.

* 생명지수 연산은 3번 문제와 동일한 방법을 사용
 */

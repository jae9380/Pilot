package com.step1;

public class HelloBiodome02 {
    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.matches(".*[^0-9].*")) {
                System.out.println("에너지 양은 숫자만을 입력하세요.");
                return;
            }
        }
        double solar = Double.parseDouble(args[0].replaceAll("[^0-9]","")),
                wind = Double.parseDouble(args[1].replaceAll("[^0-9]","")),
                intelligence = Double.parseDouble(args[2].replaceAll("[^0-9]","")),
                totalE = solar+wind+intelligence;

        System.out.printf("태양광 : %1$.3f, 풍력 : %2$.3f, 지열 : %3$.3f \n총 에너지 사용량은 %4$.3f 입니다. \n태양광 비율 : %5$.3f, 풍력 비율 : %6$.3f, 지열 비율 : %6$.3f",
                solar, wind, intelligence, totalE, solar/totalE*100, wind/totalE*100, intelligence/totalE*100);


/*
        보너스 해결 o

    1.  Process 'command .../java' finished with non-zero exit value 1 발생

        double solar = Double.parseDouble(args[0]),
                wind = Double.parseDouble(args[1]),
                intelligence = Double.parseDouble(args[2]);

        String[] args -> " 1, 12, 31 "
        위 처럼 임의의 값을 사용하여 실행 했을 때 문제가 발생했다. 발생 이유는 아래와 같다.
        * Program Arguments로 값을 줄 때 ","를 사용하지 않고 공백을 사용하여 값을 나눠 입력 해야한다.
        * 막약 숫자가 아닌 값이 들어와도 이를 걸러내야 하는 로직이 있어야 한다.

        해결 방법
        * String 클래스에서 지원하는 replaceAll()메서드를 사용하여 숫자가 아닌 것들은 전부 제거하는 방법을 사용

    2.  문자열 내 문자 걸러내기

        String 클래스에서 지원하는  contains()메서드와 정규식을 이용하여 문자열 내 숫자가 아닌 문자를 걸러낼 생각을 했다.
        하지만 해당 메서드는 정규식을 지원하지 않기 때문에 이 방법은 불가능 한 방법이였다. 이를 해결하기 위헤 다른 메서드인 matches()를 이용했고
        해당 메서드의 인자 값으로 "[^0-9]"를 사용 했지만 이는 의도와 다른 방향으로 구동되었다. 그래서  ".*[^0-9].*"를 사용하여 문제를 해결

        * "[^0-9]"      : 숫자나 아닌 문자
        * ".*[^0-9].*"  : 숫자나 문자가 어디든 포함되어 있을 경우

        matches()에서 표현식이 다를 경우 동작 차이
        "[^0-9]"은 단 하나의 문자만을 검사하고, ".*[^0-9].*"은 문자열 전체를 검사한다.
*/


    }
}

package com.step1;

public class HelloBiodome06 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("두 개의 유전자 코드를 입력해주세요.");
            return;
        }
        for (String str : args) {
            if (5 > str.length() && str.length() > 20) {
                System.out.println("유전자 정보는 최소 5개 이상의 뉴클레오타이드로 이루어져있으며, 최대 20개 입니다. \n다시 입력 하세요.");
                return;
            }
        }
        char[] sample1 = args[0].toCharArray(), sample2 = args[1].toCharArray();
        int index = 0;

        while (true) {
            if(index == sample1.length && sample1.length == sample2.length) {
                System.out.println("동일한 유전자 코드입니다.");
                break;
            }
            try {
                if ( sample1[index] != sample2[index]) {
                    System.out.println("일치하지 않습니다.");
                    break;
                }
            }catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                System.out.println("일치하지 않습니다.");
                break;
            }

            index++;
        }
        if (sample1.length < sample2.length) {
            isSubarray(sample1, sample2);
        }else {
            isSubarray(sample2, sample1);
        }


    }
    public static void isSubarray(char[] sample1, char[] sample2) {
        if (sample1.length > sample2.length) return;

        for (int i = 0; i <= sample2.length - sample1.length; i++) {
            boolean match = true;
            for (int j = 0; j < sample1.length; j++) {
                if (sample2[i + j] != sample1[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                System.out.println("부분적으로 포함됩니다.");
                return;
            }
        }
        System.out.println("포함되지 않습니다.");
        return ;
    }
}
/* 보너스 문제 o
* 주어지는 문자열 비교에 있어서 인덱스를 기준으로 검증하기 위해서 문자열을 char타입의 배열로 만드는 메서드를 사용했다.
* while문을 이용하여 두 문자열을 비교하기 때문에 배열 인덱스 값을 반복문 외부에 선언하였고 반복문 내부에는 증감식을 이용하여 각 인덱스의 문자열을 비교하도록 함.
  반복문 내부에서 각 인덱스의 char을 비교하는 과정에서 하나의 문자라도 동일하지 않을 경우에는 전체적으로 동일하지 않다고 판정하여 문구 출력을 하고 종료 하도록 하였고,
  해당 코드는 try catch를 이용하여 두 배열을 비교할 때 인덱스 범위가 벗어나는 경우 발생하는 예외를 방지 하면서 동시에 동일하지 않는 것이라 판단했다.
* 추가적으로 주어지는 두 문자열이 하나의 문자열 내 포함되는 경우를 확인하기 위해서 추가적인 메서드를 작성하였다.
  메서드를 호출할 때 매개값으로 두 배열이 사용되는데 처음으로 오는 값이 짧은 배열이 와야하고 다음으로 긴 배열이 와야한다.
  이러한 조건을 맞추기 위해서 조건문을 사용하여 각 조건에 맞게 한 번 호출하도록 했다.
 */

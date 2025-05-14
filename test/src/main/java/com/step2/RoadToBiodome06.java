package com.step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Restrictions
    1. 하나의 배열로 정렬하지 않아야 한다.
    2. 중앙값 연산의 시간 복잡도는 O(lob(n+m))이어야 한다.
*/
public class RoadToBiodome06 {
    private static final int MIN = 0, MAX = 1000; // 입력값의 최소 최대 범위가 있다고 하지만 정확한 값이 명시 x
//    커맨드 라인 값은 "[2, 10, 30] [1, 9, 27, 40, 42]" 형태
    public static void main(String[] args) {
        List<String> group1 = new ArrayList<>();
        List<String> group2 = new ArrayList<>();

        boolean firstGroupIsDone = false;
        for (String s : args) {
            if (!firstGroupIsDone) {
                group1.add(s);
                if (s.endsWith("]")) {
                    firstGroupIsDone = true;
                }
            } else {
                group2.add(s);
            }
        }

        int[] arr1 = parseArr(group1), arr2 = parseArr(group2);

        // 문제에서는 배열이 정렬이 되어 주어진다고 정의했지만, 예제에서 그렇지 않기 때문에 추가적인 정렬을 시도
        // 정렬 메서드는 따로 정의하지 않고 표준 라이브러리에서 지원하는 메서드를 이용
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.printf("Mean : %1$.1f, Median : %2$.1f \nBonus Mean : %3$.1f, Median : %4$.1f",
                getAverage(arr1, arr2, false), findMedian(arr1, arr2, false),
                getAverage(arr1, arr2, true), findMedian(arr1, arr2, true));
        System.out.printf("");
    }

//    중앙값과 평균을 반환하는 메서드에서 boolean타입의 매개값을 통해서 해당 값을 구할 때 보너스 문제 여부를 판별하도록 작성했다.

/*
    아래의 메서드는 이중탐색 알고리즘을 이용하여 중간값을 반환하도록 했다.
    메서드의 매개값으로 두 배열이 온다. 이 때 짧은 배열을 기준으로 이중탐색을 진행해야 결과값을 보다 빨리 받을 수 있기 때문에 조건문을 사용하여 짧은 배열이 첫 매개값이 되도록 했다.

    각 배열을 관리하기 위해서 변수 i와 j를 선언하였고, i는 첫 매개 배열을 관리한다. 그리고 j는 나머지 배열을 관리하는데 사용이 된다.

    이렇게 i와 j를 이용하여 떨어진 두 배열에서 가상의 파티션을 두어 구분하기 위해서 사용이 되는데 그렇기 떄문에 i의 초기화 값은 arr1의 중간 인덱스이고, j는 전체 배열의 i값을 뺸 값으로 초기화를 한다.
 */
    public static double findMedian(int[] arr1, int[] arr2, boolean isItBonus) {
        if (!isItBonus && arr1.length > arr2.length) return findMedian(arr2, arr1, false); // 더 짧은 배열을 기준으로 이진탐색 진행하기 위함

        if (isItBonus) {
            if (arr1.length > arr2.length) return findMedian(arr2, arr1, true);

            arr1 = filterOver30(arr1);
            arr2 = filterOver30(arr2);
        }

        int n = arr1.length;
        int m = arr2.length;
        int iMin = 0, iMax = n;
        int halfLen = (n + m + 1) / 2;

        System.out.println("--- arr1 배열 ---");
        for (int i : arr1) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("--- arr2 배열 ---");
        for (int i : arr2) {
            System.out.print(i+" ");
        }

        System.out.println("이진 탐색 진행");
        int count = 0;
        while (iMin <= iMax) {
            System.out.println("----"+ ++count+"회 동작 ----");
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            System.out.println("i = "+i+" / j = "+j);
            if (i < n && arr2[j - 1] > arr1[i]) {
                System.out.println("arr2[j - 1] = "+arr2[j - 1]+" / arr1[i] = "+arr1[i]);
                System.out.println("i 는 n보다 작고, arr2[j - 1]은  arr1[i] 보다 크다.");
                iMin = i + 1;
                System.out.println("i값 1 증가");

            } else if (i > 0 && arr1[i - 1] > arr2[j]) {
                System.out.println("arr1[i - 1] = "+arr1[i - 1]+" / arr2[j] = "+arr2[j]);
                System.out.println("i 는 0보다 크고, arr1[i - 1]은  arr2[j] 보다 크다.");
                iMax = i - 1;
                System.out.println("i값 1 감소");
            } else {
                // 위 두 조건문을 통해 인덱스를 옮겨 중간값의 인덱스를 찾음
                int maxOfLeft;
                if (i == 0) maxOfLeft = arr2[j - 1];
                else if (j == 0) maxOfLeft = arr1[i - 1];
                else maxOfLeft = Math.max(arr1[i - 1], arr2[j - 1]);

                if ((n + m) % 2 == 1) {
                    return maxOfLeft;
                }

                int minOfRight;
                if (i == n) minOfRight = arr2[j];
                else if (j == m) minOfRight = arr1[i];
                else minOfRight = Math.min(arr1[i], arr2[j]);

                return (maxOfLeft + minOfRight) / 2.0;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
    private static int[] parseArr(List<String> group) {
        return group.stream()
                .map(s -> s.replaceAll("[\\[\\],]", "")) // 괄호, 쉼표 제거
                .filter(s -> !s.isEmpty())               // 빈 문자열 제거
                .mapToInt(s -> {
                    int i;
                    try {
                        i = Integer.parseInt(s);
                        if (i < MIN || i > MAX) throw new IllegalArgumentException("입력값이 허용된 범위를 벗어났습니다 : " + i);
                        return i;
                    } catch (NumberFormatException e) {
                        System.out.println("숫자가 아닌 다른 문자를 입력 했습니다.\n다시 숫자만 입력하여 실행 하세요.");
                        e.printStackTrace();
                        System.exit(1);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e);
                        e.printStackTrace();
                        System.exit(1);
                    }
                    return -1;
                })
//                .mapToInt(Integer::parseInt)
                .toArray();
    }

    static double getAverage(int[] arr1, int[] arr2, boolean isItBonus) {
        int sum = 0, count = 0;
        for (int i : arr1) {
            if (isItBonus){
                if (i >= 30) {
                    sum += i;
                    count++;
                }
                continue;
            }
            sum += i;
        }
        for (int i : arr2) {
            if (isItBonus){
                if (i >= 30) {
                    sum += i;
                    count++;
                }
                continue;
            }
            sum += i;
        }

        return isItBonus ? (double) sum / count: (double) sum / (arr1.length + arr2.length);
    }

    public static int[] filterOver30(int[] arr) {
        return Arrays.stream(arr)
                .filter(element -> element >= 30)
                .toArray();
    }
}

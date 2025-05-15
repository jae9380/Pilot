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
    }

//    중앙값과 평균을 반환하는 메서드에서 boolean타입의 매개값을 통해서 해당 값을 구할 때 보너스 문제 여부를 판별하도록 작성했다.
    public static double findMedian(int[] arr1, int[] arr2, boolean isItBonus) { // 코드 설명은 따로 작성
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

        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < n && arr2[j - 1] > arr1[i]) {
                iMin = i + 1;
            } else if (i > 0 && arr1[i - 1] > arr2[j]) {
                iMax = i - 1;
            } else {
                int maxOfLeft;
                if (i == 0) maxOfLeft = arr2[j - 1];
                else if (j == 0) maxOfLeft = arr1[i - 1];
                else maxOfLeft = arr1[i - 1] > arr2[j - 1] ? arr1[i - 1] : arr2[j - 1];

                if ((n + m) % 2 == 1) {
                    return maxOfLeft;
                }

                int minOfRight;
                if (i == n) minOfRight = arr2[j];
                else if (j == m) minOfRight = arr1[i];
                else minOfRight = arr1[i] < arr2[j] ? arr1[i] : arr2[j];

                return (maxOfLeft + minOfRight) / 2.0;
            }
        }

        throw new IllegalArgumentException("배열이 정렬되어 않아 중간값을 구하기 어렵습니다.");
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

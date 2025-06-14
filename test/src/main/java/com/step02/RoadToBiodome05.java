package com.step02;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoadToBiodome05 {
    // 최소 최대 범위 검증
    // 두 배열을 합치고 정렬 (퀵 정렬)
    // 입력값 오류시 문구 출력
    static final int MIN = 0;
    static final int MAX = 100;

    public static void main(String[] args) {
        String input = String.join(" ", args);
        vaildationCheck(input);

        List<int[]> list = new ArrayList<>();
        String[] inputStringarrs = input.split("/");
        for (String arr : inputStringarrs) {
            String[] nums = arr.trim().split("\\s+");

            int[] tempArr = Arrays.stream(nums)
                    .mapToInt(s -> {
                        try {
                            int i = Integer.parseInt(s);
                            if (!vaildationCheck(i)) throw new NumberFormatException("범위 내 숫자만을 입력 하세요");
                            return i;
                        } catch (NumberFormatException e) {
                            System.out.println(e);
                            e.printStackTrace();
                            System.exit(1);
                            return -1;
                        }
                    })
                    .toArray();
            list.add(tempArr);
        }

        int[] totalArr = new int[list.get(0).length + list.get(1).length];

        System.arraycopy(list.get(0), 0, totalArr, 0, list.get(0).length);
        System.arraycopy(list.get(1), 0, totalArr, list.get(0).length, list.get(1).length);

        quickSort(totalArr, 0, totalArr.length-1);

        for (int i : totalArr) {
            System.out.print(i+" ");
        }

    }

    // 퀵 정렬 메소드
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 파티션을 구한 후 기준값의 인덱스를 반환
            int pi = partition(arr, low, high);

            // 재귀로 왼쪽 부분과 오른쪽 부분을 정렬
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // 파티션 함수: 기준값을 기준으로 배열을 분할
    public static int partition(int[] arr, int low, int high) {
        // 마지막 요소를 기준값(pivot)으로 선택
        int pivot = arr[high];
        int i = (low - 1);  // 작은 값의 인덱스

        for (int j = low; j < high; j++) {
            // 현재 값이 pivot보다 작으면, 작은 값의 인덱스를 증가시키고 값을 교환
            if (arr[j] < pivot) {
                i++;
                // swap arr[i] <-> arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // pivot을 적절한 위치에 배치
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    static void vaildationCheck(String str) {
        if (str.matches(".*[^0-9/\\s].*")) {
            System.out.println("숫자가 아닌 값을 입력할 수 없습니다.");
            System.exit(1);
        }
    }

    static boolean vaildationCheck(int value) {
        return MIN <= value && value <= MAX;
    }
}
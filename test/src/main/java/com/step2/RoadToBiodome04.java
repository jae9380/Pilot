package com.step2;


import java.util.ArrayList;
import java.util.List;

public class RoadToBiodome04 {
    static List<List<Integer>> listGroups = new ArrayList<>();
    static List<Integer> currentList = new ArrayList<>();
    static int[] arr;
    public static void main(String[] args) {

        for (String s : args) {
            if (!s.equals("/")) {
                currentList.add(Integer.parseInt(s));
            }else {
                listGroups.add(currentList);
                currentList = new ArrayList<>();
            }
        }
        if (!currentList.isEmpty()) listGroups.add(currentList); // 마지막 배열도 그룹에 추가
        int count = 1;
        for (List<Integer> current : listGroups) {
            System.out.println("------"+  count++ +"번 째 배열"+"------");
            int arrSize = current.size();
            arr = sort(current.stream()
                    .mapToInt(Integer::intValue)
                    .toArray());

            average(arr, arrSize);
            intermediate(arr, arrSize);
        }


    }

    static int[] sort(int[] arr) {   // 선택 정렬
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 최소값이 현재 위치가 아니라면 교환
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        System.out.println("오름 차순 정렬");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        return arr;
    }

    static void average(int[] arr, int len) {
        int sum = 0;
        for (int i : arr) {
            sum+=i;
        }
        System.out.println("평균값 : " + sum / len);
    }

    static void intermediate(int[] arr, int len) {
        boolean a = len % 2 == 0 ? true : false;
        int b = len / 2;
        if (a) {
            System.out.println("중간값 : "+(double) (arr[b] + arr[b - 1]) / 2);
        }else {
            System.out.println("중간값 : "+ arr[b]);

        }
    }
}

/*
    args에서 '/'를 구분인자로 사용하여 여러 배열을 만드는 방법
    1. 정규 표현식 사용
    String all = String.join(" ", args); // ex: "1 2 3 / 4 5 / 6 7"
    String[] groupStrs = all.split("\\s*\\s*");  / 주석 문제로 작은 따옴표 추가
    List<int[]> result = new ArrayList<>();
    for (String group : groupStrs) {
        String[] nums = group.trim().split("\\s+");
        int[] arr = Arrays.stream(nums)
                    .mapToInt(String::parseInt)
                    .toArray();
                    result.add(arr);
        }
    해당 방법은 args[]에서 각 요소들을 " "을 추가하여 하나의 문자로 만들고. 해당 문자열에서 '/'를 기준으로 배열을 만들기 위해서
    .spilt()를 사용한다.

    정규 표현식 \\s*\\s*, \\s+ 의미
    * \\s*'/\\s* : \\s 는 공백 문자를 의미하고, * 이스케이프 문자는 0개 이상의 반복을 의미한다.
                 위 조건을 합쳐 해당 표현식은 실제 문자(/) 앞 뒤의 공백을 제거
    * \\s+ : +는 1개 이상의 반복
*/

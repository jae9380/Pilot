package com.step02;

import java.util.HashMap;
import java.util.Map;

public class RoadToBiodome07 {
    public static void main(String[] args) {

        String[][] arr = inputToArr(args);

        sort(arr);

        for (String[] strings : arr) {
            System.out.println(strings[0]+" / "+strings[1]);
        }
    }
    static String[][] inputToArr(String[] input) {
        Map<String, Integer> map = new HashMap<>();

        for (String arg : input) {
            if (!map.containsKey(arg)) {
                map.put(arg, 1);
            }else {
                map.put(arg, map.get(arg)+1);
            }
        }

        String[][] answer = new String[map.size()][2];
        int index = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer[index][0] = entry.getKey();
            answer[index++][1] = String.valueOf(entry.getValue());
        }
        return answer;
    }

    static void sort(String[][] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                int val1 = Integer.parseInt(arr[j][1]);
                int val2 = Integer.parseInt(arr[maxIdx][1]);

                if (val1 > val2) {
                    maxIdx = j;
                } else if (val1 == val2) {
                    if (arr[j][0].compareTo(arr[maxIdx][0]) < 0) {
                        maxIdx = j;
                    }
                }
            }
            String[] temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }

    }
}

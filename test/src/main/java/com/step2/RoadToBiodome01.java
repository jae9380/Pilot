package com.step2;

import java.util.ArrayList;
import java.util.List;


public class RoadToBiodome01 {
    private static final int MAX = 1000;
    private static final int MIN = 0;
    public static void main(String[] args) {
        System.out.print("input data : ");
        for (String arg : args) System.out.print(arg+ " ");
        System.out.println();
        List<Integer> list = new ArrayList<>();
        int[] counts = new int[MAX + 1];
        try {
            for (String num : args) {
                int value = Integer.parseInt(num);
                try {
                    if (value < MIN || value > MAX) {
                        throw new IllegalArgumentException("입력된 값의 범위가 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
                    }
                }catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    return;
                }
                list.add(Integer.parseInt(num));
            }
        }catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.printf("입력된 값의 범위가 올바르지 않습니다. 1%d에서 %d까지의 값을 입력해주세요.", MIN, MAX);
            return;
        }

        for (Integer i : list) {
            counts[i]++;
        }
        for (int i = 0; i < counts.length ; i++) {
            if (counts[i] == 1) System.out.println(i);
        }
    }
}

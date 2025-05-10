package com.step1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HelloBiodome07 {
    public static void main(String[] args) {
        String input = args[0].replaceAll(" ", "/").toUpperCase();
        System.out.println(input);
        if (input.matches(".*[^C,J,H,E,Y].*")) {
            System.out.println("염기서열은 C, J, H, E, Y 다섯가지로만 입력됩니다. 확인하고 다시 입력해주세요");

        }

        System.out.println(method(input.toCharArray()));

    }
    private static String method(char[] inputArr) {
        String[] answer = new String[inputArr.length];
        int index = 0;
        char target = inputArr[0];
        int count = 1;
        boolean beforeWasSlash = (target == '/');

        for (int i = 1; i < inputArr.length; i++) {
            char current = inputArr[i];

            if (current == '/') {
                if (!beforeWasSlash) {
                    if (target != '/') {
                        answer[index++] = String.valueOf(target);
                        answer[index++] = String.valueOf(count);
                    }
                    answer[index++] = String.valueOf(current);
                    beforeWasSlash = true;
                    target = '/';
                }

                continue;
            }

            if (current == target) {
                count++;
            } else {
                if (target != '/') {
                    answer[index++] = String.valueOf(target);
                    answer[index++] = String.valueOf(count);
                }
                target = current;
                count = 1;
            }
            beforeWasSlash = false;
        }


        if (target != '/') {
            answer[index++] = String.valueOf(target);
            answer[index++] = String.valueOf(count);
        }

        for (String s : answer) {
            System.out.println(s);
        }

        return Arrays.stream(answer)
                .filter(s -> s != null)
                .collect(Collectors.joining())
                .replaceAll("/", " ");
    }
}
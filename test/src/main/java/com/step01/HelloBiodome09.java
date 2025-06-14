package com.step01;

public class HelloBiodome09 {
    public static void main(String[] args) {
        boolean hasSpecial = false;
        if (args.length == 2 && args[1].equals("&")){
            hasSpecial = true;
        }
        if (args[0].matches(".*[^0-9].*")) {
            System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
            return;
        }
        int input = Integer.parseInt(args[0]);
        if (input < 3 || input > 100) {
            System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
        }


        drawing(input, hasSpecial);
    }
    private static void drawing(int num, boolean hasSpecial) {
        int width = 2 * num - 1;

        for (int i = 1; i <= num; i++) {
            int starCount = 2 * i - 1;
            int spaceCount = (width - starCount) / 2;

            for (int j = 0; j < spaceCount; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < starCount; j++) {
                if (j == starCount/2 && hasSpecial) {
                    System.out.print("&");
                }else {
                    System.out.print("*");
                }

            }
            System.out.println();
        }

        int mid = width / 2;
        for (int i = 0; i < mid; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }
}

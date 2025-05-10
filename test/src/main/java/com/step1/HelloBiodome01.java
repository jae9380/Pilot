package com.step1;

import java.util.Arrays;
import java.util.Random;
public class HelloBiodome01 {
    public static void main(String[] args) {
        if(args.length == 0 ||args[0].trim().equals("")) {
            System.out.println("이름을 1글자 이상 입력해주세요.");
            return;
        }
        String name = args[0];
        String result = String.join("", Arrays.copyOfRange(name.split(""), 0, 10));

        String[] words = {"반갑습니다, \"%s\"님!", "환영합니다, \"%s\"님!", "\"%s\"님, 반갑습니다.", "\"%s\"님! 어서오세요."};


        System.out.printf(words[new Random().nextInt(words.length)], result);
    }
}
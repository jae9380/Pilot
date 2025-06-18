package com.step06.problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RunBiodome01 {
//    신입-하브, 멤버-세이지, 신입-아마라, 운영진-아이샤, 신입-미호, 멤버-하린, 멤버-캐머린, 운영진-리즈키, 신입-라스코, 신입-제레드
    public static void main(String[] args) {
        List<String> answer = null;
        System.out.println("멤버 리스트를 입력하세요:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();

            answer = Arrays.stream(input.split(", "))
                    .filter(s -> s.startsWith("신입-"))
                    .map(s ->  s.substring(3)+"님 환영합니다")
                    .collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println("입력 오류: " + e.getMessage());
        }

        System.out.println(String.join(", ", answer));
    }


}

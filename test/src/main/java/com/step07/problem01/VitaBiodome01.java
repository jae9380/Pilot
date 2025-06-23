package com.step07.problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class VitaBiodome01 {
    public static void main(String[] args) {
        URLUtil uu = new URLUtil();
        System.out.print("URL 주소를 입력하세요: ");
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        try {
            uu.getInfo(input);
        } catch (UnknownHostException e) {
            System.out.println("네트워크 문제 또는 DNS 서버가 해당 호스트를 찾을 수 없습니다.");
        } catch (MalformedURLException e) {
            System.out.println("URL 형식에서 예외 발생");
        } catch (URISyntaxException e) {
            System.out.println("유효하지 않은 URL 입니다.");
        }
    }
}

package com.step07.problem02;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class VitaBiodome02 {
    public static void main(String[] args) {
        System.out.print("URL을 입력하세요: ");
        String inputUrl = new Scanner(System.in).nextLine();

        scan(inputUrl);
    }

    static void scan(String inputUrl) {
        try {
            URL url = new URL(inputUrl);
            try (
                    InputStream inputStream = url.openStream();
                    InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
                    BufferedReader reader = new BufferedReader(isr)
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println("페이지를 읽어 오는 과정에서 오류 발생");
        }
    }
}

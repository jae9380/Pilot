package com.step5.problem01;

import java.io.*;

public class JournalManager {
    public Journal loadJournal(String fileName) {
        InputStream is = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();

        try {
            // 리소스 경로 접근
            ClassLoader classLoader = getClass().getClassLoader();
            is = classLoader.getResourceAsStream("step05/problem01/" + fileName);

            if (is == null) {
                System.out.println("리소스 파일을 찾을 수 없습니다: " + fileName);
                return null;
            }

            // UTF-8로 읽기
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            return new Journal(fileName, content.toString());

        } catch (IOException e) {
            System.out.println("리소스 파일을 읽는 중 오류 발생: " + fileName);
        } finally {
            try {
                if (reader != null) reader.close();
                else if (is != null) is.close(); // reader 없으면 is라도 닫기
            } catch (IOException e) {
                System.out.println("리소스 파일 닫는 중 오류 발생: " + fileName);
            }
        }

        return null;
    }
}

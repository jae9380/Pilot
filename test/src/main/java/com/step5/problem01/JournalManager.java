package com.step5.problem01;

import java.io.*;

public class JournalManager {
    public Journal loadJournal(String fileName) {
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();

        try (InputStream is = getFileAsStream(fileName)) {
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            return new Journal(fileName, content.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("리소스 파일을 읽는 중 오류 발생: " + fileName);
        }

        return null;
    }

    private InputStream getFileAsStream(String fileName) throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        // 문제에 첨부된 .txt 파일은 리소스 디렉토리 내부에 위치
        InputStream is = classLoader.getResourceAsStream("step05/problem01/" + fileName);

        if (is == null) {
            throw new FileNotFoundException("[FileNotFoundException] 리소스 파일이 존재하지 않습니다: " + fileName);
        }

        return is;
    }
}

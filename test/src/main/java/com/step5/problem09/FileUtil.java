package com.step5.problem09;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtil {
    public void findAndPrintDuplicates(String folderPath) {
        List<File> files = null;
        try {
            files = getAllFiles(folderPath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        if (files.isEmpty()) {
            System.out.println("해당 디렉토리 내부에 파일이 없습니다.");
            return;
        }

        for (int i = 0; i < files.size(); i++) {
            for (int j = i + 1; j < files.size(); j++) {
                File file1 = files.get(i);
                File file2 = files.get(j);
                try {
                    if (isSameFile(file1, file2)) {
                        System.out.printf("%s 파일과 %s 파일은 동일한 파일입니다.%n",
                                file1.getName(), file2.getName());
                        return;
                    }
                } catch (IOException e) {
                    System.out.println("파일 비교 중 오류 발생: " + e.getMessage());
                    return;
                }
            }
        }


        System.out.println("중복되는 파일이 없습니다.");

    }

    private List<File> getAllFiles(String folderPath) throws IOException {
        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) throw new IOException("올바르지 않은 경로입니다.");

        File[] files = folder.listFiles(File::isFile);
        return files != null ? Arrays.asList(files) : new ArrayList<>();
    }

    private boolean isSameFile(File file1, File file2) throws IOException {

        if (file1.length() != file2.length()) return false;

        try (InputStream is1 = new FileInputStream(file1);
             InputStream is2 = new FileInputStream(file2)) {

            int b1, b2;
            while ((b1 = is1.read()) != -1) {
                b2 = is2.read();
                if (b1 != b2) return false;
            }
            return true;
        }
    }
}

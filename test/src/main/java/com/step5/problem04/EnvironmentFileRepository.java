package com.step5.problem04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EnvironmentFileRepository {
    private final File outputFile;
    private final File outputDir = new File("src/main/resources/step05/problem04");
    private final String fileName = "environment_data.txt";


    public EnvironmentFileRepository() {
        if (!outputDir.exists()) outputDir.mkdirs(); // 디렉토리가 없으면 생성
        outputFile = new File(outputDir, fileName);
    }

    public void save(EnvironmentData ed) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
            writer.write(String.join(",", ed.getAllDate()));
            writer.newLine();
            System.out.printf("\n데이터가 %s에 저장되었습니다.\n", fileName);
        }
    }

    public List<EnvironmentData> loadAll() throws IOException {
        List<EnvironmentData> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);

                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim(); // 앞뒤 공백 제거
                }

                EnvironmentData ed = new EnvironmentData(parts[0], parts[1], parts[2], parts[3], parts[4]);
                list.add(ed);
            }
        }

        return list;
    }
}

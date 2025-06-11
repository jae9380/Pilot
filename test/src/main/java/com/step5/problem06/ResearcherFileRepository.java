package com.step5.problem06;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ResearcherFileRepository {
    private static final String FILE_NAME = "researchers_data.txt";
    private final File outputFile;
    private final File outputDir = new File("src/main/resources/step05/problem06");


    public ResearcherFileRepository() {
        if (!outputDir.exists()) outputDir.mkdirs(); // 디렉토리가 없으면 생성
        outputFile = new File(outputDir, FILE_NAME);
    }

    public void save(Researcher researcher) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
            writer.write(String.join(", ", researcher.getAllData()));
            writer.newLine();
        }
    }

    public List<Researcher> loadAll() {
        List<Researcher> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(Researcher.fromDateLine(line));
            }
        } catch (FileNotFoundException e) {
            // 첫 실행 시 파일이 없을 수 있으므로 무시
        } catch (IOException e) {
            System.out.println("파일 읽기 중 오류 발생: " + e.getMessage());
        }
        return list;
    }
}

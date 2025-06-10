package com.step5.problem05;

import com.step5.problem05.EnvironmentData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EnvironmentFileRepository {
    private final File outputFile;
    private final File outputDir = new File("src/main/resources/step05/problem05");
    private final String fileName = "environment_data.ser";


    public EnvironmentFileRepository() {
        if (!outputDir.exists()) outputDir.mkdirs();
        outputFile = new File(outputDir, fileName);
    }

    public void save(EnvironmentData ed) throws IOException {
        List<EnvironmentData> existing = loadAll();  // 기존 데이터 불러오기
        if (existing == null) existing = new ArrayList<>();
        existing.add(ed);  // 새로운 데이터 추가

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            oos.writeObject(existing);  // 전체 리스트 저장
            System.out.printf("\n데이터가 %s에 직렬화되어 저장되었습니다.\n", fileName);
        }
    }

    @SuppressWarnings("unchecked")
    public List<EnvironmentData> loadAll() throws IOException {
        if (!outputFile.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(outputFile))) {
            return (List<EnvironmentData>) ois.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("[EnvironmentFileRepository] 클래스 로드 중 문제 발생: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}

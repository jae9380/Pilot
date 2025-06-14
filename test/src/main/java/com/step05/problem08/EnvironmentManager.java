package com.step05.problem08;

import java.io.*;
import java.util.regex.Pattern;

/*
    현재 문제에서 주어지는 데이터는 날짜 기준으로 정렬되어 있다. 그렇기 때문에 생성되는 트리의 구조는 편향 구조의 트리가 될 것이다.

    일반적인 보통의 트리의 구조와 달리 편향 구조의 트리는 이진 탐색 트리를 동작하게 될 경 O(n)의 복잡도로 동작을 수행하게 된다.
    원래 이진 탐색 트리의 경우 대부분의 동작이 O(log n)의 효율을 기대하지만, 현재 이를 만족하고 있지 않는다.
*/
public class EnvironmentManager {
    private final static String FILE_PATH = "src/main/resources/step05/problem08/";
    private final static String FILE_NAME = "environment_data_Lake.txt";
    private final BinarySearchTree bst;
    private final File file;


    public EnvironmentManager() {
        bst = new BinarySearchTree();
        file = new File(FILE_PATH + FILE_NAME);
        loadAllData();
    }

    public Node getNodeByDate(String date) {
        if (!validationDateFormat(date)) {
            System.out.println("데이터 검색 시 입력값은 yyyy-MM-dd 형식으로 숫자만을 입력하세요.");
            return null;
        }
        Node node = bst.search(date);
        if (node == null) {
            System.out.println("해당 날짜의 데이터는 존재하지 않습니다.");
            return null;
        }
        node.getData().displayInfo();
        return node;
    }

    public void updateData(Node node, String... elements) {
        if (!validationAtUpdate(elements)) {
            System.out.println("데이터 수정 시 입력값에 문자가 포함될 수 없습니다.");
            return;
        }
        EnvironmentData target = node.getData();
        target = target.update(elements);
        node.updateEnvironmentData(target);

        saveData(target);
    }

    private void loadAllData() {
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            String line;
            while ((line = raf.readLine()) != null) {
                bst.insert(EnvironmentData.fromData(line));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveData(EnvironmentData data) {
        File tempFile = new File(FILE_PATH + FILE_NAME + "_temp");

        try (
                BufferedReader reader = new BufferedReader(new FileReader(file));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(data.getDate().toString())) {
                    writer.write(data.toLine());
                } else {
                    writer.write(line);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("파일 저장 중 오류 발생", e);
        }

        if (!file.delete()) {
            throw new RuntimeException("원본 파일 삭제 실패");
        }
        if (!tempFile.renameTo(file)) {
            throw new RuntimeException("임시 파일을 원본 파일로 변경 실패");
        }
    }

    private boolean validationAtUpdate(String[] elements) {
        for (String element : elements) {
            if (!element.matches("\\d+(\\.\\d+)?")) {
                return false;
            }
        }
        return true;
    }

    private boolean validationDateFormat(String inputDate) {
        return Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", inputDate);
    }
}

package com.step06.problem04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FruitStore1 {
//    private static final Path FILE_PATH = Paths.get("C:/Users/ljy53/OneDrive/Desktop/SW-P/Pilot/Pilot/test/src/main/resources/step06/problem04/fruit_data.csv");

    private static final Path FILE_PATH = Paths.get("src/main/resources/step06/problem04/fruit_data_total.csv");
    private final HashMap<String, Integer> inventoryMap;
    private final HashMap<String, List<String>> historyMap;

    public FruitStore1() {
        inventoryMap = new HashMap<>();
        historyMap = new HashMap<>();
        System.out.println("과일 상점에 오신 것을 환영합니다!");
        loadDataFromFile();
    }

    public void bestSellingsItem() {
        Map<String, Integer> saleCountMap = historyMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToInt(s -> Integer.parseInt(s.split(":")[1]))
                                .sum()
                ));

        Map.Entry<String, Integer> bestSelling = saleCountMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        if (bestSelling == null) {
            System.out.println("가장 많이 팔린 과일은 없습니다.");
            return;
        }

        System.out.printf("\t가장 많이 팔린 과일 : %1$s, 판매 수량 : %2$d\n\n", bestSelling.getKey(), bestSelling.getValue());
    }

    public void showTotalSales() {
        int answer = historyMap.values().stream()
                .flatMap(List::stream)
                .mapToInt(s -> Integer.parseInt(s.split(":")[1]))
                .sum();

        System.out.printf("\t총 판매 과일의 수 : %d\n\n", answer);
    }

    public void averageSalesVolumeOfEach() {
        System.out.println("과일별 평균 판매량");
        Map<String, Double> averageSalesMap = historyMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToDouble(s -> Double.parseDouble(s.split(":")[1]))
                                .average()
                                .orElse(0.0)
                ));

        averageSalesMap.forEach((k, v) ->
                System.out.printf("과일명: %1$s, 평균 판매량: %2$.1f개\n\n", k, v));
    }

    public void showList() {
        inventoryMap.forEach((k, v) -> System.out.printf("\t %1$s - %2$d개\n", k, v));
        System.out.println();
    }

    private void loadDataFromFile() {
        try (Stream<String> lines = Files.lines(FILE_PATH)) {
            List<String> datas = lines.toList();
            datas.stream()
                    .skip(1)
                    .forEach(s -> {
                        List<String> history = new ArrayList<>();
                        String[] data = s.split(",");
                        String name = data[0];
                        int stock = Integer.parseInt(data[1]);
                        for (int i = 2; i < data.length; i++) {
                            history.add(data[i]);
                        }

                        inventoryMap.put(name, stock);
                        historyMap.put(name, history);
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveDataToFile() {
        List<String> lines = new ArrayList<>();
        lines.add("과일명,재고량,최근 판매 정보");

        for (String name : inventoryMap.keySet()) {
            int stock = inventoryMap.get(name);
            List<String> histories = historyMap.getOrDefault(name, new ArrayList<>());
            String historyStr = String.join(",", histories);
            lines.add(name+","+stock+","+historyStr);
        }

        try {
            Files.write(FILE_PATH, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("과일 상점 관리 시스템을 종료합니다!");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}

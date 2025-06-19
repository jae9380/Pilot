package com.step06.problem03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

/*
    기존 코드에서는 판매 이력 부분에서 이전 데이터는 지우고 신규 데이터로 작성하였다.
    하지만 4번 문제에서 판매 이력은 신규 데이터로 덮어 쓰는 것이 아닌, 이전의 데이터는 유지하고 신규 데이터를 추가로 작성하는 것으로 확인
*/
public class FruitStore {
//    private static final Path FILE_PATH = Paths.get("C:/Users/ljy53/OneDrive/Desktop/SW-P/Pilot/Pilot/test/src/main/resources/step06/problem03/fruit_data.csv");

    private static final Path FILE_PATH = Paths.get("src/main/resources/step06/problem03/fruit_data.csv");
    private final HashMap<String, Integer> inventoryMap;
    private final HashMap<String, List<String>> historyMap;

    public FruitStore() {
        inventoryMap = new HashMap<>();
        historyMap = new HashMap<>();
        System.out.println("과일 상점에 오신 것을 환영합니다!");
        loadDataFromFile();
    }
    public void sale(String name, String quantity) {
        int saleQuantity;
        try {
            validateFruitExists(name);

            saleQuantity = validationQuantity(quantity);

            if (!canSale(name, saleQuantity)) {
                System.out.printf("%s의 남은 재고 수량이 판매 수량보다 작습니다.\n\n", name);
                return;
            }

            int remainStock = inventoryMap.get(name) - saleQuantity;
            inventoryMap.put(name, remainStock);

            // 판매 이력 추가
            List<String> histories = historyMap.getOrDefault(name, new ArrayList<>());
            histories.add(getHistoryFormat(saleQuantity));
            historyMap.put(name, histories);

            System.out.printf("%1$s %2$d개가 판매되었습니다.\n\n", name, saleQuantity);
        }catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addStock(String name, String quantity) {
        try {
            validateFruitExists(name);
            int addQuantity = validationQuantity(quantity);
            int updateStock = inventoryMap.getOrDefault(name, 0) + addQuantity;
            inventoryMap.put(name, updateStock);
            System.out.printf("%s의 재고가 %d개 추가되었습니다. 현재 재고: %d개\n\n", name, addQuantity, updateStock);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showList() {
        inventoryMap.forEach((k, v) -> System.out.printf("\t %1$s - %2$d개\n", k, v));
        System.out.println();
    }

    public void previousSalesHistory(String name) {
        try {
            validateFruitExists(name);
            List<String> histories = historyMap.get(name);
            if (histories == null || histories.isEmpty()) {
                System.out.println(name + "의 판매 이력이 없습니다.\n");
                return;
            }

            String latest = histories.stream()
                    .max(Comparator.comparing(h -> LocalDate.parse(h.split(":")[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                    .orElse(null);

            System.out.printf("%s의 판매 이력:\n", name);

            System.out.printf("\t판매일자: %s, 수량: %s\n",
                    latest.split(":")[0], latest.split(":")[1]);
            System.out.println();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
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

    private boolean canSale(String name, int stock) {
        return inventoryMap.get(name) >= stock;
    }

    private void validateFruitExists(String name) throws IllegalArgumentException {
        if (!inventoryMap.containsKey(name))
            throw new IllegalArgumentException(name + "은 등록되지 않은 과일입니다.\n");
    }

    private int validationQuantity(String quantity) throws NumberFormatException {
        if (quantity.contains("-"))
            throw new RuntimeException("마이너스 값을 입력할 수 없습니다.\n");
        try {
            return Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력하세요.\n");
        }
    }

    private String getHistoryFormat(int saleQuantity) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ":" + saleQuantity;
    }
}

package com.step06.problem03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FruitStore {
    private static final Path FILE_PATH = Paths.get("src/main/resources/step06/problem03/fruit_data.csv");
    private final HashMap<String, Integer> inventoryMap;
    private final HashMap<String, String> historyMap;

    public FruitStore() {
        inventoryMap = new HashMap<>();
        historyMap = new HashMap<>();
        System.out.println("과일 상점에 오신 것을 환영합니다!");
        loadDataFromFile();
    }

    public void sale(String name, String quantity) {
        int saleQuantity = validationQuantity(quantity);

        if (!canSale(name, saleQuantity)) {
            System.out.printf("%s의 남은 재고 수량이 판매 수량보다 작습니다.\n\n", name);
            return;
        }

        int remainStock = inventoryMap.get(name) - saleQuantity;

        inventoryMap.put(name, remainStock);
        historyMap.put(name, getHistoryFormat(saleQuantity));

        System.out.printf("%1$s %2$d개가 판매되었습니다.\n\n", name, saleQuantity);
    }

    public void addStock(String name, String quantity) {
        int addQuantity = validationQuantity(quantity);

        int updateStock = inventoryMap.getOrDefault(name, 0) + addQuantity;
        inventoryMap.put(name, updateStock);

        System.out.printf("%s의 재고가 %d개 추가되었습니다. 현재 재고: %d개\n\n", name, addQuantity, updateStock);
    }

    public void showList() {
        inventoryMap.forEach((k,v) -> System.out.printf("\t %1$s - %2$d개\n", k, v));
        System.out.println();
    }

    private void loadDataFromFile() {
        try (Stream<String> lines = Files.lines(FILE_PATH)) {
            List<String> datas = lines.toList();

            datas.stream()
                    .skip(1)
                    .forEach(s -> {
                        String[] data = s.split(",");
                        String name = data[0];
                        int stock = Integer.parseInt(data[1]);
                        String history = data[2];

                        System.out.println(name+"-"+stock+"-"+history);

                        inventoryMap.put(name, stock);
                        historyMap.put(name, history);
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveDataToFile() {
        List<String> lines = new ArrayList<>();

        lines.add("과일명,재고량,최근 판매 정보");

        for (String name : inventoryMap.keySet()) {
            int stock = inventoryMap.get(name);
            String history = historyMap.getOrDefault(name, "정보 없음");
            lines.add(name + "," + stock + "," + history);
        }

        try {
            Files.write(FILE_PATH, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("데이터가 성공적으로 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private boolean canSale(String name, int stock) {
        return inventoryMap.get(name) >= stock;
    }

    private int validationQuantity(String quantity) throws NumberFormatException{
        return Integer.parseInt(quantity);
    }

    private String getHistoryFormat(int saleQuantity) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ":" +saleQuantity;
    }
}

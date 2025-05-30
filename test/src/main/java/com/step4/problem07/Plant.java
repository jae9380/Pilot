package com.step4.problem07;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Plant implements Comparable<Plant>{
    private String name;
    private String type;
    private int waterAmount;
    private int waterCycleHours;
    private LocalDateTime lastWatered;

    public Plant(String name, String type, int waterAmount, int waterCycleHours, LocalDateTime lastWatered) {
        this.name = name;
        this.type = type;
        this.waterAmount = waterAmount;
        this.waterCycleHours = waterCycleHours;
        this.lastWatered = lastWatered;
        System.out.printf("[Plant] 이름 : %1$s \t종류 : %2$s \t필요한 양 : %3$dL \t공급 주기 : %4$s시간 \t마지막 공급 시간 : %5$s\n",
                name, type, waterAmount, waterCycleHours, lastWatered.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }
    public Plant(String name, String type, int waterAmount, int waterCycleHours, String lastWatered) {
        this.name = name;
        this.type = type;
        this.waterAmount = waterAmount;
        this.waterCycleHours = waterCycleHours;
        this.lastWatered =LocalDateTime.parse(lastWatered, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.printf("[Plant] 이름 : %1$s \t종류 : %2$s \t필요한 양 : %3$dL \t공급 주기 : %4$s시간 \t마지막 공급 시간 : %5$s\n",
                name, type, waterAmount, waterCycleHours, lastWatered);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public int getWaterCycleHours() {
        return waterCycleHours;
    }
    
    public void water() {
        lastWatered = LocalDateTime.now();
    }

    public String getLastWateredToString() {
        return lastWatered.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    @Override
    public int compareTo(Plant p) {
//        사이클에 더 근접한 식물이 우선순위
        return this.lastWatered.plusHours(this.waterCycleHours).compareTo(
                p.lastWatered.plusHours(p.waterCycleHours)
        );
    }
}

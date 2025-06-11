package com.step5.problem06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Researcher {
    private String id;

    private String name;

    private String rigisteDate;

    private String responsibleArea;

    public Researcher(String id, String name, String rigisteDate, String responsibleArea) {
        this.id = id;
        this.name = name;
        this.rigisteDate = rigisteDate;
        this.responsibleArea = responsibleArea;
    }

    public Researcher(String id, String name, String responsibleArea) {
        this.id = id;
        this.name = name;
        this.rigisteDate =  LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.responsibleArea = responsibleArea;

        System.out.printf("\n연구원 정보가 성공적으로 등록되었습니다!\n생성된 연구원 ID: %s\n", id);
    }

    public static Researcher fromDateLine(String line) {
        String[] info = line.split(", ");
        return new Researcher(info[0], info[1], info[2], info[3]);
    }

    public int extractYearFromId() {
        String[] parts = id.split("-");
        if (parts.length >= 2) {
            try {
                return Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return -1;
    }

    public String[] getAllData() {
        return new String[] {id, name, String.valueOf(rigisteDate), responsibleArea};
    }

    public void displayInfo() {
        System.out.printf("%1$s, %2$s, %3$s, %4$s\n", id, name, rigisteDate, responsibleArea);
    }

    public String getId() {
        return id;
    }
}

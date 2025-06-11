package com.step5.problem06;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class ResearcherManager {
    private final ResearcherFileRepository rfr;
    private List<Researcher> list;
    private int currentYear;

    private Random random;

    public ResearcherManager() {
        this.rfr = new ResearcherFileRepository();
        list =  new ArrayList<>(rfr.loadAll());
        currentYear = LocalDate.now().getYear();
        random = new Random();
    }

    public void register(String name, String responsibleArea) {
        long count = list.stream()
                .filter(r -> r.extractYearFromId() == currentYear)
                .count() + 1;

        Researcher researcher = new Researcher(idGenerator(count), name, responsibleArea);

        list.add(researcher);
        try {
            rfr.save(researcher);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showResearcherList() {
        list.forEach(Researcher::displayInfo);
    }

    public void showResearcherById(String id) {
        if (!validationResearcherId(id)) {
            System.out.println("========================================");
            System.out.printf("에러: 입력된 ID의 형태는 옳바르지 않습니다. ID : %s\n",id);
            return;
        }
        list.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .ifPresentOrElse(
                        (r) -> {
                            System.out.println("========================================");
                            System.out.println("연구원 정보 : ");
                            r.displayInfo();
                            },
                        () -> {
                            System.out.println("========================================");
                            System.out.printf("에러: 해당 ID를 가진 연구원 정보가 존재하지 않습니다. ID : %s\n",id);
                        }
                );
    }

    private boolean validationResearcherId(String id) {
        String regex = "^LUMI-\\d{4}-\\d{2}:\\d+$";
        return Pattern.matches(regex, id);
    }
    private String idGenerator(long count) {
        return String.format("LUMI-%d-%02d:%03d",
                currentYear, count,  random.nextInt(900) + 100);
    }
}

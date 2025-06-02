package com.step5.problem01;

import java.util.Scanner;

public class BiodomeForever01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JournalManager manager = new JournalManager();

        System.out.print("연구일지 파일 이름을 입력하세요 (.txt 포함): ");
        String fileName = scanner.nextLine();

        Journal journal = manager.loadJournal(fileName);
        if (journal != null) {
            journal.displayContent();
        }
    }
}

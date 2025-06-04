package com.step5.problem01;

import java.util.Scanner;

public class BiodomeForever01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JournalManager manager = new JournalManager();

        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("연구일지 파일을 확인하고 싶으면 파일의 이름을 입력하세요.\n * 연구 일지 열람 시  일지 파일명.txt 포함하여 작성 \n * 더 이상 일지 열람을 원하지 않고 종료할 경우 \'N\'을 입력하세요.");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("n")|| input.equalsIgnoreCase("No")) break;

//            String fileName = scanner.nextLine();

            Journal journal = manager.loadJournal(input);
            if (journal != null) {
                journal.displayContent();
            }else {
                System.out.println("해당 연구 일지는 존재하지 않습니다. 다시 입력하세요");
            }
            System.out.println("--------------------------------------------------");

        }

    }
}

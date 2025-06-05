package com.step5.problem01;


public class BiodomeForever01 {
//    213011210700_ShadeMist.txt 213012010200_Animal.txt
    public static void main(String[] args) {
        JournalManager manager = new JournalManager();

        for (String arg : args) {
            System.out.println("--------------------------------");
            System.out.printf("입력값 : %s\n\n",arg);

            Journal journal = manager.loadJournal(arg);
            if (journal != null) journal.displayContent();
        }
    }
}

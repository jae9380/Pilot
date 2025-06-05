package com.step5.problem02;

import com.step5.problem01.Journal;


public class BiodomeForever02 {
/**
* 입력값 213011210700_ShadeMist.txt 213012010200_Animal.txt 213012_TwilightFern.txt 213012251400_FireFly.txt
* 213011210700_ShadeMist.txt -> 성공 시나리오
* 213012010200_Animal.txt -> FileNotFoundException
* 213012_TwilightFern.txt -> ParseException
* 213012251400_FireFly.txt -> EmptyFileException (bonus task)
*/
    public static void main(String[] args) {
        JournalManager2 manager = new JournalManager2();
        for (String arg : args) {
            System.out.println("--------------------------------");
            System.out.printf("입력값 : %s\n\n",arg);

            Journal journal = manager.loadJournal(arg);
            if (journal != null) journal.displayContent2();
        }
        System.out.println("--------------------------------");
    }
}

package com.step4.problem06;

public class RuleOfBiodome06 {
    public static void main(String[] args) {
//        input Value 호랑이, 사자, 악어, 표범, 하이에나, 치타, 호랑이, 사자, 표범, 하이에나, 악어, 호랑이, 하이에나, 치타, 호랑이, 코뿔소, 사자, 악어, 표범, 하이에나, 치타, 호랑이, 사자, 악어,표범, 하이에나, 치타, 호랑이, 사자, 악어, 표범, 하이에나, 치타, 호랑이, 사자, 악어, 하이에나, 치타, 호랑이, 사자,표범, 호랑이, 사자, 악어, 하이에나, 치타, 표범, 하이에나, 치타, 코뿔소, 호랑이
        String input = "";
        for (String arg : args) {
            input += arg;
        }
        String[] s = input.replaceAll(" ", "").split(",");

        AnimalFrequencyAnalyzer afa = new AnimalFrequencyAnalyzer();

        afa.analyzeFrequencies(s);
        System.out.println("가장 많이 나온 동물 : "+afa.getHighestCounts());
        System.out.print("관찰된 동물들 : ");
        for (String string : afa.getKetSet()) {
            System.out.print(string + " ");
        }

    }
}

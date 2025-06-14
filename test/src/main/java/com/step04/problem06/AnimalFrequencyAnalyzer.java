package com.step04.problem06;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnimalFrequencyAnalyzer {
    private Map<String, Integer> map;

    public AnimalFrequencyAnalyzer() {
        this.map = new HashMap<>();
    }

    public void analyzeFrequencies(String[] input) {
        for (String animal : input) map.put(animal, map.getOrDefault(animal, 0) + 1);
    }

    public String getHighestCounts() {
        String answer = null;
        int n = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                n = entry.getValue(); answer = entry.getKey();
            }
        }
        return answer;
    }

    public Set<String> getKetSet() {
        return map.keySet();
    }
}

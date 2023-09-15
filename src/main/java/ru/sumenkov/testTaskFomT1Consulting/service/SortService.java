package ru.sumenkov.testTaskFomT1Consulting.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SortService {
    /**
     * Sorts the frequency map based on the frequency count of each character in descending order.
     *
     * @param frequencyMap the frequency map to sort
     * @return a sorted map containing the character and its frequency count
     */
    public Map<Character, Integer> sortFrequencyMap(Map<Character, Integer> frequencyMap) {
        return frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}

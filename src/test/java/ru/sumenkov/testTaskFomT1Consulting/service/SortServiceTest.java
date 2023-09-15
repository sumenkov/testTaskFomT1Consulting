package ru.sumenkov.testTaskFomT1Consulting.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SortServiceTest {
    private SortService sortService;

    @BeforeEach
    void setUp() {
        sortService = new SortService();
    }

    @Test
    void sortFrequencyMap_ShouldReturnSortedMap_WhenValidFrequencyMap() {
        // Arrange
        Map<Character, Integer> frequencyMap = new HashMap<>();
        // Add data to the frequency map
        frequencyMap.put('H', 1);
        frequencyMap.put('e', 1);
        frequencyMap.put('l', 3);
        frequencyMap.put('o', 2);
        frequencyMap.put(',', 1);
        frequencyMap.put(' ', 1);
        frequencyMap.put('W', 1);
        frequencyMap.put('r', 1);
        frequencyMap.put('d', 1);
        frequencyMap.put('!', 1);

        Map<Character, Integer> expectedSortedMap = getCharacterIntegerMap();

        // Act
        Map<Character, Integer> result = sortService.sortFrequencyMap(frequencyMap);

        // Assert
        assertEquals(expectedSortedMap, result);
    }

    private static Map<Character, Integer> getCharacterIntegerMap() {
        Map<Character, Integer> expectedSortedMap = new LinkedHashMap<>();
        // Add expected data to the sorted map (sorted by frequency count in descending order)
        expectedSortedMap.put('l', 3);
        expectedSortedMap.put('o', 2);
        expectedSortedMap.put('H', 1);
        expectedSortedMap.put('e', 1);
        expectedSortedMap.put(',', 1);
        expectedSortedMap.put(' ', 1);
        expectedSortedMap.put('W', 1);
        expectedSortedMap.put('r', 1);
        expectedSortedMap.put('d', 1);
        expectedSortedMap.put('!', 1);
        return expectedSortedMap;
    }
}

package ru.sumenkov.testTaskFomT1Consulting.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrequencyServiceTest {
	private FrequencyService frequencyService;

	@BeforeEach
	void setUp() {
		frequencyService = new FrequencyService();
	}

	@Test
	void getFrequencyMap_ShouldReturnCorrectFrequencyMap_WhenValidInputString() {
		// Arrange
		String inputString = "Hello, World!";
		Map<Character, Integer> expectedFrequencyMap = new HashMap<>();
		// Add expected data to the frequency map
		expectedFrequencyMap.put('H', 1);
		expectedFrequencyMap.put('e', 1);
		expectedFrequencyMap.put('l', 3);
		expectedFrequencyMap.put('o', 2);
		expectedFrequencyMap.put(',', 1);
		expectedFrequencyMap.put(' ', 1);
		expectedFrequencyMap.put('W', 1);
		expectedFrequencyMap.put('r', 1);
		expectedFrequencyMap.put('d', 1);
		expectedFrequencyMap.put('!', 1);

		// Act
		Map<Character, Integer> result = frequencyService.getFrequencyMap(inputString);

		// Assert
		assertEquals(expectedFrequencyMap, result);
	}
}

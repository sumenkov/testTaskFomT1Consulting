package ru.sumenkov.testTaskFomT1Consulting.controller;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.sumenkov.testTaskFomT1Consulting.service.FrequencyService;
import ru.sumenkov.testTaskFomT1Consulting.service.SortService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RequiredArgsConstructor
class FrequencyControllerTest {
	@Mock
	private SortService sortService;
	@Mock
	private FrequencyService frequencyService;

	private FrequencyController frequencyController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		frequencyController = new FrequencyController(sortService, frequencyService);
	}

	@Test
	void returnJson_ShouldReturnFrequencyMap_WhenValidInputString() {
		// Arrange
		String inputString = "Hello, World!";
		Map<Character, Integer> mockFrequencyMap = new HashMap<>();
		// Add some mock data to the frequency map
		mockFrequencyMap.put('H', 1);
		mockFrequencyMap.put('e', 1);
		mockFrequencyMap.put('l', 3);
		mockFrequencyMap.put('o', 2);
		mockFrequencyMap.put(',', 1);
		mockFrequencyMap.put(' ', 1);
		mockFrequencyMap.put('W', 1);
		mockFrequencyMap.put('r', 1);
		mockFrequencyMap.put('d', 1);
		mockFrequencyMap.put('!', 1);

		when(frequencyService.getFrequencyMap(inputString)).thenReturn(mockFrequencyMap);
		when(sortService.sortFrequencyMap(mockFrequencyMap)).thenReturn(mockFrequencyMap);

		// Act
		Map<?, Integer> result = frequencyController.returnJson(inputString);

		// Assert
		assertEquals(mockFrequencyMap, result);
	}
}

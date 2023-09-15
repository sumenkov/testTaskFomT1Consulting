package ru.sumenkov.testTaskFomT1Consulting.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.sumenkov.testTaskFomT1Consulting.model.FrequencyModel;

import java.util.LinkedHashMap;
import java.util.Map;

class FrequencyServiceTest {
	
	@Test
	void analyzeFrequency() {

		FrequencyService frequencyService = new FrequencyService();
		String inputString = "hello world";

		FrequencyModel result = frequencyService.analyzeFrequency(inputString);

		Map<String, Integer> expected = new LinkedHashMap<>();
		expected.put("l", 3);
		expected.put("o", 2);
		expected.put(" ", 1);
		expected.put("d", 1);
		expected.put("e", 1);
		expected.put("h", 1);
		expected.put("r", 1);
		expected.put("w", 1);
		
		Assertions.assertEquals(expected, result.frequencyMap());
	}
}

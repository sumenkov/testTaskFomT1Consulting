package ru.sumenkov.testTaskFomT1Consulting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sumenkov.testTaskFomT1Consulting.service.FrequencyService;

import java.util.LinkedHashMap;
import java.util.Map;

public class FrequencyServiceTest {
	
	@Test
	public void testRun() {
		// Arrange
		FrequencyService frequencyService = new FrequencyService();
		String inputString = "hello world";
		
		// Act
		Map<String, Integer> result = frequencyService.run(inputString);
		
		// Assert
		Map<String, Integer> expected = new LinkedHashMap<>();
		expected.put("l", 3);
		expected.put("o", 2);
		expected.put(" ", 1);
		expected.put("d", 1);
		expected.put("e", 1);
		expected.put("h", 1);
		expected.put("r", 1);
		expected.put("w", 1);
		
		Assertions.assertEquals(expected, result);
	}
}

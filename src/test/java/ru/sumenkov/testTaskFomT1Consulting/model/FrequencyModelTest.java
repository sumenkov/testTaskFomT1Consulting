package ru.sumenkov.testTaskFomT1Consulting.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;


class FrequencyModelTest {
	
	@Test
	void frequencyMap() {
		Map<String, Integer> frequencyMap = new HashMap<>();
		frequencyMap.put("a", 3);
		frequencyMap.put("b", 2);
		frequencyMap.put("c", 1);

		FrequencyModel frequencyResult = new FrequencyModel(frequencyMap);

		assertEquals(frequencyMap, frequencyResult.frequencyMap());
	}
}
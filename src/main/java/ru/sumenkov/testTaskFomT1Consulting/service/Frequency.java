package ru.sumenkov.testTaskFomT1Consulting.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Frequency {
	
	public static Object run(String inputString) {
		Map<String, Integer> frequencyMap = new HashMap<>();
		
		for (int i = 0; i < inputString.length(); i++) {
			String character = String.valueOf(inputString.charAt(i));
			frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
		}

		return frequencyMap.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
}

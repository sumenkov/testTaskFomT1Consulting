package ru.sumenkov.testTaskFomT1Consulting.service;

import org.springframework.stereotype.Service;
import ru.sumenkov.testTaskFomT1Consulting.model.FrequencyModel;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FrequencyService {
	
	public FrequencyModel analyzeFrequency(String inputString) {
		Map<String, Integer> frequencyMap = new HashMap<>();
		calculateFrequency(inputString, frequencyMap);
		return new FrequencyModel(sortFrequencyMap(frequencyMap));
	}
	
	private void calculateFrequency(String inputString, Map<String, Integer> frequencyMap) {
		for (int i = 0; i < inputString.length(); i++) {
			String character = String.valueOf(inputString.charAt(i));
			frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
		}
	}
	
	private Map<String, Integer> sortFrequencyMap(Map<String, Integer> frequencyMap) {
		return frequencyMap.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
}

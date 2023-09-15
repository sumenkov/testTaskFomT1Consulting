package ru.sumenkov.testTaskFomT1Consulting.service;

import org.springframework.stereotype.Service;
import ru.sumenkov.testTaskFomT1Consulting.model.FrequencyModel;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class for analyzing the frequency of characters in a string.
 */
@Service
public class FrequencyService {
	
	/**
	 * Analyzes the frequency of characters in the given input string.
	 *
	 * @param inputString the input string to analyze
	 * @return a FrequencyModel object containing the frequency map
	 */
	public FrequencyModel analyzeFrequency(String inputString) {
		Map<String, Integer> frequencyMap = new HashMap<>();
		calculateFrequency(inputString, frequencyMap);
		return new FrequencyModel(sortFrequencyMap(frequencyMap));
	}
	
	/**
	 * Calculates the frequency of characters in the input string and populates the frequency map.
	 *
	 * @param inputString the input string to analyze
	 * @param frequencyMap the map to store the frequency of characters
	 */
	private void calculateFrequency(String inputString, Map<String, Integer> frequencyMap) {
		for (int i = 0; i < inputString.length(); i++) {
			String character = String.valueOf(inputString.charAt(i));
			frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
		}
	}
	
	/**
	 * Sorts the frequency map in descending order of frequency.
	 *
	 * @param frequencyMap the frequency map to sort
	 * @return a sorted map in descending order of frequency
	 */
	private Map<String, Integer> sortFrequencyMap(Map<String, Integer> frequencyMap) {
		return frequencyMap.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
}

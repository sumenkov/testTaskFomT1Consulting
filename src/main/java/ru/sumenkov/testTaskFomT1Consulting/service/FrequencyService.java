package ru.sumenkov.testTaskFomT1Consulting.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FrequencyService {
	/**
	 * Returns a frequency map for the given input string.
	 *
	 * @param inputString the input string to process
	 * @return a map containing the frequency count of each character in the input string
	 */
	public Map<Character, Integer> getFrequencyMap(String inputString) {
		return inputString.chars().mapToObj(c -> (char) c)
				.collect(Collectors.toMap(Function.identity(), key -> 1, Integer::sum));
	}
}

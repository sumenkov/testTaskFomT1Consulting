package ru.sumenkov.testTaskFomT1Consulting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import ru.sumenkov.testTaskFomT1Consulting.service.FrequencyService;
import ru.sumenkov.testTaskFomT1Consulting.service.SortService;

import java.util.Map;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class FrequencyController {
	final SortService sortService;
	final FrequencyService frequencyService;

	/**
	 * Returns a JSON representation of the frequency map for the given input string.
	 *
	 * @param inputString the input string to process
	 * @return a map containing the frequency count of each character in the input string
	 */
	@GetMapping("json")
	public Map<?, Integer> returnJson(@RequestParam String inputString) {
		return sortService.sortFrequencyMap(frequencyService.getFrequencyMap(inputString));
	}
}

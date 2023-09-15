package ru.sumenkov.testTaskFomT1Consulting.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import ru.sumenkov.testTaskFomT1Consulting.service.FrequencyService;

/**
 * Controller class for handling frequency-related API requests.
 */
@RestController
@RequestMapping("api")
public class FrequencyController {
	
	private final ObjectMapper objectMapper;
	private final FrequencyService frequencyService;
	
	/**
	 * Constructor for FrequencyController.
	 *
	 * @param objectMapper the ObjectMapper used to serialize objects to JSON
	 */
	public FrequencyController(ObjectMapper objectMapper, FrequencyService frequencyService) {
		this.objectMapper = objectMapper;
		this.frequencyService = frequencyService;
	}
	
	/**
	 * Returns the frequency of characters in the input string as a JSON string.
	 *
	 * @param inputString the input string to analyze
	 * @return the JSON string representing the frequency of characters
	 */
	@GetMapping("json")
	public String returnJson(@RequestParam String inputString) {

		try {
			return objectMapper.writeValueAsString(frequencyService.analyzeFrequency(inputString).frequencyMap());
		} catch(JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}

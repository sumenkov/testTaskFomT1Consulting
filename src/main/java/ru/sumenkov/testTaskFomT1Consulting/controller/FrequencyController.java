package ru.sumenkov.testTaskFomT1Consulting.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import ru.sumenkov.testTaskFomT1Consulting.service.FrequencyService;

@RestController
@RequestMapping("api")
public class FrequencyController {
	
	private final ObjectMapper objectMapper;
	
	public FrequencyController(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	
	@GetMapping("json")
	public String returnJson(@RequestParam String inputString) {
		
		FrequencyService frequencyService = new FrequencyService();
		
		try {
			return objectMapper.writeValueAsString(frequencyService.analyzeFrequency(inputString).frequencyMap());
		} catch(JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	@GetMapping
	public String json(@RequestParam String inputString) {
		return returnJson(inputString);
	}
}

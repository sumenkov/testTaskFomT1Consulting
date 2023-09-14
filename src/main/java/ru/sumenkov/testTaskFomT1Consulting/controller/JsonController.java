package ru.sumenkov.testTaskFomT1Consulting.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api", method = {RequestMethod.GET})
public class JsonController {
	
	private final ObjectMapper objectMapper;
	
	public JsonController(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	
	@GetMapping("json")
	public String returnJson(@RequestParam String inputString) {
		try {
			return objectMapper.writeValueAsString(calculateFrequency(inputString));
		} catch(JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Object calculateFrequency(String inputString) {
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

package ru.sumenkov.testTaskFomT1Consulting.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api", method = {RequestMethod.GET})
public class Controller {
	
	@GetMapping("frequency")
	public Map<String, Integer> calculateFrequency(@RequestParam String inputString) {
		
		Map<String, Integer> frequencyMap = new HashMap<>();
		
		for (int i = 0; i < inputString.length(); i++) {
			String character = String.valueOf(inputString.charAt(i));
			frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
		}
		
		return frequencyMap.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
	
	@GetMapping("json")
	public String returnJson(@RequestParam String inputString) {
		
		return new Gson().toJson(calculateFrequency(inputString));
	}
}

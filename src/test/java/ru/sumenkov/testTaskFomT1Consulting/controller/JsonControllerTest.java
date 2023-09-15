package ru.sumenkov.testTaskFomT1Consulting.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class JsonControllerTest {
	
	@Mock
	private ObjectMapper objectMapper;
	
	private JsonController jsonController;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		jsonController = new JsonController(objectMapper);
	}
	
	@Test
	void returnJson() throws JsonProcessingException {
		String inputString = "Hello World!";
		Map<String, Integer> frequencyMap = new HashMap<>();
		frequencyMap.put("H", 1);
		frequencyMap.put("e", 1);
		frequencyMap.put("l", 3);
		frequencyMap.put("o", 2);
		frequencyMap.put(" ", 1);
		frequencyMap.put("W", 1);
		frequencyMap.put("r", 1);
		frequencyMap.put("d", 1);
		frequencyMap.put("!", 1);
		
		when(objectMapper.writeValueAsString(frequencyMap)).thenReturn("{\"H\":1,\"e\":1,\"l\":3,\"o\":2,\" \":1,\"W\":1,\"r\":1,\"d\":1,\"!\":1}");
		
		String expectedJson = "{\"H\":1,\"e\":1,\"l\":3,\"o\":2,\" \":1,\"W\":1,\"r\":1,\"d\":1,\"!\":1}";
		String actualJson = jsonController.returnJson(inputString);
		
		assertEquals(expectedJson, actualJson);
	}
	
	@Test
	void json() throws JsonProcessingException {
		returnJson();
	}
}
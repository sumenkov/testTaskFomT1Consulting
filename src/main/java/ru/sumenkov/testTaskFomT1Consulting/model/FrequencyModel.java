package ru.sumenkov.testTaskFomT1Consulting.model;

import java.util.Map;

/**
 * Represents a model for storing the frequency of characters in a string.
 */
public record FrequencyModel(Map<String, Integer> frequencyMap) {

}

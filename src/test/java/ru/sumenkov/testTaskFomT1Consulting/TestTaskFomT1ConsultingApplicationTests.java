package ru.sumenkov.testTaskFomT1Consulting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sumenkov.testTaskFomT1Consulting.controller.Controller;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestTaskFomT1ConsultingApplicationTests {
	
	@Test
	void testCalculateFrequency() {
		Controller controller = new Controller();
		
		// Тест 1: Проверка входной строки без повторяющихся символов
		Map<String, Integer> result1 = controller.calculateFrequency("abcd");
		assertEquals(4, result1.size());
		assertEquals(1, result1.get("a"));
		assertEquals(1, result1.get("b"));
		assertEquals(1, result1.get("c"));
		assertEquals(1, result1.get("d"));
		
		// Тест 2: Проверка входной строки с повторяющимися символами
		Map<String, Integer> result2 = controller.calculateFrequency("aaaabbbbcccc");
		assertEquals(3, result2.size());
		assertEquals(4, result2.get("a"));
		assertEquals(4, result2.get("b"));
		assertEquals(4, result2.get("c"));
		
		// Тест 3: Проверка входной строки с пустым значением
		Map<String, Integer> result3 = controller.calculateFrequency("");
		assertEquals(0, result3.size());
		
		// Тест 4: Проверка входной строки с пробелами
		Map<String, Integer> result4 = controller.calculateFrequency("HelloWorld");
		assertEquals(7, result4.size());
		assertEquals(3, result4.get("l"));
		assertEquals(2, result4.get("o"));
		assertEquals(1, result4.get("H"));
		assertEquals(1, result4.get("e"));
		assertEquals(1, result4.get("W"));
		assertEquals(1, result4.get("r"));
		assertEquals(1, result4.get("d"));
		
		// Тест 5: Проверка входной строки с разным регистром символов
		Map<String, Integer> result5 = controller.calculateFrequency("AbCdEfG");
		assertEquals(7, result5.size());
		assertEquals(1, result5.get("A"));
		assertEquals(1, result5.get("b"));
		assertEquals(1, result5.get("C"));
		assertEquals(1, result5.get("d"));
		assertEquals(1, result5.get("E"));
		assertEquals(1, result5.get("f"));
		assertEquals(1, result5.get("G"));
	}
	
	@Test
	void testReturnJson() {
		Controller controller = new Controller();
		
		// Тест 1: Проверка входной строки без повторяющихся символов
		String result1 = controller.returnJson("abcd");
		assertEquals(25, result1.length());
		assertEquals("{\"a\":1,\"b\":1,\"c\":1,\"d\":1}", result1);
		
		// Тест 2: Проверка входной строки с повторяющимися символами
		String result2 = controller.returnJson("aaaabbbbcccc");
		assertEquals(19, result2.length());
		assertEquals("{\"a\":4,\"b\":4,\"c\":4}", result2);
		
		// Тест 3: Проверка входной строки с пустым значением
		String result3 = controller.returnJson("");
		assertEquals(2, result3.length());
		assertEquals("{}", result3);
		
		// Тест 4: Проверка входной строки с пробелами
		String result4 = controller.returnJson("HelloWorld");
		assertEquals(43, result4.length());
		assertEquals("{\"l\":3,\"o\":2,\"r\":1,\"d\":1,\"e\":1,\"W\":1,\"H\":1}", result4);
		
		// Тест 5: Проверка входной строки с разным регистром символов
		String result5 = controller.returnJson("AbCdEfG");
		assertEquals(43, result5.length());
		assertEquals("{\"A\":1,\"b\":1,\"C\":1,\"d\":1,\"E\":1,\"f\":1,\"G\":1}", result5);
	}
}
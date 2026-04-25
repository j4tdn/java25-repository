package view.stream.demo;

import static utils.PrintUtils.*;
import static utils.NumberUtils.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class Ex01StreamFiltering {

	public static void main(String[] args) {
		
		List<Integer> elements = List.of(3, 5, 4, 15, 16, 4, 4, 16, 9);
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Integer element : elements) {
			Integer value = map.get(element);
			if(value != null) {
				map.put(element, value + 1);
			} else {
				map.put(element, 1);
			}
		}
		
		generate("1. Các số nguyên tố: ", 
				elements.stream().filter(n -> isPrime(n)).toList());
		
		generate("2. Các số ko trùng nhau: ", 
				elements.stream().distinct().toList());
		
		List<Integer> uniqueElements = elements.stream()
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()))
				.entrySet() // Set<Entry<Int, Long>
				.stream()
				.filter(e -> e.getValue() == 1L)
				.map(Entry::getKey)
				.toList();
		generate("3. Các số duy nhất: ", uniqueElements);
		
	}
	
}

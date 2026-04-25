package view.stream.demo;

import java.util.List;

public class Ex05Reducing {

	public static void main(String[] args) {
		
		List<String> elements = List.of("A2", "Z1", "B7", "E4", "C5");
		
		elements.stream()
				.reduce((max, cur) -> max.compareTo(cur) < 0 ? cur : max)
				.ifPresent(val -> System.out.println(val));
		
	}
	
}

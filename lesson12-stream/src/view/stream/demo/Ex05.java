package view.stream.demo;

import java.util.List;

public class Ex05 {
	public static void main(String[] args) {
		
		List<String> elements = List.of("A2", "Z1", "B7", "E4", "C5");
		elements.stream()
		.reduce((max, element) -> max. compareTo(element) < 0 ? element : max)
		.ifPresent(val -> System.out.println("maxValue -- > " + val));

		
	}
}

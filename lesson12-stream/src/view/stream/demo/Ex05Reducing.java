package view.stream.demo;

import java.util.List;

public class Ex05Reducing {

	public static void main(String[] args) {
		
		List<String> es = List.of("A2", "Z1", "B7", "E4", "C5");
		
		es.stream()
			.reduce((max, e) -> max.compareTo(e) < 0 ? e : max)
			.ifPresent(val -> System.out.println("maxElement --> " + val));
		
	}
	
}

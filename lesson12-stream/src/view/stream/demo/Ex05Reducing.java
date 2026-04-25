package view.stream.demo;

import java.util.List;
import java.util.function.BinaryOperator;

public class Ex05Reducing {

	public static void main(String[] args) {
		List<String> elements = List.of("A2","Z1","B7","E4","C5");
		
//		String max = "";
//		for(String element: elements) {
//			if(max.compareTo(element) < 0) {
//				max = element;
//			}
//		}
		
//		System.out.println("max --> " + max);
		
		String maxElement = elements.stream()
				.reduce("", (max, element) -> max.compareTo(element) < 0 ? element : max);
		
	}

}

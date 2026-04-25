package view.stream.demo;

import java.util.List;
import java.util.Optional;

import static utils.PrintUtils.*;

public class Ex04FindingAndMatching {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(1, 2, 1, 4, 5, 8, 10, 4, 12);
		
		boolean hasDividedBy10 = numbers.stream()
				.anyMatch(n -> n % 10 == 0);
		System.out.println(("1. Có số nào chia hết cho 10 ko: " + hasDividedBy10));
		
		Optional<Integer> firstDividedBy4 = numbers.stream()
				.filter(n -> n % 4 == 0)
				.findFirst();
		firstDividedBy4.ifPresentOrElse(
				val -> System.out.println(("2. Số đầu chia hết cho 4: " + val)), 
				() -> System.out.println("There is no number divisible by 4"));
		
		List<Integer> dividedBy5Nums = numbers.stream()
				.filter(n -> n % 5 == 0)
				.toList();
		generate("3. Các số chia hết cho 5", dividedBy5Nums);
		
		boolean allLessThan100 = numbers.stream()
				.allMatch(n -> n < 100);
		
		// Optional.of(value) --> value required != null
		// Optional.ofNullable(value)
		
	}
	
}

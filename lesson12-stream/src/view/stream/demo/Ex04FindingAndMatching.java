package view.stream.demo;

import java.util.List;
import java.util.Optional;

public class Ex04FindingAndMatching {
	
	public static void main(String[] args) {
		// Example: Give a list of numbers: 1, 2, 1, 4, 5, 8, 10, 4, 12
		List<Integer> numbers = List.of(1, 2, 1, 42, 5, 81, 10, 45, 121);
		
		System.out.println(numbers.stream().anyMatch(num -> num%10 == 0));
		
		Optional<Integer> firstD4Opt = numbers.stream()
				.filter(a -> a%4 == 0)
				.findFirst();
		
		firstD4Opt.ifPresentOrElse(val -> System.out.println(), 
				() -> System.out.println("There is no element divisible by 4"));
		
		System.out.println(numbers.stream().filter(a -> a%5 == 0).toList());

		
		System.out.println(numbers.stream().allMatch(a -> a < 100));
		
		System.out.println(numbers.stream().noneMatch(a -> a > 0));
		
		// Optional.of(value)          --> value required != null
		// Optional.ofNullable(value)  --> nullable value
	}
	
}

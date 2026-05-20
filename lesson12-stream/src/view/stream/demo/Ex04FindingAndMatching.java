package view.stream.demo;

import java.util.List;
import java.util.Optional;

public class Ex04FindingAndMatching {
	
	public static void main(String[] args) {
		
		// Example: Give a list of numbers: 1, 2, 1, 4, 5, 8, 10, 4, 12
		
		List<Integer> numbers = List.of(1, 2, 1, 42, 5, 81, 17, 45, 121);
		
		// 1st: is there any element that is divisible by 10
		System.out.println(
				"1st: is there any element that is divisible by 10 --> " + numbers.stream().anyMatch(n -> n % 10 == 0));
		
		// 2nd: find the first element that is divisible by 4
		Optional<Integer> firstD4Opt = numbers.stream()
			.filter(n -> n % 4 == 0)
			.findFirst();
		
		firstD4Opt.ifPresentOrElse(
			val -> System.out.println("2nd: find the first element that is divisible by 4 --> " + val),
			() -> System.out.println("2nd: there is no element divisible by 4"));
		
		// 3rd: find the elements that is divisible by 5 in the list
		
		// 4th: does all elements less than 100
		
		// 5th: does no elements greater than 0
		
		
		// Optional.of(value)         --> value required != null
		// Optional.ofNullable(value) --> nullable value
	}
	
}
package view.stream.demo;

import java.util.List;
import java.util.Optional;

public class Ex04FindingAndMatching {
	public static void main(String[] args) {
		// Example: Give a list of numbers: 1, 2, 1, 4, 5, 8, 10, 4, 12
		List<Integer> numbers = List.of(1, 2, 1, 4, 5, 8, 10, 4, 12);
		
		// 1st: is there any element that is divisible by 10
		System.out.println("1st: is there any element that is divisible by 10: " 
							+ numbers.stream().anyMatch(n -> n % 10 == 0));
		
		// 2nd: find the first element that is divisible by 4
        Optional<Integer> firstDivBy4 = numbers.stream().filter(n -> n % 4 == 0).findFirst();
        System.out.println("First divisible by 4: " + firstDivBy4.orElse(null));

        // 3rd: find the elements that are divisible by 5 in the list
        List<Integer> divBy5 = numbers.stream().filter(n -> n % 5 == 0).toList();
        System.out.println("Divisible by 5: " + divBy5);

        // 4th: does all elements less than 100
        boolean allLessThan100 = numbers.stream().allMatch(n -> n < 100);
        System.out.println("All less than 100? " + allLessThan100);

        // 5th: does no elements greater than 0
        boolean noneGreaterThan0 = numbers.stream().noneMatch(n -> n > 0);
        System.out.println("No elements greater than 0? " + noneGreaterThan0);
	}
}

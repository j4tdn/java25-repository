package view.stream.demo;

import java.util.List;
import java.util.Optional;

public class Ex04FindingAndMatching {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(1,2,1,5,81,110);
		
		boolean hasDivisibleBy10 = numbers.stream().anyMatch(n -> n % 10 == 0);
		System.out.println("Cau 1: " + hasDivisibleBy10);
		
		Optional<Integer> findFirstDivisibleBy4 = numbers.stream().filter(n -> n % 4 == 0).findFirst();
		
		findFirstDivisibleBy4.ifPresentOrElse(val -> System.out.println("Cau 2: " + val), 
												() -> System.out.println("Cau 2: Khong co"));
		
		List<Integer> hasDivisibleBy5 = numbers.stream().filter(n -> n % 5 == 0).toList();
		System.out.println("Cau 3: " + hasDivisibleBy5);
		
		
	}
	
}

package view.stream.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static utils.PrintUtils.*;

public class Ex02FlatMap {
	
	public static void main(String[] args) {
		// s1 -> Stream<T> <-- mapping --> Stream<R> -> s2
		
		List<String> words = List.of("hello", "java21", "programing");
		
		generate(
			"1. Chuyển đối từ string -> length",
			words.stream().map(String::length).toList()
		);
		

		// s1 -> Stream<Collection<T>> <-- flatMap --> Stream<T> -> s2
		// s1 -> Stream<T[]> <-- flatMap --> Stream<T> -> s2
		
		List<Set<Integer>> list = List.of(
			Set.of(1,11,21), 
			Set.of(2,3,4), 
			Set.of(10, 20)
		);
		
		List<Integer> flattenList = list.stream() // Stream<Set<E>>
				.flatMap(Collection::stream) // Stream<E>
				.toList();
		generate(
			"2. Gom các phần tử từ list<set>",
			flattenList
		);
		
		String[][] letters = {
				{"A", "B"},
				{"C", "D", "E"}
		};
		
		String[] flatenArray = Arrays.stream(letters) // Stream<E[]>
			.flatMap(Arrays::stream) // Stream<E>
			.toArray(String[]::new); // E[]
		generate(
			"2. Gom các phần tử từ list<set>",
			flatenArray
		);
		
	}
	
}
package view.stream.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static utils.PrintUtils.*;

public class Ex02FlatMap {

	public static void main(String[] args) {
		
		// mapping: s1 -> Stream<T> - Stream<R> -> s2
		List<String> words = List.of("hello", "java21", "programing");
		generate("1. Chuyen doi tu string -> length", words.stream().map(String::length).toList());
		
		//flatMap: s1 -> Stream<Collection<T>> - Stream<T> -> s2
		// s1 -> Stream<T[]> <-- flatMap --> Stream<T> -> s2
		
		List<Set<Integer>> list = List.of(
			Set.of(1,11,21),
			Set.of(2,3,4),
			Set.of(10,20)
			);
		
		List<Integer> flattenList = list.stream() // Stram<Set<E>>
				.flatMap(Collection::stream) // Stream<E>
				.toList();
		generate("2. Gom cac phan tu tu list<set>", flattenList);
		
		String[][] letters = {
				{"A", "B"},
				{"C", "D", "E"}
		};
		
		String[] flattenArray = Arrays.stream(letters) // Stream<E[]>
			.flatMap(Arrays::stream)
			.toArray(String[]::new);
		generate("3. Gom cac phan tu tu list<set>", flattenArray);
		
	}
	
}

package view.stream.demo;

import static utils.NumberUtils.isPrime;
import static utils.PrintUtils.generate;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex01StreamFiltering {
	
	/*
	 - filtering with a predicate
	 - filtering only unique elements
	 - ignoring the first|last few elements of a stream
	 - truncating a stream to a given size
	 
	 --> filter, distinct, sorted, limit, skip
	 */
	
	public static void main(String[] args) {
		
		List<Integer> elements = List.of(3, 5, 4, 15, 16, 4, 4, 16, 9);
		
		generate(
			"1. Tìm các phần tử là số nguyên tố",
			elements.stream().filter(e -> isPrime(e)).toList()
		);
		
		generate(
			"2. Loại bỏ các phần tử trùng nhau[chỉ in ra 1 lần]",
			elements.stream().distinct().toList() // hashcode, demo 
		);
		
		generate(
			"3. Tìm các phần tử duy nhất",
			filterElements(elements, count -> count == 1L)
		);
		
		generate(
			"4. Tìm các phần tử xuất hiện nhiều hơn n lần",
			filterElements(elements, count -> count > 1L)
		);
		
		generate(
			"5. Lấy 3 phần tử đầu tiên và sắp xếp tăng dần",
			elements.stream().limit(3).sorted().toList()
		);
		
		generate(
			"6. Lấy 4 phần tử cuối cùng và sắp xếp giảm dần",
			elements.stream().skip(elements.size() - 4).sorted(Comparator.reverseOrder()).toList()
		);
		
		// A B C D E F G H
		// 7. Lấy các phần tử từ 2-5
		generate(
			"7. Lấy các phần tử từ 2-5",
			elements.stream().skip(2).limit((5-2+1)).toList()
		);
	}
	
	private static List<Integer> filterElements(List<Integer> elements, Predicate<Long> predicate) {
		return elements.stream()
			.collect(Collectors.groupingBy(e -> e, Collectors.counting()))
			.entrySet().stream()
			.filter(e -> predicate.test(e.getValue()))
			.map(Entry::getKey)
			.toList();
	}
	
}

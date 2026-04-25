package view.stream.demo;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ex01StreamFiltering {

	public static void main(String[] args) {
		List<Integer> elements = List.of(2, 3, 5, 4, 15, 16, 4, 4, 16);
		
		// 1. Tìm các phần tử là số nguyên tố trong danh sách trên
		List<Integer> primeNumbers = elements.stream()
									.filter(num -> isPrime(num))
									.toList();
		
		// 2. Loại bỏ những phần tử trùng nhau
		List<Integer> distinctElements = elements.stream()
										.distinct()
										.toList();
		
		// 3. Tìm các phần tử duy nhất
//		List<Integer> statisticElements = filterElement(elements, count -> count == 1L);
		// 4. Tìm các phần tử xuất hiện nhiều hơn n lần
		List<Integer> statisticElements = filterElement(elements, count -> count > 1L);
		
		// 5. Lấy 3 phần tử đầu tiên và sắp xếp tăng dần
		List<Integer> results = elements.stream()
								.limit(3)
								.sorted()
								.toList();
		
		// 6. Lấy 4 phần tử cuối cùng và sắp xếp giảm dần
		List<Integer> ans = elements.stream()
								.skip(elements.size() - 4)
								.sorted((n1,n2) -> n2 - n1)
								.toList();
		
		// 7. Lấy các phần tử từ 2-5
		List<Integer> yeuCau7 = elements.stream()
								.skip(2)
								.limit((5-2+1))
								.toList();
	}
	
	private static List<Integer> filterElement(List<Integer> elements, Predicate<Long> predicate) {
		return elements.stream()
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(e -> predicate.test(e.getValue()))
				.map(Entry::getKey)
				.toList();
	}
	
	private static boolean isPrime(int n) {
		for(int i = 2;i<=Math.sqrt(n);++i) {
			if(n%i == 0) {
				return false;
			}
		}
		return n > 1;
	}

}

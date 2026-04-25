package view.stream.demo;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static utils.PrintUtils.*;

public class Ex01StreamFiltering {

	public static void main(String[] args) {
		
		List<Integer> elements = List.of(3,5,4,15,16,4,4,16,9);
		
		// 1. Tim cac phan tu la so ngto
		List<Integer> primeNumbers = elements.stream()
			    .filter(Ex01StreamFiltering::isPrime)
			    .toList();
		generate("1. Cac phan tu la so ngto", primeNumbers);
		
		// 2. Loai bo nhung phan tu trung -> 3 4 5 15 16
		List<Integer> distinctElements = elements.stream()
			    .distinct() // hashcode, demo
			    .sorted()
			    .toList();
		generate("2. Loai bo nhung phan tu trung", distinctElements);
		
		// 3. Tim cac phan tu duy nhat
		generate(
			    "3. Tìm các phần tử duy nhất",
			    filterElements(elements, count -> count == 1L)
			);
		
		// 4. Tim cac phan tu xuat hien nhieu hon n lan
		generate(
			    "4. Tìm các phần tử xuất hiện nhiều hơn n lần",
			    filterElements(elements, count -> count > 1L)
			);
		
		// 5. Lay 3 phan tu dau va sx tang dan
		generate(
			    "5. Lay 3 phan tu dau va sx tang dan",
			    elements.stream().limit(3).sorted().toList()
			);
		
		// 6. Lay 4 phan tu cuoi va sap xep giam dan
		generate(
			    "6. Lay 4 phan tu cuoi va sap xep giam dan",
			    elements.stream().skip(elements.size() - 4).sorted(Comparator.reverseOrder()).toList()
			);
		
		// 7. Lay cac phan tu 2-5
		generate(
			    "7. Lay cac phan tu 2-5",
			    elements.stream().skip(2).limit(5-2+1).toList() // 5-2+1 la cong thuc
			);
	}
	
	public static boolean isPrime(int n) {
	    if (n < 2) return false;
	    for (int i = 2; i <= Math.sqrt(n); i++) {
	        if (n % i == 0) return false;
	    }
	    return true;
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

package view.stream.demo;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
		List<Integer> elements = List.of(2, 3, 4, 15, 16, 4, 4, 16);
		
		// 1. Tìm các phần tử là số nguyên tố
        List<Integer> primes = elements.stream()
                .filter(Ex01StreamFiltering::isPrime)
                .collect(Collectors.toList());
        System.out.println("Primes: " + primes);

        // 2. Loại bỏ phần tử trùng nhau
        List<Integer> distinct = elements.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct: " + distinct);

        // 3. Tìm các phần tử duy nhất (xuất hiện đúng 1 lần)
        List<Integer> unique = elements.stream()
                .filter(e -> Collections.frequency(elements, e) == 1)
                .collect(Collectors.toList());
        System.out.println("Unique only: " + unique);

        // 4. Tìm các phần tử xuất hiện nhiều hơn n lần (ví dụ n=2)
        int n = 2;
        List<Integer> moreThanN = elements.stream()
                .filter(e -> Collections.frequency(elements, e) > n)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Appear > " + n + " times: " + moreThanN);

        // 5. Lấy 3 phần tử đầu tiên và sắp xếp tăng dần
        List<Integer> first3Sorted = elements.stream()
                .limit(3)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("First 3 sorted asc: " + first3Sorted);

        // 6. Lấy 4 phần tử cuối cùng và sắp xếp giảm dần
        List<Integer> last4SortedDesc = elements.stream()
                .skip(elements.size() - 4)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Last 4 sorted desc: " + last4SortedDesc);

        // 7. Lấy các phần tử từ 2-5 (index 1 đến 4)
        List<Integer> subList = elements.stream()
                .skip(1)
                .limit(4)
                .collect(Collectors.toList());
        System.out.println("Elements from 2-5: " + subList);
    }

    // Hàm kiểm tra số nguyên tố
	public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
	
}

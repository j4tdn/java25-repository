package view.stream.demo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static utils.NumberUtils.*;
import static utils.PrintUtils.*;

public class Ex01StreamFiltering {
	
	public static void main(String[] args) {
		
		List<Integer> elements = List.of(3,5,4,15,16,4,4,16,9);
		
			generate(
					" 1. Tìm các phần tử là số nguyên tố", 
					elements.stream().filter(e -> isPrime(e)).toList()
			);

			generate(" 2. Loại bỏ các phần tử trùng nhau, trả về 1 phần tử duy nhất nếu có trùng",
					elements.stream().distinct().toList()
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
					elements.stream().limit(3).toList()
			);

			generate(
					"6. Lấy 4 phần tử cuối cùng và sắp xếp giảm dần",
					elements.stream().skip(elements.size() - 4).sorted(Comparator.reverseOrder()).toList()
			);

			generate(
					"7. Lấy các phần tử từ chỉ số 2 đến 5",
					elements.stream().skip(2).limit((5-2+1)).toList()
			);
	}
	private static List<Integer> filterElements(List<Integer> elements, Predicate<Long> predicate) {
	    return elements.stream()
	            .collect(Collectors.groupingBy(e -> e, Collectors.counting())) // Nhóm các phần tử theo giá trị và đếm tần suất xuất hiện
	            .entrySet().stream()
	            .filter(e -> predicate.test(e.getValue())) // Lọc ra những phần tử xuất hiện chỉ 1 lần
	            .map(Entry::getKey) // Lấy giá trị phần tử (chỉ số)
	            .collect(Collectors.toList()); // Chuyển kết quả thành danh sách
	}
}

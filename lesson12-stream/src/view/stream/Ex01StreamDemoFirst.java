package view.stream;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import bean.Dish;
import common.Kind;
import model.DataModel;

import static utils.PrintUtils.*;
import static utils.NumberUtils.*;

public class Ex01StreamDemoFirst {
	
	/**
	 * IntStream, DoubleStream, LongStream
	 * - Lưu trữ tập hợp dữ liệu (nguyên thủy)
	 * 
	 * Stream<T>
	 * - Lưu trữ tập hợp dữ liệu (Đối tượng)
	 *   --> Hạn chế lưu trữ trong Stream vì
	 *       ..... Stream chỉ cho phép duyệt, xử lý qua 1 lần duy nhất .....
	 *   --> Thường source --> stream [dùng các operation xử lý] --> target    
	 * - Hỗ trợ các thao tác xử lý bên trong
	 * 
	 * filter, map --> Stream<T>
	 * 
	 * target
	 * --> Collectors.toList || toSet || joining || toMap || toArray
	 * 
	 */
	
	
	
	public static void main(String[] args) {
		List<Dish> menu = DataModel.mockDishList();
		
		Set<Dish> highCaloricDishes = menu.stream() // Stream<Dish> 8
			.filter(d -> d.getCalories().compareTo(bd("400")) > 0) // Stream<Dish> 5
			.collect(Collectors.toSet()); // List<Dish>
		generate("1. Print dishes which have the calories > 400", highCaloricDishes);
		
		String nameOfDishes = menu.stream() // Stream<Dish> 8
				.map(Dish::getName) // Stream<String> 8
				.collect(Collectors.joining(", ", "[", "]"));
		System.out.printf("2. Print name of dishes %s\n", nameOfDishes); 
		
		String[] nameOfVeggieDishes = menu.stream()
				.filter(d -> d.getKind() == Kind.VEGGIE)
				.map(Dish::getName)
				.toArray(String[]::new);
		generate("3. Print name of veggie dishes", nameOfVeggieDishes);
		
		Map<String, Integer> models = DataModel.mockModelMap();
		
		// Stream<E> --> Collection<E>
		// Stream<E> --> Map<K, V>
		
		// (v1, v2) -> v2 --> BinaryOperator<T> ==> T apply(T T)
		// khi convert sang map, nếu 2 phần tử có trùng key thì sẽ lấy value nào ...
		
		Map<Integer, String> sortedModels = models.entrySet() // Set<Entry<K, V>>
				.stream() // Stream<Entry<K, V>>
				.sorted(Entry.comparingByValue())  // Stream<Entry<K, V>>
				.collect(Collectors.toMap(Entry::getValue, Entry::getKey, (v1, v2) -> v2, LinkedHashMap::new));
		
		generate("4. Sorted models", sortedModels);
		
		
	}
	
}

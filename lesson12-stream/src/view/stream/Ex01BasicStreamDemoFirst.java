package view.stream;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static utils.PrintUtils.*;
import static utils.NumberUtils.*;

import bean.Dish;
import common.Kind;
import model.DataModel;

public class Ex01BasicStreamDemoFirst {
	/**
	 * IntStream, DoubleStream, LongStream - Lưu trữ tập hợp dữ liệu nguyên thủy
	 * 
	 * Stream<T> - Lưu trữ tập hợp dữ liệu (Đối tượng) --> Hạn chế lưu trữ trong
	 * Stream vì
	 * 		.... Stream chỉ cho phép lưu 1 lần duy nhất
	 * --> Thường source --> stream [dùng các operation xử lý] --> target - Hỗ trợ
	 * các thao tác xử lý bên trong
	 * 
	 * filter, map --> Stream<T>
	 * 
	 * 
	 * target --> Collectors.toList || toSet || joining
	 */

	public static void main(String[] args) {
		List<Dish> menu = DataModel.mockDishList();

		// Get dishes which have the calories > 250
		Set<Dish> highCaloricDishes = menu.stream().filter(d -> d.getCalories().compareTo(new BigDecimal("400")) > 0)
				.collect(Collectors.toSet());
		generate("1. Print dishes which have the calories > 400", highCaloricDishes);

		// toList --> return immutable list
		// collectors.toList --> return dynamic list

		List<String> nameOfDishes = menu.stream().map(Dish::getName).collect(Collectors.toList());
		generate("2. Print name of dishes", nameOfDishes);

		String[] nameOfVeggieDishes = menu.stream().filter(d -> d.getKind() == Kind.VEGGIE).map(Dish::getName)
//				.toArray(new IntFunction<String[]>() {
//					@Override
//					public String[] apply(int value) {
//						return new String[value];
//					}
//				});
									  .toArray(String[]::new);

		generate("3. Print name of veggie dishes", nameOfVeggieDishes);

		Map<String, Integer> models = DataModel.mockModelMap();

		Map<Integer, String> sortedModels = models.entrySet()
				.stream() // Stream<Entry<K,V>>
				.sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(Entry::getValue, Entry::getKey, (v1,v2) -> v2, LinkedHashMap::new));

		generate("4. Sorted models", sortedModels);
	}

}

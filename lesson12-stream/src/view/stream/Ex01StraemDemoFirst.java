package view.stream;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import bean.Dish;
import common.Kind;
import model.DataModel;
import static utils.PrintUtils.*;
import static utils.NumberUtils.*;

public class Ex01StraemDemoFirst {
	
	/**
	 * IntStream, DoubleStream, LongStream
	 * - Lưu trữ tập hợp dữ liệu (nguyên thủy)
	 *
	 * Stream<T>
	 * - Lưu trữ tập hợp dữ liệu (Đối tượng)
	 * --> Hạn chế lưu trữ trong Stream vì
	 *
	 * - Thường source --> stream (dùng các operation xử lý) --> target
	 * - Hỗ trợ các thao tác xử lý bên trong
	 *
	 */

	public static void main(String[] args) {
	    List<Dish> menu = DataModel.mockDishList();
	    Set<Dish> highCaloricDishes = menu.stream() // Stream<Dish>
	            .filter(d -> d.getCalories().compareTo(bd("400")) > 0) // Stream<Dish>
	            .collect(Collectors.toSet()); // List<Dish>

	    generate("1. Print dishes which have the calories > 400", highCaloricDishes);

	    // Get name of dishes
	   String nameOfDishes = menu.stream()
	    		.map(Dish::getName)
	    		.collect(Collectors.joining(", ", "[", "]"));
	    System.out.printf("2. Print name of dishes %s", nameOfDishes);
	    
	    // Get name of veggie dishes
	    String[] nameOfVeggieDishes = menu.stream()
	            .filter(d -> d.getKind() == Kind.VEGGIE)
	            .map(Dish::getName)
	            .toArray(String[]::new);

	    generate("3. Print name of veggie dishes", nameOfVeggieDishes);

	    // Sort the given model map
	    Map<String, Integer> models = DataModel.mockModelMap();
	    
	    Map<String, Integer> sortedModels = models.entrySet()
	    		.stream()
	    		.sorted(Entry.comparingByValue())
	    		.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v2, LinkedHashMap::new));
	    generate("4. Original model", models);
	}
	
}

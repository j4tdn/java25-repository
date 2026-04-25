package view.stream;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import bean.Dish;
import common.Kind;
import model.DataModel;

import static utils.PrintUtils.*;

public class Ex01StreamDemoFirst {

	/**
	 * Stream<T>
	 * 	- Lưu trữ tập hợp dữ liệu object
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Dish> menu = DataModel.mockDishList();
		
		// Get dishes which have calories greater than 50
		Set<Dish> highCaloriesDishes = menu.stream()
			.filter(d -> d.getCalories().compareTo(new BigDecimal("400")) > 0)
			.collect(Collectors.toSet());
		generate("1. Print dishes which have calories greater than 400", highCaloriesDishes);
			
		// Get name of dishes
		String nameOfDishes = menu.stream()
				.map(d -> d.getName())
				.collect(Collectors.joining(", ", "[", "]"));
		System.out.print("2. Print all name of dishes" + nameOfDishes);
		
		// Get name of VEGGIE dishes
		String[] nameOfVeggieDishes = menu.stream()
				.filter(d -> Kind.VEGGIE.equals(d.getKind()))
				.map(d -> d.getName())
				.toArray(String[]::new);
		generate("3. Print all name of VEGGIE dishes", nameOfVeggieDishes);
		
		// Sort the given model map
		Map<String, Integer> models = DataModel.mockModelMap();
		
		Map<String, Integer> sortedModels = models.entrySet() // Set<Entry<String, Integer>>
				.stream() // Stream<Entry<String, Integer>>
				.sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (v1, v2) -> v2, LinkedHashMap::new));
		generate("4. Sorted models", sortedModels);
		
	}
	
}

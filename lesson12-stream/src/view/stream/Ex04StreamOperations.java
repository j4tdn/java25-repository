package view.stream;

import java.util.List;

import bean.Dish;
import model.DataModel;
import static utils.NumberUtils.*;
import static utils.PrintUtils.*;

public class Ex04StreamOperations {

	public static void main(String[] args) {
		// intermediate operations: form a pipeline(query) until terminal operation is invoked
		// terminal operations
		
		List<Dish> menu = DataModel.mockDishList();
		
		generate("1. Menu", menu);
		
		List<Dish> filteredDishes = menu.stream()
				.filter(dish -> {
					return dish.getCalories().compareTo(bd("500")) > 0;
				})
				.toList();
		
		generate("2. Filtered Dishes", filteredDishes);
	}

}

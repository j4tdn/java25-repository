package view.stream;

import java.util.List;

import bean.Dish;
import model.DataModel;

import static utils.NumberUtils.*;
import static utils.PrintUtils.*;

public class Ex04StreamOperations {

	public static void main(String[] args) {
		
		// intermediate operations
		// terminal operations
		
		List<Dish> menu = DataModel.mockDishList();
		
		generate("1. Menu", menu);
		
		List<Dish> filteredDishes = menu.stream()
			.filter(dish -> {
				return dish.getCalories().compareTo(bd("200")) > 0;
			})
			.toList();
		
		generate("1. Filtered Dishes", filteredDishes);
	}
	
}

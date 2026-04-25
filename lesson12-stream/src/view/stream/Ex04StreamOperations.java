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
		
		List<String> filtereDishes = menu.stream()
			.filter(dish -> {
				System.out.println("#Filter --> " + dish.getId());
				return dish.getCalories().compareTo(bd("500")) >0;
			})
			.map(dish ->{
				System.out.println("#Map --> " + dish.getId());
				return dish.getName();
			})
			.limit(2)
			.toList();
		generate("2. Filted Dishes", filtereDishes);
		
	}
}

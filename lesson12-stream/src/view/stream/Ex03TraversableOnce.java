package view.stream;

import static utils.NumberUtils.bd;

import java.util.List;
import java.util.stream.Stream;

import bean.Dish;
import model.DataModel;

public class Ex03TraversableOnce {
	
	// 1. Vì sao không lưu trữ trong stream sau khi xử lý xong
	// 2. Phân biệt intermediate[trung gian] và terminal[đầu cuối] operations 
	
	public static void main(String[] args) {
		List<Dish> menu = DataModel.mockDishList();
		
		Stream<Dish> stream1 = menu.stream().filter(d -> d.getCalories().compareTo(bd("500")) > 0);
		
		System.out.println("Compute A1");
		stream1.forEach(System.out::println);
		
		// System.out.println("\nCompute A2");
		// stream1.forEach(System.out::println);
		
		List<Dish> list1 = menu.stream().filter(d -> d.getCalories().compareTo(bd("500")) > 0).toList(); // immutable list
		
		System.out.println("\nCompute B1");
		list1.forEach(System.out::println);
		
		System.out.println("\nCompute B2");
		list1.forEach(System.out::println);
		
	}
	
}
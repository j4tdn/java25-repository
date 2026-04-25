package view.stream;

import java.util.List;
import java.util.stream.Stream;

import bean.Dish;
import model.DataModel;

import static utils.NumberUtils.*;
import static utils.PrintUtils.*;

public class Ex03TraversableOne {
	
	
	public static void main(String[] args) {
		List<Dish> menu = DataModel.mockDishList();
		
		Stream<Dish> stream1 =   menu.stream().filter(d -> d.getCalories().compareTo(bd("550")) >0);
	
		System.out.println("Compute A1");
		stream1.forEach(System.out::println);
		
//		System.out.println("\nCompute A2");
//		stream1.forEach(System.out::println);
		
		List<Dish> list1 = menu.stream().filter(d -> d.getCalories().compareTo(bd("550")) >0).toList();
		
		System.out.println("Compute B1");
		list1.forEach(System.out::println);
		
		System.out.println("\nCompute B2");
		list1.forEach(System.out::println);
	}

}

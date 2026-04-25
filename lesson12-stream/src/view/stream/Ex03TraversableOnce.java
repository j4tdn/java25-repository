package view.stream;

import java.util.List;
import java.util.stream.Stream;

import bean.Dish;
import model.DataModel;
import static utils.NumberUtils.*;
import static utils.PrintUtils.*;

public class Ex03TraversableOnce {
	
	// 1. Vì sao không lưu trữ stream sau khi xử lý xong
	// 2. Phân biệt intermediate and terminal operations

	public static void main(String[] args) {
		List<Dish> menu = DataModel.mockDishList();
		
		// chỉ được thao tác 1 lần duy nhất
		Stream<Dish> stream = menu.stream().filter(d -> d.getCalories().compareTo(bd("500")) > 0);
		
		System.out.println("Compute A1");
		stream.forEach(System.out::println);
		
		// Đảm bảo dữ liệu chỉ thao tác 1 lần hẳn lưu trong stream
		System.out.println("Compute A2");
		stream.forEach(System.out::println);
	}

}

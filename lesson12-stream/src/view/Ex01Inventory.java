package view;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import bean.Apple;
import common.Color;
import model.DataModel;

import static utils.NumberUtils.*;
import static utils.PrintUtils.*;

public class Ex01Inventory {
	
	/**
	   1st: find all green apples in his inventory
	   2nd: find all red apples in his inventory
	   3rd: find all apples heavier than 150 g
	   4th: find all apples lighter than 200g
       5th: find all apples that are green and heavier than 400 g
       
       Ôn tập khái niệm strategy pattern, functional interface & lambda
	 */
	
	public static void main(String[] args) {
		
		List<Apple> inventory = DataModel.mockAppleList();
		
		List<Apple> greenApples = filterApples(inventory, apple -> Color.GREEN.equals(apple.getColor()));
		
		List<Apple> redApples = filterApples(inventory, apple -> Color.RED.equals(apple.getColor()));
		
		List<Apple> heavyApples = filterApples(inventory, apple -> apple.getWeight().compareTo(bd("200")) > 0);
		
		generate("1. Kho hàng", inventory);
		
		generate("2. Danh sách táo màu xanh", greenApples);
		
		generate("3. Danh sách táo màu đỏ", redApples);
		
		generate("4. Danh sách táo có cân nặng hơn 200gr", heavyApples);
		
		// 1. Runnable runnable = () -> {}; OK
		// 2. Supplier<String> supplier = () -> "Raoul"; OK
		// 3. Supplier<String> supplier = () -> {return "Raoul";}; OK
		// ---- 4. Function<Integer, String> function = (Integer i) -> "Alan" + i; ---- X
		// 5. Function<String, String> function = (String s) -> "Iron Man"; OK
		
	}
	
	// Tham số là functional interface
	// Truyền vào --> implementation class: chỗ override method dài, phức tạp, dùng cho nhiều vị trí [phải tạo thêm class]
	//            --> anonymous class     : override trực tiếp functional interface chỗ gọi
	//            --> anonymous function(lambda): ngắn gọn nhất
	
	// Lambda: (parameters) -> {body}
	// - parameters
	//   + nếu chỉ có 1 tham số --> ko cần ()
	//   + ko cần phải khai báo KDL cho parameter, vì override từ abstract method biết dc từng tham số này kiểu gì rồi
	// - arrow
	//   + bắt buộc
	// - body
	//   + có thể return KDL nào đó hoặc void
	//   + nếu chỉ có 1 dòng thì ko cần {} ko cần từ khóa return
	
	private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple: inventory) {
			if (predicate.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
}

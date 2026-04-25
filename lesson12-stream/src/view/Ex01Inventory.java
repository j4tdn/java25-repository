package view;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import bean.Apple;
import common.Color;
import model.DataModel;
import static utils.NumberUtils.*;
import static utils.PrintUtils.*;
public class Ex01Inventory {

	
	public static void main(String[] args) {

	    List<Apple> inventory = DataModel.mockAppleList();

	    List<Apple> greenApples = filterApples(inventory,
	            apple -> Color.GREEN.equals(apple.getColor()));

	    List<Apple> redApples = filterApples(inventory,
	            apple -> Color.RED.equals(apple.getColor()));

	    List<Apple> heavyApples = filterApples(inventory,
	            apple -> apple.getWeight().compareTo(bd("200")) > 0);
	    
	    generate("1. KHo hàng", inventory);
	    generate("2. Danh sách táo mù xanh", greenApples);
	    generate("3.  Danh sách táo màu đỏ", redApples);
	    generate("4. Danh sách táo có cân nặng hơn 200gr", heavyApples);
	    
	    
	}

	private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
	    List<Apple> result = new ArrayList<>();

	    for (Apple apple : inventory) {
	        if (predicate.test(apple)) {
	            result.add(apple);
	        }
	    }

	    return result;
	}
}

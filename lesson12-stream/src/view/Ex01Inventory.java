package view;

import static model.DataModel.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import bean.Apple;
import common.Color;

import static utils.PrintUtils.*;

public class Ex01Inventory {

	public static void main(String[] args) {
		
		List<Apple> apples = mockAppleList();
		
		List<Apple> greenApples = new ArrayList<Apple>();
		for(Apple apple : apples) {
			if(Color.GREEN.equals(apple.getColor())) {
				greenApples.add(apple);
			}
		}
		
		List<Apple> redApples = filterApples(apples, (a) -> {
			return Color.RED.equals(a.getColor());
		});
		
		List<Apple> heavierThan150gApples = filterApples(apples, (a) -> {
			return a.getWeight().compareTo(new BigDecimal("150")) > 1;
		});
		
		List<Apple> lighterThan200gApples = filterApples(apples, (a) -> {
			return a.getWeight().compareTo(new BigDecimal("200")) < 1;
		});
		
		generate("1. Ds táo xanh", greenApples);
		generate("2. Ds táo đỏ", redApples);
		generate("3. Ds táo có trọng lượng > 150g", heavierThan150gApples);
		generate("4. Ds táo có trọng lượng < 200g", lighterThan200gApples);
		
	}
	
	private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {		
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : inventory) {
			if(predicate.test(apple)) {
				result.add(apple);
			}
		}
		
		return result;	
	}
	
}

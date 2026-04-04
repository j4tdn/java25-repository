package view.generic;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import bean.Item;

public class Ex03GeneticTypeExtends {
	public static void main(String[] args) {
		String[] sElements = {"A1", "A2", "A3"};
		Item[] items = {
			new Item(1, "Item X1", bd("120"), toDate("10/12/2020"), 101),new Item(3, "Item Z3", bd("111"), toDate("14/12/2021"), 101)	
		};
		
//		sort(items);
		
		for(Item item: items) {
			System.out.println(item);
		}
	}
	
	private static <E extends Comparable<E>> void sort(E[] objects) {
		Arrays.sort(objects);
	}
	
	public static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}

	public static LocalDate toDate(String dMy) {
		return LocalDate.parse(dMy, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}
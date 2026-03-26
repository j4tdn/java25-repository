package view.generic;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import bean.Item;

public class Ex03GenericTypeExtends {
	
	public static void main(String[] args) {
		
		String[] sElements = {"A1", "A2", "A3"};
		
		Item[] items = {
				new Item(1, "Item X1", bd("120"), toDate("10/12/2020"), 101),
				new Item(2, "Item A2", bd("181"), toDate("12/12/2022"), 101)
		};
		
		sort(sElements);
		
		// runtime: Exception in thread "main" java.lang.ClassCastException: class bean.Item cannot be cast to class java.lang.Comparable
		sort(items);

		// compile 
		
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

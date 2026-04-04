package view.set;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import bean.Item;

import static utils.PrintUtils.*;

public class Ex01SetDemo {

	public static void main(String[] args) {
		
		Set<String> elements = new HashSet<String>();
		elements.add("A1");
		elements.add("A2");
		elements.add("A3");
		elements.add("A4");
		elements.add("A5");
		
		Set<Integer> numbers = Set.of(1,2,3,4,5);
		generateStrings("2. Numbers", numbers);
		
		Set<Item> items = new HashSet<Item>();
		items.add(new Item(1, "Item1", bd("120"), toDate("10/12/2020"), 101));
		items.add(new Item(2, "Item2", bd("120"), toDate("10/12/2020"), 101));
		items.add(new Item(3, "Item3", bd("120"), toDate("10/12/2020"), 101));
		
		System.out.println("A. Item size --> " + items.size());
		
		items.add(new Item(1, "ItemX1", bd("120"), toDate("10/12/2020"), 101));
		
		System.out.println("B. Item size --> " + items.size());
		
	}
	
	public static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}
	
	public static LocalDate toDate(String dMy) {
		return LocalDate.parse(dMy, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
}

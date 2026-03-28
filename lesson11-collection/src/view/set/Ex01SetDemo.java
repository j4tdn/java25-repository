package view.set;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import bean.Item;

import static util.PrintUtils.*;

public class Ex01SetDemo {

	public static void main(String[] args) {
		
		Set<String> elements = new TreeSet<String>(Comparator.reverseOrder());
		elements.add("A2");
		elements.add("C1");
		elements.add("E7");
		elements.add("B8");
		elements.add("D9");
		elements.add("E7");
		
		generate("1. Elements", elements);
		
		Set<Integer> numbers = Set.of(1, 2, 3, 4);
		generate("2. Number", numbers);
		
		List<Item> items = new ArrayList<>();
		
		items.add(new Item(1, "Item X1", bd("120"), toDate("10/12/2020"), 101));
        items.add(new Item(2, "Item A2", bd("181"), toDate("12/12/2020"), 101));
        items.add(new Item(3, "Item Z3", bd("111"), toDate("14/12/2020"), 101));
        
        System.out.println("A. Item size --> " + items.size());
        
        items.add(new Item(1, "Item X1", bd("120"), toDate("10/12/2020"), 101));
        System.out.println("B. Item size --> " + items.size());
	}
	
	public static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}
	
	public static LocalDate toDate(String dMy) {
		return LocalDate.parse(dMy, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}

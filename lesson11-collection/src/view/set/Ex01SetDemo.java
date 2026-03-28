package view.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import bean.Item;

import static utils.PrintUtils.*;
public class Ex01SetDemo {

	
	 public static void main(String[] args) {

	        Set<String> elements = new TreeSet<>(Comparator.reverseOrder());
	        elements.add("A2");
	        elements.add("C1");
	        elements.add("E7");
	        elements.add("B8");
	        elements.add("D9");
	        elements.add("E7");
	        generate("1. Elements", elements);

	        Set<Integer> numbers = Set.of(1,2,3,4,5);
	        generate("2. Numbers", numbers);

	        Set<Item> items = new HashSet<>();

	        items.add(new Item(1, "Item X1", bd("120"), toDate("10/12/2020"), 101));
	        items.add(new Item(2, "Item A2", bd("181"), toDate("12/12/2022"), 101));
	        items.add(new Item(3, "Item Z3", bd("111"), toDate("14/12/2021"), 101));

	        System.out.println("A. Items Size --> " + items.size());

	        items.add(new Item(1, "Item X1", bd("120"), toDate("10/12/2020"), 101));

	        System.out.println("B. Items Size --> " + items.size());
	    }
}

package view.generic;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import bean.CustomList;
import bean.IList;
import bean.Item;

public class Ex02GenericClassInterface {
	public static void main(String[] args) {
		IList<Item> customList = new CustomList<Item>();
		
		customList.add(new Item(1, "Item X1", bd("120"), toDate("10/12/2020"), 101));
		customList.add(new Item(2, "Item A2", bd("181"), toDate("12/12/2022"), 101));
		customList.add(new Item(3, "Item Z3", bd("111"), toDate("14/12/2021"), 101));
		customList.add(new Item(4, "Item B4", bd("888"), toDate("16/12/2023"), 101));
		customList.add(new Item(51, "Item K2", bd("123"), toDate("16/12/2023"), 105));
		customList.add(new Item(51, "Item K2", bd("123"), toDate("16/12/2023"), 105));
		
		System.out.println("item#size:  " + customList.size());
		System.out.println("item#capacity:  " + customList.capacity());
	}
	
	public static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}

	public static LocalDate toDate(String dMy) {
		return LocalDate.parse(dMy, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}

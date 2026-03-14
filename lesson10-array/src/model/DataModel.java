package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import bean.Item;

public class DataModel {

	private DataModel() {
	}

	public static Item[] mockItem() {
		return new Item[] { new Item(1, "Item X1", bd("120"), toDate("10/12/2020"), 101),
				new Item(2, "Item A2", bd("181"), toDate("12/12/2022"), 101),
				new Item(3, "Item Z3", bd("111"), toDate("14/12/2021"), 101),
				new Item(4, "Item B4", bd("888"), toDate("16/12/2023"), 101),
				new Item(51, "Item K2", bd("123"), toDate("16/12/2023"), 105),
				new Item(52, "Item K1", bd("456"), toDate("16/12/2025"), 105),
				new Item(52, "Item K1", bd("789"), toDate("16/12/2024"), 105),
				new Item(71, "Item T9", bd("777"), toDate("16/12/2024"), 107),
				new Item(73, "Item T8", bd("222"), toDate("16/12/2024"), 107),
				new Item(72, "Item T7", bd("555"), toDate("16/12/2024"), 107) };
	}

	private static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}

	private static LocalDate toDate(String dMy) {
		return LocalDate.parse(dMy, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}

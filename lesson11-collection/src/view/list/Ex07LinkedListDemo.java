package view.list;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import bean.Item;
import utils.PrintUtils;

public class Ex07LinkedListDemo {
	public static void main(String[] args) {
		List<Item> items = new LinkedList<>();
		items.add(new Item(1,"A1", new BigDecimal("100"),LocalDate.now(),101));
		items.add(new Item(2,"A2", new BigDecimal("200"),LocalDate.now(),102));
		items.add(new Item(3,"A3", new BigDecimal("300"),LocalDate.now(),103));
		
		items.sort((item1,item2) -> item1.getSalesPrice().compareTo(item2.getSalesPrice()));
		
//		PrintUtils
	}
}

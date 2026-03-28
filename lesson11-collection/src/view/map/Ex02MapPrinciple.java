package view.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Item;

import static util.PrintUtils.*;

public class Ex02MapPrinciple {

	/**
	 * Bai toan
	 * - Luu DS cac mat hang va DS cua hang se ban mat hang do
	 * 
	 * K: Item
	 * V: List<String>
	 * 
	 * - Co che phat hien key da ton tai trong map chua
	 * - Khi put 1 phan tu moi vao trong map, map kiem tra
	 * - Key da ton tai trong map hay chua thong qua so sanh
	 * 	- hashing value: hashcode (mac dinh la dia chi ma JVM cap phat cho doi tuong)
	 * 	- value: equals (mac inh dung Object#equals so sanh dia chi doi tuong)
	 * 
	 * Thay vi dung dia chi dde xac dinh key da ton tai chua, dung gia tri cua key bang cach
	 * override ham hashcode, equals theo gia tri thuoc tinh cua key
	 * 
	 */
	
	public static void main(String[] args) {
		
		Map<Item, List<String>> items = new HashMap<>();
		
		items.put(new Item(1, "Item 1"), List.of("A1", "A2", "A3"));
		items.put(new Item(2, "Item 2"), List.of("B1", "B2", "B3"));
		items.put(new Item(3, "Item 3"), List.of("C1", "C2", "C3"));
		items.put(new Item(4, "Item 4"), List.of("D1", "D2", "D3"));
		
		System.out.println("items size: " + items.size());
		generate("1. DS cac mat hang va DS cua hang se ban mat hang", items);
	}
	
}

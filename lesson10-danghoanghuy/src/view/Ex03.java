package view;

import java.util.Arrays;

import bean.Item;

public class Ex03 {

	public static void main(String[] args) {
		
		Item[] items = {
	            new Item(1, "A", 25, 101),
	            new Item(2, "B", 90, 102),
	            new Item(3, "C", 88, 102),
	            new Item(4, "D", 40, 101),
	            new Item(5, "E", 60, 102),
	            new Item(6, "F", 18, 101)
	        };
		
		Arrays.sort(items, (item1, item2) -> {
			return item2.getSalesPrice() - item1.getSalesPrice();
	    });
		
		findByStoreId(items, 101);
		findByStoreId(items, 102);
		
	}
	
	private static void findByStoreId(Item[] items, int storeId) {
		for(Item i: items) {
			if(i.getStoreId() == storeId) {
				System.out.println("Mat hang co gia tri cao nhat CH " + i.getStoreId() + " la: " + i.getSalesPrice());
				break;
			}
		}
	}
}

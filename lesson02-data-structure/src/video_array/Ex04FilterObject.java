package video_array;

import java.util.Arrays;

import bean.Item;

public class Ex04FilterObject {
	public static void main(String[] args) {
		Item itemA = new Item(123, 'A', 720);
		Item itemB = new Item(234, 'B', 260);
		Item itemC = new Item(345, 'C', 100);
		Item[] items = { itemA, itemB, itemC };
		Item[] result = salePrices(items);
		
		for(Item item: result) {
			System.out.println(item);
		}
	}
	
	// Tim nhung mat hang co gia > 200
	private static Item[] salePrices(Item[] elements) {
		Item result[] = new Item[elements.length];
		int count = 0;
		
		for(Item element: elements) {
			if(element.salesPrice > 200) {
				result[count] = element;
				count++;
			}
		}
		return Arrays.copyOfRange(result, 0, count);
	}

}

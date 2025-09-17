package structure.array;

import java.util.Arrays;

import bean.Item;

public class Ex04FilterObject {
	public static void main(String[] args) {
		Item itemA = new Item(123, 'a', 720);
		Item itemB = new Item(234, 'b', 260);
		Item itemC = new Item(345, 'c', 100);
		Item[] items = { itemA, itemB, itemC};
		
		Item[] result = getItem(items);
 
		//in ra ptu trong mảng
		for(Item item :  result) {
			System.out.println(item);
		}
			
	}
	private static Item[] getItem(Item[] items) {
		Item[] result = new Item[items.length];
		int count = 0;
		for(Item item : items) {
			if(item.salesPrice >200) {
				result[count] = item;
				count++;
			}
		}
		return Arrays.copyOfRange(result, 0, count);
		
	}
}

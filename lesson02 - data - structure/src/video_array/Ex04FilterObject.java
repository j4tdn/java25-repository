package video_array;

import java.util.Arrays;

import bean.Item;

public class Ex04FilterObject {
	public static void main(String[] args) {
		Item itemA = new Item(234, 'A', 500);
		Item itemB = new Item(345, 'B', 300);
		Item itemC = new Item(456, 'C', 600);
		Item[] items= {itemA, itemB, itemC};
		//for(int i=0; i<items.length;i++) {
		//	if(items[i].salePrice>350) {
		//		System.out.println(items[i]);
		//	}
		//}
		Item[] result = filter(items);
		for(Item item : result) {
			System.out.println(item);
		}
	}
	private static Item[] filter(Item[] items) {
		Item[] result = new Item[items.length];
		int count =0;
		for(Item item : items ) {
			if(item.salePrice>350) {
				
				result[count] = item;
				count++;
			}
		}
		return Arrays.copyOfRange(result, 0, count);
	}
}

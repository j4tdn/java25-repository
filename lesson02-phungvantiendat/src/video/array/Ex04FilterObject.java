package video.array;

import java.util.Arrays;

public class Ex04FilterObject {

	public static void main(String[] args) {
		Item[] items = {
				new Item(123,"Item123",720),
				new Item(234,"Item 234",260),
				new Item(345, "Item 345", 100)
		};
		
		System.out.println(Arrays.toString(filterPrice(items)));
	}
	
	private static Item[] filterPrice(Item[] items) {
		Item[] result = new Item[items.length];
		int cnt = 0;
		for(Item item: items) {
			if(item.price > 200) {
				result[cnt++] = item;
			}
		}
		return Arrays.copyOfRange(result, 0, cnt);
	}

}

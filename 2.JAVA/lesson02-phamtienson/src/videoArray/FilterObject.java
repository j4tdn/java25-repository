package videoArray;

import java.util.Arrays;
import bean.Item;
public class FilterObject {
	public static void main(String[] args) {
			Item itemA = new Item(123, 'A', 720);
			Item itemB = new Item(234, 'B', 260);
			Item itemC = new Item(345, 'C', 100);
			
			Item[] items = { itemA, itemB, itemC, };
			Item[] result = filter(items);
			
			for(Item item: result) {
			System.out.println(item);
		}
	}
		
		//Tìm những mặt hàng có giá tri lớn hơn 200
		private static Item[] filter(Item[] items) {
			Item[] result = new Item[items.length];
			int count = 0;
			for(Item item: items) {
				if(item.salesPrice > 200) {
					result[count] = item;
					count++;
				}
				
			}
			return Arrays.copyOfRange(result, 0, count);
		}
	}
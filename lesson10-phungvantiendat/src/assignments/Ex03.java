package assignments;

import bean.Item;
import static model.DataModel.*;
import static utils.PrintUtils.*;

import java.util.Arrays;


public class Ex03 {

	public static void main(String[] args) {
		Item[] items = mockItem();
		
		Arrays.sort(items, (n1, n2) -> n2.getSalesPrice() - n1.getSalesPrice());
		
		System.out.println("1. Mặt hàng có giá bán cao nhất của cửa hàng 101: " + findByStoreId(items, 101));
		System.out.println("2. Mặt hàng có giá bán cao nhất của cửa hàng 102: " + findByStoreId(items, 102));
		
	}
	
	private static Item findByStoreId(Item[] items,int storeId) {
		for(int i = 0;i<items.length;++i) {
			if(items[i].getStoreId() == storeId) {
				return items[i];
			}
		}
		return null;
	}

}

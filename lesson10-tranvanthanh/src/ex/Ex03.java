package ex;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;

import java.util.Arrays;

import bean.Item;
import bean.Data;

public class Ex03 {
	public static void main(String[] args) {
		Item[] items = Data.getItems();
		maxPriceInStoreId(items);

	}

	private static void maxPriceInStoreId(Item[] items) {
		Arrays.sort(items, comparing(Item::getStoreId).thenComparing(Item::getSalesPrice, reverseOrder()));
		System.out.println("Mặc hàng có giá bán cao nhất tại cửa hàng " + items[0].getStoreId() + " là: " + items[0]);
		int storeId = items[0].getStoreId();
		for (Item item : items) {
			if (item.getStoreId() != storeId) {
				storeId = item.getStoreId();
				System.out.println("Mặc hàng có giá bán cao nhất tại cửa hàng " + storeId + " là: " + item);
			}
		}
	}

}
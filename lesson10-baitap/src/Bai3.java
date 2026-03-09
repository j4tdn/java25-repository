import java.util.*;

class Item {
	int itemId;
	String name;
	int price;
	int storeId;

	public Item(int itemId, String name, int price, int storeId) {
		this.itemId = itemId;
		this.name = name;
		this.price = price;
		this.storeId = storeId;
	}
}

public class Bai3 {
	public static void main(String[] args) {

		List<Item> list = new ArrayList<>();

		list.add(new Item(1, "A", 25, 101));
		list.add(new Item(2, "B", 90, 102));
		list.add(new Item(3, "C", 88, 102));
		list.add(new Item(4, "D", 40, 101));
		list.add(new Item(5, "E", 60, 102));
		list.add(new Item(6, "F", 18, 101));

		Map<Integer, Item> maxItem = new HashMap<>();

		for (Item i : list) {
			if (!maxItem.containsKey(i.storeId) || i.price > maxItem.get(i.storeId).price) {
				maxItem.put(i.storeId, i);
			}
		}

		for (Integer store : maxItem.keySet()) {
			Item i = maxItem.get(store);
			System.out.println("Store " + store + ": " + i.name + " - " + i.price);
		}
	}
}
package datastructure.object;

import bean.Item;

public class Ex04PassVariablesViaMethod {

	public static void main(String[] args) {
		int a1 = 5;

		Item item1 = new Item(1, 'A', 11);
		System.out.println("item1 before: " + item1);
		modify(item1);
		System.out.println("item1 after: " + item1);
	}
	
	// Item item = item1
	private static void modify(Item item) {
		item.name = 'K'; 
	}
	
	private static void update(int src) {
		src = 999;
	}
}

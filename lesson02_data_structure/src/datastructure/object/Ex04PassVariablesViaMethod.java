package datastructure.object;

import bean.Item;

public class Ex04PassVariablesViaMethod {
	
	int a1 = 5;
	System.out.println("a1 before: " + a1);
	update(a1);
	System.out.println("a1 after: " + a1);
	System.out.println("\n");
	// KDL Đối Tương
	Item item1 = new Item(1, 'A', 11);
	System.out.println("item1 before:" + item1);
	modify (item1);
	System.out.println("item1 after: " + item1);
	// Item item = item1;
	private static void modify(Item item) {
	item. name = 'W' ;
	item.salesPrice = 99;
	}
	// int source = a1;
	private static void update(int source) {
	source = 999;
	}
}

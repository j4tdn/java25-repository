package datastructure.object;

import bean.Item;

public class Ex04PassVariablesViaMethod {
	public static void main(String[] args) {

		int a1 = 5;
		System.out.println("a1 before: " + a1);
		update(a1);
		System.out.println("a1 after: " + a1);

		System.out.println("\n");
		// KDL Đối tượng
		Item item1 = new Item(1, 'A', 11);
		System.out.println("item before: " + item1);
		modify(item1);
		System.out.println("item after: " + item1);
		
		System.out.println("\n==============\n");
		
		Item item2 = new Item(2, 'B' ,22);
		System.out.println("item2 before: " + item2);
		change(item2);
		System.out.println("item2 after: " + item2);
	}
	private static void change(Item item) {
		Item itz = new Item(33, 'T', 333);
		item = itz;
		itz.salesPrice = 777;
		Item itw = itz;
		itw. name = '0';
		itw = new Item(6,'V' , 66) ;
		item = itw;
		itz = new Item();	
	}

	// Item item = item1;
	private static void modify(Item item) {
		item.name = 'w';
		item.salesPrice = 99;
	}

	// int source = a1;
	private static void update(int source) {
		source = 999;
	}
}

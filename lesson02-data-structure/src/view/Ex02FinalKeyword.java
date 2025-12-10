package view;

import bean.Item;

public class Ex02FinalKeyword {
	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		a = 8;
		b = a + 20;
		final int c = 20;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		
		final Item item1 = new Item(1, 'A', 22d);
		Item item2 = new Item(2, 'B', 44d);
		
		item1.id =11;
		System.out.println("item1: " + item1);
		System.out.println("item2: " + item2);
		
	}

}

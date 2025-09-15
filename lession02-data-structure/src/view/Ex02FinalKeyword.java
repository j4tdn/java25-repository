package view;

import bean.CustomText;
import bean.Item;

public class Ex02FinalKeyword {
	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		a = 8;
		b = a + 20;
		final int c = 20;
		//c = b;
		
		System.out.println("a: "  +a);
		System.out.println("b: "  +b);
		System.out.println("c: "  +c);
		
		Item item1 = new Item(1, 'A' , 22d);
		Item item2 = new Item(2, 'B' , 44d);
		//cập nhaath tại stack
		item1 = item2;
		item2 = new Item(2,  'Z', 66);
		//cập nhật tại heap
		item1.id = 11;
		System.out.println("item1: " + item1);
		System.out.println("item2: " + item2);
		//Immutable
		String s1 = "Welcome";
		Double d2 = 22.2d;
		
		CustomText ct1 = new CustomText(s1);
		CustomText ct2 = new CustomText("xyz");
		
		System.out.println("ct1 text: " + ct1.getText());
		System.out.println("ct2: " + ct2);
	}
}

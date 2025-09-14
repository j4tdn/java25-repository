package view;

import bean.CustomText;
import bean.Item;

public class Ex02FinalKeyword {
	
	/*
	 * - Mutable: 1 class duoc goi la mutable neu: khi khoi tao doi tuong
	 * tu class - gia tri thuoc tinh tai vung nho heap co the thay doi duoc --> mutable clas
	 * 
	 * - Immutable: 1 class dgl immutable neu: khi khoi tao doi tuong tu class - gia tri cua 
	 * cac thuoc tinh tai vung nho heap khong the thay doi duoc --> immutable class
	 * 
	 * Lam sao de class tro thanh immutable neu: khi khoi tao doi tuong tu class
	 *  gia tri thuoc tinh cua class sau khi khoi tao doi tuong
	 *  # access modifier: private
	 *  # them tu khoa final cac thuoc tinh
	 * */

	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		a = 8;
		b = a + 20;
		final int c = 20;
		
		System.out.println("a: " + a);
		System.out.println("b: "+ b);
		System.out.println("c: "+ c);
		
		final Item item1 = new Item(1,'A', 22d);
		Item item2 = new Item(2,'B',44d);
		
		item2 = new Item(2,'Z',66d);
		
		item1.id = 11;
		System.out.println("item1: "+item1);
		System.out.println("item2: "+item2);

		CustomText ct1 = new CustomText("xyz");
		CustomText ct2 = new CustomText("welcome");
		
		System.out.println("ct1 : " + ct1);
		System.out.println("ct2 text: " + ct2.getText());

	}

}

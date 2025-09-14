package view;

import bean.CustomText;
import bean.Item;

public class Ex02FinalKeyword {
	public static void main(String[] args) {
		/*
		 Bien KDL nguyen thuy
		 - Bien: stack
		 - Gia tri: stack
		 - De cap nhat gia tri
		  --> dung = 
		 
		 Bien KDL doi tuong 
		 - Bien: stack luu tru dia chi cua o nho tai heap ma bien dang tro den
		 - Gia tri: heap
		 - De cap nhat gia tri
		  --> dung = de cap nhat gia tri tai stack
		  --> goi den cac thuoc tinh o heap va cap nhat
		  
		  Tu khoa final
		  - Khi them tu khoaa final vao bien, bien do se tro thanh hang so (stack)
		  	nghia la k the cap nhat gia tri o tai stack
		  - hang so o stack
		  
		  Khai niem mutable, immutable(ap dung cho KDL doi tuong)
		  - Mutable: 1 class dc goi la mutable neu: khi khoi tao doi tuong tu class - gia tri cua cac thuoc tinh tai vung nho heap co the thay doi dc
		  				-->mutable class
		  	VD: Item, Store
		  				
		  - Immutable:1 class dc goi la immutable neu: khi khoi tao doi tuong tu class - gia tri cua cac thuoc tinh tai vung nho heap k the thay doi dc
		  				-->immutable class
		  				
		  	Lam sao de class do thanh immutable(k the thay doi sau khi tao ddoi tuong)
		  	- access moddifier: private
		  	- Them tu khoa final cac thuoc tinh
		  	
		  	VD: Tat ca cac KDL doi tuong co san cua java(Integer, Double, String,...)
		  		Tu tao ra immutable class
		 */
		
		int a = 5;
		int b = 10;
		a = 8;
		b = a + 20;
		final int c = 20;
		//c = b;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		
		final Item item1 = new Item(1, 'A', 22d);
		Item item2 = new Item(2, 'B', 44d);
		
		// Cap nhat tai stack
		//item1 = item2;
		item2 = new Item(2, 'Z', 66);
		
		// Cap nhat tai heap
		item1.id = 11;
		
		System.out.println("Item1: " + item1);
		System.out.println("Item2: " + item2);
		
		// Immutable 
		String s1 = "Welcome";
		Double d2 = 22.2d;
		
		CustomText ct1 = new CustomText(s1);
		CustomText ct2 = new CustomText("xyz");
		
		System.out.println("ct1 text: " + ct1.getText());
		System.out.println("ct2 text: " + ct2);
	}
}

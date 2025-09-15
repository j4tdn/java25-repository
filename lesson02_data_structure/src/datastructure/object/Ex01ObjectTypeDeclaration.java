package datastructure.object;

import bean.Item;

public class Ex01ObjectTypeDeclaration {
	public static void main (String[]args) {
		int number = 22;
		char letter = 'z';
		System.out.println("number"+number);
		System.out.println("letter"+letter);		
		
		// KDL Đối Tương
		Item i1 = null;
		Item i2 = new Item(); // goi hàm khởi tao rồng
		Item i3 = new Item();
		i3.id = 17;
		i3.name = 'W';
		i3.salesPrices = 171;
		System.out.println("i1: " + i1);
		System.out.println("i2: " + i2);
		System.out.println("i3: " + i3);
		System.out.println("i3: " + i3.toString());
		Item i4 = new Item(10, 'A', 250.5);
		System.out.println(i4);
		Item i5 = new Item(11,'G',123);
		System.out.println("i5: "+i5);
		
	}
}

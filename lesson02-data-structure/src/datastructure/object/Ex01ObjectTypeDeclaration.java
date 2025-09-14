package datastructure.object;

import bean.Item;

public class Ex01ObjectTypeDeclaration {
	public static void main(String[] args) {
		int number = 22;
		char letter = 'Z';
		System.out.println("number: "+ number);
		System.out.println("lettter: " + letter);
		
		System.out.println("\n\n");
		
		Item i1 = null;
		Item i2 = new Item();
		Item i3 = new Item();
		i3.id = 17;
		i3.name = 'W';
		i3.salesPrice = 171;
		
		Item i4 = new Item(22,'T',222);
		Item i5 = new Item(44,'R',123);
		
		System.out.println("i1: "+ i1);
		System.out.println("i2: "+ i2);
		System.out.println("i3: "+ i3);
		System.out.println("i4: "+ i4);
		System.out.println("i5: "+ i5);
	}
}

package datastructure.object;

import bean.Item;

public class Ex01ObjectTypeDeclaration {
	public static void main(String[] args) {

		// KDL Nguyên thủy
		int number = 22;
		char letter = 'Z';
		System.out.println("number: " + number);
		System.out.println("letter: " + letter);

		System.out.println("\n\n");

		// KDL Doi tuong
		Item i1 = null;
		Item i2 = new Item();// goi ham khoi tao rong
		Item i3 = new Item();
		i3.id = 17;
		i3.name = 'W';
		i3.salesPrice = 171;
		
		System.out.println("i1: " + i1);
		System.out.println("i2: " + i2);
		
		System.out.println("i3: " + i3);
		System.out.println("i3: " + i3.toString());
		
	}
}
package datastructure.object;

import bean.Item;

public class Ex01ObjectTypeDeclaration {
	
	// KDL nguyen thuy
	
	public static void main(String[] args) {
		
		
		int number = 22;
		char letter = 'Z';
		System.out.println("number: " + number);
		System.out.println("letter: " + letter);
		
		System.out.println("\n\n");
		
		// KDL doi tuong
		
		Item i1 = null;
		Item i2 = new Item();
		
		Item i3 = new Item(3, 'A', 2d);
		
		System.out.println(i2);
		
		
	}
	
	

}

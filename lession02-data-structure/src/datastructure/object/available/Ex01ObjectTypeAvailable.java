package datastructure.object.available;

import bean.Item;

public class Ex01ObjectTypeAvailable {

	
	
	public static void main(String[] args) {
		int a1 = 5;
		char a2 = 'A';
		System.out.printf("a1(%s) a2(%s)", a1 , a2);
		
		System.out.println("\n");
		
		Integer b1 = new Integer(7);
		String b2 = new String("Xchao");
		
		System.out.printf("b1(%s) b2(%s)", b1 , b2);
		
		System.out.println("\n");
		
		Integer c1 = 22;
		String c2 = "TBiet";
		System.out.printf("c1(%s) c2(%s)", c1 , c2);
		
		Item item1 = new Item(1, 'A' , 11);
		//Item item2 = 2 'B' 22;
		
	}
}

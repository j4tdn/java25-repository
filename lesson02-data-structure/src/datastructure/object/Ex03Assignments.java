package datastructure.object;

import bean.Item;

public class Ex03Assignments {
	public static void main(String[] args) {
		
		// De cap nhat gia tri cho bien la:
		/*
		 * - KDL nguyen thuy
		 * 		--> Gia tri luu o STACK
		 * 		--> Thong qua toan tu gan "=" --> Copy cap nhat gia tri tai vung nho "STACK"
		 * 
		 * - KDL doi tuong 
		 * --> Gia tri that su cua doi tuong luu o HEAP
		 * --> Gia tri cua bien 
		 * 
		 * Bien la KDL doi tuong hhay nguyen thuy --> luon nam o STACK
		 */
		
		// KDL nguyen thuy
		int a1 = 10;
		int a2 = 20;
		int a3 = 30;
		
		a2 = a1;
		a3 = a2;
		a1 = 60;
		a3 = a1;
		
		System.out.println("a1 --> " + a1);
		System.out.println("a2 --> " + a2);
		System.out.println("a3 --> " + a3);
		
		System.out.println("\n\n");
		
		Item i1 = new Item(1, 'A', 11d);
		Item i2 = new Item(2, 'B', 22d);
		Item i3 = new Item(3, 'C', 33d);
		
		System.out.println("\n\n");
		
		System.out.println("i1: " + i1);
		System.out.println("i2: " + i2);
		System.out.println("i3: " + i3);
		
		// Cap nhat salesPrice cua i2 thanh 44
		i2.salesPrice = 44;
		System.out.println("i2:" + i2);
		
		System.out.println("\n\n");
		
		i1 = i3; // Cap mhat gia tri tai vung nho STACK
		i1.salesPrice = 99;
		
		i2 = new Item();
		
		System.out.println("i1: " + i1);
		System.out.println("i2: " + i2);
		System.out.println("i3: " + i3);
	}
}

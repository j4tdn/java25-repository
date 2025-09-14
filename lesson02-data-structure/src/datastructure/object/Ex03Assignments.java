package datastructure.object;

import bean.Item;

public class Ex03Assignments {

	public static void main(String[] args) {

		Item i1 = new Item(1,'A',11);
		Item i2 = new Item(2,'B',22);
		Item i3 = new Item(3,'C',33);
		
		System.out.println("i1 --> "+i1);
		System.out.println("i2 --> "+i2);
		System.out.println("i3 --> "+i3);
		
		// Cap nhat salesPrice cua i2 thanh 44
		i2.salesPrice = 44;// Cap nhat gia tri tai vung nho HEAP
		System.out.println("i2 --> "+i2);
		
		i1 = i3;
		System.out.println("i1 --> "+i1);
		System.out.println("i2 --> "+i2);
		System.out.println("i3 --> "+i3);
		
		System.out.println("i1 code: "+System.identityHashCode(i1));
		System.out.println("i2 code: "+System.identityHashCode(i2));
		System.out.println("i3 code: "+System.identityHashCode(i3));
	}

}

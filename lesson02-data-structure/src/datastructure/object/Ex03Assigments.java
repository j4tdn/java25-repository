package datastructure.object;

import bean.Item;

public class Ex03Assigments {
	public static void main(String[] args) {
		
		//Biến dù là KDl là nguyên thủy hay đối tượng là đều lưu ở Stack
		
		// Cập nhập gtri là kiểu nguyên thủy
		// Gtri lưu trữ ở Stack
		int a1 =10;
		int a2 = 20;
		int a3 = 30;
		
		a2 = a1;
		a3 = a2;
		a1 = 60;
		a3 = a1;
		System.out.println("a1: " + a1);
		System.out.println("a2: " + a2);
		System.out.println("a3: " + a3);
		
		
		//Cập nhập gtri là kiểu đối tượng
		// Gtri thật sự của đối tượng lưu trữ ở HEAP
		// Gtri của biến ở vùng nhớ STack là địa chỉ của ô nhớ HEAP mà nó đang trỏ đến
		
		System.out.println("\n\n");
		
		Item i1 = new Item(1, 'A', 11d);
		Item i2 = new Item(2, 'B', 22d);
		Item i3 = new Item(3, 'C', 33d);
				
		System.out.println("i1: " + i1);
		System.out.println("i2: " + i2);
		System.out.println("i3: " + i3);
		
		System.out.println("\n\n");
		i2.salesPrice =44;
		System.out.println("i2: " + i2);
		System.out.println("\n\n");
		
		i1 =i3;
		i1.salesPrice =99; 
		 
		i2 = new Item(); 
		
		System.out.println("i1: " + i1);
		System.out.println("i2: " + i2);
		System.out.println("i3: " + i3);
		
		System.out.println("i1 code: " + System.identityHashCode(i1));
		System.out.println("i2 code: " + System.identityHashCode(i2));
		System.out.println("i3 code: " + System.identityHashCode(i3));
		
		
		
		
	}
}

package datastructure.object;

import bean.Item;

public class Ex03Assignments {
	public static void main(String[] args) {

		Item i1 = new Item(1, 'A', 11d);
		Item i2 = new Item(2, 'B', 22d);
		Item i3 = new Item(3, 'C', 33d);
		System.out.println("Địa chỉ của i1: " + System.identityHashCode(i1));
		System.out.println("Địa chỉ của i2: " + System.identityHashCode(i2));
		System.out.println("Địa chỉ của i3: " + System.identityHashCode(i3));
		i1 = i3;
		i3.salesPrice = 333;

		System.out.println("i1 --> " + i1);
		System.out.println("i2 --> " + i2);
		System.out.println("i3 --> " + i3);

		System.out.println("\n\n");

		// Cập nhật salesPrice của i2 thành 44
		// cập nhật giá trị tại vùng nhớ HEAP
		System.out.println("i2 --> " + i2);

		System.out.println("\n\n");
//in ra địa chỉ của biến đối tượng

		System.out.println("i1 --> " + i1);
		System.out.println("i2 --> " + i2);
		System.out.println("i3 --> " + i3);
		System.out.println("Cuối cùng");
		System.out.println("Địa chỉ của i1: " + System.identityHashCode(i1));
		System.out.println("Địa chỉ của i2: " + System.identityHashCode(i2));
		System.out.println("Địa chỉ của i3: " + System.identityHashCode(i3));

	}
}

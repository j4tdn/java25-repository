package datastructure.object;

import bean.Item;

public class Ex04PassVariablesViaMethod {
	
	public static void main(String[] args) {
		
		// Truyền tham số qua hàm
		// Nếu tham số là KDL nguyên thủy thì 100% khi ra khỏi hàm biến truyền vào ban đầu không thay đổi giá trị
		
		
		// KDL Nguyên Thủy
		// Nếu tham số là KDL đối tượng thì có thể cập nhật giá trị của biến đó khi ra khỏi hàm --> cập nhật giá trị tại HEAP
		
		// Khi truyền tham số qua hàm, ra khỏi hàm biến truyền vào cập nhật được giá trị, có 2 yêu cầu
		// - biến KDL đối tượng
		// - [cho phép] cập nhật giá trị của các thuộc tính tại heap
		
		// Có 2 cách để cập nhật giá trị của 1 biến đối tượng
		// - dùng toán tử = để cập nhật địa chỉ tại stack
		// - gọi và cập nhật thuộc tính của ô nhớ tại heap mà biến đó đang trỏ đến
		
		
		int a1 = 5;
		System.out.println("a1 before: " + a1);
		update(a1);
		System.out.println("a1 after: " + a1);
		
		System.out.println("\n===========\n");
		
		// KDL Đối Tượng
		Item item1 = new Item(1, 'A', 11);
		System.out.println("item1 before: " + item1);
		modify(item1);
		System.out.println("item1 after: " + item1);
		
		System.out.println("\n===========\n");
		
		Item item2 = new Item(2, 'B', 22);
		System.out.println("item2 before: " + item2); // 2 B 22
		change(item2);
		System.out.println("item2 before: " + item2); // 2 B 22
		
	}
	
	private static void change(Item item) {
		Item itz = new Item(33, 'T', 333);
		item = itz;
		itz.salesPrice = 777;
		Item itw = itz;
		itw.name = 'O';
		itw = new Item(6, 'V', 66);
		item = itw;
		itz = new Item();
	}
	
	// Item item = item1;
	private static void modify(Item item) {
		item.name = 'W';
		item.salesPrice = 99;
	}
	
	// int source = a1;
	private static void update(int source) {
		source = 999;
	}
	
	

}

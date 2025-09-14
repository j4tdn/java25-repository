package datastructure.object;

import bean.Item;

public class Ex04PassVariablesViaMethod {
	public static void main(String[] args) {
		
		// truyền tham số qua hàm
		// nếu tham sô là KDL nguyên thủy thì 100% khi ra khỏi hàm biến truyền vào ban đầu ko thay đổi giá trị
		
		
		// KDL nguyên thủy
		// nếu tham số là KDL đối tượng thì có thể cập nhạt giá trị của biến đó khi ra khỏi hàm --> cập nhật giá trị tại HEAP
		// khi truyền tham số qua hàm, ra khỏi hàm biến truyền vào cập nhât được giá trị, có 2 yêu cầu
		// - biến KDL đối tượng
		// - cho phép cập nhậ t giá trị của các thuộc tính tại HEAP
		
		// có 2 cách để cập nhật giá trị của 1 biến đối tượng
		// - dùng toán tử = để cập nhật địa chỉ tại stack
		// - gọi và cập nhật thuộc tính của ô nhớ tại HEAP mà biến đó đang trỏ đến
		
		
		int a1 = 5;
		System.out.println("a1 before:" + a1);
		update(a1);
		System.out.println("a1 after:" + a1);
		
		System.out.println("\n\n");
		
		// KDL đối tượng
		Item item1  = new Item(1, 'A', 11);
		System.out.println("item1 before:" + item1);
		modify(item1);
		System.out.println("item1 after:" + item1);
		
		Item item2 = new Item(2, 'B', 22);
		
		item2.name = 'C';
		System.out.println("item2 :" + item2);
	}
	
	
	
	// Item item = item1
	private static void modify(Item item) {
		item.name = 'W';
		item.salesPrice = 99;
	}
	
	// int source = a1
	private static void update(int source) {
		source = 999;
		
	}

}

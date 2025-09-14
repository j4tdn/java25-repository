package datastructure.object;

import bean.Item;

public class Ex04PassVariablesViaMethod {

	public static void main(String[] args) {
		
		// Tuyền tham số qua hàm
		// Nếu tham số là KDL nguyên thủy thì 100% khi ra khỏi
		// 	hàm biến truy cập vào ban đầu ko thay đổi giá trị
		
		// KDL nguyên thủy
		// Nếu tham số truyền vào là KDL đối tượng thì có thể cập nhật giá trị
		// 	của biến đó khi ra khỏi hàm --> cập nhật giá trị ở HEAP
		
		// Khi truyền tham số qua hàm, ra khỏi hàm biến truyền vào cập nhật
		// 	được giá trị, có 2 yêu cầu:
		//	- biến KDL đối tượng
		//	- cho phép cập nhật các giá trị thuộc tính tại HEAP
		
		// Có 2 cách để cập nhật giá trị của 1 biến đối tượng
		// 	- dùng toán tử = để cập nhật địa chỉ tại STACK
		// 	- gọi và update thuộc tính của ô nhớ tại HEAP và biến đó đang trỏ đến
		
		int a1 = 5;
		System.out.println("a1 before: " + a1);
		update(a1);
		System.out.println("a1 after: " + a1);
		
		// KDL đối tượng
		Item item1 = new Item(1, 'A', 11); 
		System.out.println("item1 before: " + item1);
		modify(item1);
		System.out.println("item1 after: " + item1);
		
	}
	
	// Item item = item1;
	public static void modify(Item item) {
		item.name = 'W';
		item.salesPrice = 99;
	}
	
	// int source = a1;
	public static void update(int source) {
		source = 999;
	}
	
}

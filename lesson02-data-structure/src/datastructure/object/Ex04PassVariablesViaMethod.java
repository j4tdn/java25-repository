package datastructure.object;

import bean.Item;

public class Ex04PassVariablesViaMethod {
	// Truyền tham số qua hàm
	// Nếu tham số là KDL nguyên thủy thì 100% khi ra khỏi hàm biến truyền vào ban
	// đầu không thay đổi giá trị

	// KDL Nguyên Thủy
	// Nếu tham số là KDL đối tượng thì có thể cập nhật giá trị của biến đó khi ra
	// khỏi hàm --> cập nhật giá trị tại HEAP

	// Khi truyền tham số qua hàm, ra khỏi hàm biến truyền vào cập nhật được giá
	// trị, có 2 yêu cầu
	// - biến KDL đối tượng
	// - cho phép cập nhật giá trị của các thuộc tính tại heap

	// Có 2 cách để cập nhật giá trị của 1 biến đối tượng
	// - dùng toán tử = để cập nhật địa chỉ tại stack
	// - gán và cập nhật thuộc tính của ô nhớ tại heap mà biến đó đang trỏ đến

	public static void main(String[] args) {
		int a1 = 5;
		System.out.println("a1 before: " + a1);
		int a2 = update(a1);
		System.out.println("a1 after: " + a1);
		System.out.println("a1 after: " + a2);
		System.out.printf("\n");

		// Kdl Đối Tượng
		Item item1 = new Item(1, 'a', 200);
		System.out.println(item1);
		modify(item1);
		System.out.println("Item 1 sau khi modify: " + item1);
		Item item2 = item1;
		change(item2);
		System.out.println("item 2 sau khi change: " + item2);
	}

	private static void modify(Item item) {
		item.id = 10;
		item.name = 'B';
	}

	private static void change(Item item) {
		Item itz = new Item(33, 'T', 333);
		item = itz;
		itz.salesPrice = 777;
		item.salesPrice = 888;
		Item itw = itz;
		itw.name = 'o';
		itw = new Item(6, 'V', 66);
		item = itw;
		itz = new Item();

	}

	private static int update(int source) {
		source = 999;
		return source;
	}

}

package datastructure.object;

import bean.Item;

public class Ex04PassVariablesViaMethod {
	public static void main(String[] args) {
		
		// Truyền tham số qua hàm
		// Nếu tham số là KDL nguyen thủy thì 100% khi ra khỏi hàm biến truyền vào ban đầu không thay đổi gtri
		
		// KDL Nguyên thủy
		//Nếu truyền tham số là KDL đối tượng thì có thể cập nhập gtri của biến đó khi ra khỏi hàm --> cập nhập gtri tại heap
		
		
		//Khi trueyefn tham số qua hàm, ra khỏi hàm biến truyền vào cập nhập điocjw gtri, cs 2 yêu cầu
		//-Biến KDL đối tượng
		//-cho phép cập nhập gtri của các thuộc tính tại heap
		
		//có 2 cách để cập nhập gtri của biến đối tượng
		//-dùng toán tử = để cập nhập địa chỉ tại stack
		//-gọi và cập nhập thuộc tính cuả ô nhớ tại heap mà biến đó đang trỏ đến 
		
		int a1 = 5;
		System.out.println("a1 before: " + a1);
		update(a1);
		System.out.println("a1 after: " + a1);
		
		System.out.println("\n\n");
		
		
		// KDL đối tượng
		Item item1 = new Item(1, 'A', 11);
		System.out.println("Item1 befor: " + item1);
		modify(item1);
		System.out.println("Item1 after: " + item1);
		
		Item item2 = new Item(2, 'B', 22);
		System.out.println("Item2 befor: " + item2);
		change(item2);
		System.out.println("Item2 after: " + item2);
		
		
	}
	
	private static void change(Item item) {
		Item itz = new Item(33, 'T', 333);
		item = itz;
		itz.salesPrice = 77;
		Item itw = itz;
		itw.name ='o';
		itw =new Item(6, 'V', 66);
		item = itw;
		itz = new Item();
	}
	//Item item = item1
	private static void modify(Item item) {
		
		
		item.name = 'w';
		item.salesPrice = 99;
		
	}
	
	
	private static void update(int source) {
		source = 999;
		
	}
}

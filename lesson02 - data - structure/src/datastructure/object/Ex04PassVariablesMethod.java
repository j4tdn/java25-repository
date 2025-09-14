package datastructure.object;
import bean.Item;
public class Ex04PassVariablesMethod {

	public static void main(String[] args) {

		// Truyền tham số qua hàm 
		// Nếu tham số là KDL nguyên thủy thì 100% khi ra khỏi hàm biến truyền vào ban đầu ko thay đổi value
		
		// KDL Nguyên Thủy
		// Nếu tham số là KDL đối tượng thì có thể update value của biến đó khi ra khỏi hàm --> update value tại HEAP
		// có 2 cách để update value của 1 biến đối tượng:
		//  - dùng toán tử = để update địa chỉ tại STACK
		//  - gọi và update thuộc tính của ô nhớ tại HEAP mà biến đó đang trỏ đến
		int a1 = 5;
		System.out.println("a1 before: "+a1);
		
		 update(a1);
		System.out.println("a1 after: "+a1);
		// KDL Đối Tượng
		Item item1= new Item(1,'A', 11);
		 modify(item1);
		System.out.println("item1: "+item1);
		
	
	}
	
	
	// Item item = item1
	private static void modify(Item item) {
		item.name='W';
		item.salePrice=99;
		
	}
	// int source =a1
	private static void update(int source) {
		 source = 999;
	}
}

package view;

import bean.CustomTest;
import bean.Item;

public class Ex02FinalKeyword {
	public static void main(String[] args) {
		/*
		 * Biến KDL nguyên thủy 
		 * -Biến: Stack 
		 * -Gtri: Stack; 
		 * -Để cập gtri của biến nguyên thủy
		 *  --> dùng toán tử =
		 * 
		 * Biến KDL đối tượng 
		 * -Biến: stack lưu trữ địa chỉ của ô nhớ tại heap mà biến
		 * đang trỏ dến 
		 * -Gtri: heap -Để cập gtri của biến đối tượng 
		 * -->dùng toán tử = để cap nhập gtri(địa chỉ) tại stack
		 *
		 * -->gọi đến các thuộc tính ở heap và cập nhập\
		 * 
		 * 
		 * Từ khóa final 
		 * - khi thêm từ khóa final vào biến, biến đó trở thành hằng
		 * số(stack) nghĩa là không thể cập nhập gtri của ô nhớ đó tại stack 
		 * - Hằng ở stack
		 * 
		 * Khái niệm mutable, immutable (áp dụng cho KDL đối tượng)
		 * -Mutable: 1 class được gọi là mutable nếu: khi khởi tạo đối tượng từ class 
		 * giá trị của các thuộc tính tại vùng nhớ heap có thể thay đổi được --> mutable class
		 * vd: Item, store
		 *
		 * -Immutable: 1 class được gọi là immutable nếu: khi khởi tạo đối tượng từ class - giá trị của các 
		 * thuộc tỉnh tại vùng nhớ heap không thể thay đổi được --> mutable class
		 * 
		 * 
		 */
		int a = 5;
		int b = 10;
		a = 8;
		b = a + 20;
		final int c = 20;
		//c = b;
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
		
		Item item1 = new Item(1, 'a', 22d);
		Item item2 = new Item(2, 'b', 44d);
		
		//cập nhâpj tại stack
		item1 = item2;
		item2 = new Item(2, 'z', 66);
		
		//cập nhập tại heap
		item1.id = 11;
		
		System.out.println("item1: " + item1);
		System.out.println("item2: " + item2);
		
		String s1 = "welcome";
		Double d2 = 22.2d;
		
		
		CustomTest ct1 = new CustomTest(s1);
		CustomTest ct2 = new CustomTest("xyz");
		
		System.out.println("Ct1 text: " + ct1.getText());
		System.out.println("Ct2 text: " + ct2);
	}
}

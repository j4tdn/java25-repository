package view;

import bean.CustomText;
import bean.Item;

public class Ex02FinalKeyword {
	
	public static void main(String[] args) {
		/*
		 
		  	Toán tử = luôn hoạt động ở STACK
		 
			Biến KDL nguyên thủy:
			- biến: STACK
			- giá trị: STACK
			- để cập nhật giá trị của biến nguyên thủy: 
				--> dùng toán tử =
			
			Biến KDL đối tượng:
			- biến: STACK lưu trữ địa chỉ của ô nhớ tại HEAP mà biến đang trỏ đến
			- giá trị: HEAP
			- để cập nhật giá trị của biến đối tượng:
				--> dùng toán tử = để cập nhật giá trị(địa chỉ) tại STACK
				--> gọi đến các thuộc tính ở HEAP và cập nhật
				
			Từ khóa FINAL
			- Khi thêm từ khóa FINAL vào biến, biến đó sẽ trở thành hằng số(STACK) nghĩa
			  là kh thể cập nhật giá trị của ô nhớ đó tại STACK
			- FINAL ở STACK
			
			Khái niệm mutable, immutable(áp dụng cho KDL đối tượng);
			- Mutable: 1 class được gọi là mutalbe nếu: khi mà khởi tạo đối tượng từ class - 
			giá trị của các thuộc tính tại vùng nhớ HEAP có thể thay đổi được --> mutable class
			
			Làm sao để class thành immutable(làm sao để thuộc tính của class đó kh thể thay đổi
			sau khi tạo object)
			# access modifier: private
			# thêm từ khóa final các thuộc tính
			
			VD: tất cả KDL đối tượng có sẵn của JAVA(Integer, Double, String)
				tự tạo ra immutable class
		 
		 */
		
		int a = 5;
		int b = 10;
		a = 8;
		b = a + 20;
		final int c = 20;
		// c = b;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		
		final Item item1 = new Item(1,'A',22d);
		Item item2 = new Item(2,'B',44d);
		// cập nhật tại STACK
		// item1 = item2;
		item2 = new Item(2,'Z',66);
		
		// cập nhật tại HEAP
		item1.id = 11;
		System.out.println("item1: " + item1);
		System.out.println("item2: " + item2);
		
		// Immutable
		String s1 = "welcome";
		Double d2 = 22.2d;
		
		CustomText ct1 = new CustomText(s1);
		CustomText ct2 = new CustomText("xyz");
		
		System.out.println("ct1 text: " + ct1.getText());
		System.out.println("ct2 text: " + ct2.getText());
	}
	
}

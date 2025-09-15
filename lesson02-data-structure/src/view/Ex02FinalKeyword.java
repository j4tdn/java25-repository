package view;

import bean.Item;

public class Ex02FinalKeyword {
public static void main(String[] args) {
		/*
		 Biến KDL nguyên thủy
		 - biến: Stack
		 -Giá trị: STACK
		 -để cập nhật giá trị của biến nguyên thủy: dung toán tử =
		 
		 Biến KDL đối tượng
		 -BIến: STACk lưu trữ địa chỉ của ô nhớ tại HEAP mà biến đang trỏ đến
		 -GIá trị: HEAP
		 -Để cập nhật giá trị của biến đối tượng\
		 --> dùng toán tử = để cập nhật giá trị (địa chỉ) tại STACK
		 --> Gọi đến các thuộc tính (nếu cho phép) ở HEAP và cập nhật
		 
		 Từ khóa final
		 -khi thêm từ khóa final vào cho biến, biến đó trở thành hằng số(stack) nghĩa là không thể cập nhật giá trị ô nhớ đó tại stack
		 -hằng số ở STACK
		 
		 Khái niệm mutable, immutable(áp dụng cho KDL đối tượng)
		 -Mutable: 1 class được gọi là mutable nếu: khi khởi tạo đối tượng từ class - giá trị của các thuộc tính tại vùng nhớ HEAP có thể thay đổi được --> mutable class
		 VD: Item, Store
		 
		 Immutable: 1 class được gọi là immutable nếu: khi khởi tạo đối tượng từ class - giá trị của các thuộc tính tại vùng nhớ HEAP không thể thay đổi được --> immutable class
		 
		 Làm sao để class trở thành immutable( làm sao để thuộc tính của class không thể thay đổi sau khi tạo đối tượng
		 # access modifier: private
		 # thêm từ khóa final các thuộc tính
		 
		 VD: Tất cả các KDL đối tượng có sẵn của Java(Integer, Double, String...)
			Tự tạo ra immutable class
		 
		 
		 */
	int a = 5;
	int b = 10;
	a = 8;
	b = a + 20;
	final int c =20;
	// c = b;
	
	System.out.println("a: "+ a);
	System.out.println("b: "+ b);
	System.out.println("c: "+ c);
	
	final Item item1 = new Item(1, "A", 22d);
	Item item2 = new Item(2, "B",44d);
	//Cập nhật tại STACK
	//item1 = item2;
	item2 = new Item(2, "Z", 66);
	
	//Cập nhật tại HEAP
	item1.id = 11;
	System.out.println("item1: "+item1);
	System.out.println("item2: "+item2);
	
	//immutable
	String s1 = "welcome";
	Double d2 = 22.d;
	
//	CustomText ct1 = new CustomText(s1);
//	CustomText ct2 = new CustomText("xyz");
//	
//	System.out.println("ct1 text: " + ct1.getText());
//	System.out.println("ct2: "+ ct2);
	
	
	}
}

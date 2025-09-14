package view;


import bean.CustomText;
import bean.Item;
public class Ex02FinalKeyword {

	public static void main(String[] args) {
		
		/*
		 * Biến KDL nguyên thủy
		 * - biến: Stack
		 * - giá trị: Stack
		 * - để cập nhật giá trị của biến nguyên thủy:
		 *  --> dùng toán tử '='
		 * 
		 * Biến KDL đối tượng
		 * - biến: Stack lưu trữ địa chỉ của ô nhớ tại heap mà biến đang trỏ đến
		 * - giá trị: Heap
		 * - để cập nhật giá trị của biến đối tượng
		 *  --> dùng toán tử '=' để cập nhật giá trị (địa chỉ) tại Stack
		 *  --> gọi đến các thuộc tính ở Heap và cập nhật 
		 *  
		 *  Từ khóa 'final' 
		 *  - khi thêm từ khóa final vào cho biến, biến đó trở thành hằng số(Stack) nghĩa là
		 *  mình k thể update giá trị của ô nhớ đó tại Stack
		 *  - 'final' ở Stack
		 *  
		 *  Khái niệm mutable, immutable(áp dụng cho KDL đối tượng)
		 *  - Mutable: 1 class được gọi là Mutable nếu: 
		 *  	+ Khi khởi tạo đối tượng từ class từ class: giá trị của các thuộc tính tại vùng nhớ
		 *  HEAP có thể thay đổi được --> mutable class
		 *  - Immutable: 1 class được gọi là Immutable nếu: 
		 *  	+ Khi khởi tạo đối tượng từ class từ class: giá trị của các thuộc tính tại vùng nhớ
		 *  HEAP không thể thay đổi được --> Immutable class
		 *   Làm sao để Class trở thành Immutable (làm sao để thuộc tính của class không thể thay đổi
		 *   sau khi tạo đối tượng
		 *   
		 *  # access modifier(phạm vi truy cập): private
		 *  # thêm từ khóa final các thuộc tính
		 *  
		 *  VD: 
		 *  
		 */
		
		int a = 5;
		int b = 10;
		a=8;
		b= a+20;
		final int c=20;
		//c=b;
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		
		Item item1 = new Item(1,'A',22d);
		Item item2 = new Item(2,'B',44d);
		
		//cập nhật tại Stack
		item1= item2;
		item2 = new Item(2,'Z',66);
		
		//cập nhật tại HEAP
		item1.id=11;
		System.out.println("item1: " +item1);
		System.out.println("item1: " +item2);
		
		// Immutable
		String s1 ="Welcome";
		Double d2= 22.2d;
		CustomText ct1 = new CustomText(s1);
		CustomText ct2 = new CustomText("xyz");
		
		System.out.println("ct1 text: "+ ct1.getText());
		System.out.println("ct2: "+ct2);
	}
	
}

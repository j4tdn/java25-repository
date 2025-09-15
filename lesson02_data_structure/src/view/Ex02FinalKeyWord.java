package view;

import bean.CustomText;
import bean.Item;

public class Ex02FinalKeyWord {
	public static void main(String[] args) {
	int a = 5;
	int b = 10;
	a = 8;
	b = a + 20;
	final int c = 20;
	// c = b;
	System.out.println("a: " + a);
	System.out.println("b:" + b);
	System.out.println("c: " + c);
	final Item item1 = new Item(1,'A',22d) ;
	Item item2 = new Item(2,'B',44d);
	// cập nhật tại stack
	// item = item2;
	item2 = new Item(2, 'Z', 66);
	// cập nhật tai heap
	item1.id = 11;
	System.out.println("item1: " + item1);
	System.out.println("item1: " + item1) ;
	String s1 = "welcome";
	double d2 = 22d;
	CustomText ct1 = new CustomText(s1);
	CustomText ct2 = new CustomText("xyz");
	System.out.println("ct1 text "+ct1.getText());
	System.out.println("ct2: "+ct2);
}
	/*
	 * Biến kdl nguyên thuỷ 
	 -Biến :stack
	 - Giá trị : Stack 
	 - Để cập nhật giá trị ở biến nguyên thuỷ thì dùng toán tử bằng 
	 *Biến kdl đói tượng
	 Biến KDL đối tương
     - biến: stack lưu trữ đia chỉ của ô nhớ tai heap mà biến đang trỏ đến
     - giá tri: heap
     - để cập nhật giá tri của biến đối tương
     --> dùng toán tứ = đề cập nhât giá trị (địa ghi) tạt stackg
     --> gọi đến các thuộc tính ở heap và cập nhậ
     *Từ khoá Final 
     -Khi thêm từ khoá final thì biến đó trở thành hằng số nghĩa là không thể cập nhật tại ô nhớ stack 
     -Final ở stack 
     *Mutable và imutable
     -
	 */
	
	
}

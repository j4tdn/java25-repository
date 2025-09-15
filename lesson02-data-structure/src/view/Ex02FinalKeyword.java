package view;

import bean.CustomText;
import bean.Item;

public class Ex02FinalKeyword {
	public static void main(String[] args) {
		/*
		 * Biến KDL Nguyên Thủy -Biến: Stack. -Giá trị: Stack. để cập nhật giá trị của
		 * biến thì dùng toán tử '='
		 * 
		 * Biến KDL đối tượng biến : Stack lưu trữ địa chỉ ô nhớ HEAP mà biến đang trỏ
		 * đến giá trị: HEAP -để cập nhật giá trị của biến đối tượng -> dùng toán tử '='
		 * để cập nhật giá trị(địa chỉ) tại stack Person p1=new Person(1),Person p2=new
		 * Person(2), p1=p2 -> gọi đến các thuộc tính ở HEAP và cập nhật Khi thêm final
		 * vào cho biến, biến đó trở thành hằng số (ở Stack) nghĩa là không thể cập nhật
		 * giá trị của ô nhớ đó tại Stack Một đối tượng ở vùng nhớ HEAP không cập nhật
		 * được các giá trị bên trong đối tượng đó gọi là Immutable object
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

		final Item item1 = new Item(1, 'A', 22d);
		Item item2 = new Item(2, 'B', 44d);

		// cập nhật tại stack không được, sẽ xảy ra lỗi
		// item1 = item2;
		item2 = new Item(2, 'Z', 66);

		// cập nhật tại heap
		item1.id = 11;
		System.out.println("item1: " + item1);
		System.out.println("item2: " + item2);

		// Immutable
		String s1 = "welcome";
		// Double d2 = 22.2d;

		CustomText ct1 = new CustomText(s1);
		CustomText ct2 = new CustomText("xyz");

		System.out.println("ct1 text: " + ct1.getText());
		System.out.println("ct2: " + ct2);
	}

}

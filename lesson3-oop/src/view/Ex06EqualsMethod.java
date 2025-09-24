package view;

import bean.Car;

public class Ex06EqualsMethod {

	public static void main(String[] args) {
		/*
		Lý thuyết

		Biến KDL nguyên thủy
		- Stack: giá trị thực tế

		Biến KDL đối tượng
		- Stack: địa chỉ của ô nhớ tại HEAP mà nó đang trỏ đến
		- Heap: giá trị thực tế của đối tượng

		Để so sánh giá trị của 2 biến có bằng, giống nhau không --> thường sử dụng toán tử ==

		Toán tử == (so sánh giá trị của biến ở stack)

		Như vậy

		Dùng toán tử == để so sánh 2 biến nguyên thủy --> so sánh giá trị --> OK

		Dùng toán tử == để so sánh 2 biến đối tượng --> so sánh địa chỉ (so xem 2 biến này có đang trỏ đến cùng 1 địa chỉ hay không)

		--> Muốn so sánh giá trị của 2 biến đối tượng ?
		--> Đối tượng có thể có 1 hoặc N thuộc tính, khi so sánh cần đặt câu hỏi 2 đối tượng đó ntn là bằng nhau
		
		Su dung ham equals
	 	- tu class Object, mac dinh ham equals co body cung la so sanh dia chi cua 2 bien doi tuong
	 	- khong dung ham equals mac dinh ma override sao cho 2 bien doi tuong so sanh gia tri tai HEAP
	 		--> doi tuong co the co 1 hoac N thuoc tinh
		*/

		Car c1 = new Car(1, "Honda", "crv", 1240d);
		Car c2 = new Car(1, "Honda", "crv", 1240d);
		Car c3 = new Car(2, "Honda", "brv", 720d);
		
		System.out.println("(c1==c2): "+ (c1==c2));
		System.out.println("(c1 eq c2): " + (c1.equals(c2)));
		System.out.println("(c1 eq c3): " + (c1.equals(c3)));
		
		String s1 = new String("hello");
		String s2 = new String("hello");
		String s3 = "hello";
		
		System.out.println("(s1==s2): "+(s1==s2));
		System.out.println("(s1==s3): "+(s1 == s3));

	}

}

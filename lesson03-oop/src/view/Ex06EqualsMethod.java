package view;

import bean.Car;

public class Ex06EqualsMethod {

	public static void main(String[] args) {
		
		/*
			
			Lý thuyết:
			
			Biến KDL nguyên thủy
			- STACK: giá trị thực tế
			
			Biến KDL đối tượng
			- HEAP: địa chỉ ô nhớ HEAP mà nó đang trỏ đến
			- STACK: giá trị thực tế của đối tượng
			
			Để so sánh(bằng) giá trị của 2 biến -> sử dụng toán tử ==
			
			Toán tử == (so sánh giá trị ở STACK)
		
			Khi so sánh đối tượng --> nên so sánh giá trị tt của đối tượng đó
			
			Sử dụng hàm equals
			
			- Từ class Object, mặc định hàm equals có body cũng là so sánh địa chỉ 2 biến
				đối tượng
			- Không dùng hàm equals default mà nên override sao cho 2 biến đối tượng
				so sánh giá trị tt tại HEAP
				
			Với các class có sẵn từ java như Integer, Double, String, Long đều đã
				override hàm equals từ class Object
			
		*/
		
		Car c1 = new Car(1, "honda", "crv", 1240d);
		Car c2 = new Car(1, "honda", "crv", 1240d);
		
		System.out.println("(c1==c2): " + (c1 == c2));
		
		String s1 = "hello";
		String s2 = "hello";
				
		System.out.println("(s1==s2): " + (s1 == s2));
		
	}
	
}

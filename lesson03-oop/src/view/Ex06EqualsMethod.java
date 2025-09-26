package view;

import bean.Car;

public class Ex06EqualsMethod {
	public static void main(String[] args) {
		/*
		  Lý thuyết
		  
		  Biến KDL nguyên thủy -Stack: giá trị thực tế
		  
		  Biến KDL đối tượng -Stack: địa chỉ của ô nhớ tại HEAP mà nó đang trỏ đến
		  
		  -HEAP: giá trị thực tế của đối tượng Để so sánh giá trị của 2 biến có bằng,
		  
		  giống nhau không --> thường sử dụng toán tử == Toán tử == (so sánh giá trị
		  
		  của biến ở stack) Như vậy Dùng toán tử == để so sánh 2 biến nguyên thủy -->
		  
		  so sánh giá trị --> OK Dùng toán tử == để so sánh 2 biến đối tượng --> so
		  
		  sánh địa chỉ(so xem 2 biến này có đang trỏ đến cùng một địa chỉ hay k) -->
		  
		  Muốn so sánh giá trị của 2 biến đối tượng? --> Đối tượng có thể có 1 hoặc N
		  
		  thuộc tính, khi so sánh cần đặt câu hỏi 2 đối tượng đó ntn là bằng nhau
		 
		  Sử dụng hàm equal
		  
		  -từ class Object, mặc định hàm equals có body cũng là so sánh địa chỉ của 2 biến đối tượng
		  
		  -không dùng hàm equals mặc đinh mà override saop cho 2 biến đối tượng so sánh giá trị tại HEAP
		  
		  	--> đối tượng có thể có 1 hoặc N thuộc tính, khi so sánh cần đặt câu hỏi 2 đối tượng đố ntn là bằng
		  	
		  	--> VD: 2 đối tượng Car bằng nhau khi có id giống nhau
		  	
		  	Với các class có sẵn của Java như Integer, String, Double, Long, BigDecimal đã thừa kế vào override lại hàm equals từ class object rồi để so sánh theo giá trị
		 */

		Car c1 = new Car(1, "honda", "crv", 1240d);
		Car c2 = new Car(1, "honda", "crv", 1240d);
		Car c3 = new Car(2, "honda", "brv", 720d);

		System.out.println("(c1==c2): " + (c1 == c2));
		System.out.println("(c1 eq c2): " + (c1.equals(c2)));
		System.out.println("(c1 eq c3): " + (c1.equals(c3)));

		String s1 = new String("hello");
		String s2 = new String("hello");

		System.out.println("(s1==s2): " + (s1 == s2)); 
		System.out.println("(s1 eq s2): " + (s1.equals(s2)));
	}
}

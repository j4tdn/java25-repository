package view;

import java.security.PublicKey;

import bean.Car;

public class Ex06EqualsMethod {
	/*
	 * Lý thuyết
	 * 
	 * Biến KDL nguyên thủy
	 * - Stack: giá trị thực tế
	 * 
	 * Biến KDL đối tượng
	 * - Stack: địa chỉ của ô nhớ tại HEAP mà nó đang trỏ đến
	 * - HEAP: giá trị thực tế của đối tượng
	 * 
	 * Để so sánh giá trị của 2 biến có bằng, giống nhau ko --> thường sử dụng toán tử ==
	 * Toán tử == (so sánh giá trị của biến ở STACK)
	 * 
	 * Như vậy
	 * Dùng toán tử == để so sánh 2 biến nguyên thủy --> so sánh giá trị --> OK
	 * Dùng toán tử == để so sánh 2 biến đối tượng --> so sánh địa chỉ (so xem 2 biến này có đang trỏ đến cùng 1 vùng nhớ HEAP kp)
	 * 
	 * --> Muốn so sánh giá trị của 2 biến đối tượng?
	 * --> Đối tượng có thể có 1 hoặc N thuộc tính, khi nào so sánh cần đặt câu hỏi 2 đối tượng đó ntn là bằng nhau
	 *
	 *Sử dụng hàm equals
	 * - từ class Object, mặc định hàm equals có body cũng là so sánh
	 * - ko dùng hàm equals mặc định mà override sao cho 2 biến
	 * --> đối tượng có thể có thể có 1 hoặc N thuộc tính, khi so sánh cần đặt câu hỏi 2 đối tượng đó ntn là bằng nhau
	 * --> VD: 2 đối tượng Car bằng nhau khi có id giống nhau
	 * 
	 * Với các class có sẵn của Java như Integer, String, Double, Long, BigDecimal đã thừa kế và overide lại hàm equals từ class Object rồi để SS
	 * để so sánh theo giá trị
	 */ 
	public static void main(String[] args) {
		Car c1 = new Car(1,"honda","CRV",1250d);  //H1
		Car c2 = new Car(1,"honda","CRV",1250d);  //H2
		String s1 = "hello";
		String s2 =  "hello";
		System.out.println("c1.equals(c2) "+ c1.equals(c2)); // equals so sánh địa chỉ của 2 biến đối tượng
			System.out.println("c1==c2 " + (c1==c2));
			
			System.out.println("s1==s2 " + (s1==s2));
			
	}

	
}
	
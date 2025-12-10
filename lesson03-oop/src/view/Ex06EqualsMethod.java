package view;

import bean.Car;

public class Ex06EqualsMethod {
	/* 
	 
	 Lý thuyết
	 
	 Biến KDL nguyên thuỷ
	 - Stack: giá trị thực tế
	 
	 Biến KDL đối tượng
	 - Stack: địa chỉ của ô nhớ thực tại HEAP mà nó đang trỏ đến
	 - Heap: giá trị thực tế của đối tượng
	 
	 để so sánh giá của 2 biến có bằng, giống nhau không --> thường sử dụng toán tử ==
	 
	 sử dụng toán tử == (so sánh giá trị của biến ở stack)
	 
	 như vậy
	 Dùng toán tử == để so sánh 2 biến nguyên thuỷ --> so sánh giá trị --> OK
	 
	 Dùng toán tử == để so sánh 2 biến đối tượng --> so sánh địa chỉ( so xem 2 biến này có đang trỏ đến cùng 1 địa chỉ không)
	 
	 --> muốn so sánh giá trị của 2 biến đối tượng?
	 --> đối tượng có thể có 1 hoặc N thuộc tính, khi so sánh cần đặt câu hỏi 2 đối tượng ntn là bằng nhau
	
	 với các class có sẵn của Java như Integer, String, Double, Long, BigDecimal đã thừa kế và override lại
	 hàm equal từ class Object rồi để so sánh theo giá trị
	 
	 */
	
	public static void main(String[] args) {
		Car c1 = new Car(1, "Honda", "crv", 1240d);
		Car c2 = new Car(1, "Honda", "crv", 1240d);
		Car c3 = new Car(2, "Honda", "crv", 740d);
		
		System.out.println("(c1 == c2): " + (c1 == c2));
		System.out.println("(c1 euqal c2): " + (c1.equals(c2)));
		System.out.println("(c1 equal c3): " + (c1.equals(c3)));
		
		String s1 = "hello";
		String s2 = "hello";
		
		System.out.println("s1 == s2)" + (s1==s2));
		System.out.println("s1 equal s2)" + (s1.equals(s2)));
	}
	

}

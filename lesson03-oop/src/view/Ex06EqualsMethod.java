package view;

import bean.Car;

public class Ex06EqualsMethod {
	public static void main(String[] args) {

	/*
	 * Lý thuyết: 
	 * Với KDL nguyên thủy: stack, giá trị thực tế
	 * Với KDL đối tượng: stack lưu địa chỉ ô nhớ tại HEAP mà nó đang trỏ đến
	 * Heap: giá trị thực tế của đối tượng
	 * 
	 * Để so sánh giá trị của 2 biến có bằng, giống nhau không --> sử dụng toán tử ==
	 * Sử dụng toán tử ==  ( so sánh giá trị của biến ở stack)
	 * Như vậy, nếu dùng toán tử== để so sánh 2 biến nguyên thủy thì --> so sánh giá trị
	 * Nếu dùng toán tử== để so sánh 2 biến đối tượng --> chỉ đang so sánh địa chỉ( so sánh 2 biến có đang trỏ đến cùng 1 địa chỉ hay không)
	 * Vậy muốn so sánh giá grij của 2 biến đối tượng?
	 * Đôi tượng có thể có hoặc N thuộc tính, khi so sánh cần đặt câu hỏi 2 đối tượng đó ntn là bằng nhau?
	 */
	
	/*Sử dụng hàm equals
	 Từ class Object, mặc định hàm equasl có body cũng là so sánh địa chỉ của 2 biến đối tượng
	 Không dùng hàm equal mặc định mà override sao cho 2 biến dối tượng so sánh giá trị tại HEAP
	 Đôi tượng có thể có hoặc N thuộc tính, khi so sánh cần đặt câu hỏi 2 đối tượng đó ntn là bằng nhau?
	 Ví dụ: 2 đối tượng Car bằng nhau khi có id giống nhau
	 
	 Với các class có sẵn của Java như Integer, String, Double, Long, BigDecimal đã thừa kế và override lại hàm equals từ 
	 class object rồi để so sánh theo giá trị
	 
	 */
	
	Car c1 = new Car(1, "honda", "crv", 1240d); // H1
	Car c2 = new Car(1, "honda", "crv", 1240d); // H2
	Car c3 = new Car(2, "honda", "brv", 720d); // H3
	
	System.out.println("(c1==c2):  " + (c1==c2));	// #1
	System.out.println("(c1 eq c2):  " + (c1.equals(c2))); 	// #2
	System.out.println("(c1 eq c3):  " + (c1.equals(c3))); 	// #3
	
	String s1 = new String( "hello");
	String s2 = new String( "hello");
	
	System.out.println("\n(s1==s2):  " + (s1==s2)); // #4
	System.out.println("\n(s1 eq s2):  " + (s1.equals(s2))); // #5

}
	
}
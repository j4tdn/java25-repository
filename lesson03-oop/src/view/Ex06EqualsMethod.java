package view;

import bean.Car;

public class Ex06EqualsMethod {

	public static void main(String[] args) {
		/**
		 
		  Lý thuyết
		 
		 Biến KDL nguyên thủy
		   -Stack: giá trị thực tế
		   
		 Biến KDL đối tượng
		 	- stack: địa chỉ của ô nhớ tại heap mà nó đang trỏ đến
		 	- Heap: giá trị thực tế của đối tượng
		 	
		 Để so sánh giá trị của 2 biến có bằng, giống nhau không --> thường sử dụng toán tử ==
		 
		 Sử dụng toán tử == (so sánh giá trị của biến ở stack )
		 
		 NHư vậy
		 
		 Dùng toán tử == để so sánh hai biến nguyen thủy --> so sánh giá trị --> ok
		 
		 Dùng toán tử == để so sánh 2 biến đối tượng --> so sánh địa chỉ(so xem 2 biến này có đang trỏ đến cùng 1 địa chỉ không)
		 
		 
		 --> Muốn so sanh  giá trị của 2 biến đối tượng ??
		 --> Đối tượng có thể có 1 hoặc nhiều thuộc tính, khi so sánh cần đặt câu hỏi 2 đối tượng đó ntn là bằng nhau
		 
		 Sử dụng hàm equals
		 
		 - từ class object, mặc định hàm equals có body cũng là so sánh địa chỉ của hai biến đối tượng
		 - không dùng hàm equals mặc định mà overide lại sao cho 2 biến đối tượng đó so sánh giá trị tại HEAP
		 --> VD: hai đối tượng CAR bằng nhua khi nó có id giống nhau
		 
		 Với các class có sẵn của JAva như Integer, String, Double, Long, Bigdecimal đã thừa kế và override
		 lại hamf equals từ class object rồi để sa sanh theo giá trị
		
		 
		 */
		
		Car c1 = new Car(1, "honda", "crv", 1240d);
		Car c2 = new Car(1, "honda", "crv", 1240d);
		Car c3 = new Car(2, "honda", "brv", 720d);
		
		System.out.println("(c1==c2) : " + (c1==c2));
		System.out.println("(c1 eq c2) : " + (c1.equals(c2)));
		System.out.println("(c1 eq c2) : " + (c1.equals(c3)));
		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		
		System.out.println("\n (s1==s2) : " + (s1==s2));
		System.out.println("\n (s1 eq s2) : " + (s1.equals(s2)));
		
	}
	
}

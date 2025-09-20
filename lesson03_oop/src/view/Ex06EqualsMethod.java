package view;

import bean.Car;

public class Ex06EqualsMethod {
	public static void main(String[] args) {
		/*
		  Lý thuyết:
		  
		  Biến KDL nguyên thủy
		   -statck: giá trị thực tế
		   
		  Biến KDL đối tượng
		   - stack: địa chỉ của ô nhớ tại heap mà nó đang trỏ đến
		   - heap: giá trj thực tế của đối tượng 
		  
		  Để so sánh giá trị của 2 cái biến có bằng, giống nhau ko --> thường sử dụng toán tử ==
		   Sử dụng toán tử == (so sánh giá trị của biến ở stack)
		   
		   
		  Dùng toán tử == để so sánh 2 biến nguyên thủy --> so sánh giá trị --> OK
		  dùng toán tử == để so sánh 2 biến đối tượng --> so sánh địa chỉ(xem 2 biến này có đang trỏ đến cùng 1 địa chỉ ko)
		  
		   --> muốn so sánh giá trị của 2 biến đối tượng
		   --> đối tượng có thể có 1 hoặc N thuộc tính, khi so sánh cần đặt câu hỏi 2 đối tượng đó ntn là bằng nhau
		  
		  Sử dụng hàm equals
		  
		   - từ class object, mặc định hàm equals có body cũng là so sánh địa chỉ của 2 biến đối tượng
		   - ko dùng hàm equals mặc định, mà override sao cho 2 biến đối tượng so sánh giá trị tại heap
		    -->đối tượng có thể có 1 hoặc N thuộc tính, khi so sánh cần đặt câu hỏi 2 đối tượng đó ntn là bằng nhau
		    --> VD: 2 đối tượng car bằng nhau khi có id gioong nhau
		    
		  Với các class có sẵn của java như Integer, String , Double đã thừa kế và override lại hàm equals
		  từ class Object rồi để so sánh theo giá trị
		 */
		
		Car c1 = new Car(1, "honda", "srv", 124d); // h1
		Car c2 = new Car(1, "honda", "srv", 124d); // h2
		Car c3 = new Car(2, "honda", "brv", 720d);
		
		System.out.println("c1 == c2: " + (c1==c2));
		System.out.println("c1 eq c2: " + (c1.equals(c2)));
		System.out.println("c1 eq c3: " + (c1.equals(c3)));
		
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		System.out.println("\ns1 == s2: " + (s1 == s2));
		System.out.println("\ns1 eq s2: " + (s1.equals(s2)));
		
	}

}

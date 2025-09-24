package view;

import bean.Car;

public class Ex06EqualMethod {
	public static void main(String[] args) {
		
		/*	ly thuyet
		 	Biến KDL nguyên thuy
			- Stack: giá trị thực tế

		  	Biên KDL đoi tượng
			-Stack: đia chi của ỏ nhỏ tại HEAP mà nó đang tró đến
			- Heap: giá trị thực tế của đỏi tương
			Để so sánh giá trị của 2 biến có băng, giống nhau không --> thường sử dụng toán tử =-Toán tử == (so sánh giá trị của biến ở stack)
			Như vày
			Dùng toán từ == đe so sảnh 2 biên nguyên thuy -> so sanh gia tri --> OK
		  	Dùng toán tử == để so sảnh 2 biến đổi tượng --> so sảnh địa chi (so xem 2 biến này có đang tró đến cùng 1 dia chi
			--> Muòn so sảnh già trị của 2 biến đối tượng ?
			--> Đói tượng có thể có 1 hoặc N thuộc tính, khi so sảnh căn đặt câu hỏi 2 đối tượng đỏ ntn Là bảng nhau

		 */
		Car c1 =  new Car(1, "honda", "crv", 1240d);
		Car c2 =  new Car(1, "honda", "crv", 1240d);
		Car c3 =  new Car(2, "honda", "brv", 720d);
		
		System.out.println("(c1 == c2): " +(c1==c2));
		System.out.println("(c1 eq c2): " +(c1.equals(c2)));
		System.out.println("(c1 eq c2): " +(c1.equals(c3)));
		
		String s1 = "hello";
		String s2 = "hello";
		
		System.out.println("\n(s1 == s2): " +(s1==s2));
		System.out.println("\n(s1 eq s2): " +(s1.equals(s2))); 
	}
}

package polymorphism.object;

import java.awt.Rectangle;
import java.awt.Shape;

public class Ex01PolymorphismDemo {
	
	/*
	 	làm 1 số chức năng (tính diện tích ) liên quan đến hình học 
	 	- Square: calculates
	 	- Rectangle: calArea
	 	- Circle: tinhS
	 	==> cùng 1 chức năng , code không đồng bộ - nhớp 
	 	==> xử lý
	 	
	 	1. Tạo ta 1 class là cha của các class trên
	 	- shape
	 	- Tạo ra hàm chung --> calcS(tổng quản, chưa biết công thức cụ thể)
	 	
	 	2. Tạo ra các class con Square , Rectangle, Circle
	 	- Dùng mặc định nội dung của hàm calcS
	 	- Hoặc override lại công thức	
	 */

	public static void main(String[] args) {
		System.out.println("Khởi tạo các đối tượng thông thường"); 
//		Shape shape1 = new Shape();
		Rectangle rectangle1 = new Rectangle();
//		square1 square1 = new Square();
		
//		shape1.calcS();			//Shape#calS unknow
//		square1.calcS();		//Square#calS....formula
//		rectangle1.calcS();		//Rectangle#calS....formula
		
		
		
		System.out.println("Khởi tạo các đối tượng theo tính chất đa hình");
//		Shape s1 = new Square();
		Shape s2 =  new Rectangle();
			
//		Shape s3 = new Circle();
//		s1.calcS();
//		s2.calcS();
		
		/*
		 Giải thích : đa hình trong đối tượng 
		 	Biến KDL cha có thể trỏ đến các đối tượng KDL con của nó
		 	Ví dụ: s1 lúc compli --> KDL Shape
		 			   runtime --> KDL Square
		 			   		  --> chạy in kết quả gọi hàm calcS trong Square 
		
		 1. Tại sao ko lấy biến KDL đối tượng khởi tạo chính class của nó mà phảil ấy biến cha trỏ đến đối tượng con 
		 2. ĐHTĐT, biến KDL cha có thể trỏ/gán đến KDL con , ngược lại có được ko? vì sao 
		 */
	}
	
}

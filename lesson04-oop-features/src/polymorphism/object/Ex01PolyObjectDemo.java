package polymorphism.object;

public class Ex01PolyObjectDemo {
	
	/*
	 Làm một số chức năng(tính diện tích) liên quan đến hình học
	 - Square: calculateS
	 - Rectangle: calcArea
	 - Circle: tinhS 
	 ==> Cùng một chức năng, code không đồng bộ - nhớp
	 ==> Xử lý
	 
	 1. Tạo ra một class là cha của các class trên
	    - Shape
	    - Tạo ra hàm chung --> calcS(tổng quan, chưa biết công thức cụ thể)
	    
	 2. Tạo ra các class con Square, Rectangle, Circle
	    - Dùng mặc định nội dung của hàm calcS
	    - Hoặc override lại công thức
	 */
	
	public static void main(String[] args) {
		System.out.println("=== Khởi tạo các đối tượng thông thường ==="); 
		Shape shape1 = new Shape();
		Square square1 = new Square();
		Rectangle rectangle1 = new Rectangle();
		
		shape1.calcS();     // Shape#calcS unknown
		square1.calcS();    // SquarecalcS .... formula
		rectangle1.calcS(); // Rectangle#calcS .... formula
		
		
		
		System.out.println("\n\n=== Khởi tạo các đối tượng theo tính chất đa hình ===");
		Shape s1 = new Square();
		Shape s2 = new Rectangle();
		s1.calcS(); // Square#calcS .... formula
		s2.calcS(); // Rectangle#calcS .... formula
		
		/*
		 Giải thích: đa hình trong đối tượng
		 Biến KDL cha có thể trỏ đến các đối tượng KDL con của nó
		 Ví dụ: s1 lúc compile --> KDL Shape
		               runtime --> KDL Square
		                       --> chạy in kết quả gọi đến hàm calcS trong Square
		                       
		 1. Tại sao không lấy biến KDL đối tượng khởi tạo cho chính KDL class của nó mà 
		 phải lấy biến cha trỏ đến đối tượng con ?
		 
		 2. ĐHTĐT, biến KDL cha có thể trỏ/gán đến KDL con, ngược lại có được không. Vì sao ?                  
		 */
	}
	
}

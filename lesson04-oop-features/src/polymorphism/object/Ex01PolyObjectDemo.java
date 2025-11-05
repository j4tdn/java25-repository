package polymorphism.object;

public class Ex01PolyObjectDemo {
	
	/**
	 Làm một số chức năng(tính diện tích) liên quan đến hình học
	 Square: calculateS
	 Rectangle: calcArea
	 Circle: tinhS
	 ==> Cùng 1 chức năng, code không đồng bộ - code nhớp
	 
	 ==>Xử lý:
	 	1. Tạo ra một class là cha của các class trteen
	 		- class Shape
	 		- Tạo ra hàm chung --> calcS(tổng quan, chưua biết công thức cụ thể)
	 		
	 	2. Tạo ra các class con Square, Retangle, Circle
	 		- Dùng mặc định nội dung của hàm calcS
	 		- Hoặc override lại công thức
	 
	 */
	public static void main(String[] args) {
		System.out.println("=== khởi tạo các đối tượng thông thường ==="); 
		Shape shape1 = new Shape();
		Square square1 = new Square();
		Rectangle rectangle1 = new Rectangle();
	
		
		shape1.calcS();
		square1.calcS();
		rectangle1.calcS();
		
			
		System.out.println("\n\n=== khởi tạo các đối tượng theo tính chất đa hình ===");
		Shape s1 = new Rectangle();
		Shape s2 = new Square();
		s1.calcS();
		s2.calcS();
		
		s2 = s1;
		
		/**
		 Giải thích: đa hình trong đối tượng
		 Biến KDL cha có thể trỏ đến các đối tượng KDL con của nó
		 Ví dụ: s1 lúc compile --> KDL Shape
		 			   runtime --> KDL Square
		 			   		   --> chạy in kết quả gọi đến hàm calcS trong Square 
		 			
		 1. Tại sao không lấy biến KDL đối tượng khởi tạo cho chính KDL class của nó mà phải
		 	lấy biến cha trỏ đến đối tượng con ?
		 	--> -Dễ dàng, linh hoạt ép KDL qua về trong phạm vi cha con tại thời điểm compile
		 		-Lúc compile các biến đều là KDL cha nên:
		 			+Tạo mảng, danh sách nhận các phần tử là chính nó hoặc KDL con
		 			+Biến KDL cha có thể nhận chính nó hoặc KDL con, linh hoạt khi truyền tham số qua hàm
		 
		 2. Đa hình trong đối tượng, biến KDL cha có thể được trỏ/gán đến KDL con, ngược lại có được không, VÌ sao ?
		 	--> không, vì lúc compile KDL con có thể gọi đến hàm của riêng nó nhưng lúc runtime khong thể tìm
		 	thấy hàm đó trong đối tượng KDL cha
		 
		 */
		
		Shape[] shapes = {s1, s2, shape1, square1, rectangle1};
		
		// đếm số phần tử trong mảng là square
		// Nếu là Square --> gọi hàm setBackground của nó
		int squareCounter = 0;
		for (Shape shape: shapes) {
			if(shape instanceof Square sq) {
				sq.setBackground();
				squareCounter++;
			}
		}
		System.out.println("Số lượng hình vuông: " + squareCounter);
		
		doCalculation(s1);
		doCalculation(s2);
		doCalculation(square1);
		doCalculation(rectangle1);
		
		System.out.println("\n\n=======================\n");
		
		Square sq1 = (Square) new Shape();
		sq1.calcS();
		sq1.setBackground();
	}
	
	private static void doCalculation(Shape shape) {
		shape.calcS();
	}
	
	
}

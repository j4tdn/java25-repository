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
		
		s2 = s1; // collection list set
		
		/*
		 Giải thích: đa hình trong đối tượng
		 Biến KDL cha có thể trỏ đến các đối tượng KDL con của nó
		 Ví dụ: s1 lúc compile --> KDL Shape
		               runtime --> KDL Square
		                       --> chạy in kết quả gọi đến hàm calcS trong Square
		                       
		 1. Tại sao không lấy biến KDL đối tượng khởi tạo cho chính KDL class của nó mà 
		 phải lấy biến cha trỏ đến đối tượng con ?
		 - Dễ dàng, linh hoạt ép KDL qua về trong phạm vi cha con tại thời điểm compile
		 - Lúc compile các biến đều là KDL cha:
		   --> Tạo mảng, danh sách nhận các phần tử là chính nó hoặc KDL con
		   --> Biến KDL cha có thể nhận chính nó hoặc KDL con, linh hoạt khi truyền tham số qua hàm
		 
		 2. Đa hình trong đối tượng, biến KDL cha có thể được gán từ KDL con trỏ đến KDL con, 
		    ngược lại có được không. Vì sao ?
		   --> không, lúc compile KDL con có thể gọi đến hàm của riêng nó nhưng lúc runtime ko thể
		   tìm thấy hàm đó trong đối tượng của KDL cha
		 */
		
		Shape[] shapes = {s1, s2, shape1, square1, rectangle1};
		
		// Đếm số phần tử trong mảng là Square
		// Nếu là Square --> gọi hàm setBackground của nó
		// shape instanceof Square sq
		int squareCounter = 0;
		for (Shape shape: shapes) {
			if (shape != null && shape.getClass() == Square.class) {
				Square sq = (Square)shape;
				sq.setBackground();
				squareCounter++;
			}
		}
		System.out.println("Số lượng hình vuông: " + squareCounter);
		
		doCalculation(s1);
		doCalculation(s2);
		doCalculation(square1);
		doCalculation(rectangle1);
		
		System.out.println("\n\n==============\n");
		
		Square sq1 = (Square) new Shape(); // lỗi
		sq1.calcS();
		sq1.setBackground();
	}
	
	private static void doCalculation(Shape shape) {
		shape.calcS();
	}
	
}

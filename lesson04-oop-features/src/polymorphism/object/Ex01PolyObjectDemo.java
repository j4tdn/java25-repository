package polymorphism.object;

public class Ex01PolyObjectDemo {

	/*
	 Làm một chức năng(tính diện tích) liên quan đến hình học
	 - Square: caculates
	 - Rectangle: calcArea
	 - Circle: tinhS
	 --> Cùng một chức năng, code k đồng bộ - nhớp
	 --> Xử lý:
	   1. Tạo ra 1 class cha của các class trên
	     - Shape 
	     - Tạo ra hàm chung --> calcS (tổng quan, chưa biết công thức cụ thể)
	   2. Tạo ra các class con Square, Rectangle, Circle
	     - Dùng mặc định nội dung của hàm calcS
	     - hoặc override lại cthuc
	 */
	public static void main(String[] args) {
		System.out.println("===Khởi tạo các đối tượng thông thường===");
		Shape shape1 = new Shape();
		Square square1 = new Square();
		Rectangle rectangle1 = new Rectangle();
		
		shape1.calcS();      // Shape#calcS unknown
		square1.calcS();     // SquarecalcS ... formula
		rectangle1.calcS();  // Rectangle#calcS ... formula
		
		System.out.println("\n\n===Khởi tạo các đối tượng theo tính chất đa hình===");
		Shape s1 = new Rectangle();
		Shape s2 = new Square();
		// Shape s3 = new Circle();
		s1.calcS(); // SquarecalcS ... formula
		s2.calcS(); // Rectangle#calcS ... formula
		
		s2 = s1;
		
		/*
		 Giải thích: đa hình trong đối tượng 
		 Biến KDL cha có thể trỏ đến các đối tượng KDL của con nó
		 VD: s1 trong lúc compile --> KDL Shape
		                  runtime --> KDL Square 
		                          --> chay in kết quả gọi đến hàm calcS trong Square
		 
		 1. Tại sao k lấy biến KDL đối tượng khởi tạo cho chính KDL class của chính nó
		  mà phải lấy biến cha trỏ đến đối tượng con?
		  - Dễ dang, linh hoạt ép KDL qua về trong phạm vi cha con tại thời điểm compile
		  - Lúc compile các biến đều là KDL cha:
		    --> Tạo mảng, danh sách nhận các phần tử là chính nó hoặc KDL con
		    --> Biến KDL cha có thể nhận chính nó hoặc KDL cin, linh hoạt khi truyền tham số qua hàm
		 2. ĐH trong đối tượng: biến KDL cha có thể trỏ/gán đến KDL con, ngược lại có được không ?
		  - Không, vì lúc compile KDL con có thể gọi đến hà của riêng có nhưng lúc run time k thể
		   tìm thấy hà đó trong KDL của đối tượng cha.
		 */
		
		Shape[] shapes = {s1, s2, shape1, square1, rectangle1};
		
		// Đếm sô phần tử trong mảng là Square
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
		doCalculation(s1);
		doCalculation(s1);
		doCalculation(s1);
		
		System.out.println("\n\n=========\n");
		
		Square sq1 = (Square) new Shape();
		sq1.calcS();
		sq1.setBackground();
	}
	
	private static void doCalculation (Shape shape) {
		shape.calcS();
	}
}

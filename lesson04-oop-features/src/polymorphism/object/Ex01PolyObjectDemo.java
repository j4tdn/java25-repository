package polymorphism.object;

public class Ex01PolyObjectDemo {
	
	/*
	  Làm một số chức năng(tính diện tích) liên quan đến hình học
	  - square: calculateS
	  - Rectangle: calcArea
	  - Cỉcle: tinhS
	  --> cùng một chức năng, code không đồng bộ - nhớp
	  --> xử lý
	  
	  1. tạo ra một class là cha của các class trên
	    - shape
	    - tạo ra hàm chung --> calcS(tổng quan, chưa biết công thức cụ thể)
	    
	  2. tạo ra các class con như Square, Rectangle, Circle
	    - dùng mặc định nội dung của hàm calsS
	    - hoặc override lại công thức  
	  
	 */
	public static void main(String[] args) {
		System.out.println("===khởi tạo các đối tượng thông thường===");
		Shape shape1 = new Shape();
		Square square1 = new Square();
		Rectangle rectangle1 = new Rectangle();
		
		shape1.calcS();
		rectangle1.calcS();
		square1.calcS();
		
		
		System.out.println("\n\n===khởi tạo các đối tượng da hinh===");
		Shape s1 = new Square();
		Shape s2 = new Rectangle();
		
		
		s1.calcS();
		s2.calcS();
		
		s2 = s1;
		
		/*
		 Giải thích: đa hình trong đối tượng
		 Biến KDL cha có thể trỏ đến các đối tượng KDL con của nó
		 ví dụ: s1 luc compile --> KDL shape
		               runtime --> KDL Square
		                       --> chạy in ra kết quả gọi đến hàm calcS trong Square
		                       
		 1. tại sao ko lấy biến KDL đối tượng khởi tạo cho chính KDL class của nó mà phải lấy biến cha trỏ đến đối tượng con?
		 - Dễ dàng, linh hoạt ép KDL qua về trong phạm vi cha con tại thời điểm compile
		 - Lúc compile các biến đều là KDl cha:
		   --> tạo mảng, danh sách nhận các phần tử là chính nó hoặc KDL con
		   --> Biến KDL cha có thể nhận chính nó hoặc KDL con, linh hoạt khi truyền tham số qua hàm
		 
		 
		 2. Đa hình trong đối tượng, biến KDL cha có thể trỏ/gán đến KDL con, ngược lại được không, vì sao?
		   --> không, vì lúc compile KDL con có thể gọi đến hàm của riêng nó nhưng lúc runtime ko thể tìm 
		   thấy hàm đó trong đối tượng của KDL cha
		 
		 */
		Shape[] shapes = {s1, s2, shape1, square1, rectangle1};
		
		// Đếm số phần tử trong mảng là Square
		// Nếu là Square --> gọi hàm setBackground của nó
		int squareCounter = 0;
		for (Shape shape : shapes) {
			if (shape != null && shape.getClass() == Square.class) {
				Square sq = (Square)shape;
				sq.setBackgroud();
				squareCounter++;
			}
 			
		}
		System.out.println("so luong hinh vuong: " + squareCounter);
		
		doCalculation(s1);
		doCalculation(s2);
		doCalculation(square1);
		doCalculation(rectangle1);
		
		System.out.println("\n\n================\n");
		
		Square sq1 = (Square) new Shape(); // loi
		sq1.calcS();
		sq1.setBackgroud();
	}
	
	private static void doCalculation(Shape shape) {
		shape.calcS();
	}


}

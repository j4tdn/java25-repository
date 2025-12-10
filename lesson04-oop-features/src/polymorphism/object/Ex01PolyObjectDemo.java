package polymorphism.object;

public class Ex01PolyObjectDemo {
	/*
	 làm một số chức năng(tính diện tích) liên quan đến hình học
	 - Square: calculateS
	 - Rectangle: calcArea
	 - Circle: tinhS
	 ==> cùng một chức năng, code không động bộ - nhớp
	 ==> xử lý
	 
	 1. tạo ra một class là cha của các class trên
	 - Shape
	 - Tạo ra hàm chung --> calcS(tổng quan, chưa biết công thức cụ thể)
	 
	 2. tạo ra các class con Square, Rectangle, Circle
	 - dùng mặc định nội dung của hàm calcS
	 - hoặc overide lại côgn thức
	 */
	public static void main(String[] args) {
		
		System.out.println("======khởi tạo các đối tượng thông thường ======");
		Shape shape1 = new Shape();
		Square square1 = new Square();
		Rectangle rectangle1 = new Rectangle();
		
		shape1.calcS();		//Shape#calcS unknown
		square1.calcS();	//SquarecalcS... formula
		rectangle1.calcS();	//Rectangle#calcS... formula
	
		System.out.println("\n\n====khởi tạo đối tượng theo tính chất đa hình=====");
		Shape s1 = new Square();
		Shape s2 = new Rectangle();
		s1.calcS();
		s2.calcS();
		
		/*
		 giải thích: đa hình trong đối tượng
		 biến KDL cha có thể trỏ đến các đối tượng KDL con của nó
		 ví dụ: s1 lúc compile --> KDL Shape
		 			runtime --> KDL Square
		 					--> chạy in kết quả gọi đến hàm calcS trong Square
		 		
		
		 1. tại sao không lấy biến KDL đối tượng khởi tạo cho chính KDL class của nó mà phải 
		 lấy biến cha trỏ đến đối tượng con
		 	- dễ dàng, linh hoạt ép KDL qua về trong phạm vi cha con tại thời điểm compile
		 	- lúc compile các biến đều là KDL cha:
		 	--> tạo mảng, danh sách nhận các phần tử là chính nó hoặc KDL con
		 	--> biến kiểu dữ liệu cha có thể nhận chính nó hoặc kdl con, linh hoạt khi truyền tham số qua hàm
		 2. ĐHTĐT, biến KDL cha có thể trỏ/ gán đến KDL con, ngược lại có được không. Vì sao?
		 	--> không, lúc compile KDL con có thể gọi đến hàm của riêng nó nhưng lúc 
		 	runtime không thể tìm thấy hàm đó trong đối tượng của KDL cha
		 */
		
		Shape[] shapes = {s1, s2, shape1, square1, rectangle1};
		Shape r = shapes[4];
		
		// Đếm số phần tử trong mảng là Square
		// nếu là Square --> gọi hàm setBackground của nó
		// shape instanceof Square sq
		int squareCounter = 0;
		for(Shape shape: shapes) {
			// if (shape != null && shape.getClass() = Square.class){
			if(shape instanceof Square sq) {
			//	Square sq = (Square)shape;
				sq.setBackground();
				squareCounter++;
			}
		}
		System.out.println("Số lượng hình vuông: " + squareCounter);
		
		doCalculation(s1);
		doCalculation(s2);
		doCalculation(square1);
		doCalculation(rectangle1);
		
		System.out.println("\n===========\n");
		
		Square sq1 = (Square) new Shape();
		sq1.calcS();
		sq1.setBackground();
	}
	private static void doCalculation(Shape shape) {
		shape.calcS();
	}

}

package polymorphism.object;

public class Ex01PolyObjectDemo {

	/*
	 * Làm 1 số chức năng(tính diện tích) liên quan đến hình học
	 * Square: calculates
	 * Rectangle: calcArea
	 * Circle: tinhS
	 * ==> Cùng 1 chức năng, code k đồng bộ - nhớp
	 * ==> Xử lý
	 * 
	 * 1. Tạo ra 1 class là cha của các class trên
	 *  - Shape
	 *  - Tạo ra hàm chung --> calcS(tổng quan, chưa biết công thức cụ thể)
	 * 2. Tạo ra các class con Square, Retangle, Circle
	 *  - Dùng mặc định nội dung của hàm calcS
	 *  - Hoặc override lại Công thức
	 */
	public static void main(String[] args) {
		System.out.println("khởi tạo các đối tượng thông thường");
		Shape shape1 = new Shape();
		Square square1 = new Square();
		Rectangle rectangle1 = new Rectangle();
		
		shape1.calcS();
		square1.calcS();
		rectangle1.calcS();
		
		System.out.println("Khởi tạo các đối tượng theo tính chất đa hình");
		Shape s1 = new Rectangle();
		Shape s2 = new Square();
		
		s1.calcS();
		s2.calcS();
		
		/*
		 * Giải thích: đa hình trong đối tượng
		 * Biến KDL cha có thể trỏ đế đối tượng KDL con
		 * VD: s1 lúc compile --> KDL Shape
		 * 			  runtime --> KDL Square
		 * 			  		  --> chạy in kết quả gọi đến hàm calcS trong Square
		 * 
		 * 1. Tại sao k lấy biến KDL object khởi tạo cho chính KDL class của nó mà
		 * phải lấy biến cha trỏ đến đối tượng con?
		 * - Dễ dàng, linh hoạt ép KDL qua về trong phạm vi cha con tại thời điểm compile
		 * - Lúc compile các biến đều là KDL cha:
		 *  --> Tạo mảng, danh sách nhận các phần tử là chính nó hoặc KDL con
		 *  --> Biến KDL cha có thể nhận chính nó hoặc KDL con, linh hoạt khi truyền tham số qua hàm.
		 *  2. ĐHTĐT, biến KDL cha có thể trỏ/gán đến KDL con, ngược lại có được không. Vì sao?
		 *  --> Không, lúc compile KDL con có thể gọi đến hàm của riêng nó nhưng lúc runtime k thể tìm thấy hàm đó
		 *  trong đối tượng của KDL cha
		 */
		Shape[] shapes = {s1, s2, shape1,square1,rectangle1};
		// Đếm số phần tử trong mảng là Square
		int squarecount =0;
		
		for(Shape shape:shapes) {
		
			if(shape instanceof Square) {
				squarecount++;
			}
		}
		// Hoặc: if(shape !=null && shape.getClas()== Square.class){
		//			Square sq= (Square)shape;
		//"Nếu là Square --> gọi hàm setBackground của nó:" sq.setBackground();
		// squarecount++;}
		System.out.println("Số lượng hình vuông là: "+ squarecount);
		
		doCalculation(s1);
		doCalculation(s2);
		doCalculation(square1);
		doCalculation(rectangle1);
	}
	private static void doCalculation(Shape shape) {
		shape.calcS();
	}
}

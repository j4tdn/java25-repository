package polymorphism.object;

public class Ex01PolyObjectDemo {
	
	/*
	 	Làm một số chức năng(tính diện tích) liên quan đến hình học
	 	Square: calculateS
	 	Rectangle: calcArea
	 	Circle: tinhS
	 	
	 	2. Tạo ra các class con Square, Rectangle, Circle
	 		- Dùng mặc định nội dung của hàm calcS
	 		- Hoặc override lại công thức
	 */

	public static void main(String[] args) {
		Shape shape1 = new Shape();
		Rectangle rectangle = new Rectangle();
		Square square1 = new Square();
		
		Shape s1 = new Rectangle();
		Shape s2 = new Square();
		s1.calcS();
		s2.calcS();
		
//		s2 = s1;
		
		/*
		 	Giải thích: đa hình trong đối tượng
		 	Biến KDL cha có thể trỏ đến các đối tượng KDL con của nó
		 	Ví dụ: s1 lúc compile --> KDL Shape
		 				  runtime --> KDL Square
		 				  
		 	1. Tại sao không lấy biến KDL đối tượng khởi tạo cho chính KDL class của nó mà
		 	phải lấy biến cha trỏ đến đối tượng con
		 	- Dễ dàng, linh hoạt ép KDL qua về trong phạm vi cha con tại thời điểm compile 
		 	- Lúc compile các biến đều là KDL cha:
		 	  --> Tạo mảng, danh sách các phần tử là chính nó hoặc KDL con
		 	  --> Biến KDL cha có thể nhận chính nó hoặc KDL con, linh hoạt khi truyền tham số qua hàm
		 	2. ĐHTĐT, biến KDL cha có thể trỏ/gán đến KDL con, ngược lại có được không? Vì sao?
		 	  --> Không, lúc compiile KDL con có thể gọi đến hàm của riêng nó nhưng lúc runtime
		 	  ko thể tìm thấy hàm đó trong đối tượng của KDL cha nên sẽ lỗi
		 */
		
		Shape[] shapes = {s1, s2, shape1, square1, rectangle};
		
		int squareCounter = 0;
		for(Shape shape: shapes) {
			if(shape!=null && shape.getClass() == Square.class) {
				Square sq = (Square)shape;
				sq.setBackground();
				++squareCounter;
			}
		}
		System.out.println("So luong hinh vuong: "+squareCounter);
	}

}

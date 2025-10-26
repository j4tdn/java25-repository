package inheritance.iiterface;

public class InheritanceInterfaceDemo {
	public static void main(String[] args) {
	//anonymous class: code tai vi tri khai báo khởi tạo đôiks tụpownjg s4ẽ dài hơn 
	//dung khi interface chie có 1 cái hàm trừu tượng và cái phần thực thi bênr trong hàm trừu tượng ngắn 
		
	Shape sh1 = new Shape() {
		@Override
		public void calcS() {
			// TODO Auto-generated method stub
			System.out.println("Circle(sh1) --> calcS ...");
			
		}
	};
	// implementtation class: tại vị trí khai báo ngắn gọn , tốn thêm 1 class
	// Sửu dụng khi interface có nhièu hơn 1 hàm trừu tượng hoặc hàm trừou tượng có phần thực thi code dài 
	sh1.calcS();
	System.out.println();
	
	Shape sh2 = new Circle();
	sh2.calcS();
	
	Square sq = new Square();
	Rectangle rec = new Rectangle();
	
	sq.calcS();
	rec.calcS();
}
}

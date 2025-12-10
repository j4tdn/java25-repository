package inheritance.iinterface;

public class InheritanceInterfaceDemo {
	
	public static void main(String[] args) {
		
		Shape sh1 = new Shape() {
			
			@Override
			public void calcS() {
				System.out.println("Circle(sh1) --> calcS...");
			}
		};
		
		sh1.calcS();
		
		System.out.println();
		// implementation class: tại vị trí khai báo ngắn gọn, tốn thêm 1 class
		// sử dụng khi interface có nhiều hơn 1 hàm trừu trượng hoặc hàm trừu 
		// 	tượng có phần thực thi code dài
		
		Shape sh2 = new Circle();
		sh2.calcS();
		Square sq = new Square();
		Rectangle rec = new Rectangle();
		
		sq.calcS();
		rec.calcS();
	}

}

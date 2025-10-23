package inheritance.iinterface;

public class InheritanceInterfaceDemo {

	public static void main(String[] args) {
		
		
		// anonymous class: code tại vị trí khao báo
		// sử dụng khi interface chỉ có 1 hàm trừu tượng
		Shape sh = new Shape() {
			@Override
			public void calcS() {
				System.out.println("Circle --> calcS ...");
			}
		};
		sh.calcS();
		
		// anonymous class: tốn thêm 1 class
	    // sử dụng khi interface có nhiều hơn 1 hàm trừu tượng
		Shape sh2 = new Circle();
		sh2.calcS();
		
		Square sq = new Square();
		Rectangle rec = new Rectangle();
		
		sq.calcS();
		rec.calcS();
		
	}
	
}

package inheritance.iinterface;

public class InheritanceInterfaceDemo {
	public static void main(String[] args) {
		
		// anonymous class: code tai vi tri khai bao, khoi tao doi tuong se dai hon
		// su dung khi interface chi co 1 ham truu tuong va phan thuc thi ben trong ham truu tuong ngan
		Shape sh1 = new Shape() {
			
			@Override
			public void calcS() {
				System.out.println("Circle(sh1) --> calcS...");
			}
		};
		sh1.calcS();
		
		// implements class: tai vi tri khai bao ngan gon, ton them 1 class
		// su dung khi interface co nhieu hon 1 ham truu tuong hoac ham truu tuong co phan thuc thi code dai
		Shape sh2 = new Circle();
		sh2.calcS();
		
		Square sq = new Square();
		Rectangle rec = new Rectangle();
		
		sq.calcS();
		rec.calcS();
	}
}

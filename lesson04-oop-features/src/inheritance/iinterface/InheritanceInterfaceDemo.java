package inheritance.iinterface;

public class InheritanceInterfaceDemo {
	public static void main(String[] args) {
		
		
		
		Shape sh = new Shape() {
			
			@Override
			public void calcS() {
				System.out.println("Circle --> calcS ...");
			}
		};
		sh.calcS();
		
		System.out.println();
		
		Shape sh2 = new Circle();
		sh2.calcS();
		
		Square sq = new Square();
		Rectangle rec = new Rectangle();
		
		sq.calcS();;
		rec.calcS();;
	}
}

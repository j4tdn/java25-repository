package polymorphism.object;


public class Ex01PolyObjectDemo {
	public static void main(String[] args) {
		 System.out.println("=== khởi tạo các đối tượng thông thường ===");
		 Shape shape1 = new Shape();
		 Rectangle rectangle1 = new Rectangle();
		 Square square1 = new Square();
		 
		 
		 shape1.calcS();
		 square1.calcS();
		 rectangle1.calcS();
		 
		 System.out.println("\n\n=== khởi tạo các đối tượng theo tính chất đa hình ===");
		 Shape s1 = new Square();
		 Shape s2 = new Rectangle();
		 
		 s1.calcS();
		 s2.calcS();
		 
		 s1 = s2;
		 
		 Shape[] shapes = {s1, s2, shape1, square1, rectangle1};
		 int squareCounter = 0;
		 for(Shape shape : shapes) {
			 if(shape != null && shape.getClass() == Square.class) {
				 Square sq = (Square)shape;
				 sq.setBackground();
				 squareCounter++;
				 
			 }
		 }
		 System.out.println("số lượng hình vuông: " + squareCounter);
		 
		 doCalculation(s1);
		 doCalculation(s2);
		 doCalculation(square1);
		 doCalculation(rectangle1);
		 
		 System.out.println("\n\n==============\n");
		 
		 Square sq1 = (Square) new Shape();//lỗi
		 sq1.calcS();
		 sq1.setBackground();
		
	}
	private static void doCalculation(Shape shape) {
		
		
	}
}

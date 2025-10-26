package polymorphism.object;

public class PolyObjectDemo {
	/*
	 * Làm 1 số chức năng liên quan đến hình học 
	 * Square : calculates
	 *Rectangle: calcAreỉ
	 *Circle :tinhS
	 *-->Cùng một chưucs ănng code không đôngf bộ 
	 *
	 *1. Tạo ra 1 class là cha của các class trên 
	 *-Shape 
	 *- Tạo ra hàm chung --> calcs(tổng quan, chưa biết công thưucs cụ thể 
	 *2. Tạo ra cac class con Square ...
	 *-Dùng mặc định nội dunng hàm calss
	 *-Hoặc override lại côngh thức
	 * */
	public static void main(String[] args) {
		// Khởi tạo đối tượng thông thường 
		System.out.println("=== Khởi tạo các đối tươngj thông thường  ===");
		Shape shape1 = new  Shape();
		Rectangle rectangle1 = new Rectangle();
		Square square1 = new Square();
		
		shape1.calcS(); //"Shape#calS"
		square1.calcS();
		rectangle1.calcS();//
		
		System.out.println("");
		Shape s1 = new Rectangle();
		Shape s2 = new Square();
		
		s1.calcS();
		s2.calcS();
		// Khời tạo đối tượng tính chất đa hình 
		/*
		 * Giải thíchs đa hình trong đối tượng 
		 * Biến KDl cha cóthể trỏ đến các đối tượng KDL cou của nó 
		 * Víụ dụ L s1 lúc comple --> KDL shape 
		 * runtime -- kdl Square 
		 * --> chạy in kết quả gọi đén hàma calcs trong Square 
		 * -
		 * 
		 * 1. Tại sao không biến kDl  đối tượng khởi tạo cho chính kdl classcủa nó mà phải lấy biến cha trở đến tư0ọng con 
		 * - Dễ dàng không lấy biến KDL qua về trong phạm vi cha con tạithời điểm  complie 
		 * - Lúc comple cac biến đề là KDL cha: 
		 * -> Tạo mảng tạo danh sách nhận các phần tử là chính nó 
		 * --> Bieens kdl cha cos therr nhaanjk chinhs nos haowjc kdl con, linh hoạt khi truyền tham số qua hàm 
		 * 2. DHTDT biến kdl cha có thể trỏ gán đến KDL con ngươc lại có được không vì sao?
		 * -->Không lúc complekdl concó  thể gọi  tên hàm của riêng nó nhưng nó lúc runtiem  không tìm thấy hgamf đó trong đối tượng cuiar kdl 
		 */
		Shape[] shapes = {s1,s2,shape1,square1,rectangle1};
		Shape r = shapes[4];
		
		// Dem so luong pghan tu trong mang la square
		int squareCounter =0;
		for(Shape shape : shapes) {
			if(shape !=null && shape.getClass() == Square.class) {
				Square sq = (Square) shape;
				sq.setBackground();
				squareCounter++;
			}
			System.out.println("Số lượng hình vuông : "+ squareCounter);
			
		}
	
	}

}

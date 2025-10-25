package polymorphism.object;

public class Ex01PolyObjectDemo {
	
	/*
	 Lam 1 so chuc nang(tinh dien tich) lien quan den hinh hocj
	 - Square: calculateS
	 - Rectangle: calcArea
	 - Circle: tinhS
	 ==> cung 1 chuc nang, code k dong bo --> nhop
	 ==> Xu ly
	 
	 1. Tao ra 1 class la  cha cua cac class tren
	 - Shape
	 - Tao ra hamf chung --> calcS(tong quan, chua biet cong thuc cu the)
	 
	 2. Tao ra cac class con Square, Rectangle, Circle
	 - Dung mac dinh noi dung cua ham calcS
	 - Hoac override lai cong thuc
	 
	 */
	
	public static void main(String[] args) {
		System.out.println("=== Khoi tao cac doi tuong thong thuong ===");
		Shape shape1 = new Shape();
		Rectangle rectangle1 = new Rectangle();
		Square square1 = new Square();
		
		shape1.calcS();
		rectangle1.calcS();
		square1.calcS();
		
		
		System.out.println("\n\n=== Khoi tao cac doi tuong theo tinh chat da hinh ===");
		Shape s1 = new Rectangle();
		Shape s2 = new Square();
		s1.calcS();
		s2.calcS();
		
		/*
		 Giai thich: Da hinh trong doi tuong 
		 Bien KDL cha co the tro den cac doi tuong KDL con cua no
		 Vi du: s1 luc compile --> KDL Shape
		 		   luc runtime --> KDL Square
		 		   			   --> chay in kq  goi den ham calcS trong Square
		 		   			   
		 1. Tai sao k lay bien KDL doi tuong khoi tao cho chinh KDL class cua no ma phai lay bien cha tro den doi tuong con
		 - De dang, linh hoat ep KDL qua ve trong pham vi cha con trong thoi diem conpile
		 - Luc compile cac bien deu la KDL cha:
		 	--> Tao mang, danh sach nhan cac phan tu la chinh no hoac KDL con
		 	--> Bien KDL cha co the nhan chinh no hoac KDL con, linh hoat khi truyen tham so qua ham
		 	
		 2. Da hinh trong doi tuong, bien KDL cha co the tro/gan den KDL con, nguoc lai co dc k, vi sao
		 --> khong, luc compile KDL con co the goi den ham cua rieng no nhung luc runtime k the
		 tim thay ham do trong doi tuong KDL cha
		 
		 */
		
		Shape[] shapes = {s1, s2, square1, rectangle1, shape1};
		
		// Dem so phan tu trong mang la Square
		// Neu la Square --> goi ham setBackGround cua no
		int squareCounter = 0;
		for(Shape shape: shapes) {
			if(shape instanceof Square sq) {
				sq.setBackground();
				squareCounter++;
			}
		}
		System.out.println("So luong hinh vuong: " + squareCounter);
		
		doCalculation(s1);
		doCalculation(s2);
		doCalculation(square1);
		doCalculation(rectangle1);
		
		System.out.println("\n\n==========\n");
		
		Square sq1 = (Square) new Shape();
		sq1.calcS();
		sq1.setBackground();
	}
	
	private static void doCalculation(Shape shape) {
		shape.calcS();
	}
}

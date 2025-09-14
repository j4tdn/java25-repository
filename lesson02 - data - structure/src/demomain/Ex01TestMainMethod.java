package demomain;

public class Ex01TestMainMethod {

	// chuong trinh => .java ==> tao 1 class
	// + cau truc du lieu
	// _giai thuat (tao cac ham de xe ly)
	// .cac ham xu ly logic
	// .ham dac biet: main - noi bat dau va ket thuc cua mot chuong trinh
	
	/*
	 chuong trinh => .java ==> tao 1 class
	 + cau truc du lieu
	 + giai thuat (tao cac ham de xe ly)
	 .cac ham xu ly logic
	 .ham dac biet: main - noi bat dau va ket thuc cua mot chuong trinh
	 . cu phap cua mot ham
	 	
	 	[access_modifier] [static] return_type method_name([arguments]
	 	
	 access_modifier(pham vi truy cap): public/private
	 - public: duoc dung o moi noi trong du an
	 - private: chi duoc dung ben trong class chua no
	 
	 static
	 - neu 1 ham co tu khoa static: co the lay class name goi ham do ma
	 k can phai "khởi tạo đối tượng".
	 
	 return_datatype(kiểu dữ liệu trả về): void, int, string
	 
	 method_name: thuong la [cụm động từ]
	 
	 arguments: tham số đầu vào của hàm
	 
	 */
	// Nơi bắt đầu và kết thúc của 1 chương trình
	public static void main(String[] args) {
		System.out.println(" Main: Test the real one");
		System.out.println("-----");
		main();
	}
	// Khai bao ra 1 ham ten la main, tra ve kieu void va ko co tham so truyen vao
	public static void main() {
		System.out.println("Main: Test the fake one");
		
	}
	public static void sum() {
		System.out.println("Test sum method");
		
	}
	private static void sub() {
		System.out.println("Test sub method");
		
	}
	public void mul() {
		System.out.println("Test mul method");
		
	}
	
}

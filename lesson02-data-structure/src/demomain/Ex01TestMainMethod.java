package demomain;

public class Ex01TestMainMethod {
	
	/*
	 chương trình => .java ==> tạo 1 class
	 + cấu trúc dữ liệu
	 + giải thuật(tạo các hàm để xử lý)
	   . các hàm xử lý logic
	   . hàm đặc biệt: main - nơi bắt đầu và kết thúc của một chương trình
	   . cú pháp của một hàm
	     [access_modifier] [static] return_type method_name([arguments...])
	   
	   1. access_modifier(phạm vi truy cập): public/private
	   - public: được gọi dùng ở mọi nơi trong dự án
	   - private: chỉ được dùng bên trong class chứa nó 
	   
	   2. static
	   - nếu 1 hàm có từ khóa static: có thể lấy class name gọi hàm đó
	     mà không cần phải "khởi tạo đối tượng"
	     
	   3. return_data_tye(KDL trả về): void, int, string
	   
	   4. method_name: thường là [cụm] động từ
	   
	   5. arguments: tham số đầu vào của hàm
	   
	 */
	
	// Nơi bắt đầu và kết thúc của một chương trình
	public static void main(String[] args) {
		System.out.println("Main: Test the real one 1");
		
		System.out.println("-----");
		
		main();
		
		Ex01TestMainMethod.sub();
		// Nếu gọi hàm static, gọi chính bên trong class chứa nó
		// --> ko cần phải lấy tên class gọi nó, gọi trực tiếp
	}
	
	// Khai báo ra một hàm tên là main, trả về void và ko có tham số truyền vào
	public static void main() {
		System.out.println("Main: Test the fake one 2");
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
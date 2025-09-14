package demomain;

public class Ex01TestMainMethod {

	// chương trình => .java ==> tạo 1 class
	// + cấu trúc dữ liệu
	// + giải thuật(tạo các hàm để xử lý)
	//		. các hàm xử lý logic
	//		. hàm đặc biệt: main - nơi start và end của 1 chương trình
	
	/*
	 
	 chương trình => .java ==> tạo 1 class
	 + cấu trúc dữ liệu
	 + giải thuật(tạo các hàm để xử lý)
	 	. các hàm xử lý logic
	 	. hàm đặc biệt: main - nơi start và end của 1 chương trình
	 	. cú pháp 1 hàm
	 	
	 		[access_modifier] [static] return_type method_name([arguments...])
	 	
	 	access_modifier(phạm vi truy cập): public/private
	 	- public: gọi đc ở mọi nơi trong dự án
	 	- private: chỉ đc dùng bên trong class chứa nó
	 	
	 	static
	 	- nếu 1 hàm có từ khóa static: có thể lấy classname gọi hàm đó
	 	  mà ko cần phải "khởi tao đối tượng"
	 	  
	  	return_date_type(KDL trả về): void, int, string
	  	
	  	method_name: thường là [cụm] động từ
	  	
	  	arguments: tham số đầu vào của hàm
	 
	 */
	
	public static void main(String[] args) {
		System.out.println("Main: Test the real one");
		System.out.println("-----");
		
		Ex01TestMainMethod.main();
		
		// Nếu gọi hàm static, gọi chính bên trong class chứa nó
		// --> ko cần phải lấy tên class gọi nó, gọi trực tiếp
	}
	
	// Khai báo 1 hàm tên main, trả về void và ko có tham số truyền vào
	public static void main() {
		System.out.println("Main: Test the fake one");
	}
	
	public static void sum() {
		System.out.println("Test sum method");
	}
	
	public static void sub() {
		System.out.println("Test syb method");
	}
	
	public void mul() {
		System.out.println("Test syb method");
	}
}

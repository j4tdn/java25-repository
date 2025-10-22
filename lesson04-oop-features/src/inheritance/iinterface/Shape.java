package inheritance.iinterface;

public  interface Shape {

	 // Từ 1.1 đến 1.7
	// Interface: chứa các hàm trừu tượng (abstract method): hàm chỉ có phần khai báo , ko có body
	
	// trong KDL con(class) thực thi thì bắt buộc phải override lại
	// Mặc định: tự thêm từ khoá public abstract
	// Mỗi phần dịnh nghĩa trong 1 class hình là khác nhau 
	
	void calcS();
	
	// Các hình học, cần hàm mới --> clear (xoá hình)
	// có phần thực thi là giống nhau cho tất cả các loại hình học 
	// từ  1.8 , hàm trong interface có thể chứa body
	// sử dụng khi có hàm chung(khai báo, thực thi) trong các class --> đưa nó vào interface
	// - chung khai báo
	// - ko bị trùng code override ở class con
	
	//default(public default)
	// static(public static)
	//private
	
	default void clear() {
		System.out.println("Shape#clear");
	}
}

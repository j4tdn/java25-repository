package inheritance.iinterface;

public interface Shape {
	
	// từ 1.1 đến 1.7
	// Interface: chứa các hàm trừu tượng(abstract method): hàm chỉ có phần 
	// 	khai báo, không có phần body
	
	// Trong KDL con(class) thực thi thì bắt buộc phải override lại
	// Mặc định: tự thêm từ khóa public abstract
	
	void calcS();
	
	// các hình học, cần hàm mới --> clear(xóa hình)
	// có phần thực thi là giống nhau cho tất cả các loại hình học
	// từ 1.8, hàm trong interface có thể chứa body
	// sử dụng khi có hàm chung(khai báo, thực thi) trong các class --> đưa nó vào interface
	// - chung khai báo
	// - không bị trùng code override ở class con
	
	// default(public default)
	// static(public static)
	// private
	default void clear() {
		System.out.println("Shape#clear");
	}

}

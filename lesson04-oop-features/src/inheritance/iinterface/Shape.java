package inheritance.iinterface;

public interface Shape {

	// Từ 1.1-1.7
	// Interface: chứa các hàm trừu tượng: hàm chỉ có phần phai báo, k có phần body
	
	// Trong KDL con(class) thực thi thì bắt buộc phải override lại
	// Mặc định tự thêm từ khóa public abstract
	// Mỗi phần định nghĩa trong 1 class hình là khác nhau
	void calcS() ;
	
	// Các hình học, cần làm mới --> clear( xóa hình)
	// Có phần thực thi là giống nhau có tất cả các loại hình học
	// Từ 1.8, hàm trong interface có thể chứa body
	// Sử dụng khi có hàm chung(khai báo, thực thi) trong các class --> đưa nó và interface
	//  - chung khai báo
	//  - k bị trùng code override ở class con
	
	// default(public default
	// static (public static)
	// private
	default void clear() {
		System.out.println("Shape#clear");
	}
	  
}

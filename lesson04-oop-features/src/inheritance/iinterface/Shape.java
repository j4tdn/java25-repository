package inheritance.iinterface;

public interface Shape {

	// Từ 1.1 đến 1.7
	// Interface: chứa các hàm trừu tượng(abstract method): hàm chỉ có phần khai
	// báo, ko có phần body

	// Trong KDL con(class) thực thi thì bắt buộc phải override lại
	// Mặc định: tự thêm từ khóa public abstract

	void calcS();

	// Các hình học, cần ham mới --> clear(xoa hình)
	// Có phần thực thi là giống nhau cho tất cả các loại hình học
	// Từ 1.8, hàm trong interface có thể chứa body
	// Sử dụng khi có hàm chung(khai báo, thực thi) trong các các class -> đưa nó vào interface
	// - chung khai bảo
	// - ko bị trùng code override ở class con
	
	// default(public default)
	// static(public static)
	// private

	default void clear() {

		System.out.println("Shape#clear");

	}

}

package inheritance.iinterface;

public interface Shape {
	// từ 1.1 đến 1.7 
	// Interface: chứa cáchamf trừu tượng(abstrack method): hàm chỉ có phần khia báo, ko có phần body
	
	// Trong KDl con(class) thực thi thì bắt buộc phải override lại
	// mặc định tự thêm từ khóa public abstract
	// mỗi phần định nghĩa trong 1 class hình là khác nhau
	void calcS();
	
	// các hình học cần hàm(clear) mới để xóa hình
	// có phần thực thi là giống nhau cho tất cả cá loại hình học
	// từ java 1.8 hàm trong interface có thể chưá body
	// sử dingj khi có hàm chung(khai báo, thưc thi) trong các class --> đưa nó vào interface
	// - chung khai báo
	// - ko bị trùng code override ở class con
	
	// default(public default)
	// static(public static)
	// private
	default void clear() {
		System.out.println("Shape#clear");
	}

}

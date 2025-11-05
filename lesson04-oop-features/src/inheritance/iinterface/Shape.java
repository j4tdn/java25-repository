package inheritance.iinterface;

public interface Shape {
	// Từ 1.1 đến 1.7
	// Interface: chức các hàm trừu tượng(abstract method): hàm chỉ cos hàm khai bsao, không có phần body
	
	
	//Trong KDl con(class) thyif bắc buộc phải override
	//Mặc định: tự thêm từ khóa public abstract
	// Mỗi phần định nghĩa trong 1 class hình là khcs nhau
	void clacS();
	
	
	// Các hình học, cần hàm mới--> clear(xóa hình)
	// Có phần thưc thi là giống nhau cho tất cả các loại hình học
	// Từ 1.8, hàm trong interface có thể chứa body
	// Sử dụng khi có hàm chung(Khia báo, thực thi) trong các class -> đưa nó vào interface
	//- Chung khai báo
	//- không bị trung code override ở class con
	
	//default(public default)
	//static(public static)
	//private
	
	default void clear() {
		System.out.println("Shape clear");
	}

}

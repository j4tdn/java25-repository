package inheritance.iinterface;

public interface Shape {
		/*
		 * Từ 1.1 đến 1.7
		 * Interface: chứa các hàm trừu tượng (abstract method): hàm chỉ có phần khai báo, ko có phần body
		 * Trong KDL con (class) thực thi thì bắt buộc phải override lại
		 */
	void calcS();
	default void clear() {
		System.out.println("Shape#clear");
	}
}

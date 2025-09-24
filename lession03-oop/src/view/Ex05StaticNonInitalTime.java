package view;

public class Ex05StaticNonInitalTime {
	public static void main(String[] args) {
		s1();
		s2();
		
		Ex05StaticNonInitalTime x1 = new Ex05StaticNonInitalTime();
		x1.ns1();
		x1.ns2();
	}
	//Hàm, thuộc tinh static được khởi tạo cùng thời điểm thực thi class (trước)
	//Hàm, thuộc tinh non static chi được khởi tạo khi tạo ra đối tượng từ class đó [sau)|

	public static void s1() {
		s2();
		// ns2(); từ hàm static ko thế trực tiếp goi hàm non-static vì chưa có đõi tượng nào để gọi hàm static
		Ex05StaticNonInitalTime o1 = new Ex05StaticNonInitalTime();
		o1.ns2();
	}

	public static void s2() {

	}
	private void ns1() {
		ns2();
		s2(); 	// từ hàm non-static có thể goi trực tiếp hàm static,
				// vì hàm static ko phụ thuộc đối tương đang goi và được khởi tạo cùng thời điêm với class
	}
	private void ns2() {
		
	}
}

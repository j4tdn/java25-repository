package view;

public class Ex05StaticNonInitialTime {
	public static void main(String[] args) {
		s1();
		s2();

		Ex05StaticNonInitialTime x1 = new Ex05StaticNonInitialTime();
		x1.ns1();
		x1.ns2();

	}

	// Hàm, thuộc tính stt được khởi tạo cùng thời điêm thực thi class ( trước)

	// Hàm, thuộc tính non-stt chỉ được khởi tạo khi tạo ra đối tượng từ class đó (sau)

	// ví dụ với 2 hàm static
	private static void s1() {
		s2();
		// ns2(); từ hàm static ko thể gọi trực tiếp hàm non-static vì chưa có đối tường nào để gọi hàm static
		Ex05StaticNonInitialTime o1 = new Ex05StaticNonInitialTime();
		o1.ns2();

	}

	private static void s2() {

	}

	// Ex05StaticNonInitialTime object = new Ex05StaticNonInitialTime();
	// object ns1();

	// ví dụ với 2 hàm non -static
	private void ns1() {
		ns2();
		s2();// từ hàm non-stt có thể gọi trực tiếp hàm tt, vì hàm stt ko phụ thuộc đối tượng
				// đang gọi và được khởi tạo cùng thời điểm với class

	}

	private void ns2() {
		
		

	}
}

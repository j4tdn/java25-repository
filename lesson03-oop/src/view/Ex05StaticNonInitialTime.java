package view;

public class Ex05StaticNonInitialTime {

	public static void main(String[] args) {
		
		s1();
		s2();
		
		Ex05StaticNonInitialTime x1 = new Ex05StaticNonInitialTime();
		x1.ns1();
		x1.ns2();
		
	}
	
	// Hàm, tt static được khởi tạo cùng thời điểm thực thi class (trước)
	
	// Hàm, tt non-static chỉ được khởi tạo khi tạo ra object từ class đó (sau)
	
	private static void s1() {
		s2();	
		// ns2(); từ hàm static ko thể gọi hàm non-static vì chưa có đối tượng để gọi
	}
	
	private static void s2() {
		
	}
	
	private void ns1() {
		ns2();
		s2(); // từ hàm non-static có thể gọi trực tiếp hàm static,
			  // vì hàm static ko phụ thuộc object và được khởi tạo cùng thời điểm với class
	}
	
	private void ns2() {
		
	}
	
}

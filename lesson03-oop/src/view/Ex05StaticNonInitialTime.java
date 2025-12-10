package view;

public class Ex05StaticNonInitialTime {
	public static void main(String[] args) {
		
		s1();
		s2();
		
		Ex05StaticNonInitialTime x1 = new Ex05StaticNonInitialTime();
		x1.ns1();
		x1.ns2();
		
	}
	
	// hàm,thuộc tính static được khởi tạo cùng thời điểm thực thi class(trước)
	
	// hàm, thuộc tính non static chỉ được khởi tạo khi tạo ra đối tượng từ class đó (sau)
	
	// ví dụ với 2 hàm static
	private static void s1() {
		s2();
		// ns2(); từ hàm static không thể gọi trực tiếp hàm non-static vì chưa có đối tượng nào để gọi hàm static
		
		Ex05StaticNonInitialTime o1 = new Ex05StaticNonInitialTime();
		o1.ns2();
	}
	
	private static void s2() {
		
	}
	
	private void ns1() {
		ns2();
		s2(); // từ hàm non-sstatic có thể gọi trực tiếp hàm static,
			// vì hàm static không phụ thuộc vào đối tượng đang gọi và được khởi tạo cùng thời điểm với class
		
	}
	
	private void ns2() {
		
	}

}




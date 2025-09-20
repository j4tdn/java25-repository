package view;

public class Ex05StaticNonInititalTime {
	public static void main(String[] args) {
		s1();
		s2();
		
		Ex05StaticNonInititalTime x1 = new Ex05StaticNonInititalTime();
		 x1.ns1();
		 x1.ns2();
	}
	
	// hàm, thuộc tính static được khởi tạo cùng thời điêm thực thi class (trước)
	// hàm, thuộc tính non-static chỉ được khởi tạo khi tạo ra đối tượng từ class đó(sau)
	
	// ví dụ với 2 hàm static
	private static void s1() {
		s2();
		// ns2: từ hàm static ko thể trực tiếp gọi hàm non-static vì chưa có đối tượng nào để gọi hàm static
		
	}
	
	private static void s2() {
		
	}
	
	// vi du voi 2 hamf non-static
	private void ns1() {
		ns2();
		s2(); // từ hàm non-static có thể gọi trực tiếp hàm static, vì hàm static ko phụ thuộc đối tượng đang gọi
		      // và được khởi tạo cùng thời điểm với class
	}
	
	private void ns2() {
		
	}

}

package view;

public class Ex05StaticNonInitalTime {

	public static void main(String[] args) {
		s1();
		s2();
		
		Ex05StaticNonInitalTime x1 = new Ex05StaticNonInitalTime();
		x1.ns1();
		x1.ns2();
		
	}
	
	// Hàm, thuộc tính static được khởi tạo cùng thời điểm thực thi class
	// hàm, thuộc tính non-static chỉ được khởi tạo ra đối tượng từ class đó (sau)
	
	// ví dụ với 2 hàm static
	private static void s1() {
		s2();
		//ns2(); từ hàm static ko thể trược tiếp gọi hàm non-static vì chưa có đối tượng nào để gọi hàm static
		
		Ex05StaticNonInitalTime o1 = new Ex05StaticNonInitalTime();
		o1.ns2();
	}
	
	private static void s2() {
		
	}
	
	// ví dụ với 2 hàm non-static
	private void ns1() {
		ns2();
		s2(); // từ hàm non-static có thể gọi trự tiếp hàm static, vid hàm static không phụ thuộc 
				//đối tượng đnag gọi và đang được khởi tạo cùng thời điểm với class
	}
	
	private void ns2() {
		
	}
	
	
}

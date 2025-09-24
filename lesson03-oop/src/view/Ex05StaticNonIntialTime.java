package view;

public class Ex05StaticNonIntialTime {
	public static void main(String[] args) {
		s1();
		s2();
		Ex05StaticNonIntialTime x1= new Ex05StaticNonIntialTime();
		x1.ns1();
		x1.ns2();
	}
	private static void s1() {
		s2();
		//ns2() từ hàm static khôpng thể trực tiếp gọi hàm non static vì chưa có đối tườn nào để gọi hàm static 
		Ex05StaticNonIntialTime o1= new Ex05StaticNonIntialTime();
		o1.ns1();
		o1.ns2();
		
	}
    private static void s2() {
		
	}
	private void ns1() {
		ns2();
		s2();
		// từ hàm noin static có thể gọi trực tiếp hàm static vì hàm static không phụ thuộc đôi tượng và ddang goi là được khởi tạo cùng thời điểm với 
	}
	private void ns2() {
		
	}
	

}

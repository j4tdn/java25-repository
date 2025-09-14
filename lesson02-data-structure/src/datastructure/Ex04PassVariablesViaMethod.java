package datastructure;

public class Ex04PassVariablesViaMethod {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Khi truyền giá trị tham số qua hàm
	 * 
	 * Tham số chỉ nhận giá trị của ô nhớ {ở STACK}, sao chép 
	 * 	giá trị của biến truyền vào qua tham số
	 * 	còn tham số bên ngoài hoạt động độc lập
	 */
	private static void modify(int e1) {
		int e2 = 77;
		e1 = 28;
	}
	
}

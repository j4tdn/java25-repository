package view;

public class Ex05Throw {
	public static void main(String[] args) {
		System.out.println("=== Bắt đầu chương trình ===\n");
		
		// th1: validated
		System.out.println("Kết quả TH1: " + div(8, 2));
		
		// th2: no validate yet
		try {
			System.out.println("Kết quả TH2: \n" + div(5, 0));
		} catch (ArithmeticException e) {
			System.out.println("th2: " + e.getMessage());
		}

		System.out.println("\n=== Bắt đầu chương trình ===\n");

	}

	/*
	 * nguyên nhân hàm div có thể xảy ra exception --> mẫu số b = 0 ; tham số nhận
	 * từ bên ngoài truyền vào
	 * 
	 * TH1: nếu bên ngoài(chỗ gọi hàm) đã xử lý việc nhập vào mẫu số b luôn !=
	 * 0(validate khi gọi hàm div, không bao giờ xảy ra exception try/catch bên
	 * trong hàm --> thừa
	 * 
	 * TH2: nếu bên ngoài chỗ gọi hàm chưa có validate cho mẫu số b khi gọi hàm div,
	 * vẫn có thể xảy ra exception try/catch hợp lý
	 */
	private static int div(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Vui lòng truyền mẫu số != 0: ");
		}
		return a / b;
	}

}

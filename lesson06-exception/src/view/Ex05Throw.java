package view;

public class Ex05Throw {
	
	// BÀi toán
	// Viết hàm thực hiện phpes chia hai số nguyên
	
	public static void main(String[] args) {
		System.out.println("=======Bắt đầu chương trình =======\n");
		System.out.println("Kết quả TH1: " + div(8, 2));
		
		//tH2: not validate yet
		try {
			System.out.println("Kết quả TH2: " + div(5, 0));
		}catch(ArithmeticException e) {
			System.out.println("TH2 " + e.getMessage());
		}
		
		System.out.println("\n==========Kết thúc============");
	}
	/*
	 * Nguyên nhân hamf div cí thể xảy ra exception
	 * -> mẫu số b = 0: tham số nhận từ ngaoif truyyeenf vào
	 * 
	 * TH!: nếu bne
	 */
	
	private static int div(int a, int b) {
		if(b == 0) {
			throw new ArithmeticException("vui lòng truyền Mẫu số khác 0");
		}
		return a / b;
	}

}

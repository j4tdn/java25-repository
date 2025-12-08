package view;

public class Ex05Throw {
	// BÀi toán viết 1 hàm thực hiện phép chia 2 sốnguyen
	
	public static void main(String[] args) {
		System.out.println("=== Bắt đầu chương tìh ===\n");
		//th1:validated
		System.out.println("Kết quả: "+ div(8,2));
		//th2: not validate yet
		try {
			System.out.println("Kết quả: "+ div(5,0));
		}catch(ArithmeticException e) {
			System.out.println("th2: "+ e.getMessage());
		}
		System.out.println("=== Ket thuc chuong trinh ===");
	}
	/*
	 * Nguyên nhân hàm div có thể xảy ra exception
	 * --> Mấu số b = 0: tham sô nhận từ ben ngoài truyền vào 
	 * 
	 * Th1: nếu bên ngoài (chỗ nao hàm) đã xử lí việc nhập vào mẫu số b luôn !=0( validation)
	 *     khi gọi hàm div, không bao giờ xảy ra exception 
	 *     try/catch bên trong hàm --> thừa
	 * Th2: nếu bên ngoài(chỗ gọi nàm) chưa có validation cho maasus số b 
	 *     khi gọi hàm div, vẫn có thể xảy ra exception 
	 *     try/catch hợp lí
	 *     
	 */
	
	
	
	private static int div(int a,int b) {
		if(b==0) {
			throw new ArithmeticException("Vui long truyen mau so !=0 ");
		}
		return a/b;
	}
}

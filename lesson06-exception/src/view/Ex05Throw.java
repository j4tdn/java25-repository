package view;

public class Ex05Throw {
	
	/*
	 Bài toán: Viêt hàm thực hiện phép chia 2 sôs nguyên
	 */
	
	public static void main(String[] args) {
		System.out.println("=== Bắt đầu chưa trình  ===\n");
		
		//th1: validated
		System.out.println("Kết quả: "+div(8,2));
		
		//th2: not validate yet
		try {
			System.out.println("Kết quả th2: "+div(5,0));
		} catch (ArithmeticException e) {
				System.out.println("th2: "+ e.getMessage());
		}
	
		System.out.println("=== Kết thúc chưa trình  ===");
	}
	
	/*
	 Nguyên nhân hàm div có thể xảy r exception
	 --> Mẫu số b= 0 : Tham số nhận từ bên ngoài truyền vào
	 
	 Th1: Nếu bên ngoài(chỗ gọi hàm ) đã xử lí việc nhập vào mẫu số b luốn khác 0
	 		Khi gọi div ko bao giờ xảy ra exception
	 		try/catch bên trong hàm--> thừa
	 		
	 Th2: Nếu bên ngoài (chỗ gọi hàm ) chưa có validate cho mẫu số b
	 		Khi gọi div vẫn có thể xảy ra exception
	 		try/catch hợp lí
	 */
	
	private static int div(int a, int b) {
		if(b==0) {
			throw new ArithmeticException("Vui lòng truyền mẫu số !=0");
		}
		return a/b;
	}
	
}

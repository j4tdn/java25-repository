package datastructure.primitive;

public class Ex04PassVariablesViaMethod {
	public static void main(String[] args) {
		
		// Cứ mối khi truyền vào 2 số nguyên 
		// Lấy tổng của 2 số đó -> "2 --> ^2
		
		int a1 = 2;
		int a2 = 3;
		int a12 = a1 + a2;
		double da12 = Math.pow(a12, 2);
		double pa12 = da12 * da12;
		
		System.out.println("Resutl a: " + pa12);
		
		
		
		int b1 = 5;
		int b2 = 1;
		int b12 = b1 + b2;
		double db12 = Math.pow(b12, 2);
		double pb12 = db12 * db12;
		System.out.println("Resutl b: " + pb12);
		
		
		int c1 = 3;
		int c2 = 2;
		int c12 = doCalc(c1, c2);
		System.out.println("c12: " + c12);
		
		int d12 = doCalc(1, 15);
		System.out.println("d12: " + d12);
		
		
		
		int e1 = 5;
		int e2 = 7;
		
		//ketqua1
		System.out.println("e1: " + e1);
		System.out.println("e2: " + e2);
		
		//ketqua2
		modify(e1);
		System.out.println("e1: " + e1);
		System.out.println("e2: " + e2);
		
		//ketqua3
		modify(e2);
		System.out.println("e1: " + e1);
		System.out.println("e2: " + e2);
		
		
		
	}
	/*
	 * Khi truyền gtri tham số qua hàm 
	 * 
	 * 
	 * tham số chỉ nhận gtri của ô nhớ { ở Stack}, sao chép gtri của biến  truyền vào qua tham số
	 * Còn tham số và biến bên ngoài hoạt động độc lập
	 * 
	 * --> Khi truyền gtri cho tham số, là KDL nguyên thủy --> sau khi gọi làm xong nếu không có return hay gán lại
	 * --> 100% biến truyền vào đó sẽ không thay đổi
	 * 
	 * */
	private static void modify(int e1) {
		int e2 = 77;
		 e1 = 28;
	}
	
	
	
	
	/*
	 * Khi tạo hàm cần biết:
	 * 	-Hàm đó có thể dùng ở đâu
	 * 	- [static] để lấy class gọi
	 * 	- KDL trả về: logic của hàm này xử lý xong thì sẽ trả về kết quả hay là kh trả về(void)
	 * 	- Tên hàm
	 * 	-Tham số truyền vào(KDL tên biến): arguments
	 * 
	 * 
	 * */
	
	//Khai báo hàm doCalc, nhận vào 2 tham số arg1, arg2
	//Chỗ nào gọi hàm doCalc thì phải truyền gtri cho 2 tham số đó
	public static int doCalc(int arg1, int arg2) {
		int arg12 = arg1 + arg2;
		int darg = arg12 *2;
		int parg = darg + darg;
		return parg;
	}
	
	
}

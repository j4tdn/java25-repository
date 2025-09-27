package datastructure.primitive;

public class Ex04PassVariablesViaMethod {
	
	public static void main(String[] args) {
		
		// Cứ mỗi khi truyền vào 2 số nguyên
		// Lấy tổng của 2 số đó --> * 2 --> ^2
		int a1 = 2;
		int a2 = 3;
		int a12 = a1 + a2;
		int da12 = a12 * 2;
		int pa12 = da12 * da12;
		System.out.println("pa12: " + pa12);
		
		
		int b1 = 5;
		int b2 = 1;
		int b12 = b1 + b2;
		int db12 = b12 * 2;
		int pb12 = db12 * db12;
		System.out.println("pb12: " + pb12);
		
		int c1 = 3;
		int c2 = 2;
		int c12 = doCalc(c1, c2);
		System.out.println("c12: " + c12);
		
		int d12 = doCalc(1, 5);
		System.out.println("d12: " + d12);
		
		int e1 = 5;
		int e2 = 7;
		
		System.out.println("e1: " + e1); // 5
		System.out.println("e2: " + e2); // 7
		
		modify(e1);
		
		// sau khi gọi modify e1
		System.out.println("e1: " + e1); // 28 5
		System.out.println("e2: " + e2); // 7  7
		
		modify(e2);
		
		// sau khi gọi modify e2
		System.out.println("e1: " + e1); // 28 5
		System.out.println("e2: " + e2); // 77 7
	}
	
	/*
	 * Khi truyền giá trị cho tham số qua hàm
	 * 
	 * Tham số chỉ nhận giá trị của ô nhớ {ở STACK}, sao chép giá trị của biến truyền vào qua tham số
	 * Còn tham số và biến bên ngoài hoạt động độc lập
	 * 
	 * --> Khi truyền giá trị cho tham số, là KDL nguyên thủy --> sau khi gọi hàm xong nếu ko có return hay gán lại
	 * --> 100% biến truyền vào đó sẽ ko thay đổi
	 */
	
	// modify(e1); int e1 = e1;
	private static void modify(int e1) {
		int e2 = 77;
		e1 = 28;
	}
	
	/*
	 * Khi tạo hàm cần biến
	 * - Hàm đó có thể dùng ở đâu
	 * - [static] để lấy class gọi
	 * - KDL trả về: logic của hàm này xử lý xong thì sẽ trả về kết quả hay là ko trả về(void)
	 * - Tên hàm
	 * - Tham số truyền vào(KDL tên biến): arguments
	 */
	
	// Khai báo hàm doCalc, nhận vào 2 tham số arg1, arg2
	// Chỗ nào gọi hàm doCalc thì phải truyền giá trị cho 2 tham số đó
	// doCalc(c1, c2)
	// int arg1 = c1; int arg2 = c2;
	
	// doCalc(1, 5);
	// int arg1 = 1; int arg2 = 5;
	private static int doCalc(int arg1, int arg2) {
		int arg12 = arg1 + arg2;
		int darg = arg12 * 2;
		int parg = darg * darg;
		return parg;
	}
	
}

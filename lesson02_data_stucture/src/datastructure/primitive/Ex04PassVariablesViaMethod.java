package datastructure.primitive;

public class Ex04PassVariablesViaMethod {
	public static void main(String[] args) {
		
		/*
		 * cứ mỗi khi truyền vào 2 số nguyên 
		 * Lấy tổng của 2 số nguyên đó --> * 2 --> ^2
		 */
		
		int a1 = 2;
		int a2 = 3;
		int a12 = a1 + a2;
		int da12= a12 * 2;
		int pa12 =  da12 * da12;
		System.out.println("pa12:" + pa12);
		
		int b1 = 5;
		int b2 = 1;
		int b12 = b1 + b2;
		int db12= b12 * 2;
		int pb12 =  db12 * db12;
		System.out.println("pb12:" + pb12);
		
		int c1 = 3;
		int c2 =2;
		int c12 = doCalc(c1,c2);
		System.out.println("c12:" + c12);
		
		
		int d12 = doCalc(1, 5);
		System.out.println("d12:"+ d12);
		
		
		int e1 = 5;
		int e2 = 7;
		
		System.out.println("e1:" + e1);
		System.out.println("e2:" + e2);
		
		modify(e1);
		System.out.println("e1:" + e1);
		System.out.println("e2:" + e2);
		
		modify(e2);
		System.out.println("e1:" + e1);
		System.out.println("e2:" + e2);
		
		
	}
	
	/*
	 * khi truyền giá trị cho tham số qua hàm
	 * 
	 * tham số chỉ thận gía trị của ô nhớ ở STACK, sao chép giá trị của biến truyền vào qua tham số
	 * còn tham số và biến bên ngoài hoạt dộng đọc lập
	 * 
	 * --> khi truyền giá trị cho một tham số, là KDL nguyên thủy --> sau lhi gọi hàm xong nếu ko có return hay gán lại
	 * --> 100% biến truyền vào đó sẽ ko thay đổi
	 */
	
	private static void modify(int e1) {
		
		int e2 = 77;
		e1 = 28;
	}
	
	/*
	 * khi tạo hàm cần biết'
	 *  - hàm đó dùng ở đâu
	 *  - [static] để lấy class gọi
	 *  - KDL trả về' logic của hàm này xử lý xong thì sẽ trả về kết quả hay là không trả về
	 *  - tên hàm
	 *  - tham số truyền vào(KDL ten bien): argument
	 */
	 
	// khai báo hàm docalc, nhận vào 2 tham số arg1, arg2
	// chỗ nào gộ hàm docalc thì phải tryuền giá trị cho 2 thaam số
	// docalc(c1, c2)
	// int arg1 = c1; int arg2 = c2
	
	// docalc(1,5);
	// int agr1 = 1; arg2 = 5;
	private static int doCalc(int arg1, int arg2) {
		int arg12 = arg1 + arg2;
		int darg = arg12 * 2;
		int parg = darg * darg;
		return parg;
		
		
		
		
	}

}

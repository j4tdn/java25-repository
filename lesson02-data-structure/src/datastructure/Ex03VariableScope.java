package datastructure;

public class Ex03VariableScope {
	
	/*
	 * Chương trình: gồm 2 phần
	 * - cấu trúc dữ liệu: biến để lưu trữ dữ liệu
	 * - giải thuật: các hàm, phương thức
	 * 			   : khai báo các biến bên trong để xử lý
	 */
	
	
	private static int g1 = 555;
	private static int gc = 222;
	
	public static void main(String[] args) {
		
		int gc = 33;
		System.out.println("gc at main: " + (gc + Ex03VariableScope.gc));
		
		int m1 = 12;
		int m2 = 22;
		
		int result = m1 + m2;
		System.out.printf("m1(%s) + m2(%s) = %s", m1, m2, result);
		
		dummy();
		
	}
	
	// khai báo hàm tên là dummy - ko có tham số truyền vào, KDL trả về là void
	private static void dummy() {
		
	}

}

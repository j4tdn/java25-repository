package datastructure.primitive;

public class Ex03VariableScope {
	
	/*
	 * Chương trình: gồm 2 phần
	 * - cấu trúc dữ liệu: khai báo biến để lưu trữ dữ liệu
	 * - giải thuật: các hàm, phương thức
	 *             : khai báo các biến bên trong để xử lý
	 *             
	 * Biến cục bộ
	 * - Cú pháp: [final] data_type variable_name;
	 * - Phạm vi sử dụng: block scope
	 * 
	 * Biến toàn cục
	 * - Cú pháp: [access modifier] [static] [final] data_type variable_name;
	 * - Phạm vi sử dụng: phụ thuộc vào access modifier
	 *   private: dùng bên trong class chứa nó
	 *   public : dùng, gọi mọi nơi
	 *             
	 */
	
	private static int g1 = 555;
	private static int gc = 222;
	
	public static void main(String[] args) {
		
		int gc = 33;
		System.out.println("gc at main: " + (gc + Ex03VariableScope.gc));
		
		int m1 = 12;
		int m2 = 22;
		
		int result = m1 + m2;
		System.out.printf("m1(%s) + m2(%s) = %s\n", m1, m2, result);
		
		{
			int m3 = 24;
			System.out.println("m1: " + m1);
		}
		
		// System.out.println("m3: " + m3);
		System.out.println("Use g1 at main method: " + g1);
		
		g1 = 777;
		
		// gọi để thực thi nội dung bên trong hàm dummy
		System.out.println("\n-------------");
		dummy();
	}
	
	// khai báo hàm tên là dummy - ko có tham số truyền vào, KDL trả về là void
	private static void dummy() {
		System.out.println("Calling dummy method ...");
		
		int gc = 99;
		System.out.println("gc at dummy: " + gc);
		
		// System.out.println("m1 value: " + m1);
		System.out.println("Use g1 at dummy method: " + g1);
	}
	
}
package datastructure.primitive;

// Chương trình gồm 2 phần:
//	 --Cấu trúc dữ liệu:Khai báo biến để lưu trữ dữ liệu 
//	 --Giải thuật: Các hàm, phương thức
//   --				Khai báo các biến bên trong để xử lý
public class Ex03VariableScope {
	private static int g1 = 555;
	private static int gc = 222;

	public static void main(String[] args) {

		int gc = 33;
		System.out.println("gc at main: " + (gc + Ex03VariableScope.gc));

		int m1 = 12;
		int m2 = 22;

		int result = m1 + m2;
		System.out.printf("m1(%s) + m2(%s) = %s%n", m1, m2, result);

		{
			int m3 = 24;
			System.out.println("m3: " + m3);
		}

		// System.out.println("m3: " + m3);
		System.out.println("Use g1 at main method: " + g1);

		g1 = 777;
		System.out.println("v-------------v");
		dummy();
	}

	// khai báo hàm tên là dummy – không có tham số truyền vào, KDL trả về là void
	private static void dummy() {
		System.out.println("calling dummy method ....");
		int gc = 99;
		System.out.println("gc at dummy: " + gc);

		System.out.println("Use g1 at dummy method: " + g1);

		// System.out.println("m1 value: " + m1);
	}

}

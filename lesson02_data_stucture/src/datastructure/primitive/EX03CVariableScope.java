package datastructure.primitive;

public class EX03CVariableScope {
	
	/*
	 *  1 chương trình gồm 2 phần
	 *   - cấu trúc dữ liệu: khai báo biến để lưu trữ dữ liệu
	 *   - giải thuật: các hàm, phương thức
	 *               : khai báo các biến bên trong để xử lí
	 *  Biến cục bộ 
	 *   - phạm vi sử dụng: BLOCK SCOPE
	 *   - cú pháp[final] data_type variable_name
	 *  
	 *  Biến toàn cục
	 *   - phạm vi sử dụng' phụ thuộc vào accsess modifier 
	 *   - cu phap: [accsess modifier] [static] [final] data_type variable_name
	 *                
	 */
	private static int g1 = 555;
	private static int gc = 222;
	
	public static void main(String[] args) {
		
		int gc = 33;
		System.out.println("gc at main:" + (gc + EX03CVariableScope.gc));
		
		int m1 = 12;
		int m2 = 22;
		
		int result = m1 + m2;
		System.out.printf("m1(%s) + m2(%s) = %s\n", m1, m2, result);
		
		{
		int m3 = 24;
		System.out.println("m1:" + m1);
		}
		
		System.out.println("Use g1 at main method:"+g1);
		
		g1 = 777;
		
		System.out.println("\n--------------");
		// gọi để thực thi nội dung bên trong hàm dammy
		dumny();
		
		
	}
	
	// khai báo hàm tên là dummy, ko có tham số truyền vào, KDL trả về là void
	private static void dumny() {
		
		System.out.println("Calling dummy method");
		
		int gc = 99;
		System.out.println("gc at dummy:" + gc);
		
		System.out.println("Use g1 at dummy method" + g1);
		
		
		
		
	}

}

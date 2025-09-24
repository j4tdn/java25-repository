package datastructure.primitive;

public class Ex01PrimitiveTypeDeclaration {
	
	public static void main(String[] args) {
		System.out.println("=== Start Main method ===");
		// khai báo và gán giá trị mặc định cho các biến a, b, c, d
		// kiểm tra giá trị trong phạm vi cho phép của KDL lúc compile
		int a = 12;
		int b = 24;
		
		float c = 7.8f;
		double d = 22.6;
		
		// khai báo một biến e có KDL là char
		char e;
		
		// không thể in ra một biến mà chỉ mới khai báo - chưa sử dụng để tính toán hay gán giá trị lại
		// System.out.println("e1 --> " + e);
		
		// Gán giá trị % cho e
		e = '^';
		
		boolean f1 = true;
		boolean f2 = false;
		
		// println: in kết quả ra xong xuống dòng
		// print: in kết quả ra
		// printf: in với format
		
		System.out.println("a --> " + a);
		System.out.println("b --> " + b);
		System.out.println("c --> " + c);
		System.out.println("d --> " + d);
		
		System.out.printf("e2 --> %s\n", e);
		System.out.println("f1 --> " + f1 + ", f2 --> " + f2);
		System.out.printf("f1 --> %s, f2 --> %s\n", f1, f2);
		
		logging();
		
		
		
		System.out.println("=== Finish Main method");
	}
	
	private static void logging() {
		System.out.println("logging >> final result 999");
	}
	
}
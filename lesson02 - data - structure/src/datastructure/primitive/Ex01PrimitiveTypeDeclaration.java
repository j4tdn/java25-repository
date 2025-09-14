package datastructure.primitive;

public class Ex01PrimitiveTypeDeclaration {
	public static void main(String[] args) {
		//khai báo và gán giá trị mặc định
		// kiểm tra giá trị trong phạm vi cho phep của KDL lúc compile
		int a= 12;
		int b= 24;
		float c= 7.8f;
		double d=22.6;
		
		// Gán giá trị % cho e
		char e;
		// K thể in ra 1 biến mà chỉ mới khai báo - chưa sử dụng để tính toán hay gán giá trị
		//System.out.println("e1 --> "+ e);
		e= '^';
		
		// println: in kq ra xong xuống dòng
		// print: in kq ra
		// printf: in với format
		boolean f1= true;
		boolean f2= false;
		System.out.println("a: "+ a);
		System.out.println("b: "+ b);
		System.out.println("c: "+ c);
		System.out.println("d: "+ d);
		System.out.printf("e: %c\n", e);
		System.out.printf("f1 --> %s, f2 --> %s\n ", f1, f2);
		logging();
	}
	private static void logging() {
		System.out.println("logging >> final result 999");
	}
}

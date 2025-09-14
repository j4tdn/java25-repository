package datastructure.primitive;

public class Ex01PrimitiveTypeDeclaration {
	public static void main(String[] args) {
		System.out.println("Start main method");
		// Khai bao va gan gia tri mac dinh cho cac bien a, b, c, d
		int a = 12;
		int b = 24;
		
		float c = 7.8f;
		double d = 22.6d;
		
		// Khai bao 1 bien e co kieu du lieu la char
		char e;
		
		// Trong java k the in mot bien ma chi moi khai bao - chua su dung de tinh toan hay gan gia tri lai
		//System.out.println("e1--->" + e);
		
		
		// Gan gia tri "@" cho e
		e = '@';
		
		boolean f1 = true;
		boolean f2 = false;
		
		// printf: in voi format
		System.out.println("a--->" + a);
		System.out.println("b--->" + b);
		System.out.println("c--->" + c);
		System.out.println("d--->" + d);
		
		System.out.printf("e---> %s\n" , e);
		System.out.println("f1--->" + f1 + ", f2--->" +f2);
		System.out.printf("f1--->%s, f2--->%s\n", f1, f2);
		
		logging();
		
		System.out.println("Finish main method");
	}
	private static void logging() {
		System.out.println("Logging >> final result 999");
	}
}

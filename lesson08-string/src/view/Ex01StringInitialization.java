package view;

public class Ex01StringInitialization {

	public static void main(String[] args) {

		// String(Immutable)
		
		// Khai báo theo kiểu String Literal
		String l1 = "hello";
		String l2 = "welcome";
		String l3 = "hello";
		System.out.println("=============== String Literal =================");
		System.out.println("l1 address: " + System.identityHashCode(l1));
		System.out.println("l2 address: " + System.identityHashCode(l2));
		System.out.println("l3 address: " + System.identityHashCode(l3));
		
		// Khai báo theo kiểu String Object
		System.out.println("=============== String Object =================");
		String o1 = new String("water");
		String o2 = new String("cake");
		String o3 = new String("water");
		System.out.println("o1 address: " + System.identityHashCode(o1));
		System.out.println("o2 address: " + System.identityHashCode(o2));
		System.out.println("o3 address: " + System.identityHashCode(o3));
		
		
		// --> 100% using String Literal
	}
	
}

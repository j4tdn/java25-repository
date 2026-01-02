package view;

public class Ex01StringInitialization {
	
	public static void main(String[] args) {
		// String(Immutable)
		
		// Khai báo theo kiểu String Literal
		String l1 = "hello";   // H1
		String l2 = "welcome"; // H2
		String l3 = "hello";   // H1
		System.out.println("============ String Literal ============");
		System.out.println("l1 address: " + System.identityHashCode(l1));
		System.out.println("l2 address: " + System.identityHashCode(l2));
		System.out.println("l3 address: " + System.identityHashCode(l3));
		
		// Khai báo theo kiểu String Object
		String o1 = new String("water"); // X1
		String o2 = new String("cake");  // X2
		String o3 = new String("water"); // X3
		System.out.println("\n============ String Object ============");
		System.out.println("o1 address: " + System.identityHashCode(o1));
		System.out.println("o2 address: " + System.identityHashCode(o2));
		System.out.println("o3 address: " + System.identityHashCode(o3));
		
		// Giống nhau của String Literal và Object --> immutable
		// Một đối tượng được tạo ra thì ko thể cập nhật giá trị
		
		l1 = "long text"; // H4
		o1 = "short text"; // X4
		
		System.out.println("\n============ Post Update ============");
		System.out.println("l1 address: " + System.identityHashCode(l1));
		System.out.println("l3 address: " + System.identityHashCode(l3));
		
		System.out.println("o1 address: " + System.identityHashCode(o1));
		System.out.println("o3 address: " + System.identityHashCode(o3));
		
		// --> 100% using String Literal
	}
	
}
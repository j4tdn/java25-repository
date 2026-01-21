package view;

public class Ex01StringInittialization {
	public static void main(String[] args) {
		
		// String(immutable)
		
		// khai bao theo kieu String literal
		String l1 = "hello";    // H1
		String l2 = "wellcome"; // H2
		String l3 = "hello";    // H1
		
		System.out.println("============= String Literal ===============");
		System.out.println("l1 address: " + System.identityHashCode(l1));
		System.out.println("l2 address: " + System.identityHashCode(l2));
		System.out.println("l3 address: " + System.identityHashCode(l3));

		// khai bao theo kieu String Object
		String o1 = new String("water");  // X1
		String o2 = new String("cake");   // X2
		String o3 = new String("water");  // X3
		
		System.out.println("============= String Object ===============");

		System.out.println("o1 address: " + System.identityHashCode(o1));
		System.out.println("o2 address: " + System.identityHashCode(o2));
		System.out.println("o3 address: " + System.identityHashCode(o3));
		
		// giống nhâu của String literal và Object --> immutalbe
		// Một đối tượng được tạo ra thì ko thể cập nhật giá trị được
		
		l1 = "Long Text";
		o1 = "Short text";
		
		System.out.println("============= String Update ===============");

		System.out.println("l1 address: " + System.identityHashCode(l1));
		System.out.println("l3 address: " + System.identityHashCode(l3));
		
		System.out.println("o1 address: " + System.identityHashCode(o1));
		System.out.println("o3 address: " + System.identityHashCode(o3));
		
		// 100% using String Literal

		
	}

}

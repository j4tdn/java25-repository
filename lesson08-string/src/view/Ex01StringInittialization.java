package view;

public class Ex01StringInittialization {
	
	public static void main(String[] args) {
		
		//String(Immutable)
		
		// khai báo theo kiểu String literal
		String l1 = "hello"; 	//H1
		String l2 = "wellcome";	//H2
		String l3 = "hello";	//H3
		System.out.println("============String literal===============");
		System.out.println("l1 address: " + System.identityHashCode(l1));
		System.out.println("l2 address: " + System.identityHashCode(l2));
		System.out.println("l3 address: " + System.identityHashCode(l3));
		
		// Khai báo theo kiểu String object
		String o1 = new String("water"); 	// X1
		String o2 = new String("cake");		// X2
		String o3 = new String("water");	// X3
		System.out.println("\n=================String object ===========");
		System.out.println("o1 address: " + System.identityHashCode(o1));
		System.out.println("o2 address: " + System.identityHashCode(o2));
		System.out.println("o3 address: " + System.identityHashCode(o3));
		
		// Giống nhau của string literal và object --> immutable
		// một đối tượng đơcj tạo ra  thì ko thể cập nhâpj giá trị
		
		l1 = "long text";
		o1 = "short text";
		
		System.out.println("\n==============post update===========");
		System.out.println("l1 address: " + System.identityHashCode(l1));
		System.out.println("l3 address: " + System.identityHashCode(l3));
		
		System.out.println("o1 address: " + System.identityHashCode(o1));
		System.out.println("o3 address: " + System.identityHashCode(o3));
		
		// --> 100% using String Literal
	}

}

package view;

public class Ex01StringInitialization {

	public static void main(String[] args) {
		
		// String(Immutable)
		
		// Khai bao theo kieu String Literal
		String l1 = "Hello"; // H1
		String l2 = "Welcome"; // H2
		String l3 = "Hello"; // H3
		System.out.println("==========String Literal=============");
		System.out.println("l1 adress: " + System.identityHashCode(l1));
		System.out.println("l2 adress: " + System.identityHashCode(l2));
		System.out.println("l3 adress: " + System.identityHashCode(l3));
		
		// Khai bao theo kieu String Object
		String o1 = new String("Water"); // X1
		String o2 = new String("Cake"); // X2
		String o3 = new String("Water"); // X3
		System.out.println("==========String Object=============");
		System.out.println("o1 adress: " + System.identityHashCode(o1));
		System.out.println("o2 adress: " + System.identityHashCode(o2));
		System.out.println("o3 adress: " + System.identityHashCode(o3));
		
		
		// Giong nhau String Literal va String Object --> immutable
		// mot doi tuong ddc tao ra thi k the cap nhat gia tri
		
		l1 = "long text"; // H4
		o1 = "short text"; // X4
		
		System.out.println("==========Post Update=============");
		System.out.println("l1 adress: " + System.identityHashCode(l1));
		System.out.println("l3 adress: " + System.identityHashCode(l3));
		
		System.out.println("o1 adress: " + System.identityHashCode(o1));
		System.out.println("o3 adress: " + System.identityHashCode(o3));
		
		// --> 100% using String Literal
	}
	
}

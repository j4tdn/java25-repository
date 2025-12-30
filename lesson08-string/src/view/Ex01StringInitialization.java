package view;

public class Ex01StringInitialization {
	public static void main(String[] args) {
		//String (Immutable)
		
		//Khai báo theo kiểu String Literal
		String l1 = "hello"; 	//H1
		String l2 = "welcome";	//H2
		String l3 ="hello";		//H3
		System.out.println("=====String Literal=====");
		System.out.println("l1: "+ System.identityHashCode(l1));
		System.out.println("l2: " +System.identityHashCode(l2));
		System.out.println("l3: "+ System.identityHashCode(l3));
		
		//Khai báo theo kiêu String Object
		System.out.println("=====String Object=====");
		String o1 = new String("water");	//x1
		String o2 = new String("cake");		//x2
		String o3 = new String("water");	//x3
		System.out.println("o1: "+ System.identityHashCode(o1));
		System.out.println("o2: "+ System.identityHashCode(o2));
		System.out.println("o3: "+ System.identityHashCode(o3));
		
		//Giống nhau cua string Literal và Object -->Immutable
		//Một dối tượng được tạo ra thì không thể cập nhập gtri
		
		l1 = "long test"; //H4
		o2 = "short text"; //x4
		
		System.out.println("=====Post Update=====");
		System.out.println("l1: "+ System.identityHashCode(l1));
		System.out.println("l3: "+ System.identityHashCode(l3));
		
		System.out.println("o1: "+ System.identityHashCode(o1));
		System.out.println("o3: "+ System.identityHashCode(o3));
		
	}
}

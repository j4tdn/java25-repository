package view;

public class Ex02StringComparision {

	public static void main(String[] args) {
		
		// so sánh 2 chuỗi
		// boolean: equals(...) --> Object#equals(==, compare address) 
		//		--> String#equals(override, value)
		// int
		String l1 = "hello";
		String l2 = "welcome";
		String l3 = "hello";
		
		System.out.println("(l1==l2) --> " + (l1 == l2));
		System.out.println("(l2==l3) --> " + (l2 == l3));
		System.out.println("(l1==l3) --> " + (l1 == l3));
		
		System.out.println("(l1 eq l2) --> " + l1.equals(l2));
		System.out.println("(l2 eq l3) --> " + l2.equals(l3));
		System.out.println("(l3 eq l4) --> " + l1.equals(l3));
		
		System.out.println("(l3 cpt l4) --> " + l2.compareTo(l1));
		System.out.println("(dyiqi cpt w) --> " + ("dyiqi".compareTo("k")));
		
	}
	
}

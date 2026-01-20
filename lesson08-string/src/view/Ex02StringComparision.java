package view;

public class Ex02StringComparision {

	public static void main(String[] args) {
		
		// so sanh 2 chuoi
		// boolean: equals(...) --> Objects#equals --> String#equals
		// int: compareTo(...)
		
		String l1 = "Hello"; // H1
		String l2 = "Welcome"; // H2
		String l3 = "Hello"; // H3
		
		System.out.println("(l1==l2) --> " + (l1==l2));
		System.out.println("(l2==l3) --> " + (l2==l3));
		System.out.println("(l1==l3) --> " + (l1==l3));
		
		System.out.println();
		
		System.out.println("(l1 eq l2) --> " + (l1.equals(l2)));
		System.out.println("(l2 eq l3) --> " + (l2.equals(l3)));
		System.out.println("(l1 eq l3) --> " + (l1.equals(l3)));
		
		System.out.println();
		
		System.out.println("(l1 cpt l2) --> " + (l1.compareTo(l2)));
		
		System.out.println("(dfghjk cpt w) --> " + ("dfghjk".compareTo("k")));
		
	}
	
}

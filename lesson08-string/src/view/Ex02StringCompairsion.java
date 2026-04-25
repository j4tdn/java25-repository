package view;

public class Ex02StringCompairsion {
	
	//So sánh 2 chuỗi
	// boolean: equals (...) --> objects#equals(==, compare address)  --> String#equals(ovveride, value)
	// int: compareTo(...)
	
	public static void main(String[] args) {
		String l1 = "hello"; 	//H1
		String l2 = "wellcome";	//H2
		String l3 = "hello";	//H3
		
		System.out.println( "(l1==l2) --> " + (l1==l2));
		System.out.println( "(l2==l3) --> " + (l2==l3));
		System.out.println( "(l1==l3) --> " + (l1==l3));
		
		System.out.println();
		
		System.out.println("(l1 eq l2) --> " + (l1.equals(l2)));
		System.out.println("(l2 eq l3) --> " + (l2.equals(l3)));
		System.out.println("(l1 eq l3) --> " + (l1.equals(l3)));
		
		System.out.println();
		
		System.out.println("(l1 cpt l2) --> " + (l1.compareTo(l2)));
		
		System.out.println("(dyiqi cpt w) --> " + ("dyiqi".compareTo("k")) );
		
	}

}

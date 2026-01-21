package view;

public class Ex02StringComparision {
	public static void main(String[] args) {
		// so sánh 2 chuỗi 
		// bôlean: equal  --> Object#equal  --> String#equal
		// int: compareTo(...)
		
		String l1 = "hello";    // H1
		String l2 = "wellcome"; // H2
		String l3 = "hello";    // H1
		System.out.println("(l1==l2): " + (l1==l2));
		System.out.println("(l2==l3): " + (l2==l3));
		System.out.println("(l3==l1): " + (l3==l1));
		
		System.out.println("=======================");
		
		System.out.println("(l1 eq l2): " + (l1.equals(l2)));
		System.out.println("(l2 eq l3): " + (l2.equals(l3)));
		System.out.println("(l3 eq l1): " + (l3.equals(l1)));
		
		System.out.println("=======================");

		System.out.println("l1 cpt l2: " + (l1.compareTo(l2)));

	}

}

package view;

public class Ex02StringComparison {
	public static void main(String[] args) {
		// so sanh 2 chuoi
		// boolean: equals(...) --> Objects#equals(==, compare address) --> String#equals(override, value
		// int: compareTo
		
		String l1 = "hello";
		String l2 = "welcom";
		String l3 = "hello";
		
		System.out.println("l1==l2 --> " + (l1 == l3));
		System.out.println("l2==l3 --> " + (l2 == l3));
		System.out.println("l1==l3 --> " + (l1 == l3));
		
		System.out.println("l1 eq l2 --> " + (l1.equals(l2)));
		System.out.println("l1 eq l2 --> " + (l2.equals(l3)));
		System.out.println("l1 eq l2 --> " + (l1.equals(l3)));
		
		
		System.out.println();
		
		System.out.println("l1 cpt l2  " + (l1.compareTo(l2)));
		
		System.out.println("dyiqi cpt w --> " + ("dyiqi".compareTo("k")));
		
	}
}

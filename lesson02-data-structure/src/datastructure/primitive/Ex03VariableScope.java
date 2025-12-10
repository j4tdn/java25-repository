package datastructure.primitive;

public class Ex03VariableScope {
	public static void main(String[] args) {
		
		int m1 = 12;
		int m2 = 22;
		
		int result = m1 + m2;
		System.out.printf("m1(%s) + m2(%s) = %s", m1, m2, result);
		
		dummy();
	}
	private static void dummy() {
		System.out.println("calling dummy method...");
		
	}

}

package datastructure.primitive;

public class Ex03VariableScope {
	
	
	private static int g1 = 555;
	private static int gc = 222;
	public static void main(String[] args) {
		
		int gc = 33;
		System.out.println("gc at main: " + (gc + Ex03VariableScope.gc));
		
		int m1 = 12;
		int m2 = 22;
		
		
		
		int result = m1 + m2;
		System.out.printf("m1(%s) + m2(%s) = %s\n", m1 , m2 , result);
		{
		int m3 = 24;
			System.out.println("m1: " +m1);
		}
		//System.out.println("m3: " + m3);
		System.out.println("Use g1 at main method: " + g1);
		
		g1 = 777;
	
		
		System.out.println("\n---------------");
		dummy();
	}
	private static void dummy() {
		System.out.println("Calling dummy method ...");
		
		//System.out.println("m1 value: " + m1);
		System.out.println("Use g1 at main method: " + g1);
	}
}

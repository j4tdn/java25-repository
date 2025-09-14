package datastructure.primitype;

public class Ex01PrimitiveTypeDeclaration {

	public static void main(String[] args) {
		
		System.out.println("=== Start Main method ===");
		int a = 12;
		int b = 24;
		
		float c = 7.8f;
		double d = 22.6;
		
		char e;
		e = '^';
		
		boolean f1 = true;
		boolean f2 = false;
		
		System.out.println("a --> "+ a);
		System.out.println("b --> "+ b);
		System.out.println("c --> "+ c);
		System.out.println("d --> "+ d);

		System.out.printf("e --> %s\n", e);
		System.out.println("f1 --> " + f1 + ", f2 --> "+ f2);
		System.out.printf("f1 --> %s, f2 --> %s\n",f1 ,f2);
		
		logging();
		
		System.out.println("=== Finish Main method");
		
	}
	
	private static void logging() {
		System.out.println("logging >> final result 999");
	}
	
}

package datastructure.primitive;

public class Ex03VariableScope {

	private static int gc = 222;

	public static void main(String[] args) {
		int m1 = 12;
		int m2 = 22;

		int gc = 33;

		int result = m1 + m2;
		System.out.printf("m1(%s) + m2(%s) = %s", m1, m2, result);

		{
			int m3 = 24;
		}

		dummy();
	}

	private static void dummy() {
		System.out.println("Calling dummy method...");
		int gc = 99;
		System.out.println("gc at dummy: " + gc);
	}

}

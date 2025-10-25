package encapsulation.inside;

public class InTest01 {

	private static int a1;
	public static int a2;
	protected static int a3;
	static int a4;
	
	private static void method01() {}
	public static void method02() {}
	protected static void method03() {}
	static void method04() {}
	
	public static void main(String[] args) {
		System.out.println("a1 --> " + a1);
		method01();
	}
}
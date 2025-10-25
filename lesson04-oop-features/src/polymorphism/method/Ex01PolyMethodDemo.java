package polymorphism.method;

public class Ex01PolyMethodDemo {
	public static void main(String[] args) {
		sum(2, 4);
		sum(2.2f, 4);
		sum(2, 4, 6);
		
		sum(new int[] {2,3,4,2,1,32,3,2,2,2,1});
		sum(2);
		sum(2,2);
		sum(2,2,3);
		sum(2,2,3,8);
	}
	private static long sum(int... elements) {
		long total = 0;
		for(int element: elements) {
			total += element;
		}
		return total;
	}
	private static float sum(float a, int b) {
		return a + b;
	}
	private static int sum(int a, int b) {
		return a + b;
	}
	private static int sum(int a, int b, int c) {
		return a + b + c;
	}
	@Override
	public String toString() {
		return "Ex01PolyMethodDemo --> toString ...";
	}
}

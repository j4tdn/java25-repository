package polymorphism.method;

public class Ex01PolyMethodDemo {
	public static void main(String[] args) {
		sum(2, 4);
		sum(2f, 4);
		sum(2, 4, 6);
		sum(new int [] {1,2,3,4,4,5,5,6,7});
		sum(2,3,4,5,5,7,87,8,9,9);
	}
	
	// Overloading
	
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
	
	/*
	 
	 2/N ham ddc goi la overloading neu:
	 - thuoc trong cung class
	 - ten ham giong nhau
	 - va thoa man 1 trong cac dieu kien:
	 	+ khac so luong tham so truyen vao
	 	+ khac  KDL truyen vao cua  tham so
	 
	 */
	
	@Override
	public String toString() {
		return "Ex01";
	}
}

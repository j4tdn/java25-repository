package polymorphism.method;

public class Ex01PolyMethodDemo {

	public static void main(String[] args) {
		sum(2,4);
		sum(2f,4);
		sum(2,4,6);
		
		sum(new int[] {2,3,5,4,76,12,4,27});
		sum(2);
	}
	
	//Overloading
	
	private static long sum(int... elements) {
		long total = 0;
		for (int element : elements) {
			total += element;
		}
		return total;
	}
	private static float sum(float a,int b) {
		return a+b;
	}
	private static int sum(int a,int b) {
		return a+b;
	}
	private static int sum(int a,int b,int c) {
		return a+b+c;
	}
	
	/*
	 * 2 hay N hàm được gọi là overloading nếu
	 * - thuộc trong cùng 1 class 
	 * - tên hàm giống nhau
	 * - và thỏa mãn 1 trong các điều kiện sau
	 *   . khác số lượng tham số truyền vào 
	 *   . khác KDL truyề vào của tham số
	 */
	@Override
	public String toString() {
		
		return "Ex01PolyMethodDemo ---> toString ...";
	}
}

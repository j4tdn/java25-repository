package polymorphism.method;

public class Ex01PolyMethodDemo {
	public static void main(String[] args) {
		sum(new int[] {2,3,4,45,2,1,4,6,2});
		sum(2);
		sum(2, 3);
		sum(2,2,4);
		sum(2,3,45,3);
	}
	
	//Overloading
	private static long sum(int...elements) {
		long total = 0;
		for(int element : elements) {
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
	
	/**
	 * 
	 * 2/N hàm được gọi là overloading nêu
	 * - thuộc trong cùng 1 class
	 * - tên hàm giống nhau
	 * - và thỏa mãn 1 trong các điều kiện sau
	 * 		khác số lượng tham số truyền vào
	 * 		khác kdl truyền vào của tham số
	 * 
	 * */
	
	@Override
	public String toString() {
		return "Ex01PolyMethodDemo ->> toString ... ";
	}
}

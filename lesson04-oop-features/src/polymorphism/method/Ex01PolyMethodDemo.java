package polymorphism.method;

public class Ex01PolyMethodDemo {
	public static void main(String[] args) {
		
	}
	
	/**
	 * Overloading
	 * @param a
	 * @param b
	 * @return
	 */
	
	/*
	 * 2 hay nhiều hàm được gọi là overloading nếu
	 * - thuộc trong cùng 1 class
	 * - tên hàm giống nhau
	 * - và thỏa mãn 1 trong các điều kiện sau:
	 * 	 . khác số lượng tham số truyền vào
	 *   . khác KDL truyền vào của tham số
	 * */
	
	private static long sum(int... elements) {
		long total = 0;
		for(int element: elements) {
			total += element;
		}
		return total;
	}

	private static int sum(int a, int b) {
		return a + b;
	}
	
	
	private static int sum(int a, int b, int c) {
		return a + b;
	}

	@Override
	public String toString() {
		return "Ex01PolyMethodDemo --> toString ...";
	}
		
}

package polymorphism.method;

public class Ex01PoLyMethodDemo {
	@Override
	public String toString() {
		return "Ex01PoLyMethodDemo []";
	}

	public static void main(String[] args) {
		sum(1,1,1);
	}
	//overloading
	
	private static long sum (int[] elements) {
		long total =0;
		for (int element : elements) {
			total +=element;
		}
		return total;
	}
	
	private static int sum(int a, int b) {
		return a+b;
		
	}
	private static int sum(int a, int b,int c) {
		return a+b+c;
		
	}
	/*
	 * 2 hay nhiều hàm được gọi là overloading nếu
	 * - Thuộc trong cùng 1 class
	 * - tên hàm giống nhua 
	 * - và thoả mãn 1 trong các điều kiện sau 
	 * . Khác số lượng tham số truyền vào 
	 * . Khád kdl truyền vào của tham số 
	 * --> Giúp minh có thể tạo các method cùng tên trong cùng 
	 * */
	
}

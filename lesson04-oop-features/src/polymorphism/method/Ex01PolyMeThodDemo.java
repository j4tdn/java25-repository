package polymorphism.method;

public class Ex01PolyMeThodDemo {

	public static void main(String[] args) {
		
		sum(new int[] {2,3,4,5,2,1,1,4,6,2,5});
		sum(2,2);
		sum(2f,2);
		sum(2,2,3);
		sum(2,2,3,8);
		
	}
	
	// Overloading
	
	private static long sum(int... elements) {
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
	 
	       I) hai hay nhiều hàm được gọi là overloading nếu
		 	1. thuộc cùng 1 class
		 	2. có tên hàm giống nhau
		 	3. thỏa mãn 1 trong các điều kiện bên dưới:
		 		+ khác số lượng tham số truyền vào
		 		+ khác kiểu dữ liệu truyền vào của tham số
		 	--> giúp chung ta có thể tạo method trùng tên trong cùng 1 class
	 
	 */
	
	@Override
	public String toString() {
		return " Ex01PolyMethodDemo --> tótring ...";
	}
	
}

package polymorphism.method;

public class Ex01PolyMethodDemo {

	public static void main(String[] args) {
		sum(2,4);
		sum(2.2f ,4);
		sum(2,4,6);
		sum(2,2,3,8);
	}
	
	//Overloading
	
	private static long sum(int... elements ) {
		long total =0;
		for(int element:elements) {
			total += element;
		}
		return total;
	}
	
	private static float sum(float a, int b) {
		return a+b;
	}
	
	private static int sum(int a, int b) {
		return a+b;
	}
	
	private static int sum(int a, int b, int c) {
		return a+b+c;
		
	}
	/*
	 	2/N hàm được gọi là overloading nếu
	 	-thuộc trong cùng 1 class
	 	- tên hàm giống nhau
	 	- và thoả mãn 1 trong các dk sau
	 	. Khác só lượng tham số truyền vào
	 	. Khách KDL truyền vào của tham số 
	 	
	 	-> giúp có thể tạo các method cùng tên trong 1 dự án
	 */
	@Override
	public String toString() {
		return "Ex01PolyMethodDemo ";
	}
}

package polymorphism.method;

public class Ex01PolymethodDemo {
	public static void main(String[] args) {
		
		sum(2, 4);
		sum(2.2f, 4);
		sum(2, 4, 6);
		
		sum(new int[] {2,3,4,3,43,5,2,5,3,5,});
		sum(2,3,5,6,3,7,6,3,45,6,6,7,3);
		
	}
	private static long sum(int... elements) {
		long total = 0;
		for (int element: elements) {
			total += element;
		}
		return total;
	}
	
	private static int sum(int a, int b) {
		return a + b;
	}
	private static float sum(float a, int b) {
		return a + b;
	}
	
	private static int sum(int a, int b, int c) {
		return a + b + c;
	}
	
	
	
	@Override
	public String toString() {
		return "Ex01PolyMethodDemo --> toString...";
	}
}


	/*
	 2/N hàm được gọi là overloading nếu
	 - thuộc trong cùng 1 class
	 - tên hàm giống nhau
	 - và thỏa mãn 1 trong các điều kiện sau
	 	. khác số lượng và tham số truyền vào
	 	. khác KDL truyền vào của tham số
	 
	*/

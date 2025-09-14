package datastructure.primitive;

public class Ex05SwapTest {
	
	public static void main(String[] args) {
		
		int a1= 5;
		int a2 =7;
		System.out.println("a1: "+a1);
		System.out.println("a2: "+a2);
		
		System.out.println("--- After Swap ---");
		int temp;
		temp=a1;
		a1=a2;
		a2=temp;
	
		System.out.println("a1: "+a1);
		System.out.println("a2: "+a2);
		System.out.println("--- Swap again ---");
		
		Swap(a1,a2);
		// hàm Swap chỉ in ra được kq mong muốn nhưng k đổi được 2 giá trị ban đầu của các biến
	}
	// Viết hàm swap 2 số nguyên
	private static void Swap(int m, int n) {
		int temp2=m;
		m=n;
		n=temp2;
		System.out.println("a1: "+m);
		System.out.println("a2: "+n);
	}
}

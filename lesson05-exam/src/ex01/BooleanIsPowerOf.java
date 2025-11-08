package ex01;

public class BooleanIsPowerOf {

	public static void main(String[] args) {

		System.out.println("Kiểm tra số 2 & 8 có phải là số luỹ thừa không?");
		if(IsPowerOf(2,8) == false) {
			System.out.println("false");
		}else System.out.println("true");
		
		System.out.println("Kiểm tra số 8 & 2 có phải là số luỹ thừa không?");
		if(IsPowerOf(8,2) == false) {
			System.out.println("false");
		}else System.out.println("true");
		
		System.out.println("Kiểm tra số 16 & 5 có phải là số luỹ thừa không?");
		if(IsPowerOf(16,5) == false) {
			System.out.println("false");
		}else System.out.println("true");
		
	}

	private static boolean IsPowerOf(int a, int b) {
		
		if(a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		if( a < b || b <= 1 )
			return false;
		
		
		while(a % b == 0) {
			a = a / b;
		}
		return a == 1 ; 
	}
		
}

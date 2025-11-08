package ex02;

public class BooleanIsSpecialNumber {

	public static void main(String[] args) {
			
		int n = 10;
		System.out.println(n + " có phải là số đặc biệc không? "+IsSpecialNumber(n));
	}

	private static boolean IsSpecialNumber(int n) {
		
		int sum = 0;
		
		for(int i = 1; sum < n;i++ ) {
			sum = sum + i;
			if(sum == n )
				return true;
		}
		return false;
	}
	
	
}

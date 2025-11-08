package bai1;

public class CheckNums {
	
	public static void main(String[] args) {
		System.out.println("2 số có phải lũy thừa: "+ isPowerOf(2, 8));
		System.out.println("2 số có phải lũy thừa: "+ isPowerOf(8, 2));
		System.out.println("2 số có phải lũy thừa: "+ isPowerOf(6, 2));
		System.out.println("2 số có phải lũy thừa: "+ isPowerOf(15, 4));
	}
	
	private static boolean isPowerOf(int a, int b) {
		if(a<=0||b<=0) {return false;	}
		
		
		int tempa =a;
		while(tempa %b==0) {
			tempa = tempa/b;
			
		}
		if(tempa ==1) {
			return true;
		}
		int tempb =b;
		while(tempb %a==0) {
			tempb = tempb/a;
			
		}
		if(tempb ==1) {
			return true;
		}
		return false;
	}
}

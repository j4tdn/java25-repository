import java.util.HashSet;
import java.util.Set;

public class Ex02HappyNumber {
	private static boolean isHappyNumber(int n) {
		if(n == 1) {
			return true;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		
		while(n > 0) {
			int tmp = n;
			int sum = 0;
			while(tmp != 0) {
				sum+= (tmp %10) * (tmp%10);
				tmp/=10;
			}
			
			if(sum == 1) {
				return true;
			}
			
			if(!set.add(sum)) {
				return false;
			}
			
			n = sum;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isHappyNumber(4));
	}
}

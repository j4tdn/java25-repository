package test;

import java.util.HashSet;

public class HappyNumber {
	public static void main(String[] args) {
		
	System.out.println(HappyNum(12));
	
	}
	
	private static int SumOfSquares(int n) {
		int sum=0;

		while(n>0){
			int temp = n%10;
			sum+= temp*temp;
			n/=10;
			
		}
		return sum;
	}
	public static boolean HappyNum(int n) {
        
		HashSet<Integer> checked = new HashSet<>();

        while (n != 1) {
            if (checked.contains(n)) {
                return false; 
            }

            checked.add(n);
            n = SumOfSquares(n);
        }

        return true;
    }
}

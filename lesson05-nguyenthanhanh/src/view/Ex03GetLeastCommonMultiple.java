package view;

public class Ex03GetLeastCommonMultiple {

	public static void main(String[] args) {
		System.out.println("[2, 3, 4] --> " + 
				getLeastCommonMultiple(new int[] {2,3,4}));
		System.out.println("[2, 3] --> " + 
				getLeastCommonMultiple(new int[] {2,3}));
	}
	 
	private static int getLeastCommonMultiple(int[] nums) {
		if(nums.length <= 0) {
			return -1;
		}
		int result = nums[0];
		for(int i = 1; i < nums.length; i++) {
			result = bcnn(result, nums[i]);
		}
		
		return result;
	}
	
	private static int ucln(int a, int b) {
		if(a == b) {
			return a;
		}
		while(a != b) {
			if(a > b) {
				a -= b;
			} else {
				b -= a;
			}
		}
		
		return a;
	}
	
	private static int bcnn(int a, int b) {
		return (a * b) / ucln(a,b);
	}
	
}

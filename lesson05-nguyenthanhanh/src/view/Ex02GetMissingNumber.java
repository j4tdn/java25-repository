package view;

public class Ex02GetMissingNumber {

	public static void main(String[] args) {
		System.out.println("[3, 2, 1, 6, 5], 6 --> " +
				getMissingNumber(new int[] {3, 2, 1, 6, 5}, 6));
		System.out.println("[3, 7, 9, 2, 1, 6, 5, 4, 10], 10 --> " +
				getMissingNumber(new int[] {3, 7, 9, 2, 1, 6, 5, 4, 10}, 10));
	}
	
	private static int getMissingNumber(int[] nums, int n) {
		if(nums.length <= 0) {
			return -1;
		}
		
		boolean[] appearanceNums = new boolean[n + 1];
		for(int num : nums) {
			if(num >= 1 && num <= n) {
				appearanceNums[num] = true;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(!appearanceNums[i]) {
				return i;
			}
		}
		
		return -1;
	}
	
}

package lesson05.exam;

public class Ex04 {
	private static int[] cnt = new int[100000];

	private static int sum(int[] a ) {
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;

		for(int i = 0;i<a.length;++i) {
			cnt[a[i]]++;
			if(a[i] < minVal) {
				minVal = a[i];
			}
			
			if(a[i] > maxVal) {
				maxVal = a[i];
			}
		}
		
		int sum = 0;
		
		for(int i = 0;i<a.length;++i) {
			if(a[i] == minVal) {
				cnt[a[i]] = 0;
			}
			if(a[i] == maxVal) {
				cnt[a[i]] = 0;
			}
			if(cnt[a[i]]!=0) {
				sum+=a[i];
				cnt[a[i]] = 0;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
//		int[] a = new int[] {1,5,8,9,2,5,9};
		int[] a = new int[]	{4,2,6,6,4,15,1};
		System.out.println(sum(a));
	}

}

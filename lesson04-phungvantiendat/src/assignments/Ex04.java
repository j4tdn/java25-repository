package assignments;

import java.util.Arrays;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] a = new int[n];
		for(int i = 0;i<n;++i) {
			a[i] = sc.nextInt();
		}
		int[] rq1 = divideForSeven(a);
		int[] rq2 = divideForSevenAndFive(a);
		int[] rq3 = divideForFive(a);
		
		String ans = "";
		
		for(int i = 0;i<rq1.length;++i) {
			ans+=rq1[i];
			if(i<rq1.length-1) {
				ans+=", ";
			}
		}
		
		ans+=" | ";
		for(int i = 0;i<rq2.length;++i) {
			ans+=rq2[i];
			if(i<rq2.length-1) {
				ans+=", ";
			}
		}

		ans+=" | ";
		for(int i = 0;i<rq3.length;++i) {
			ans+=rq3[i];
			if(i<rq3.length-1) {
				ans+=", ";
			}
		}
		System.out.println(ans);
	}

	private static int[] divideForFive(int[] a) {
		int index = 0;
		int cnt = 0;
		for (int i = 0; i < a.length; ++i) {
			if (a[i] % 5 == 0 && a[i]%7!=0) {
				++cnt;
			}
		}
		int[] result = new int[cnt];
		for (int i = 0; i < a.length; ++i) {
			if (a[i] % 5 == 0 && a[i]%7!=0) {
				result[index++] = a[i];
			}
		}
		return result;
	}

	private static int[] divideForSeven(int[] a) {
		int index = 0;
		int cnt = 0;
		for (int i = 0; i < a.length; ++i) {
			if (a[i] % 7 == 0 && a[i] % 5 !=0) {
				++cnt;
			}
		}
		int[] result = new int[cnt];
		for (int i = 0; i < a.length; ++i) {
			if (a[i] % 7 == 0 && a[i] % 5 !=0) { 
				result[index++] = a[i];
			}
		}
		return result;
	}

	private static int[] divideForSevenAndFive(int[] a) {
		int index = 0;
		int cnt = 0;
		for (int i = 0; i < a.length; ++i) {
			if ((a[i] % 7 == 0 && a[i] % 5 == 0) || (a[i]%5!=0 && a[i]%7!=0)) {
				++cnt;
			}
		}
		int[] result = new int[cnt];
		for (int i = 0; i < a.length; ++i) {
			if ((a[i] % 7 == 0 && a[i] % 5 == 0) || (a[i]%5!=0 && a[i]%7!=0)) {
				result[index++] = a[i];
			}
		}
		return result;
	}
}

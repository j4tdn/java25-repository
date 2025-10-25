package assignments;

import java.util.Scanner;

public class Ex05 {
	private static int[] F = new int[1000001];
	private static int[] cnt = new int[10001];
	
	private static void sieve() {
		for(int i = 1;i<=1000000;++i) {
			for(int j = i;j<=1000000;j+=i) {
				F[j]++;
			}
		}
	}
	
	public static void main(String[] args) {
		sieve();
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] a = new int[n];
		for(int i = 0;i<n;++i) {
			a[i] = sc.nextInt();
		}
		for(int i = 0;i<n;++i) {
			cnt[F[a[i]]] = a[i];
		}
		for(int i = 0;i<cnt.length;++i) {
			if(cnt[i]!=0) {
				System.out.println(cnt[i]);
			}
		}
	}
}

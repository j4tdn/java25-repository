package lesson2.assignments;

import java.util.Scanner;

public class Ex09 {
	
	private static int[] p = new int[10000005];
	
	private static void sieve() {
		for(int i = 2;i<=10000000;++i) {
			p[i] = 1;
		}
		
		p[0] = p[1] = 0;
		for(int i = 2;i<=Math.sqrt(10000000);++i) {
			if(p[i] == 1) {
				for(int j = i * i;j<=10000000;j+=i) {
					p[j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sieve();
		int cnt = 0;
		for(int i = 2;i<=1000000;++i) {
			if(p[i]==1) {
				++cnt;
			}
			
			if(cnt==200) {
				System.out.println(i);
				break;
			}
		}
	}
}

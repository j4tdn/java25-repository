package view;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhap n: ");
		long n = sc.nextLong();
		
		System.out.print("Nhap m: ");
		long m = sc.nextLong();
		
		if (checkEquivalence(n, m)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
		
		sc.close();
	}
	
	private static boolean checkEquivalence(long n, long m) {
		
		long[] factorsN = getPrimeFactors(n);
		for(long factor: factorsN) {
			if(m % factor != 0) {
				return false;
			}
		}
		
		long[] factorsM = getPrimeFactors(m);
		for(long factor: factorsM) {
			if(n % factor != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	private static long[] getPrimeFactors(long n) {
		
		long[] temp = new long[100];
		int count = 0;
		long num = n;
		
		if(n % 2 == 0) {
			temp[count++] = 2;
			while(num % 2 == 0) num /= 2;
		}
		
		for(int i = 3; i * i < num; i += 2) {
			if(num % i == 0) {
				temp[count++] = i;
				while(num % i == 0) num /= i;
			}
		}
		
		if(num > 1) temp[count] = num;
		
		long[] rs = new long[count];
		
		// mang muon cop -> vi tri muon cop -> mang dich -> vi tri paste -> so luong phan tu
		System.arraycopy(temp, 0, rs, 0, count);
		
		return rs;
		
	}
	
}

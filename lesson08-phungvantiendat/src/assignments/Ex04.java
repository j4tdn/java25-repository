package assignments;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.*;

import java.lang.reflect.Array;

public class Ex04 {
	
	public static ArrayList<Long> solve(long n) {
		int cnt = 0;
		ArrayList<Long> list = new ArrayList<>();
		for(long i = 2;i * i <=(n);++i) {
			if(n%i==0) {
				list.add(i);
				while(n%i==0) {
					n/=i;
				}
			}
		}
		if(n!=1) {
			list.add(n);
		}
		return list;
	}
	
	private static boolean isValid(long a, long b) {
		ArrayList<Long> firstSet = solve(a);
		ArrayList<Long> secondSet = solve(b);
		if (firstSet.size() != secondSet.size()) return false;
		for(Long it : firstSet) {
			if(!secondSet.contains(it)) {
				return false;
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--- Nhap so thu nhat ---");
		Long a = Long.parseLong(sc.nextLine());
		System.out.println("--- Nhap so  thu hai ---");
		Long b = Long.parseLong(sc.nextLine());
		
		if(isValid(a, b)) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		

		
	}
}

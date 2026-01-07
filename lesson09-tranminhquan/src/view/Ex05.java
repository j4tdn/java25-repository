package view;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số : ");
		int n = sc.nextInt();
		
		if (isHappy(n)) {
			System.out.println(n + " là số hạnh phúc");
		} else {
			System.out.println(n + " k phải là số hạnh phúc");
		}
	}
	public static boolean isHappy(int n) {
		Set<Integer> s = new HashSet<Integer>();
		
		while (n != 1 ) {
			if(s.contains(n)) {
				return false;
			}
			s.add(n);
			int sum = 0;
			while (n > 0) {
				int d = n % 10;
				sum += d * d;
				n /= 10;
			}
			n = sum;
		}
		
		return true;
	}
}

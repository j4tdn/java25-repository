package ex01;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập chuỗi:  ");
		String s = sc.nextLine().trim();
		s1(s);
		s2(s);
	}
	//In mỗi kí tự trên 1 dòng 
	public static void s1(String s) {
		System.out.println("\n Mỗi kí tự: ");
		for(char c: s.toCharArray()) {
			System.out.println(c);
		}
	}
	//In ra mỗi từ trên 1 dòng 
	public static void s2(String s) {
		System.out.println("\n Mỗi từ trên 1 dòng: ");
		String [] word = s.split(" ");
		for(String i : word) {
			System.out.println(i);
		}
		
	}
}

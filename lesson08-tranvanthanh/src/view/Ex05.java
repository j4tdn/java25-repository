package view;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
//		s1 = "ABCEDEABC";
//		s2 = "ABCEDCBBCK";
		Scanner ip = new Scanner(System.in);

		System.out.print("Nhập chuỗi kí tự: s1 =  ");
		String s1 = ip.nextLine();
		System.out.print("Nhập chuỗi kí tự: s2 =  ");
		String s2 = ip.nextLine();
		System.out.println("s1 = "+s1);
		System.out.println("s2 = "+s2);
		System.out.println("Chuỗi kí tự chung của s1 và s2: ");
		find(s1, s2);
	}

	private static void find(String s1, String s2) {
		String[] arr = new String[100];
		int count = 0;
		for (int i = 0; i < s1.length() - 1; i++) {
			for (int j = i + 1; j < s1.length(); j++) {
				if (s2.contains(s1.substring(i, j))) {
					arr[count++] = s1.substring(i, j);
				}
			}
		}

		String[] realArr = new String[count];
		for (int i = 0; i < realArr.length; i++) {
			realArr[i] = arr[i];
		}

		String max = realArr[0];
		for (int i = 0; i < realArr.length; i++) {
			max = max(max, realArr[i]);
		}
		System.out.println(max);
	}

	private static String max(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return s1;
		}
		return s2;
	}
}
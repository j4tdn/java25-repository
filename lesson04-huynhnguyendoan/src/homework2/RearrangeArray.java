package homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RearrangeArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		System.out.println("Nhap so luong phan tu(tu 5 toi 100): ");

		int a = sc.nextInt();

		List<Integer> listDiv7 = new ArrayList<>();
		List<Integer> listMid = new ArrayList<>();
		List<Integer> listDiv5 = new ArrayList<>();


		for (int i = 0; i < a; i++) {
			int number = rd.nextInt(96) +5;

			if (number % 7 == 0 && number % 5 != 0) {
				listDiv7.add(number);

			} else if (number % 5 == 0 && number % 7 != 0) {
				listDiv5.add(number);

			} else {
				listMid.add(number);
			}
		}
		String result = join(listDiv7) + " | " + join(listMid) + " | " + join(listDiv5);
		System.out.println(result);

	}

	private static String join(List<Integer> list) {
		if (list.isEmpty()) {
			return "";
		}
		String result = "";
		for (int i = 0; i < list.size(); i++) {
			result += list.get(i);
			if (i != list.size() - 1) {
				result += ",";
			}
		}
		return result;
	}
}

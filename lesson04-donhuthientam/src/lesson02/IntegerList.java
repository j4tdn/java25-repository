package lesson02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IntegerList {
	public static void main(String[] args) {
		Random rd = new Random();

		int[] value = new int[10];
		System.out.print("Input : ");
		for (int i = 0; i < 10; i++) {
			value[i] = rd.nextInt(96) + 5;
			System.out.printf("%d%s", value[i], ", ");
		}

		List<Integer> div7 = new ArrayList<>();
		List<Integer> div5 = new ArrayList<>();
		List<Integer> others = new ArrayList<>();

		for (int x : value) {
			if (x % 7 == 0) {
				div7.add(x);
			} else if (x % 5 == 0) {
				div5.add(x);
			} else {
				others.add(x);
			}
		}

		System.out.print("\n\nOutput: ");
		printList(div7);
		System.out.print(" | ");
		printList(others);
		System.out.print(" | ");
		printList(div5);
		System.out.println();

	}

	private static void printList(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%d %s", list.get(i), (i < list.size() - 1 ? ", " : ""));
		}
	}
}

package view;

import utils.InputUtils;
import static java.lang.Math.*;

public class Ex06MaxMinFinder {

	public static void main(String[] args) {

		int a = InputUtils.inputNumber(-1, 20, 5);
		int b = InputUtils.inputNumber(-1, 20, 5);
		int c = InputUtils.inputNumber(-1, 20, 5);

		System.out.println("min A1 = " + min(a, min(b, c)));
		System.out.println("max A1 = " + max(a, max(b, c)));

		int[] numbers = { a, b, c };

		Pair pair = getMinMax(numbers);
		
		System.out.println("min A2 = " + pair.min);
		System.out.println("max A2 = " + pair.max);
	}
	
	private static Pair getMinMax(int[] numbers) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int number : numbers) {
			min = min(number, min);
			max = max(number, max);
		}
		
		return new Pair(min, max);
	}

	private static class Pair {

		private int min;
		private int max;

		private Pair(int min, int max) {
			this.min = min;
			this.max = max;
		}

		@Override
		public String toString() {
			return "Pair(" + min + ", " + max + ")";
		}
	}

}
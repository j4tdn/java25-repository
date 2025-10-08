package view;

import java.util.Arrays;
import java.util.Random;

import utils.MathUtils;

public class Ex04FactTotal {
	
	private static Random rd = new Random();
	
	public static void main(String[] args) {
		int[] elements = random(4, 10, 20);
		System.out.println("elements: " + Arrays.toString(elements));
		
		System.out.printf("Total of %s = %s", Arrays.toString(elements), totalOfFacts(elements));
	}
	
	private static long totalOfFacts(int[] elements) {
		long total = 0;
		for (int element: elements) {
			Long f = MathUtils.fact(element);
			total += (f == null ? 0 : f);
		}
		return total;
	}
	
	private static int[] random(int length, int minIncl, int maxExcl) {
		int[] output = new int[length];
		for (int i = 0; i < length; i++) {
			output[i] = rd.nextInt(minIncl, maxExcl);
		}
		return output;
	}
}

package view;

import java.util.Arrays;

import bean.Item;

public class Ex01DeclareAndInitial {

	public static void main(String[] args) {

		int[] numbers = new int[12];

		double[] points = { 1d, 2d, 3d, 4d };

		double[] generatedPoints = generatePoints();

		String[] seqs = { "today", "welcome", "k25" };
		
		Item[] items = new Item[4];

		System.out.println("numbers#length = " + numbers.length);

		System.out.println("points#length = " + points.length);
		
		System.out.println("generatedPoints#length = " + generatedPoints.length);

		System.out.println("seqs#length = " + seqs.length);
		
		System.out.println("items#length = " + items.length);
		
		System.out.println("items#values = " + Arrays.toString(items));

	}

	private static double[] generatePoints() {
		return new double[] { 1d, 2d, 3d, 4d, 5d };
	}
}
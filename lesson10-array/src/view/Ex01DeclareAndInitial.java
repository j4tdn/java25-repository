package view;

import java.util.Arrays;

import bean.Item;

public class Ex01DeclareAndInitial {

	public static void main(String[] args) {
		
		int[] numbers = new int[12];
		double[] points = /* new double[]*/ {1d, 3d};
		String[] seqs = {"today", "welcome", "K25"};
		double[] generatedPoints = generatePoints();
		
		Item[] items = new Item[4];
		
		System.out.println("number#lenght = " + numbers.length);
		
		System.out.println("points#lenght = " + points.length);
		
		System.out.println("seqs#lenght = " + seqs.length);
		
		System.out.println("generated#lenght = " + generatedPoints.length);

		System.out.println("items#lenght = " + items.length);

		System.out.println("items#values = " + Arrays.toString(items));
	}
	
	private static double[] generatePoints() {
		return new double[] {1d, 2d};
	}
}

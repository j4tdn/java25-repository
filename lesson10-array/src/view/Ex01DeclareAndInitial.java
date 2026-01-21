package view;

import java.util.Arrays;

import bean.Item;

public class Ex01DeclareAndInitial {

	public static void main(String[] args) {
		
		int[] numbers = new int[12];
		
		double[] points = { 1d, 2d, 3d, 4d};
		
		double[] generatedPoint = generatePoint();
		
		String[] seqs = {"to day", "welcome", "k25"};
		
		Item[] items = new Item[4];
		
		System.out.println("numbers#lenght = " + numbers.length);
		
		System.out.println("points#lenght = " + points.length);
		
		System.out.println("generatedPoint#lenght = " + generatedPoint.length);
		
		System.out.println("seqs#lenght = " + seqs.length);
		
		System.out.println("items#lenght = " + items.length);
		
		System.out.println("seqs#value = " + Arrays.toString(items));
	}
	
	private static double[] generatePoint() {
		return new double[] {1d, 2d,3d, 4d, 5d };
	}
	
}

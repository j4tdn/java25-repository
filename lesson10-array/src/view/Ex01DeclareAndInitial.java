package view;

import java.util.Arrays;

import bean.Item;

public class Ex01DeclareAndInitial {
	public static void main(String[] args) {
		
		int[] number = new int[12];
		double[] generatePoint = /*new double[] */ generatePoints(); 
		String[] seqs = {"today", "wellcomr", "K25"};
		
		Item[] items = new Item[4];
		
		System.out.println("number#length = " + number.length);
		System.out.println("generatePoint#length = " + generatePoint.length);
		System.out.println("seqs#length = " + seqs.length);
		
		System.out.println("items#length = " + items.length);
		System.out.println("items#value = " + Arrays.toString(items));
	}
	private static double[] generatePoints() {
		return new double[] {1d,2d,3d,4d};
	}

}

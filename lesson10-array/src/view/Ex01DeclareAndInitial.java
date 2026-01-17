package view;

import java.util.Arrays;

import bean.Item;

public class Ex01DeclareAndInitial {

	public static void main(String[] args) {
		
		int[] numbers = new int[12];
		
		double[] points = { 1d, 2d, 3d, 4d };
		
		String[] seqs = { "double", "today", "k25" };
		
		Item[] items = new Item[4];
		
		System.out.println("item#values --> " + Arrays.toString(items));
		
	}
	
}

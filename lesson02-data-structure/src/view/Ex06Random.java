package view;

import java.util.Random;

public class Ex06Random {

	public static void main(String[] args) {
		
		Random rd = new Random();
		int a1 = rd.nextInt(5, 20); // [2, 20)
		int a2 = rd.nextInt(88); // [0, 88)
		
	}
	
}

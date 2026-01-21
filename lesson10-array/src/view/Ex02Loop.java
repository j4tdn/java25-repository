package view;

public class Ex02Loop {

	public static void main(String[] args) {
		
		int[] numbers = {7,8,2,18,39};
		
		//int for index
		for(int i = 0 ; i<numbers.length; i++) {
			System.out.printf("index (%s) val(%s)\n", i, numbers[i]);
		}
		
		
		System.out.println(" \n \n Loop with For Each");
		for(int number:numbers) {
			System.out.print(number + " ");
		}
		
		
		
	}
	
	
}

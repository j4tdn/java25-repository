package view;

public class Ex02Loop {
	
	public static void main(String[] args) {
		int[] numbers = {7, 8, 2, 18 ,30};
		
		System.out.println("Loop with for index");
		for(int i = 0; i<numbers.length; i++) {
			System.out.printf("int dex(%s) val(%s)\n", i, numbers[i]);
		}
		
		System.out.println("\n Loop with for each");
		for(int number: numbers) {
			System.out.println(number);
		}
	}

}

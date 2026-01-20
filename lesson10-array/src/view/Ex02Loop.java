package view;

public class Ex02Loop {

	public static void main(String[] args) {
		int[] numbers = {7, 8, 9, 10 ,30};

		System.out.println("Loop with for index");
		for(int i = 0;i<numbers.length;++i) {
			System.out.printf("index(%s) val(%s)",numbers[i]);
		}
		
		System.out.println("Loop with for each");
		for(int item : numbers) {
			System.out.printf("Val(%s)", item);
		}
		
	}

}

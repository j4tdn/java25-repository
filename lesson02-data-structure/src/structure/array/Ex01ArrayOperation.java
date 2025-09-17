package structure.array;

public class Ex01ArrayOperation {
	public static void main(String[] args) {
		int[] numbers = new int[6];
		numbers[3] = 25;
		
		//forindex;
		for(int i = 0; i<numbers.length; i++) {
			System.out.println("value at index: " + i + ": " + numbers[i]);
		}
		System.out.println("======");
		//foreach
		for(int number : numbers) {
			System.out.println("value: " + number);
		}
	}
}

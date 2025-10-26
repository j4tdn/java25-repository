package exercises;

public class Ex02Classification {
	public static void main(String[] args) {
		int[] numbers = {12, 21, 25, 19, 32, 35, 49, 10, 33, 14, 18};
		
		classification(numbers);
 	}
	
	private static int[] classification(int[] numbers) {
		
		int n = numbers.length;
		
		int[] output = new int[n];
		
		int fistIndex = 0;
		int lastIndex = n - 1;
		
		int middleIndex =  0;
		int[] midTemp = new int[n];
		
		for(int i = 0; i < n; i++) {
			if(numbers[i] % 5 == 0 && numbers[i] % 7 == 0) {
				midTemp[middleIndex++] = numbers[i];
			}
			else if(numbers[i] % 7 == 0) {
				output[fistIndex++] = numbers[i];
			}
			else if(numbers[i] % 5 == 0) {
				output[lastIndex--] = numbers[i];
			}
			else midTemp[middleIndex++] = numbers[i];
			
		}
		
		int currentIndex = fistIndex;
		for(int i = 0; i < middleIndex; i++) {
			output[currentIndex++] = midTemp[i];
		}
		
		outputArray(output, fistIndex, lastIndex);
		
		return output;
	}
	
	private static void outputArray(int[] output, int fistIndex, int lastIndex) {
		for(int i = 0; i < fistIndex; i++) {
			if(i == fistIndex-1) {
				System.out.print(output[i] + " | ");
			}
			else System.out.print(output[i] + ", ");
		}
		
		for(int i = fistIndex; i <= lastIndex; i++) {
			if(i == lastIndex) {
				System.out.print(output[i] + " | ");
			}
			else System.out.print(output[i] + ", ");
		}
		
		for(int i = output.length-1; i >= lastIndex + 1; i--) {
			if(i == output.length-1) {
				System.out.print(output[i] + ", ");
			}
			else System.out.print(output[i]);
		}
		
	}
}

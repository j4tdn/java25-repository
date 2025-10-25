package view;

import util.NumberUtils;

public class Bai2 {

	public static void main(String[] args) {
		int maxLength = NumberUtils.inputNumber(5, 100, 3, "Nhập n(5 <= n <= 100): ");
		int[] numbers = new int[maxLength];
		for(int i = 0; i < maxLength; i++) {
			numbers[i] = NumberUtils.inputNumber(3, "Nhập N: ");
		}
		
		int dividedBy7 = 0;
	    int dividedBy5 = 0;
	    int rest = 0;
	    for (int number : numbers) {
            if (number%7 == 0 && number%5 != 0) {
            	dividedBy7++;
            } else if (number%5 == 0 && number%7 != 0) {
            	dividedBy5++;
            } else {
            	rest++;
            }
        }
	    
	    int[] dividedBy7List = new int[dividedBy7];
        int[] dividedBy5List = new int[dividedBy5];
        int[] restList = new int[rest]; 
        
        int indexDividedBy7List = 0;
        int indexDividedBy5List = 0;
        int indexRestList = 0;

        for (int number : numbers) {
            boolean divBy7 = number % 7 == 0;
            boolean divBy5 = number % 5 == 0;

            if (number%7 == 0 && number%5 != 0) {
            	dividedBy7List[indexDividedBy7List++] = number;
            } else if (divBy5 && !divBy7) {
            	dividedBy5List[indexDividedBy5List++] = number;
            } else {
            	restList[indexRestList++] = number;
            }
        }
        
        String listOf7 = formatListToString(dividedBy7List);
        String listOf5 = formatListToString(dividedBy5List);
        String listOfRest = formatListToString(restList);
        
        String output = listOf7 + " | " + listOf5 + " | " + listOfRest;

        System.out.println("Output: " + output);
	}
	
	private static String formatListToString(int[] list) {
		String result = "";
		if(list.length == 0) {
			return result;
		}
		
		for(int i = 0; i < list.length; i++) {
			result += list[i];
			if(i < list.length - 1) {
				result += ", ";
			}
		}
		
		return result;
	}
	
}

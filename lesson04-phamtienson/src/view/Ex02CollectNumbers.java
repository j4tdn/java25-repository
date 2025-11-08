package view;

import bean.NumberProcessor;

public class Ex02CollectNumbers {
	 public static void main(String[] args) {
		 
	        int[] numbers = {12, 21, 25, 19, 32, 35, 49, 10, 33, 14, 18};
	        NumberProcessor processor = new NumberProcessor(numbers);
	        String result = processor.processArray();
	        
	        System.out.println("Input: " + java.util.Arrays.toString(numbers));
	        System.out.println("Output: " + result);
	    }

}
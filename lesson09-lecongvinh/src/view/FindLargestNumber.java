package view;

import java.util.ArrayList;
import java.util.Arrays;

public class FindLargestNumber {

	public static void main(String[] args) {
		String input = "xâu aa6b546c6e22h,";
		System.out.println(findLargestNumber(input));
	}
	
	public static String findLargestNumber( String str) {
		String[] numbers = str.split("[^0-9]+");
		String largestNumber ="";
		for(String number : numbers) {
			if(number.length()> largestNumber.length() || number.length() == largestNumber.length() && number.compareTo(largestNumber)>0) {
				largestNumber = number;
			}
		}
		largestNumber = Arrange(largestNumber);
		return largestNumber;
	}
	public static String Arrange(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		String sortedString = new String(chars);
		
		return sortedString;
	}
}

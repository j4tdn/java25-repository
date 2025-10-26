package ex02;

import java.util.ArrayList;
import java.util.Arrays;

public class SimpleNumberSorter {

    public static String categorizeAndFormat(int[] numbers) {
        
        ArrayList<Integer> group7Only = new ArrayList<>();   
        ArrayList<Integer> group5Only = new ArrayList<>();   
        ArrayList<Integer> middleGroup = new ArrayList<>();  

        for (int num : numbers) {
            boolean isDivisibleBy7 = (num % 7 == 0);
            boolean isDivisibleBy5 = (num % 5 == 0);

            if (isDivisibleBy7 && !isDivisibleBy5) {
                group7Only.add(num);
            } else if (isDivisibleBy5 && !isDivisibleBy7) {
                group5Only.add(num);
            } else {
                middleGroup.add(num);
            }
        }

        StringBuilder result = new StringBuilder();

        appendGroup(result, group7Only);
        result.append(" | ");
        appendGroup(result, middleGroup);
        result.append(" | ");
        appendGroup(result, group5Only);

        return result.toString();
    }

    private static void appendGroup(StringBuilder sb, ArrayList<Integer> group) {
        for (int i = 0; i < group.size(); i++) {
            sb.append(group.get(i));
            if (i < group.size() - 1) {
                sb.append(", ");
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {12, 21, 25, 19, 32, 35, 49, 10, 33, 14, 18};

        String result = categorizeAndFormat(input);

        System.out.println("--- PHÂN LOẠI DÃY SỐ ---");
        System.out.println("Input:  " + Arrays.toString(input).replace("[", "").replace("]", ""));
        System.out.println("Output: " + result);

    }
}
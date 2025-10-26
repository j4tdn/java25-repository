package bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class quanlidayso {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap day so (cach nhau boi dau phay): ");
        String input = scanner.nextLine();
        scanner.close();
        
        
        String[] parts = input.split(",");
        int n = parts.length;
        
        if (n < 5 || n > 100) {
            System.out.println("So phan tu phai nam trong khoang [5, 100]");
            return;
        }
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        
        
        System.out.println("\nInput: " + arrayToString(arr));
        
        
        String result = rearrangeArray(arr);
        
       
        System.out.println("Output: " + result);
    }

 
    public static String rearrangeArray(int[] arr) {
        List<Integer> divisibleBy7 = new ArrayList<>();      
        List<Integer> divisibleBy5 = new ArrayList<>();       
        List<Integer> middle = new ArrayList<>();             
        
       
        for (int num : arr) {
            if (isDivisibleBy(num, 7) && !isDivisibleBy(num, 5)) {
               
                divisibleBy7.add(num);
            } else if (isDivisibleBy(num, 5) && !isDivisibleBy(num, 7)) {
               
                divisibleBy5.add(num);
            } else {
               
                middle.add(num);
            }
        }
        
      
        List<String> parts = new ArrayList<>();
        
        
        if (!divisibleBy7.isEmpty()) {
            parts.add(listToString(divisibleBy7));
        }
        
       
        if (!middle.isEmpty()) {
            parts.add(listToString(middle));
        }
        
       
        if (!divisibleBy5.isEmpty()) {
            parts.add(listToString(divisibleBy5));
        }
        
       
        return String.join(" | ", parts);
    }


    private static boolean isDivisibleBy(int number, int divisor) {
        return divisor != 0 && number % divisor == 0;
    }

    
    private static String listToString(List<Integer> list) {
        if (list.isEmpty()) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }


    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}


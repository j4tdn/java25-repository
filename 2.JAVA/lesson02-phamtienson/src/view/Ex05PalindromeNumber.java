package view;
import java.util.Scanner;
public class Ex05PalindromeNumber {
public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
	        
	        while (true) {
	            System.out.print("Nhập số nguyên dương N =  ");
	            String input = ip.nextLine();
	            
	            try {
	                int N = Integer.parseInt(input);
	                
	                if (N < 10) {
	                    System.out.println("Số N không phải là số có 2 chữ số !!!");
	                } else if (isPalindrome(N)) {
	                    System.out.println(N + " là số đối xứng.");
	                } else {
	                    System.out.println(N + " không phải là số đối xứng.");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Nhập lỗi! Nhập lại số nguyên N = ");
	            }
	            
	            System.out.println(); 
	        }
	    }
	    
	// Hàm kiểu tra số đối xứng 
	    public static boolean isPalindrome(int number) {
	        String numStr = Integer.toString(number);
	        int left = 0;
	        int right = numStr.length() - 1;
	        
	        while (left < right) {
	            if (numStr.charAt(left) != numStr.charAt(right)) {
	                return false;
	            }
	            left++;
	            right--;
	        }
	        
	        return true;
	    }
}

package assignments;

import java.util.Scanner;

public class Ex03 {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Nhập chuỗi tiếng Việt:");
	        String input = scanner.nextLine();

	        String result = Utils.removeAccent(input);

	        System.out.println("Chuỗi không dấu:");
	        System.out.println(result);

	        scanner.close();
	    }
}

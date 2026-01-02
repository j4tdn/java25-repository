package assignments;

import java.util.Scanner;

public class Ex02 {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Nhập họ tên: ");
	        String input = sc.nextLine();

	        String normalizedName = Utils.normalizeFullName(input);

	        if (normalizedName == null) {
	            System.out.println("Họ tên không hợp lệ!");
	        } else {
	            System.out.println("Họ tên đã chỉnh sửa:");
	            System.out.println(normalizedName);
	        }

	        sc.close();
	    }
}

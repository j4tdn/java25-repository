package hoten.lesson02;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        long N = 0;              
	        boolean isValid = false;   

	        for (int i = 1; i <= 5; i++) {
	            System.out.print("Nhập số nguyên dương N: ");
	            if (scanner.hasNextLong()) {
	                N = scanner.nextLong();
	                if (N > 0) {
	                    isValid = true;
	                    break; 
	                } else {
	                    System.out.println("N phải lớn hơn 0. Vui lòng nhập lại.");
	                }
	            } else {
	                System.out.println("Không phải số nguyên. Vui lòng nhập lại.");
	                scanner.next();
	            }
	        }
	        if (isValid) {
	            if (N % 2 == 0) {
	                System.out.println( N + " là bội của 2.");
	            } else {
	                System.out.println( N + " không phải là bội của 2.");
	            }
	        } else {
	            System.out.println("Nhập sai quá 5 lần. Kết thúc chương trình.");
	        }

	        scanner.close();

	}

}

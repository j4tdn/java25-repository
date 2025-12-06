package assignments;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		int b = 0;
		do {
			try {
				System.out.println("Nhap a: ");
				a = Integer.parseInt(sc.nextLine());
				System.out.println("Nhap b: ");
				b = Integer.parseInt(sc.nextLine());
				
				if(a == 0) {
					System.out.println("Khong duoc chia cho 0");
				}else {
					System.out.println("Ket qua: "+ b/a);
					break;
				}
			} catch (NumberFormatException ex) {
//				if(ex instanceof NumberFormatException) {
					System.out.println("Chi duoc nhap so! Vui long nhap lai.");
//				}
//				if(ex instanceof ArithmeticException) {
//					System.out.println("Khong duoc chia cho 0");
//				}
			}
		} while (true);
	}

}

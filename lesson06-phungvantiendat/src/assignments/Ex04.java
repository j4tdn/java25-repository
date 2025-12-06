package assignments;

import java.util.Scanner;

import exception.NumberValidException;
import utils.NumberUtils;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = 0;
		do {
			try {
				System.out.println("Nhập số (tối đa 3 chữ số [0-999]: ");
				number = Integer.parseInt(sc.nextLine());
				if(NumberUtils.isValidDigit(number)) {
					System.out.println(NumberUtils.readNumber(number));
				}
			} catch (NumberFormatException | NumberValidException ex) {
				if(ex instanceof NumberFormatException) {
					System.out.println("Vui lòng chỉ nhập số!");
				}else if(ex instanceof NumberValidException) {
					System.out.println(ex.getMessage());
				}
			}
		} while (true);

	}
}

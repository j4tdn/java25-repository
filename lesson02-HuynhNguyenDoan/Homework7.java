package homework;

import java.util.Scanner;

public class Homework7 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhap so: ");
		int number = ip.nextInt();
		String binaryNumber = "";
		int tempNumber = number;
		if (tempNumber == 0) {
			binaryNumber = "0";

		} else {
			while (tempNumber > 0) {
				int remainNumber = tempNumber % 2;
				binaryNumber = remainNumber+ binaryNumber;
				tempNumber /= 2;

			}
		}
		System.out.println("So nhi Phan la: " + binaryNumber);
		ip.close();

	}

}

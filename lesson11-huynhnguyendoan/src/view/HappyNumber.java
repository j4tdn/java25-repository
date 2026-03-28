package view;

import java.util.Scanner;

public class HappyNumber {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so: ");
        int n = sc.nextInt();

        if (utils.NumberUtils.isHappy(n)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        sc.close();
	}
}
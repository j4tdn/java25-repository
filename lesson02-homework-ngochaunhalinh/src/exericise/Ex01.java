package exericise;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int wrongTime = 0;
		int n = 0;
		do {
			System.out.println("Nhap 1 so nguyen: ");
			if (!sc.hasNextInt()) {
				sc.next();
				System.out.println("Day kh phai so nguyen!");
				wrongTime++;
			} else {
			 n = sc.nextInt();

				if (isMultipleOfTwo(n)) {
					System.out.println("Day la so boi cua 2");
					break;
				} else {
					System.out.println("Day la so nguyen nhung kh phai boi cua 2");
					wrongTime++;
				}
			}

			if (wrongTime == 5) {
				System.out.println("Ban da nhap qua 5 lan");
				break;
			}
		} while (true);

		sc.close();
	}

	private static boolean isMultipleOfTwo(int n) {
		return n % 2 == 0;
	}

}

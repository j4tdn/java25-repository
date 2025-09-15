package nghoangminh_lesson02exercise;

import java.util.Scanner;

public class bai7 {

		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);

			System.out.print("Nhập số tự nhiên N (>=0): ");
			int N = scanner.nextInt();

			if (N < 0) {
				System.out.println("Lỗi: N phải là số tự nhiên (>=0)!");
			} else if (N == 0) {
				System.out.println("0");
			} else {
				String binary = "";
				int temp = N;

				while (temp > 0) {
					int remainder = temp % 2;
					binary = remainder + binary; // ghép vào trước
					temp = temp / 2;
				}

				System.out.println(N + " ở hệ nhị phân là: " + binary);
			}

			scanner.close();
		}
	}

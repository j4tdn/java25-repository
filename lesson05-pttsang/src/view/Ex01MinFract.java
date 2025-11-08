package view;

import java.util.Scanner;

/*
 Viết chương trình nhập vào 1 số thực có phần thập phân khác 0. Yêu
cầu nhập lại(tối đa 3 lần) nếu nhập sai
Sau đó tìm phân số tối giản của số thập phân đó.
 */
public class Ex01MinFract {
	public static void main(String[] args) {
		try (Scanner ip = new Scanner(System.in)) {
			double n = 0.0;
			boolean isValid = false;
			int count = 0;

			while (!isValid && count < 3) {
				System.out.println("Enter number: ");
				try {
					n = Double.parseDouble(ip.nextLine());
					if (n % 1 != 0) {
						isValid = true;
					} else {
						System.out.println("n không phải là số có thập phân khác 0");
					}

				} catch (Exception e) {
					System.out.println("Nhập không đúng kiểu dữ liệu");
				}
				count++;
			}
			if (isValid) {
				System.out.println("Phân số tối giản của số thập phân đó là: " + getMinFract());
			} else {
				return;
			}
		}
	}

	private static String getMinFract() {
		return "";
	}

}

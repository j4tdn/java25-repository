package homeword;

import java.util.Scanner;

/**
 * Bài 7: Viết chương trình chuyển đổi cơ số một số tự nhiên ở hệ cơ số 10(thập
 * phân) thành số ở hệ cơ số 2(nhị phân) Tham khảo công thức:
 * https://bit.ly/3QuVyXx VD: Nhập N = 0 → 0 N = 1 → 1 N = 2 → 10 N = 3 → 11 N =
 * 4 → 100 N = 5 → 101
 */
public class task7 {
	public static void main(String[] args) {
		int n;
		String bina = " ";
		Scanner ip = new Scanner(System.in);
		System.out.println("Hãy nhập N: ");
		 n = ip.nextInt();
		while(n > 0) {
			int a = n % 2;
			bina = a + bina;
			n = n / 2;
		}
		System.out.println("Số nhị phân tương ưngs là: " + bina);
		ip.close();
	}
}

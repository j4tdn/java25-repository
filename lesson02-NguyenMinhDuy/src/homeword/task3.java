package homeword;

/**
 * Bài 3: Viết chương trình tìm giai thừa của một số nguyên dương N Biết rằng: N
 * có thể được nhập từ bàn phím hoặc khai báo sẵn
 * 
 * Ví dụ: Nhập N = 1 → 1! = 1 Nhập N = 5 → 5! = 5.4.3.2.1 = 120
 */
public class task3 {
	public static void main(String[] args) {
		int n = 5;
		System.out.println("Vậy lũy thừa của" + n + " là: " + luythua(n));

	}

	private static int luythua(int n) {
		if (n < 0) {
			System.out.println("Nhập số không hợp lệ");
		}
		int b = 1;
		for (int i = 2; i <= n; i++) {
			b *= i;
		}
		return b;
	}
}

package Exercise;

public class Ex09PrimeCheck200th {

	public static void main(String[] args) {

		System.out.println("Số nguyên tố thứ 200 là: " + prime200());
	}

	// Hàm trả về số nguyên tố thứ 200:
	public static int prime200() {
		int count = 0; // đếm số nguyên tố đã gặp.
		int candidate = 1; // số đang được xem xét.

		while (count < 200) {
			candidate++;

			if (isPrime(candidate)) {
				count++; // nếu là số nguyên tố thì tăng bộ đếm lên.
			}
		}

		return candidate; // khi count = 200 thì candidate chính là kết quả cần tìm.
	}

	// Hàm kiểm tra số nguyên tố
	private static boolean isPrime(int n) {
		if (n < 2) 
			return false;
		if (n == 2) // số nguyên tố đặc biệt cần xét riêng, số chẵn duy nhất.
			return true;
		if (n % 2 == 0) // chia hết cho 2 > kp số ngto.
			return false;

		int sqrt = (int) Math.sqrt(n);// tính căn bậc 2 của n, ép kiểu int để lấy phần nguyên thôi.
		for (int i = 3; i <= sqrt; i += 2) { // Vòng lặp bắt đầu từ 3 và +2 mỗi lần nhảy(all số lẻ) -> giảm 1/2 số lần test, save time.
			if (n % i == 0)
				return false;
		}
		return true;
	}
}

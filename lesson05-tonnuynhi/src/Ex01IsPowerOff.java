/*
 * Bài 1 (15đ):Viết hàm kiểm tra một số có phải là lũy thừa của một số khác không
▪ VD: (8, 2)(true), (2, 8)(true), (6, 2)(false), (20, 4)(false), (64, 4)(true)
Method signature: boolean isPowerOf(int a, int b)
 */
public class Ex01IsPowerOff {

	public static boolean Ex01IsPowerOff(int a, int b) {
		if (a <= 0 || b <= 0)
			return false;

		int temp = b;
		while (temp < a) {
			temp *= b;

		}

		if (temp == a)
			return true;

		temp = a;
		while (temp < b) {
			temp *= a;
		}

		if (temp == b)
			return true;

		return false;

	}

	public static void main(String[] args) {
		System.out.println(Ex01IsPowerOff(8, 2));
		System.out.println(Ex01IsPowerOff(2, 8));
		System.out.println(Ex01IsPowerOff(6, 2));
		System.out.println(Ex01IsPowerOff(20, 4));
		System.out.println(Ex01IsPowerOff(64, 4));

	}

}

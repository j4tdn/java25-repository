package loop;

public class Ex01For {
	// In ra cac so nguyen tu 1 den 10 cach nhau 2 don vi
	// dong thoi la boi so cua 3
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i += 2) {
			if (i % 3 == 0) {
				System.out.println(i);
			}
		}
	}

}

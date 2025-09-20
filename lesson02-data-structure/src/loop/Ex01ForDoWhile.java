package loop;

public class Ex01ForDoWhile {

	public static void main(String[] args) {
		// In ra các số nguyên từ 1 đến 10 cách nhau 2 đơn vị
		// Đồng thời là bội của 3
		
		
		// Sử dụng for
		for (int i = 1; i <= 10; i += 2) {
			if (i % 3 == 0) {
				System.out.println(i);
			}
		}
		
		// Sử dụng while
		int i = 1;
		while (i <= 10) {
			if (i % 3 == 0) {
				System.out.println(i + " ");
		}
			i +=2;
		}
	}

	
	   // Sử dụng do while
		int i = 1;
		do {
			if (i % 3 == 0) {
				System.out.println(i + " ");
			}
			i += 2;
		}
		while(i<=10);
	}

	}
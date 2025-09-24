package loop;

public class Ex01ForDoWhile {
	
	public static void main(String[] args) {
		// In ra các số nguyên từ 1 đến 10 cách nhau 2 đơn vị
		// Đồng thời là bội của 3
		
		// sử dụng for
		for (int i = 1; i <= 10; i+=2) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}
		}
		
		System.out.println("\n");
		
		// sử dụng while
		int i = 1;
		while(i <= 10) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}
			i+=2;
		}
		
		// i = 11
		
		System.out.println("\n");
		
		// sử dụng do while
		i = 1;
		do {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}
			i+=2;
		} while(i <= 10);
		
		
		/*
		 
		 while(exp) {
		    // statements
		 }
		 
		 while(true) {
		 	// statements
		 	if (!exp) {
		 		break;
		 	}
		 }
		 */
		
		System.out.println("\n");
		
		i = 1;
		while(true) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}
			i+=2;
			if (i > 10) {
				break;
			}
		}
	}
	
}
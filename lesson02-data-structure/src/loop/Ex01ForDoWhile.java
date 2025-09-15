package loop;

public class Ex01ForDoWhile {
	// In ra cac so nguyen tu 1 den 10 cach nhau 2 don vi
	// dong thoi la boi so cua 3
	
	//su dung for
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i += 2) {
			if (i % 3 == 0) {
				System.out.println(i);
			}
		}
		
	System.out.println("\n");
	
	// su dung while
	int i = 1;
	while (i <= 10) {
		if (i % 3 == 0) {
			System.out.println(i + "");

		}
		i += 2;
	}
	// su dung do while
	i = 1;
	do {
		i += 2;

	} while (i <= 10);
	
	/*
	 while(exp) {
	 	//statement
	 }
	 while(true) {
	 	statement
	 	if(!exp) {
	 	break;
	 	}
	 }
	 */
	
	i = 1;
	while (true) {
		if (i % 3 == 0) {
			System.out.println(i + "");

		}
		i += 2;
		if (i > 10) {
			break;
		}
	}
}

}

package loop;

import javax.swing.SortOrder;

public class Ex01ForDoWhile {
	public static void main(String[] args) {
		for(int i = 1; i <= 10; i+=2) {
			if(i % 3 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println("\n");
		
		int i = 1;
		while(i <= 10) {
			if(i % 3 == 0) {
				System.out.print(i + " ");
			}
			i+=2;
		}
		
		
		i = 1;
		do {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}
			i += 2;
		} while (i <= 10);
		
		
		
		i = 1;
		while(true) {
			if(i % 3 == 0) {
				System.out.print(i + " ");
			}
			i+=2;
			if(i>10) {
				break;
			}
		}
		
	}
}

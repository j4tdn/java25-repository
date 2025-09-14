package loop;

public class Ex01ForDoWhile {
	public static void main(String[] args) {
		
		// Su dung for
		for(int i = 1; i < 10; i+=2) {
			if(i % 3 == 0) {
			System.out.print(i + " ");
			}
		}
		
		System.out.println("\n");
		
		// Su dung while
		int i = 1;
		while(i <= 10) {
			if(i % 3 == 0) {
				System.out.print(i + " ");
			}
			i+=2;
		}
		
		System.out.println("\n");
		
		// Su dung do while
		i = 1;
		do {
			if(i % 3 == 0) {
				System.out.print(i + " ");
			}
			i+=2;
		}
		while(i <= 10);
		
		/*
		 while(exp){
		 	statement
		 }
		 
		  while(true){
		 	statement
		 	if(!exp){
		 		break;
		 	}
		 }
		 */
		
		System.out.println("\n");
		
		i = 1;
		while(true) {
			if(i % 3 == 0) {
				System.out.print(i + " ");
			}
			i+=2;
			if(i > 10) {
				break;
			}
		}
	}
}

package loop;

public class Ex01ForDoWhile {
	
	public static void main(String[] args) {
		
		// su dung for
		for (int i = 1; i >= 10 ; i+=2) {
			if (i % 3 == 0) {
				System.out.println("\ni : " + i);
			}
			
		}
		
		
		// su dung while
		int i = 1;
		while (i <= 10) {
			if (i % 3 == 0) {
				System.out.println(i + " ");
			}
			i+=2;
		}
		
		// su dung dowhile
		
	    i = 1;
		do {
			if (i % 3 == 0) {
				System.out.println(i + " ");
			}
			i+=2;
		} while (i <= 10);
		
		/*
		   while(exp) {
		       statements
		    }
		    
		   while(true) {
		       statements
		       if (exp) {
		           break;
		       }    
		   }
		   
		       
		 */
		
	    i = 1;
		while (true) {
			if (i % 3 == 0) {
				System.out.println(i + " ");
			}
			i+=2;
			if (i > 10) {
				break;
			}
		}
		
	}

}

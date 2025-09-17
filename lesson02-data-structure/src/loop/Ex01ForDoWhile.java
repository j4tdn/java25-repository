package loop;

public class Ex01ForDoWhile {
	public static void main(String[] args) {
		
		//for
		for(int i=1; i<=10; i+=2) {
			if(i%3==0) {
				System.out.println("tu 1 toi 10 cach nhau 2 don vi va là bội của 3: " + i);
			}
			
		}
		System.out.println("===========");
		
		
		//while
		int i =1;
		while(i<=10) {
			if(i%3==0) {
				System.out.println("tu 1 toi 10 cach nhau 2 don vi va là bội của 3: " + i);
			}
			i+=2;
		}
		System.out.println("===========");
		
		
		//Do while
		i = 1;
		do {
			if(i%3==0) {
				System.out.println("tu 1 toi 10 cach nhau 2 don vi va là bội của 3: " + i);
			}
			i+=2;
		}
		while(i<=10);
		System.out.println("===========");
		
		//while(true) lập vô hạn
		i=1;
		while(true) {
			if(i%3==0) {
				System.out.println(i + " ");
			}
			i+=2;
			if(i >10) {
				break;
			}
			
		}
		
		
	}
}
